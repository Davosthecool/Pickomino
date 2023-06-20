package Vue

import javafx.scene.control.Button
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox

interface Vue_jeu {

    val desActif : VBox
    val lanceDes : Button
    fun updatePouleCommune(listDomino:MutableList<Int>)
    fun updateDice(listDe:MutableList<String>,target : VBox)
    fun updateDomino(listDomino:MutableList<Int>)
}