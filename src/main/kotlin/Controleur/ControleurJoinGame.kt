package Controleur

import Modele.Modele_jeu
import Modele.Modele_menu
import Vue.Vue_2j
import Vue.Vue_3j
import Vue.Vue_4j
import Vue.Vue_menu
import iut.info1.pickomino.Connector
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.stage.Stage

class ControleurJoinGame(vue:Vue_menu,modmenu:Modele_menu,stage: Stage,modjeu : Modele_jeu):EventHandler<ActionEvent> {
    val modmenu = modmenu
    val vue = vue
    val stage = stage
    val modjeu = modjeu
    override fun handle(event: ActionEvent?) {
        if (modmenu.isLocal==false) {
            val connect = Connector.factory("172.26.82.76", "8080")
            stage.hide()
            //update Modele_Jeu
            modjeu.key = modmenu.inputkey.value
            modjeu.id = modmenu.inputid.value
            modjeu.isLocal = modmenu.isLocal
            //get the game and update player number
            val currentGame = connect.gameState(modjeu.id,modjeu.key)
            //set the player size
            println(currentGame)
            modjeu.nbjoueur = currentGame.current.player+1
            println("il y a ${modjeu.nbjoueur } joueurs")
            //set view
            if (modmenu.nbjoueur==4) {
                stage.scene.root=Vue_4j()
            } else if (modmenu.nbjoueur==3) {
                stage.scene.root= Vue_3j()
            } else if (modmenu.nbjoueur==2) {
                stage.scene.root= Vue_2j()
            }
            modjeu.vue=stage.scene.root
            stage.isMaximized=true
            stage.show()
        }
    }
}