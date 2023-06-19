package Controleur

import Modele.Modele_jeu
import Vue.Vue_2j
import Vue.Vue_3j
import Vue.Vue_4j
import Vue.Vue_menu
import iut.info1.pickomino.Connector
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.stage.Stage

class ControleurJoinGame(vue:Vue_menu,stage: Stage,modjeu : Modele_jeu):EventHandler<ActionEvent> {
    var vue = vue
    val stage = stage
    val modjeu = modjeu
    val connect = modjeu.connector
    override fun handle(event: ActionEvent?) {
        if (modjeu.isLocal==false) {
            stage.hide()
            //set view
            if (modjeu.nbjoueur==4) {
                stage.scene.root=Vue_4j(vue.theme_value,modjeu.id.value,modjeu.key.value)
            } else if (modjeu.nbjoueur==3) {
                stage.scene.root= Vue_3j(vue.theme_value,modjeu.id.value,modjeu.key.value)
            } else if (modjeu.nbjoueur==2) {
                stage.scene.root= Vue_2j(vue.theme_value,modjeu.id.value,modjeu.key.value)
            }
            stage.isMaximized=true
            stage.show()
        }
    }
}