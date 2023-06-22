package Controleur

import Modele.Des
import Modele.Jeu
import Vue.Vue_jeu
import iut.info1.pickomino.Connector
import iut.info1.pickomino.data.DICE
import iut.info1.pickomino.data.STATUS
import iut.info1.pickomino.exceptions.BadStepException
import javafx.event.EventHandler
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.input.MouseEvent
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox

class ControleurChoisirDes(vue : Vue_jeu, modele: Jeu, connect : Connector) : EventHandler<MouseEvent> {

    private val connect = connect
    private val vue = vue
    private val modele = modele
    override fun handle(event: MouseEvent?) {
        if (connect.gameState(modele.id, modele.key).current.status == STATUS.KEEP_DICE) {
            //Selectionner valeur choisie
            var ev = event?.source as ImageView
            var de : DICE = DICE.d1
            for (i in connect.gameState(modele.id,modele.key).current.rolls) {
                if (i.toString() == ev.userData.toString()) {
                    de = i
                }
            }

            //Mettre a jour modele et vue en consequence(desChoisis,desActifs)
            if (!connect.gameState(modele.id,modele.key).current.keptDices.contains(de)) {
                vue.desActif.children.forEach {
                    if (it.userData.toString()==de.toString()){
                        it.opacity = 1.0
                    }else{
                        it.opacity = 0.3
                    }
                }


                //Boite de dialogue
                var al = Alert(Alert.AlertType.CONFIRMATION)
                al.contentText = "Etes vous sur de vouloir ces dés"
                al.showAndWait()

                if (al.result == ButtonType.OK) {
                    //Deplacement dés en consequence
                    connect.keepDices(modele.id, modele.key, de)

                    vue.updateDice(connect.gameState(modele.id,modele.key).current.rolls, vue.desActif)
                    vue.updateDice(connect.gameState(modele.id,modele.key).current.keptDices, vue.desChoisi)
                    vue.lanceDes.isDisable = false

                    //Mettre a jour vue PouleCommune
                    var pick = 0
                    var pickJoueurs = 0
                    if (modele.sommeDes(connect.gameState(modele.id,modele.key).current.keptDices) >= 21) {
                        //choisis dans la pouleCommune la bonne valeur(exacte ou inferieure)
                        pick = connect.gameState(modele.id,modele.key).accessiblePickos().maxByOrNull { number -> if (number <= modele.sommeDes(connect.gameState(modele.id,modele.key).current.keptDices)) number else 0 }!!
                        //verifier si un joueur possede la valeur exacte de la somme des dés
                        if (connect.gameState(modele.id,modele.key).pickosStackTops().contains(modele.sommeDes(connect.gameState(modele.id,modele.key).current.keptDices))){ pickJoueurs=modele.sommeDes(connect.gameState(modele.id,modele.key).current.keptDices) }

                        //Mettre a jour vue en consequence(surbrillance picko clické PouleCommune)
                        vue.pouleCommune.children.forEach {
                            it.opacity = 0.3
                            if (it.userData == pick && connect.gameState(modele.id,modele.key).current.keptDices.contains(DICE.worm)) {
                                it.opacity = 1.0
                            }
                        }

                        //Mettre a jour vue en consequence(surbrillance picko clické DominoJoueurs)
                        if (pickJoueurs!=0){
                            vue.listeDominoJoueurs.forEach {
                                it.opacity = 0.3
                                if ((it.userData.toString() == pickJoueurs.toString()) and (it.userData!=0) ) {
                                    it.opacity = 1.0
                                }
                            }
                        }

                    }
                }else{
                    vue.desActif.children.forEach{
                        if (modele.listeDesStr2(connect.gameState(modele.id,modele.key).current.keptDices).contains(it.userData)) {
                            it.opacity = 0.3
                        }else{
                            it.opacity = 1.0
                        }
                    }
                }
            }
        }else {
            throw BadStepException()
        }
    }
}