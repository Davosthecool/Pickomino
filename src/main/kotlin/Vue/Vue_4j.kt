package Vue

import javafx.application.Application
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.*
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.*
import javafx.scene.paint.Color
import javafx.stage.Stage
import java.io.FileInputStream

class Vue_4j: BorderPane() {
    val jeu = BorderPane()
    val des1 = GridPane()
    val des2 = GridPane()
    val pouleCommune = GridPane()
    val joueur1 = GridPane()
    var joueur2 = GridPane()
    var joueur3 = GridPane()
    var joueur4 = GridPane()

    val hbox = HBox()

    init {
        // Configuration du contenu pour chaque joueur
        val dominoj1 = Label("JOUEUR 1")
        val dominoj2 = Label("JOUEUR 2")
        val dominoj3 = Label("JOUEUR 3")
        val dominoj4 = Label("JOUEUR 4")
//        val des1L = Label("DÉS CHOISIS")
//        val des2L = Label("DÉS ACTIFS")
//        val poule = Label("POULE COMMUNE")

        val joueurLabelFontSize = 20.0
        dominoj1.style = "-fx-font-weight: bold; -fx-font-size: ${joueurLabelFontSize}px"
        dominoj2.style = "-fx-font-weight: bold; -fx-font-size: ${joueurLabelFontSize}px"
        dominoj3.style = "-fx-font-weight: bold; -fx-font-size: ${joueurLabelFontSize}px"
        dominoj4.style = "-fx-font-weight: bold; -fx-font-size: ${joueurLabelFontSize}px"
//        des1L.style = "-fx-font-weight: bold;"
//        des2L.style = "-fx-font-weight: bold;"
//        poule.style = "-fx-font-weight: bold;"



        joueur1.children.add(dominoj1)
        joueur2.children.add(dominoj2)
        joueur3.children.add(dominoj3)
        joueur4.children.add(dominoj4)
//        des1.children.add(des1L)
//        des2.children.add(des2L)
//        pouleCommune.children.add(poule)


        jeu.left = des1
        jeu.center = pouleCommune
        jeu.right = des2

        des1.prefWidth = 200.0
        des2.prefWidth = 200.0


        val RC_joueur1 = RowConstraints()

        RC_joueur1.minHeight = 200.0
        joueur1.rowConstraints.add(RC_joueur1)


        val RC_joueur2 = RowConstraints()
        val CC_joueur2 = ColumnConstraints()

        RC_joueur2.percentHeight = 100.0
        CC_joueur2.minWidth = 200.0
        joueur2.columnConstraints.add(CC_joueur2)
        joueur2.rowConstraints.add(RC_joueur2)


        val RC_joueur3 = RowConstraints()

        RC_joueur3.minHeight = 200.0
        joueur3.rowConstraints.add(RC_joueur3)


        val CC_joueur4 = ColumnConstraints()

        CC_joueur4.minWidth = 200.0
        joueur4.columnConstraints.add(CC_joueur4)


        joueur1.alignment = Pos.CENTER
        joueur3.alignment = Pos.CENTER
        pouleCommune.alignment = Pos.CENTER
        des1.alignment = Pos.CENTER
        des2.alignment = Pos.CENTER


        // Placement des joueurs dans le BorderPane
        center = jeu
        bottom = joueur1
        left = joueur2
        top = joueur3
        right = joueur4



        joueur1.style = " -fx-background-color : #3355BB;-fx-border-color : black ;"
        joueur2.style = "-fx-background-color : gold; -fx-border-color : black ;"
        joueur3.style = "-fx-background-color : #BB1212; -fx-border-color : black ;"
        joueur4.style = "-fx-background-color : lime; -fx-border-color : black ;"
        jeu.style = "-fx-"
        pouleCommune.style = "-fx-border-color : black"
        des1.style = "-fx-border-color : black"
        des2.style = "-fx-border-color : black"


        // Appliquer les marges aux GridPane
        val margins = Insets(10.0)
        setMargin(joueur1, margins)
        setMargin(joueur2, margins)
        setMargin(joueur3, margins)
        setMargin(joueur4, margins)
        setMargin(jeu, margins)


        pouleCommune.hgap = 10.0
        pouleCommune.vgap = 10.0

        val imagePathsPickominos = listOf(
            "ressources/Pickominos/21.png",
            "ressources/Pickominos/22.png",
            "ressources/Pickominos/23.png",
            "ressources/Pickominos/24.png",
            "ressources/Pickominos/25.png",
            "ressources/Pickominos/26.png",
            "ressources/Pickominos/27.png",
            "ressources/Pickominos/28.png",
            "ressources/Pickominos/29.png",
            "ressources/Pickominos/30.png",
            "ressources/Pickominos/31.png",
            "ressources/Pickominos/32.png",
            "ressources/Pickominos/33.png",
            "ressources/Pickominos/34.png",
            "ressources/Pickominos/35.png",
            "ressources/Pickominos/36.png"

            // Add more image paths as needed
        )


        var columnIndexPickominos = 0
        var rowIndexPickominos = 0

        for (i in imagePathsPickominos.indices) {
            val input = FileInputStream(imagePathsPickominos[i])
            val image = Image(input)
            val imageView = ImageView(image)

            imageView.fitWidth = 100.0 // Set the desired width
            imageView.fitHeight = 200.0
            imageView.style = "-fx-border-color: black; -fx-border-width: 20px;"

            pouleCommune.add(imageView, columnIndexPickominos, rowIndexPickominos) // Add the image to the pouleCommune GridPane

            columnIndexPickominos++
            if (columnIndexPickominos == 8) {
                rowIndexPickominos++
                columnIndexPickominos = 0
            }
        }

        des2.hgap = 10.0
        des2.vgap = 10.0

        des1.hgap = 10.0
        des1.vgap = 10.0

        val imagePathsDice = listOf(
            "ressources/Dice/worm.png",
            "ressources/Dice/worm.png",
            "ressources/Dice/worm.png",
            "ressources/Dice/worm.png",
            "ressources/Dice/worm.png",
            "ressources/Dice/worm.png",
            "ressources/Dice/worm.png",
            "ressources/Dice/worm.png",
        )


        var columnIndexDice = 0
        var rowIndexDice = 0

        for (i in imagePathsDice.indices) {
            val input = FileInputStream(imagePathsDice[i])
            val image = Image(input)
            val imageView1 = ImageView(image)

            imageView1.fitWidth = 90.0 // Set the desired width
            imageView1.fitHeight = 90.0
            imageView1.style = "-fx-border-color: black; -fx-border-width: 20px;"

            des2.add(imageView1, columnIndexDice, rowIndexDice) // Add the image to the des2 GridPane

            rowIndexDice++
            if (rowIndexDice == 4) {
                columnIndexDice++
                rowIndexDice = 0
            }

            val imageView2 = ImageView(imageView1.image)

            imageView2.fitWidth = 90.0 // Set the desired width
            imageView2.fitHeight = 90.0
            imageView2.style = "-fx-border-color: black; -fx-border-width: 20px;"

            imageView1.setOnMouseClicked { event ->

                // Add the cloned image to des1 GridPane
                des1.add(imageView2, columnIndexDice, rowIndexDice)

                // Remove the selected image from des2 GridPane
                des2.children.remove(imageView1)

                // Adjust the column and row indices
                rowIndexDice++
                if (rowIndexDice == 4) {
                    columnIndexDice++
                    rowIndexDice = 0
                }
            }

            imageView2.setOnMouseClicked { event ->

                // Add the cloned image to des1 GridPane
                des2.add(imageView1, columnIndexDice, rowIndexDice)

                // Remove the selected image from des2 GridPane
                des1.children.remove(imageView2)

                // Adjust the column and row indices
                rowIndexDice++
                if (rowIndexDice == 4) {
                    columnIndexDice++
                    rowIndexDice = 0
                }
            }


        }



        // Personnalisation des styles et marges
        hbox.alignment = Pos.CENTER // Centrer les composants dans la HBox
        setMargin(hbox, Insets(10.0)) // Appliquer les marges à la HBox

    }




    //prendre_joueur domino
    //prendre_centre domino
    //remettre_centre domino

    //choisir dé
    //gardé dé
    //lancé dé

    //debut partie
    //fin partie
}