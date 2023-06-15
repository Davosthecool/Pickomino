
import Vue.Vue_menu
import iut.info1.pickomino.Connector
import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.text.TextAlignment
import javafx.stage.Stage
import Controleur.*
import Vue.*
import Modele.*
class Pickomino: Application() {

    override fun start(stage: Stage) {
        val vue = Vue_menu() //à gerer
        val mod = Modele_menu(vue) //à gerer
        val scene = Scene(vue,960.0, 540.0)
        //binding
        vue.local_game.setOnAction {
            mod.isLocal=true
            println("la partie sera en local: ${mod.isLocal}")
        }
        vue.online_game.setOnAction {
            mod.isLocal=false
            println("la partie sera en local: ${mod.isLocal}")
        }

        vue.player_number_game.setOnAction {
            mod.nbjoueur=vue.player_number_game.value
            println("la partie aura ${mod.nbjoueur} joueurs")
        }

        val contlaunch = ControleurLaunchGame(vue,mod,stage)
        vue.create_game.onAction = contlaunch

        val contjoin = ControleurJoinGame(vue,mod,stage)
        vue.join_game.onAction = contjoin
        //default
        vue.local_game.isSelected = true
        mod.isLocal=true
        vue.player_number_game.selectionModel.selectFirst()
        //lancement application
        stage.title="Pickomino"
        stage.scene=scene
        stage.isResizable = false
        //stage.isMaximized = true
        stage.show()
    }
}

fun main() {
    val connect = Connector.factory("172.26.82.76", "8080")
    println("Parties actives sur le serveur = ${connect.listOfGameIds()}")
    val identification = connect.newGame(3)
    val id = identification.first
    val key = identification.second
    val currentGame = connect.gameState(id, key)
    println("Nouvelle partie = $currentGame")
    Application.launch(Pickomino::class.java)
}
