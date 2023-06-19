package Vue

import javafx.scene.layout.*
import javafx.scene.control.*
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import java.io.FileInputStream

class Vue_4j(theme:String,id:Int,key:Int): BorderPane() {
    var id = id
    var key = key
    var theme = theme
    val jeu = BorderPane()
    val des1 = GridPane()
    val des2 = GridPane()
    val pouleCommune = GridPane()
    val joueur1 = BorderPane()
    val joueur2 = BorderPane()
    val joueur3 = BorderPane()
    val joueur4 = BorderPane()

    val infoSalon = GridPane()
    val numeroSalon = GridPane()
    val cleSalon = GridPane()

    val dominoJ1 = GridPane()
    val scoreJ1 = GridPane()
    val actionJ1 = GridPane()

    val dominoJ2 = GridPane()
    val scoreJ2 = GridPane()
    val actionJ2 = GridPane()

    val dominoJ3 = GridPane()
    val scoreJ3 = GridPane()
    val actionJ3 = GridPane()

    val dominoJ4 = GridPane()
    val scoreJ4 = GridPane()
    val actionJ4 = GridPane()

    val lancerDes1 = Button("Lancer les dés")
    val validerChoixDes1 = Button("Valider le choix\n des dés")

    val lancerDes2 = Button("Lancer les dés")
    val validerChoixDes2 = Button("Valider le choix\n des dés")

    val lancerDes3 = Button("Lancer les dés")
    val validerChoixDes3 = Button("Valider le choix\n des dés")

    val lancerDes4 = Button("Lancer les dés")
    val validerChoixDes4 = Button("Valider le choix\n des dés")

    init {

        val numSalon = Label("Numéro du Salon : ${id}")
        val clSalon = Label("Clé du Salon : ${key}")

        numeroSalon.children.add(numSalon)
        cleSalon.children.add(clSalon)


        infoSalon.prefHeight = 40.0

        numeroSalon.prefWidth = 1000.0
        cleSalon.prefWidth = 1000.0

        numeroSalon.prefHeight = 40.0
        cleSalon.prefHeight = 40.0

        des1.prefWidth = 250.0
        des2.prefWidth = 250.0

        joueur1.prefHeight = 200.0
        joueur2.prefWidth = 200.0
        joueur3.prefHeight = 200.0
        joueur4.prefWidth = 200.0

        jeu.left = des1
        jeu.center = pouleCommune
        jeu.right = des2
        jeu.bottom = joueur1
        jeu.top = joueur3

        joueur1.left = dominoJ1
        joueur1.right = scoreJ1
        joueur1.center = actionJ1

        joueur2.top = dominoJ2
        joueur2.bottom = scoreJ2
        joueur2.center = actionJ2

        joueur3.left = dominoJ3
        joueur3.right = scoreJ3
        joueur3.center = actionJ3

        joueur4.top = dominoJ4
        joueur4.bottom = scoreJ4
        joueur4.center = actionJ4

        dominoJ1.prefWidth = 300.0
        scoreJ1.prefWidth = 300.0

        dominoJ2.prefHeight = 300.0
        scoreJ2.prefHeight = 300.0

        dominoJ3.prefWidth = 300.0
        scoreJ3.prefWidth = 300.0

        dominoJ4.prefHeight = 300.0
        scoreJ4.prefHeight = 300.0

        infoSalon.hgap = 10.0

        center = jeu
        left = joueur2
        right = joueur4
        top = infoSalon

        numeroSalon.alignment = Pos.CENTER
        cleSalon.alignment = Pos.CENTER

        pouleCommune.alignment = Pos.CENTER
        des1.alignment = Pos.CENTER
        des2.alignment = Pos.CENTER

        dominoJ1.alignment = Pos.CENTER
        dominoJ2.alignment = Pos.CENTER
        dominoJ3.alignment = Pos.CENTER
        dominoJ4.alignment = Pos.CENTER

        actionJ1.alignment = Pos.CENTER
        actionJ2.alignment = Pos.CENTER
        actionJ3.alignment = Pos.CENTER
        actionJ4.alignment = Pos.CENTER

        infoSalon.add(numeroSalon, 0, 0)
        infoSalon.add(cleSalon, 1, 0)

        actionJ1.add(lancerDes1, 0, 0)
        actionJ1.add(validerChoixDes1, 0, 1)

        actionJ2.add(lancerDes2, 0, 0)
        actionJ2.add(validerChoixDes2, 0, 1)

        actionJ3.add(lancerDes3, 0, 0)
        actionJ3.add(validerChoixDes3, 0, 1)

        actionJ4.add(lancerDes4, 0, 0)
        actionJ4.add(validerChoixDes4, 0, 1)

        joueur4.styleClass.addAll("joueurhv")
        joueur3.styleClass.addAll("joueurhv")
        joueur2.styleClass.addAll("joueurhv")
        joueur1.styleClass.addAll("joueurhv")

        lancerDes1.styleClass.addAll("button-action")
        validerChoixDes1.styleClass.addAll("button-action")

        lancerDes2.styleClass.addAll("button-action")
        validerChoixDes2.styleClass.addAll("button-action")

        lancerDes3.styleClass.addAll("button-action")
        validerChoixDes3.styleClass.addAll("button-action")

        lancerDes4.styleClass.addAll("button-action")
        validerChoixDes4.styleClass.addAll("button-action")

        dominoJ1.styleClass.addAll("joueur1", "joueur", "bordure")
        dominoJ2.styleClass.addAll("joueur2", "joueur", "bordure")
        dominoJ3.styleClass.addAll("joueur3", "joueur", "bordure")
        dominoJ4.styleClass.addAll("joueur4", "joueur", "bordure")

        scoreJ1.styleClass.addAll("joueur1", "joueur", "bordure")
        scoreJ2.styleClass.addAll("joueur2", "joueur", "bordure")
        scoreJ3.styleClass.addAll("joueur3", "joueur", "bordure")
        scoreJ4.styleClass.addAll("joueur4", "joueur", "bordure")

        actionJ1.styleClass.addAll("joueur1", "joueur", "bordure","action")
        actionJ2.styleClass.addAll("joueur2", "joueur", "bordure","action")
        actionJ3.styleClass.addAll("joueur3", "joueur", "bordure","action")
        actionJ4.styleClass.addAll("joueur4", "joueur", "bordure","action")

        pouleCommune.styleClass.add("bordure")
        des1.styleClass.add("bordure")
        des2.styleClass.add("bordure")

        numeroSalon.styleClass.add("bordure")
        cleSalon.styleClass.add("bordure")

        numSalon.styleClass.add("domino")
        clSalon.styleClass.add("domino")

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

        val marginHaut = Insets(20.0, 20.0, 0.0, 20.0)
        setMargin(infoSalon, marginHaut)

        pouleCommune.hgap = 10.0
        pouleCommune.vgap = 10.0

        val imagePathsPickominos = mutableListOf<String>()

        for (i in 21..36) {
            val imagePath = "src/main/resources/GameAssets/${this.theme}/Pickomino/$i.png"
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
            val input = FileInputStream("src/main/resources/GameAssets/${this.theme}/Dice/"+lance_de_des[i]+".png")
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
                println("$des1")
            }

            imageView2.setOnMouseClicked { event ->
                des2.add(imageView1, col_coordonee[i]!!.toInt(), row_coordonee[i]!!.toInt()) //ajoute l'image clonée depuis la colonne de gauche dans celle de droite
                des1.children.remove(imageView2)
            }
        }





        //Attribution Domino joueur (décoratif)
        val aleaDominos = List(4) { (21..36).random() }

        for (i in aleaDominos.indices) {
            val aleaDomino = aleaDominos[i]
            val input = FileInputStream("src/main/resources/GameAssets/${this.theme}/Pickomino/$aleaDomino.png")
            val image = Image(input)

            val imageView1 = ImageView(image)
            imageView1.styleClass.addAll("imageView")
            imageView1.fitWidth = 100.0
            imageView1.fitHeight = 200.0
            dominoJ1.add(imageView1, 0, 0)

            val imageView2 = ImageView(image)
            imageView2.styleClass.addAll("imageView")
            imageView2.fitWidth = 100.0
            imageView2.fitHeight = 200.0
            dominoJ2.add(imageView2, 0, 0)

            val imageView3 = ImageView(image)
            imageView3.styleClass.addAll("imageView")
            imageView3.fitWidth = 100.0
            imageView3.fitHeight = 200.0
            dominoJ3.add(imageView3, 0, 0)

            val imageView4 = ImageView(image)
            imageView4.styleClass.addAll("imageView")
            imageView4.fitWidth = 100.0
            imageView4.fitHeight = 200.0
            dominoJ4.add(imageView4, 0, 0)
        }


    }
}