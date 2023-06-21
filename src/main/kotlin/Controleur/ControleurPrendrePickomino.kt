package Controleur

import Modele.Des
import Modele.Jeu
import Vue.Vue_jeu
import iut.info1.pickomino.Connector
import iut.info1.pickomino.data.Pickomino
import iut.info1.pickomino.data.STATUS
import iut.info1.pickomino.exceptions.BadPickominoChosenException
import iut.info1.pickomino.exceptions.BadStepException
import javafx.event.EventHandler
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import javafx.scene.image.ImageView
import javafx.scene.input.MouseEvent


class ControleurPrendrePickomino(vue : Vue_jeu, modele: Jeu, connect : Connector) : EventHandler<MouseEvent> {

    private val connect = connect
    private val vue = vue
    private val modele = modele
    override fun handle(event: MouseEvent?) {
        if (connect.gameState(modele.id, modele.key).current.status == STATUS.TAKE_PICKOMINO || connect.gameState(modele.id, modele.key).current.status == STATUS.ROLL_DICE_OR_TAKE_PICKOMINO) {
            //Selectionner valeur choisie
            var ev = event?.source as ImageView
            var pick = 0
            for (i in modele.listePickomino) {
                if (i == ev.userData) {
                    pick = i
                }
            }

            //Verifier que le picko est le bon
            var picko = modele.listePickomino.maxByOrNull { number -> if (number <= modele.sommeDes(modele.desChoisis) ) number else 0 }!!
            if (pick == picko){
                //Mettre a jour vue en consequence(surbrillance picko clické)
                modele.listePickomino.forEach {
                    vue.pouleCommune.children.get(it - 21).opacity = 0.3
                    if (it == picko) {
                        vue.pouleCommune.children.get(it - 21).opacity = 1.0
                    }
                }

                //Boite de dialogue
                var al = Alert(Alert.AlertType.CONFIRMATION)
                al.contentText = "Etes vous sur de vouloir ce Pickomino"
                al.showAndWait()

                if (al.result == ButtonType.OK){
                    var b = connect.takePickomino(modele.id,modele.key,picko)
                    if (!b){ throw BadPickominoChosenException() }

                    modele.prendrePickomino(picko,connect.gameState(modele.id,modele.key).current.player)

                    vue.updatePouleCommune(modele.listePickomino)
                    vue.updateDominoJoueurs(modele.joueursPickosTop)

                }else {
                    //Mettre a jour vue PouleCommune
                    modele.listePickomino.forEach {
                        vue.pouleCommune.children.get(it - 21).opacity = 0.3
                        if (it == picko) {
                            vue.pouleCommune.children.get(it - 21).opacity = 1.0
                        }
                    }
                }
            }
        }else {
            throw BadStepException()
        }
    }
}