package Controleur

import Modele.Jeu
import iut.info1.pickomino.Connector
import iut.info1.pickomino.data.STATUS
import javafx.event.EventHandler
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.input.MouseEvent
import javafx.scene.layout.HBox

class ControleurChoisirDes(vue : Any, modele: Jeu, connect : Connector) : EventHandler<MouseEvent> {

    private val connect = connect
    private val vue = vue
    private val modele = modele
    override fun handle(event: javafx.scene.input.MouseEvent?) {
        var value : Int = 0
        if (connect.gameState(modele.id, modele.key).current.status == STATUS.KEEP_DICE){

            var ev = event?.source as ImageView
            for (i in modele.listeDes){
                if (i.id==ev.userData){
                    value = i.valeur
                }
            }
            print(value)
            modele.selectionnerDes(value)

        }
    }
}