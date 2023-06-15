package Controleur

import Modele.Modele_menu
import Vue.Vue_2j
import Vue.Vue_3j
import Vue.Vue_4j
import Vue.Vue_menu
import iut.info1.pickomino.Connector
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.stage.Stage

class ControleurJoinGame(vue:Vue_menu, mod:Modele_menu, stage: Stage):EventHandler<ActionEvent> {
    val mod = mod
    val vue = vue
    val stage = stage
    override fun handle(event: ActionEvent?) {
        if (mod.isLocal==false) { //its online
            val connect = Connector.factory("172.26.82.76", "8080")
            println("Parties actives sur le serveur = ${connect.listOfGameIds()}")
            val identification = connect.newGame(mod.nbjoueur)
            val id = identification.first
            val key = identification.second
            val currentGame = connect.gameState(id, key)
            println("Nouvelle partie : $currentGame | clé : ${key} id : ${id}")
        }
        //changing view
        if (mod.nbjoueur==4) {
            stage.scene.root=Vue_4j()
            stage.isMaximized = true
        } else if (mod.nbjoueur==3) {
            stage.scene.root= Vue_3j()
            stage.isMaximized = true
        } else if (mod.nbjoueur==2) {
            stage.scene.root= Vue_2j()
            stage.isMaximized = true
        }
    }
}