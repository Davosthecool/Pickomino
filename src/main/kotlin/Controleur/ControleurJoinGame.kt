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
import javafx.scene.Scene
import javafx.stage.Stage

class ControleurJoinGame(vue:Vue_menu,modmenu:Modele_menu,stage: Stage,modjeu : Modele_jeu):EventHandler<ActionEvent> {
    val modmenu = modmenu
    val vue = vue
    val stage = stage
    val modjeu = modjeu
    override fun handle(event: ActionEvent?) {
        if (modmenu.isLocal==false) {
            stage.hide()
            if (modmenu.nbjoueur==4) {
                stage.scene.root=Vue_4j()
            } else if (modmenu.nbjoueur==3) {
                stage.scene.root= Vue_3j()
            } else if (modmenu.nbjoueur==2) {
                stage.scene.root= Vue_2j()
            }
            //update Modele_Jeu
            modjeu.key=modmenu.inputkey.value
            modjeu.id=modmenu.inputid.value
            println("id : ${modjeu.id} key : ${modjeu.key}")
            modjeu.isLocal=modmenu.isLocal
            modjeu.nbjoueur=modmenu.nbjoueur
            modjeu.vue=stage.scene.root
            stage.isMaximized=true
            stage.show()
        }
    }
}