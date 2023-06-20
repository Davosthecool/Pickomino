package Controleur

import Modele.Des
import Modele.Jeu
import Vue.Vue_jeu
import iut.info1.pickomino.Connector
import iut.info1.pickomino.data.DICE
import iut.info1.pickomino.data.STATUS
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
        var de = Des(0)
        //Selectionner valeur choisie
        if (connect.gameState(modele.id, modele.key).current.status == STATUS.KEEP_DICE){
            var ev = event?.source as ImageView
            for (i in modele.desActifs){
                if (i.id==ev.userData){
                    de = i
                }
            }
            println("id du dé : ${de.id}")
            println("listeDes")
            println(modele.listeDes.forEach{ println(it.valeur)})
            println("desActifs")
            println(modele.desActifs.forEach{ println(it.valeur)})
            println("desChoisis")
            println(modele.desChoisis.forEach{ println(it.valeur)})
            //Mettre a jour modele et vue en consequence
            modele.selectionnerDes(de.valeur)
            modele.desActifs.forEach{
                vue.desActif.children.get(it.id).opacity=0.3
                if (it.selected){
                    vue.desActif.children.get(it.id).opacity=1.0
                }
            }

            //Boite de dialogue et deplacement dés

            var al = Alert(Alert.AlertType.CONFIRMATION)
            al.contentText="Etes vous sur de vouloir ces dés"
            al.showAndWait()
            if (al.result== ButtonType.OK){
                connect.keepDices(modele.id,modele.key,de.face)

                modele.choisirDes(de.valeur)

                vue.updateDice(modele.listeDesStr(modele.desActifs),vue.desActif)
                vue.updateDice(modele.listeDesStr(modele.desChoisis),vue.desChoisi)
            }
            vue.lanceDes.isDisable=false

            //reset index
            for (i in modele.desActifs.indices) {
                modele.desActifs[i].id=i
            }

        }
    }
}