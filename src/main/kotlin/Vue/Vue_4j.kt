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

        dominoj1.styleClass.add("domino")
        dominoj2.styleClass.add("domino")
        dominoj3.styleClass.add("domino")
        dominoj4.styleClass.add("domino")

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

        val RC_joueur = RowConstraints()

        RC_joueur.minHeight = 200.0
        joueur1.rowConstraints.add(RC_joueur)
        joueur3.rowConstraints.add(RC_joueur)

        val CC_joueur = ColumnConstraints()

        CC_joueur.minWidth = 200.0
        joueur2.columnConstraints.add(CC_joueur)
        joueur4.columnConstraints.add(CC_joueur)


        joueur1.alignment = Pos.CENTER
        joueur2.alignment = Pos.CENTER
        joueur3.alignment = Pos.CENTER
        joueur4.alignment = Pos.CENTER
        pouleCommune.alignment = Pos.CENTER
        des1.alignment = Pos.CENTER
        des2.alignment = Pos.CENTER

        center = jeu
        left = joueur2
        right = joueur4

        joueur1.styleClass.addAll("joueur1","joueur")
        joueur2.styleClass.addAll("joueur2","joueur")
        joueur3.styleClass.addAll("joueur3","joueur")
        joueur4.styleClass.addAll("joueur4","joueur")
        pouleCommune.styleClass.add("bordure",)
        des1.styleClass.add("bordure",)
        des2.styleClass.add("bordure",)

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
            val imagePath = "ressources/GameAssets/Light/Pickomino/$i.png"
            imagePathsPickominos.add(imagePath)
        }

        var columnIndexPickominos = 0
        var rowIndexPickominos = 0

        for (i in imagePathsPickominos.indices) {
            val input = FileInputStream(imagePathsPickominos[i])
            val image = Image(input)
            val imageView = ImageView(image)

            imageView.fitWidth = 100.0
            imageView.fitHeight = 200.0

            pouleCommune.add(imageView, columnIndexPickominos, rowIndexPickominos) // ajoute pouleCommune au GridPane

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

        val lance_de_des = intArrayOf(
            (1..6).random(),
            (1..6).random(),
            (1..6).random(),
            (1..6).random(),
            (1..6).random(),
            (1..6).random(),
            (1..6).random(),
            (1..6).random(),
        )
        val row_coordonee = arrayOfNulls<Int>(8)
        val col_coordonee = arrayOfNulls<Int>(8)

        var columnIndexDice2 = 0
        var rowIndexDice2 = 0

        for (i in lance_de_des.indices) {
            val input = FileInputStream("ressources/GameAssets/Light/Dice/"+lance_de_des[i]+".png")
            val image = Image(input)
            val imageView1 = ImageView(image)

            imageView1.styleClass.add("imageView")
            imageView1.fitWidth = 90.0
            imageView1.fitHeight = 90.0

            des2.add(imageView1, columnIndexDice2, rowIndexDice2) // ajoute les image de des dans des2 colonne ou les des sont lancés

            col_coordonee[i] = columnIndexDice2
            row_coordonee[i] = rowIndexDice2

            rowIndexDice2++
            if (rowIndexDice2 == 4) {
                columnIndexDice2++
                rowIndexDice2 = 0
            }

            val imageView2 = ImageView(imageView1.image)

            imageView2.styleClass.add("imageView")
            imageView2.fitWidth = 90.0
            imageView2.fitHeight = 90.0

            imageView1.setOnMouseClicked { event ->
                des1.add(imageView2, col_coordonee[i]!!.toInt(), row_coordonee[i]!!.toInt()) //ajoute l'image clonée depuis la colonne de droite dans la colonne de gauche qui est celle des dés choisis
                des2.children.remove(imageView1)
            }

            imageView2.setOnMouseClicked { event ->
                des2.add(imageView1, col_coordonee[i]!!.toInt(), row_coordonee[i]!!.toInt()) //ajoute l'image clonée depuis la colonne de gauche dans celle de droite
                des1.children.remove(imageView2)
            }
        }
    }
}