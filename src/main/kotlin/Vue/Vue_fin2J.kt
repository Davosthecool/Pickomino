package Vue

import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.BorderPane
import javafx.scene.layout.GridPane

class Vue_fin2J : BorderPane(){

    val title : GridPane
    val score : GridPane

    val partie : BorderPane
    val btn1 : GridPane
    val btn2 : GridPane
    val quitter : Button
    val menu : Button

    init {
        title = GridPane()
        score  = GridPane()
        partie  = BorderPane()
        btn1 = GridPane()
        btn2 = GridPane()

        btn1.prefHeight = 200.0
        btn1.prefWidth = 800.0

        btn2.prefHeight = 200.0
        btn2.prefWidth = 800.0

        partie.prefHeight = 300.0

        quitter = Button("Quitter")
        menu = Button("Retourner au menu")


        val label = Label("Scores")

        title.add(label, 0, 0)

        label.style = "-fx-font-weight: bold; -fx-font-size: 250px;"

        title.alignment = Pos.CENTER

        top = title
        center = score
        bottom = partie

        partie.left = btn1
        partie.right = btn2

        btn1.add(quitter, 0, 0)
        btn2.add(menu, 0, 0)

        btn1.alignment = Pos.CENTER
        btn2.alignment = Pos.CENTER


        val  scoreJ1 = Label("Joueur1 : ")
        val  scoreJ2 = Label("Joueur2 : ")

        score.add(scoreJ1, 0, 0)
        score.add(scoreJ2, 0, 1)

        scoreJ1.style = "-fx-font-weight: bold; -fx-font-size: 50px; -fx-text-fill: white;"
        scoreJ2.style = "-fx-font-weight: bold; -fx-font-size: 50px; -fx-text-fill: white;"


        quitter.styleClass.addAll("button", "buttonFin")
        menu.styleClass.addAll("button", "buttonFin")


        score.vgap = 20.0
        score.alignment = Pos.CENTER

        this.styleClass.add("vue-menu")


    }
}