package Controleur

import Modele.Modele_jeu
import Modele.Modele_menu
import Vue.Vue_2j
import Vue.Vue_3j
import Vue.Vue_menu
import iut.info1.pickomino.Connector
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.stage.Stage

class ControleurLaunchGame(vue:Vue_menu,modmenu:Modele_menu,stage: Stage,modjeu : Modele_jeu):EventHandler<ActionEvent> {
    val modmenu = modmenu
    val vue = vue
    val stage = stage
    val modjeu = modjeu
    override fun handle(event: ActionEvent?) {
        stage.hide()
        //lancement partie
        val connect = Connector.factory("172.26.82.76", "8080")
        println("Parties actives sur le serveur = ${connect.listOfGameIds()}")
        val identification = connect.newGame(modmenu.nbjoueur)
        val id = identification.first
        val key = identification.second
        val currentGame = connect.gameState(id, key)
        println("Nouvelle partie : $currentGame | clé : ${key} id : ${id}")
        if (modmenu.isLocal==false) {
            println("Lancement de la partie en ligne pour ${modmenu.nbjoueur} joueurs")
        } else {
            println("Lancement de la partie en local pour ${modmenu.nbjoueur} joueurs")
        }
        //changement vue
        if (modmenu.nbjoueur==4) {
            stage.scene.root=Vue_4j()
        } else if (modmenu.nbjoueur==3) {
            stage.scene.root= Vue_3j()
        } else if (modmenu.nbjoueur==2) {
            stage.scene.root= Vue_2j()
        }
        //update Modele_Jeu
        modjeu.key=key
        modjeu.id=id
        modjeu.isLocal=modmenu.isLocal
        modjeu.nbjoueur=modmenu.nbjoueur
        modjeu.vue=stage.scene.root

        stage.isMaximized = true
        stage.show()
    }
}
