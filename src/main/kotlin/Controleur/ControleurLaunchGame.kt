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

class ControleurLaunchGame(vue:Vue_menu,stage: Stage,modjeu : Modele_jeu):EventHandler<ActionEvent> {
    val vue = vue
    val stage = stage
    val modjeu = modjeu
    val connect = modjeu.connector
    override fun handle(event: ActionEvent?) {
        stage.hide()
        //lancement partie
        println("Parties actives sur le serveur = ${connect.listOfGameIds()}")
        val identification = connect.newGame(modjeu.nbjoueur)
        val id = identification.first
        val key = identification.second
        val currentGame = connect.gameState(id, key)
        println("Nouvelle partie : $currentGame")
        println("id : ${id} clé : ${key}")
        if (modjeu.isLocal==false) {
            println("Lancement de la partie en ligne pour ${modjeu.nbjoueur} joueurs")
        } else {
            println("Lancement de la partie en local pour ${modjeu.nbjoueur} joueurs")
        }
        modjeu.key.value=key
        modjeu.id.value=id
        //changement vue
        if (modjeu.nbjoueur==4) {
            stage.scene.root=Vue_4j(vue.theme_value,modjeu.id.value,modjeu.key.value)
        } else if (modjeu.nbjoueur==3) {
            stage.scene.root= Vue_3j(vue.theme_value,modjeu.id.value,modjeu.key.value)
        } else if (modjeu.nbjoueur==2) {
            stage.scene.root= Vue_2j(vue.theme_value,modjeu.id.value,modjeu.key.value)
        }
        stage.isMaximized = true
        stage.show()
    }
}
