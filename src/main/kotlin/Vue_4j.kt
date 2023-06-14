import javafx.application.Application
import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.*
import javafx.scene.paint.Color
import javafx.stage.Stage

class Vue_4j: BorderPane() {
    init {
        val jeu = BorderPane()
        val joueur1 = GridPane()
        val joueur2 = GridPane()
        val joueur3 = GridPane()
        val joueur4 = GridPane()

        val RC_joueur1 = RowConstraints()
        val CC_joueur1 = ColumnConstraints()
        RC_joueur1.minHeight = 100.0
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

        this.bottom=joueur1
        this.top=joueur2
        this.right=joueur3
        this.left=joueur4
        this.center=jeu

        BorderPane.setMargin(joueur1, Insets(10.0, 0.0, 0.0, 0.0))
        BorderPane.setMargin(joueur2, Insets(0.0, 0.0, 10.0, 0.0))
        BorderPane.setMargin(joueur3, Insets(0.0, 0.0, 0.0, 10.0))
        BorderPane.setMargin(joueur4, Insets(0.0, 10.0, 0.0, 0.0))
    }

}