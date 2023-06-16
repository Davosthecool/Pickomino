package Vue

import javafx.scene.layout.*
import javafx.scene.control.*
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.image.Image
import javafx.scene.image.ImageView
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


    init {
        // Configuration du contenu pour chaque joueur
        val dominoj1 = Label("JOUEUR 1")
        val dominoj2 = Label("JOUEUR 2")
        val dominoj3 = Label("JOUEUR 3")
        val dominoj4 = Label("JOUEUR 4")

        val joueurLabelFontSize = 20.0
        dominoj1.style = "-fx-font-weight: bold; -fx-font-size: ${joueurLabelFontSize}px"
        dominoj2.style = "-fx-font-weight: bold; -fx-font-size: ${joueurLabelFontSize}px"
        dominoj3.style = "-fx-font-weight: bold; -fx-font-size: ${joueurLabelFontSize}px"
        dominoj4.style = "-fx-font-weight: bold; -fx-font-size: ${joueurLabelFontSize}px"

        joueur1.children.add(dominoj1)
        joueur2.children.add(dominoj2)
        joueur3.children.add(dominoj3)
        joueur4.children.add(dominoj4)

        jeu.left = des1
        jeu.center = pouleCommune
        jeu.right = des2
        jeu.bottom = joueur1
        jeu.top = joueur3

        des1.prefWidth = 250.0
        des2.prefWidth = 250.0

        val RC_joueur1 = RowConstraints()

        RC_joueur1.minHeight = 200.0
        joueur1.rowConstraints.add(RC_joueur1)

        val RC_joueur2 = RowConstraints()
        val CC_joueur2 = ColumnConstraints()

        CC_joueur2.minWidth = 200.0
        joueur2.columnConstraints.add(CC_joueur2)


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
        left = joueur2
        right = joueur4


        joueur1.style = "-fx-background-color : #FF3D3D; -fx-background-radius: 30px;"
        joueur2.style = "-fx-background-color : #4FB6F0; -fx-background-radius: 30px"
        joueur3.style = "-fx-background-color : #FFE159; -fx-background-radius: 30px"
        joueur4.style = "-fx-background-color : #58C24A; -fx-background-radius: 30px"
        pouleCommune.style = "-fx-border-color : black; -fx-border-radius: 30px"
        des1.style = "-fx-border-color : black; -fx-border-radius: 30px"
        des2.style = "-fx-border-color : black; -fx-border-radius: 30px"

        // Appliquer les marges aux GridPane
        val margins = Insets(10.0)
        setMargin(jeu, margins)
        setMargin(pouleCommune, margins)
        setMargin(des1, margins)
        setMargin(des2, margins)
        setMargin(joueur1, margins)
        setMargin(joueur3, margins)

        val marginsJoueur2 = Insets(20.0, 10.0, 20.0, 20.0)
        setMargin(joueur2, marginsJoueur2)

        val marginsJoueur4 = Insets(20.0, 20.0, 20.0, 10.0)
        setMargin(joueur4, marginsJoueur4)



        pouleCommune.hgap = 10.0
        pouleCommune.vgap = 10.0

        val imagePathsPickominos = mutableListOf<String>()

        for (i in 21..36) {
            val imagePath = "ressources/Pickominos/$i.png"
            imagePathsPickominos.add(imagePath)
        }


        var columnIndexPickominos = 0
        var rowIndexPickominos = 0

        for (i in imagePathsPickominos.indices) {
            val input = FileInputStream(imagePathsPickominos[i])
            val image = Image(input)
            val imageView = ImageView(image)

            imageView.fitWidth = 100.0 // Set the desired width
            imageView.fitHeight = 200.0

            pouleCommune.add(
                imageView,
                columnIndexPickominos,
                rowIndexPickominos
            ) // Add the image to the pouleCommune GridPane

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
            "ressources/Dice/one.png",
            "ressources/Dice/two.png",
            "ressources/Dice/three.png",
            "ressources/Dice/four.png",
            "ressources/Dice/five.png",
            "ressources/Dice/five.png",
            "ressources/Dice/worm.png",
            "ressources/Dice/worm.png",
        )
        val row_coordonee = arrayOfNulls<Int>(8)
        val col_coordonee = arrayOfNulls<Int>(8)

        var columnIndexDice2 = 0
        var rowIndexDice2 = 0

        for (i in imagePathsDice.indices) {
            val input = FileInputStream(imagePathsDice[i])
            val image = Image(input)
            val imageView1 = ImageView(image)

            imageView1.fitWidth = 90.0 // Set the desired width
            imageView1.fitHeight = 90.0
            imageView1.style = "-fx-border-color: black; -fx-border-width: 20px;"

            des2.add(imageView1, columnIndexDice2, rowIndexDice2) // Add the image to the des2 GridPane

            col_coordonee[i] = columnIndexDice2
            row_coordonee[i] = rowIndexDice2

            rowIndexDice2++
            if (rowIndexDice2 == 4) {
                columnIndexDice2++
                rowIndexDice2 = 0
            }


            val imageView2 = ImageView(imageView1.image)

            imageView2.fitWidth = 90.0 // Set the desired width
            imageView2.fitHeight = 90.0
            imageView2.style = "-fx-border-color: black; -fx-border-width: 20px;"

            imageView1.setOnMouseClicked { event ->

                // Add the cloned image to des1 GridPane
                des1.add(imageView2, col_coordonee[i]!!.toInt(), row_coordonee[i]!!.toInt())

                // Remove the selected image from des2 GridPane
                des2.children.remove(imageView1)

                // Adjust the column and row indices
            }

            imageView2.setOnMouseClicked { event ->

                // Add the cloned image to des1 GridPane
                des2.add(imageView1, col_coordonee[i]!!.toInt(), row_coordonee[i]!!.toInt())

                // Remove the selected image from des2 GridPane
                des1.children.remove(imageView2)

                // Adjust the column and row indices
            }
        }

    }

}




    //prendre_joueur domino
    //prendre_centre domino
    //remettre_centre domino

    //choisir dé
    //gardé dé
    //lancé dé

    //debut partie
    //fin partie