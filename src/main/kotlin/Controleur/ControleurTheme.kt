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
import javafx.scene.control.ChoiceBox
import javafx.scene.control.Label
import javafx.stage.Stage

class ControleurTheme(vue:Vue_menu):EventHandler<ActionEvent> {
    val vue = vue
    override fun handle(event: ActionEvent) {
        val txt = event.source as ChoiceBox<String>
        if (txt.value == "Sombre") { //dark
            vue.theme_value="Dark"
        } else { //dark
            vue.theme_value="Light"
        }
    }
}