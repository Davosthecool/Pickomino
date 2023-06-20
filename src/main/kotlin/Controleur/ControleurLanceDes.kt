package Controleur

import Modele.Jeu
import Vue.Vue_jeu
import iut.info1.pickomino.Connector
import iut.info1.pickomino.data.STATUS
import iut.info1.pickomino.exceptions.BadStepException
import javafx.event.ActionEvent
import javafx.event.EventHandler

class ControleurLanceDes(vue : Vue_jeu, modele: Jeu, connect : Connector):EventHandler<ActionEvent> {

    private val connect = connect
    private val vue = vue
    private val modele = modele
    override fun handle(event: ActionEvent?) {
        if (connect.gameState(modele.id, modele.key).current.status == STATUS.ROLL_DICE){
            connect.rollDices(modele.id, modele.key)
            modele.assignDes(connect.gameState(modele.id, modele.key).current.rolls, modele.desActifs)

            var list = mutableListOf<String>()

            for (i in modele.desActifs) {
                list.add(i.face.toString())
            }

            vue.updateDice(list, vue.desActif)
            vue.lanceDes.isDisable = true

        }else {
           throw BadStepException()
        }


        /*
        modele.desActifs=connect.rollDices(modele.id,modele.key)
        print(connect.rollDices(modele.id,modele.key))
        */
    }

}