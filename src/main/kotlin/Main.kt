
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
        val controlResponsive = ControleurResponsive(vue,mod)
        controlResponsive.bind()
        //lancement application
        stage.title="Pickomino"
        stage.scene=scene
        stage.isResizable = false
        stage.isMaximized = true
        println(scene.widthProperty().value)
        stage.show()
    }
}

fun main() {
    val connect = Connector.factory("172.26.82.76", "8080")
    println("Parties actives sur le serveur = ${connect.listOfGameIds()}")
    //val identification = connect.newGame(3)
    //val id = identification.first
    //val key = identification.second
    //val currentGame = connect.gameState(id, key)
    //println("Nouvelle partie = $currentGame")
    Application.launch(Pickomino::class.java)
}
