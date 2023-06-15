
import Vue.Vue_menu
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage
import Controleur.*
import Vue.*
import Modele.*
import javafx.beans.binding.Bindings
import javafx.css.converter.StringConverter
import javafx.scene.control.TextFormatter
import javafx.util.converter.NumberStringConverter

class Pickomino: Application() {

    override fun start(stage: Stage) {
        val vue = Vue_menu() //à gerer
        val modmenu = Modele_menu(vue) //à gerer
        val scene = Scene(vue,960.0, 540.0)
        val modjeu = Modele_jeu(vue)
        //binding
        //radio local
        vue.local_game.setOnAction {
            modmenu.isLocal=true
            println("la partie sera en local: ${modmenu.isLocal}")
            vue.join_game.isDisable = true
            vue.create_game.isDisable = false

        }
        //radio online
        vue.online_game.setOnAction {
            modmenu.isLocal=false
            println("la partie sera en local: ${modmenu.isLocal}")
            vue.join_game.isDisable = true
            vue.create_game.isDisable = false
        }
        //nbjoueur
        vue.player_number_game.setOnAction {
            modmenu.nbjoueur=vue.player_number_game.value
            println("la partie aura ${modmenu.nbjoueur} joueurs")
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
        //binding
        val converter = NumberStringConverter()
        vue.number_id.textFormatter = textFormatterid
        vue.number_id.textProperty().bindBidirectional(modmenu.inputid, converter)
        vue.number_id.textProperty().addListener { _, _, _ ->
            // This event will be triggered whenever the text in the TextField changes
            vue.join_game.isDisable = false
            vue.create_game.isDisable = true
            modmenu.isLocal=false
        }
        vue.number_key.textFormatter = textFormatterkey
        vue.number_key.textProperty().bindBidirectional(modmenu.inputkey, converter)
        vue.number_key.textProperty().addListener { _, _, _ ->
            // This event will be triggered whenever the text in the TextField changes
            vue.join_game.isDisable = false
            vue.create_game.isDisable = true
            modmenu.isLocal=false
        }
        /////////////////////////////////////////
        //bouton launch
        val contlaunch = ControleurLaunchGame(vue,modmenu,stage,modjeu)
        vue.create_game.onAction = contlaunch
        //bouton join
        val contjoin = ControleurJoinGame(vue,modmenu,stage,modjeu)
        vue.join_game.onAction = contjoin
        //default
        vue.join_game.isDisable = true
        vue.local_game.isSelected = true
        modmenu.isLocal=true
        vue.join_game.isDisable = true
        vue.player_number_game.selectionModel.selectFirst()
        //lancement application
        stage.title="Pickomino"
        stage.scene=scene
        stage.isResizable = false
        stage.show()
    }
}

fun main() {
    Application.launch(Pickomino::class.java)
}
