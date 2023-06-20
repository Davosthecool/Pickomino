package Vue

import Modele.Jeu
import iut.info1.pickomino.Connector
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.Button
import javafx.scene.input.MouseEvent
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox

interface Vue_jeu {

    val desActif : VBox
    val lanceDes : Button
    val desChoisi : VBox
    fun updatePouleCommune(listDomino:MutableList<Int>)
    fun updateDice(listDe:MutableList<String>,target : VBox)
    fun updateDomino(listDomino:MutableList<Int>)
    fun fixeBouton(bouton : Button, ecouteur : EventHandler<ActionEvent>)
    fun fixeVbox(box : VBox, ecouteur: EventHandler<MouseEvent>, modele : Jeu, connect : Connector)
}