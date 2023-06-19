
import Vue.Vue_menu
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage
import Controleur.*
import Vue.*
import Modele.*
import iut.info1.pickomino.Connector
import javafx.scene.control.TextFormatter
import javafx.util.converter.NumberStringConverter
import javafx.scene.*


class Pickomino: Application() {

    override fun start(stage: Stage) {
        val connect = Connector.factory("172.26.82.76", "8080")
        val vue = Vue_menu()
        val scene = Scene(vue,960.0, 540.0)
        val modmenu = Menu(connect)
        //CSS
        scene.stylesheets.add("/CSS/menu.css")
        scene.stylesheets.add("/CSS/Vue.css")
        //music
        //binding
        //radio local
        vue.local_game.setOnAction {
            modmenu.isLocal=true
            vue.join_game.isDisable = true
            vue.create_game.isDisable = false
        }
        //radio online
        vue.online_game.setOnAction {
            modmenu.isLocal=false
            vue.join_game.isDisable = true
            vue.create_game.isDisable = false
        }
        //nbjoueur
        vue.player_number_game.setOnAction {
            modmenu.nbjoueur=vue.player_number_game.value
            vue.join_game.isDisable = true
            vue.create_game.isDisable = false
            //get which radio is selected
            modmenu.isLocal=vue.local_game.isSelected
        }
        //salon clé et id////////////////////////
        //formatters
        val textFormatterid = TextFormatter<String> { change ->
            if (change.controlNewText.matches(Regex("\\d*"))) {
                change
            } else {
                null
            }
        }
        val textFormatterkey = TextFormatter<String> { change ->
            if (change.controlNewText.matches(Regex("\\d*"))) {
                change
            } else {
                null
            }
        }
        val converter = NumberStringConverter()
        vue.number_id.textFormatter = textFormatterid
        vue.number_id.textProperty().bindBidirectional(modmenu.id, converter)
        vue.number_id.textProperty().addListener { _, _, _ ->
            // This event will be triggered whenever the text in the TextField changes
            vue.join_game.isDisable = false
            vue.create_game.isDisable = true
            modmenu.isLocal=false
        }
        vue.number_key.textFormatter = textFormatterkey
        vue.number_key.textProperty().bindBidirectional(modmenu.key, converter)
        vue.number_key.textProperty().addListener { _, _, _ ->
            // This event will be triggered whenever the text in the TextField changes
            vue.join_game.isDisable = false
            vue.create_game.isDisable = true
            modmenu.isLocal=false
        }

        //theme
        vue.theme.setOnAction {
            if (vue.theme.value == "Sombre") { //dark
                vue.theme_value="Dark"
            } else { //dark
                vue.theme_value="Light"
            }
        }
        //regle
        vue.regle.setOnAction {
            this.hostServices.showDocument("https://docs.google.com/document/d/1wdcjL6ybM8hpasGdlTt_XzmB-nY_6P21ZzBy5xoNgBI/edit?usp=sharing")
        }
        /////////////////////////////////////////
        //bouton launch
        val contlaunch = ControleurLaunchGame(vue,stage,modmenu)
        vue.create_game.onAction = contlaunch
        //bouton join
        val contjoin = ControleurJoinGame(vue,stage,modmenu)
        vue.join_game.onAction = contjoin
        //default
        vue.join_game.isDisable = true
        vue.local_game.isSelected = true
        modmenu.isLocal=true
        vue.join_game.isDisable = true
        vue.player_number_game.selectionModel.selectFirst()
        vue.theme.selectionModel.selectFirst()
        //lancement application
        stage.title="Pickomino"
        stage.scene=scene
        stage.isMaximized = true
        stage.isResizable = false
        stage.show()
    }
}

fun main() {
    Application.launch(Pickomino::class.java)
}
