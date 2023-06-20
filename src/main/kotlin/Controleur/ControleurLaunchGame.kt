package Controleur

import Modele.Jeu
import Modele.Menu
import Vue.Vue_2j
import Vue.Vue_3j
import Vue.Vue_4j
import Vue.Vue_menu
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.stage.Stage

class ControleurLaunchGame(vue:Vue_menu, stage: Stage,modmenu : Menu):EventHandler<ActionEvent> {
    val vue = vue
    val stage = stage

    val modmenu = modmenu
    val connect = modmenu.connector
    override fun handle(event: ActionEvent?) {
        stage.hide()
        //lancement partie
        println("Parties actives sur le serveur = ${connect.listOfGameIds()}")
        val identification = connect.newGame(modmenu.nbjoueur)
        val id = identification.first
        val key = identification.second
        val currentGame = connect.gameState(id, key)
        println("Nouvelle partie : $currentGame")
        println("id : ${id} clé : ${key}")
        if (modmenu.isLocal==false) {
            println("Lancement de la partie en ligne pour ${modmenu.nbjoueur} joueurs")
        } else {
            println("Lancement de la partie en local pour ${modmenu.nbjoueur} joueurs")
        }
        modmenu.key.value=key
        modmenu.id.value=id

        //changement vue
        if (modmenu.nbjoueur==4) {
            val v = Vue_4j(vue.theme_value,modmenu.id.value,modmenu.key.value)
            val modjeu = Jeu(modmenu,v)
            v.fixeBouton(v.lanceDes, ControleurLanceDes(v, modjeu, connect))
            stage.scene.root=v
        } else if (modmenu.nbjoueur==3) {
            val v = Vue_3j(vue.theme_value,modmenu.id.value,modmenu.key.value)
            val modjeu = Jeu(modmenu,v)
            stage.scene.root=v
        } else if (modmenu.nbjoueur==2) {
            val v = Vue_2j(vue.theme_value,modmenu.id.value,modmenu.key.value)
            val modjeu = Jeu(modmenu,v)
            stage.scene.root=v
        }


        stage.isMaximized = true
        stage.show()
    }
}