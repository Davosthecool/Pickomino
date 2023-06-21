package Vue

import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.layout.BorderPane
import javafx.scene.layout.GridPane

class Vue_fin3J : BorderPane(){

    val title : GridPane
    val score : GridPane

    init {
        title = GridPane()
        score  = GridPane()

        val label = Label("Score")

        title.add(label, 0, 0)

        label.style = "-fx-font-weight: bold; -fx-font-size: 250px;"

        title.alignment = Pos.CENTER

        top = title
        center = score


        val  scoreJ1 = Label("Joueur1 : ")
        val  scoreJ2 = Label("Joueur2 : ")
        val  scoreJ3 = Label("Joueur3 : ")

        score.add(scoreJ1, 0, 0)
        score.add(scoreJ2, 0, 1)
        score.add(scoreJ3, 0, 2)

        scoreJ1.style = "-fx-font-weight: bold; -fx-font-size: 80px; -fx-text-fill: white;"
        scoreJ2.style = "-fx-font-weight: bold; -fx-font-size: 80px; -fx-text-fill: white;"
        scoreJ3.style = "-fx-font-weight: bold; -fx-font-size: 80px; -fx-text-fill: white;"

        score.vgap = 20.0
        score.alignment = Pos.CENTER

        this.styleClass.add("vue-menu")


    }
}