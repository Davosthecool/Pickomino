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
    var vue = vue
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
            //set view
            if (modmenu.nbjoueur==4) {
                stage.scene.root=Vue_4j(vue.theme_value,modjeu.id,modjeu.key)
            } else if (modmenu.nbjoueur==3) {
                stage.scene.root= Vue_3j(vue.theme_value,modjeu.id,modjeu.key)
            } else if (modmenu.nbjoueur==2) {
                stage.scene.root= Vue_2j(vue.theme_value,modjeu.id,modjeu.key)
            }
            modjeu.vue=stage.scene.root
            stage.isMaximized=true
            stage.show()
        }
    }
}