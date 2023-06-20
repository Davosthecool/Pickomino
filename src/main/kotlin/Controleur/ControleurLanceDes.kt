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
        //Lancement des
        if (connect.gameState(modele.id, modele.key).current.status == STATUS.ROLL_DICE || connect.gameState(modele.id, modele.key).current.status == STATUS.ROLL_DICE_OR_TAKE_PICKOMINO){
            connect.rollDices(modele.id, modele.key)
            //changement modele et vue en conqequence
            modele.assignDes(connect.gameState(modele.id, modele.key).current.rolls, modele.desActifs)

            vue.updateDice(modele.listeDesStr(modele.desActifs), vue.desActif)
            modele.desActifs.forEach{
                if (modele.valeursChoisis.contains(it.face)){
                    vue.desActif.children.get(it.id).opacity=0.3
                }
            }
            //bind des des
            vue.fixeVbox(vue.desActif,ControleurChoisirDes(vue,modele,connect),modele,connect)
            vue.lanceDes.isDisable = true

            //si tour perdu changement de joueur

        }else {
           throw BadStepException()
        }
    }
}