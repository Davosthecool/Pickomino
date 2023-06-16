package Vue

import javafx.scene.layout.*
import javafx.scene.control.*
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import java.io.FileInputStream
class Vue_2j:BorderPane() {

    val jeu = BorderPane()

    val des1 = GridPane()
    val des2 = GridPane()

    val pouleCommune = GridPane()

    val joueur1 = BorderPane()
    var scoreJoueur1 = GridPane()
    var dominoJoueur1 = GridPane()

    var joueur2 = BorderPane()
    var scoreJoueur2 = GridPane()
    var dominoJoueur2 = GridPane()




    init {

        val dominoj1 = Label("JOUEUR 1")
        val dominoj2 = Label("JOUEUR 2")

        val joueurLabelFontSize = 20.0
        dominoj1.style = "-fx-font-weight: bold; -fx-font-size: ${joueurLabelFontSize}px"
        dominoj2.style = "-fx-font-weight: bold; -fx-font-size: ${joueurLabelFontSize}px"

        joueur1.children.add(dominoj1)
        joueur2.children.add(dominoj2)


        jeu.left = des1
        jeu.center = pouleCommune
        jeu.right = des2

        joueur1.left = dominoJoueur1
        joueur1.right = scoreJoueur1

        joueur2.left = dominoJoueur2
        joueur2.right = scoreJoueur2

        scoreJoueur1.prefWidth = 950.0
        dominoJoueur1.prefWidth = 950.0

        scoreJoueur2.prefWidth = 950.0
        dominoJoueur2.prefWidth = 950.0

        des1.prefWidth = 250.0
        des2.prefWidth = 250.0

        joueur1.prefHeight = 200.0
        joueur2.prefHeight = 200.0



        pouleCommune.alignment = Pos.CENTER
        des1.alignment = Pos.CENTER
        des2.alignment = Pos.CENTER

        center = jeu
        bottom = joueur1
        top = joueur2

        joueur1.style = "-fx-background-color : #FF3D3D"
        scoreJoueur1.style = "-fx-border-color : black"
        dominoJoueur1.style = "-fx-border-color : black"

        joueur2.style = "-fx-background-color : #4FB6F0;"
        scoreJoueur2.style = "-fx-border-color : black"
        dominoJoueur2.style = "-fx-border-color : black"

        pouleCommune.style = "-fx-border-color : black"
        des1.style = "-fx-border-color : black"
        des2.style = "-fx-border-color : black"

        val margins = Insets(10.0)
        BorderPane.setMargin(joueur1, margins)
        BorderPane.setMargin(joueur2, margins)
        BorderPane.setMargin(jeu, margins)

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