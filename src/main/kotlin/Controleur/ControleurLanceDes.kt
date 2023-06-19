package Controleur

import Modele.Jeu
import iut.info1.pickomino.Connector
import javafx.event.ActionEvent
import javafx.event.EventHandler

class ControleurLanceDes(vue : Any,modele: Jeu,connect:Connector):EventHandler<ActionEvent> {
    private val connect = connect
    private val vue = vue
    private val modele = modele
    override fun handle(event: ActionEvent?) {
        TODO("prout")
        /*
        modele.desActifs=connect.rollDices(modele.id,modele.key)
        print(connect.rollDices(modele.id,modele.key))
        */
    }

}