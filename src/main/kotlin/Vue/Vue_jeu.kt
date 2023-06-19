package Vue

import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.GridPane
import java.io.FileInputStream

interface Vue_jeu {
    fun updatePouleCommune(listDomino:MutableList<Int>)
    fun updateDice(listDe:MutableList<Int>,target : GridPane)
    fun updateDomino(listDomino:MutableList<MutableList<Int>>)
}