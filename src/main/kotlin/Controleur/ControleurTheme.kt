package Controleur

import Vue.Vue_menu
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.ChoiceBox

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