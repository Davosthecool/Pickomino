import iut.info1.pickomino.Connector
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage

class TD2_1: Application() {

    override fun start(stage: Stage) {
        val vue = Vue_menu()
        stage.title="Pickomino"

        val scene = Scene(vue,900.0, 300.0)
        stage.scene=scene
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
    Application.launch(MainConcateneur::class.java)
}
