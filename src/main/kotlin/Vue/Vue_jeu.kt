package Vue

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox

interface Vue_jeu {
    fun updatePouleCommune(listDomino:MutableList<Int>)
    fun updateDice(listDe:MutableList<String>,target : VBox)
    fun updateDomino(listDomino:MutableList<Int>)
}