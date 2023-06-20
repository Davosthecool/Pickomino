package Controleur

import Modele.Jeu
import iut.info1.pickomino.Connector
import iut.info1.pickomino.data.STATUS
import javafx.event.EventHandler
import javafx.scene.input.MouseEvent

class ControleurChoisirDes(vue : Any, modele: Jeu, connect : Connector) : EventHandler<MouseEvent> {

    private val connect = connect
    private val vue = vue
    private val modele = modele
    override fun handle(event: javafx.scene.input.MouseEvent?) {
        if (connect.gameState(modele.id, modele.key).current.status == STATUS.KEEP_DICE){

        }
    }
}