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
            var de = Des(0)
            for (i in modele.desActifs) {
                if (i.id == ev.userData) {
                    de = i
                }
            }

            //Mettre a jour modele et vue en consequence(desChoisis,desActifs)
            if (!modele.valeursChoisis.contains(de.face)) {
                modele.selectionnerDes(de.valeur)

                modele.desActifs.forEach {
                    vue.desActif.children.get(it.id).opacity = 0.3
                    if (it.selected) {
                        vue.desActif.children.get(it.id).opacity = 1.0
                    }
                }


                //Boite de dialogue
                var al = Alert(Alert.AlertType.CONFIRMATION)
                al.contentText = "Etes vous sur de vouloir ces dés"
                al.showAndWait()

                if (al.result == ButtonType.OK) {
                    //Deplacement dés en consequence
                    connect.keepDices(modele.id, modele.key, de.face)

                    modele.choisirDes(de.valeur)

                    vue.updateDice(modele.listeDesStr(modele.desActifs), vue.desActif)
                    vue.updateDice(modele.listeDesStr(modele.desChoisis), vue.desChoisi)
                    vue.lanceDes.isDisable = false
                    modele.valeursChoisis.add(de.face)

                    //reset index
                    for (i in modele.desActifs.indices) {
                        modele.desActifs[i].id = i
                    }

                    //transparence après roll
                    modele.desActifs.forEach {
                        vue.desActif.children.get(it.id).opacity = 0.3
                    }

                    //Mettre a jour vue PouleCommune
                    var pick = 0
                    if (modele.sommeDes(modele.desChoisis) >= 21){
                        pick = modele.listePickomino.maxByOrNull { number -> if (number <= modele.sommeDes(modele.desChoisis)) number else 0 }!!
                    }
                    modele.listePickomino.forEach {
                        vue.pouleCommune.children.get(it-21).opacity = 0.3
                        if (it == pick) {
                            vue.pouleCommune.children.get(it-21).opacity = 1.0
                        }
                    }
                }
            }
        }else {
            throw BadStepException()
        }
    }
}