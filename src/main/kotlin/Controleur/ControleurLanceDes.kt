package Controleur

import Modele.Jeu
import Vue.Vue_jeu
import iut.info1.pickomino.Connector
import iut.info1.pickomino.data.DICE
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
            modele.assignDes(connect.gameState(modele.id, modele.key).current.rolls, modele.desActifs)
            vue.updateDice(modele.listeDesStr(modele.desActifs), vue.desActif)

//            //verification rolls
//            var jouable = false
//            for (i in modele.desActifs){
//                if (!(i.face in modele.valeursChoisis)){
//                    jouable=true
//                }
//            }
//            //verification vers
//            if (!modele.valeursChoisis.contains(DICE.worm) and modele.desActifs.isEmpty()){
//                jouable=false
//            }
//            //situation tour perdu
//            if (!jouable){
//                var pickoRetire : Int? = modele.retirerPickomino(connect.gameState(modele.id, modele.key).current.player)
//                if (pickoRetire != null) {
//                    modele.listePickomino.add(pickoRetire!!)
//                    if (pickoRetire!=modele.listePickomino[-1]) {
//                        modele.listePickomino.removeAt(-1)
//                    }
//
//                }
            vue.updatePouleCommune(modele.listePickomino,modele, connect)




            modele.desActifs.forEach {
                if (modele.valeursChoisis.contains(it.face)) {
                    vue.desActif.children.get(it.id).opacity = 0.3
                }
            }
            //bind des des
            vue.fixeDes(vue.desActif,ControleurChoisirDes(vue,modele,connect),modele,connect)
            vue.lanceDes.isDisable = true
            print(connect.gameState(modele.id,modele.key).current.status)
            //si tour perdu changement de joueur

        }else {
           throw BadStepException()
        }
    }
}