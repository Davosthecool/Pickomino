
import Vue.Vue_menu
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage
import Controleur.*
import Vue.*
import Modele.*

class Pickomino: Application() {

    override fun start(stage: Stage) {
        val vue = Vue_menu() //à gerer
        val modmenu = Modele_menu(vue) //à gerer
        val scene = Scene(vue,960.0, 540.0)
        val modjeu = Modele_jeu(vue,modmenu)
        //binding
        vue.local_game.setOnAction {
            modmenu.isLocal=true
            println("la partie sera en local: ${modmenu.isLocal}")
        }
        vue.online_game.setOnAction {
            modmenu.isLocal=false
            println("la partie sera en local: ${modmenu.isLocal}")
        }

        vue.player_number_game.setOnAction {
            modmenu.nbjoueur=vue.player_number_game.value
            println("la partie aura ${modmenu.nbjoueur} joueurs")
        }
        //vue.number_id.valueProperty().bindBidirectional(modmenu.inputid)
        //vue.number_key.valueProperty().bindBidirectional(modmenu.inputkey)

        val contlaunch = ControleurLaunchGame(vue,modmenu,stage,modjeu)
        vue.create_game.onAction = contlaunch

        val contjoin = ControleurJoinGame(vue,modmenu,stage,modjeu)
        vue.join_game.onAction = contjoin

        //default
        vue.local_game.isSelected = true
        modmenu.isLocal=true
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
