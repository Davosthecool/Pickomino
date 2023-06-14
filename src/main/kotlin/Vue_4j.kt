package ihm.td2

import javafx.application.Application
import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.Border
import javafx.scene.layout.BorderPane
import javafx.scene.layout.ColumnConstraints
import javafx.scene.layout.GridPane
import javafx.scene.layout.RowConstraints
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.stage.Stage


class Vue4j: Application() {

    override fun start(stage: Stage) {
        stage.title="GridPane example"
        val root = BorderPane()
        root.padding = Insets(10.0, 10.0, 10.0, 10.0)

        val jeu = GridPane()
        val joueur1 = GridPane()
        val joueur2 = GridPane()
        val joueur3 = GridPane()
        val joueur4 = GridPane()

        val RC_joueur1 = RowConstraints()
        val CC_joueur1 = ColumnConstraints()
        RC_joueur1.minHeight= 100.0
        CC_joueur1.maxWidth = 10.0
        joueur1.rowConstraints.add(RC_joueur1)
        joueur1.columnConstraints.add(CC_joueur1)

        val RC_joueur2 = RowConstraints()
        RC_joueur2.minHeight= 100.0
        joueur2.rowConstraints.add(RC_joueur2)

        val CC_joueur3 = ColumnConstraints()
        CC_joueur3.minWidth= 100.0
        joueur3.columnConstraints.add(CC_joueur3)

        val CC_joueur4 = ColumnConstraints()
        CC_joueur4.minWidth= 100.0
        joueur4.columnConstraints.add(CC_joueur4)

//        val CC_jeu = ColumnConstraints()
//        val RC_jeu = RowConstraints()
//        CC_jeu.minWidth= 100.0
//        RC_jeu.minHeight=100.0
//        jeu.columnConstraints.add(CC_jeu)
//        jeu.rowConstraints.add(RC_jeu)

        root.bottom=joueur1
        root.top=joueur2
        root.right=joueur3
        root.left=joueur4
        root.center=jeu

        BorderPane.setMargin(joueur1, Insets(10.0, 0.0, 0.0, 0.0))
        BorderPane.setMargin(joueur2, Insets(0.0, 0.0, 10.0, 0.0))
        BorderPane.setMargin(joueur3, Insets(0.0, 0.0, 0.0, 10.0))
        BorderPane.setMargin(joueur4, Insets(0.0, 10.0, 0.0, 0.0))

        root.bottom.style="-fx-background-color: red ; -fx-border-color:black"
        root.top.style="-fx-background-color: blue; -fx-border-color:black"
        root.right.style="-fx-background-color: green; -fx-border-color:black"
        root.left.style="-fx-background-color: yellow; -fx-border-color:black"
        root.center.style="-fx-background-color: white; -fx-border-color:black"



        root.maxHeight= Double.MAX_VALUE
        val scene = Scene(root, 800.0, 600.0)
        stage.scene=scene
        scene.fill = Color.web("#A0A0A0");
        stage.show()
    }
}