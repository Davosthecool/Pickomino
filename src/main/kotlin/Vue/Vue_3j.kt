package Vue

import javafx.scene.layout.*
import javafx.scene.control.*
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import java.io.FileInputStream

class Vue_3j(theme:String,id:Int,key:Int): BorderPane() {
    val id = id
    val key = key
    val theme = theme
    var jeu = BorderPane()
    var des = GridPane()
    var des1 = GridPane()
    var des2 = GridPane()
    var pouleCommune = GridPane()
    var joueur1 = BorderPane()
    var joueur2 = BorderPane()
    var joueur3 = BorderPane()

    val infoSalon = GridPane()
    val numeroSalon = GridPane()
    val cleSalon = GridPane()

    var dominoJ1 = GridPane()
    var scoreJ1 = GridPane()
    var actionJ1 = GridPane()

    var dominoJ2 = GridPane()
    var scoreJ2 = GridPane()
    var actionJ2 = GridPane()

    var dominoJ3 = GridPane()
    var scoreJ3 = GridPane()
    var actionJ3 = GridPane()

    val lancerDes1 = Button("Lancer les dés")
    val validerChoixDes1 = Button("Valider le choix\n des dés")

    val lancerDes2 = Button("Lancer les dés")
    val validerChoixDes2 = Button("Valider le choix\n des dés")

    val lancerDes3 = Button("Lancer les dés")
    val validerChoixDes3 = Button("Valider le choix\n des dés")

    init {

        val numSalon = Label("Numéro du Salon : ${this.id}")
        val clSalon = Label("Clé du Salon : ${this.key}")

        numeroSalon.children.add(numSalon)
        cleSalon.children.add(clSalon)

        infoSalon.prefHeight = 40.0

        numeroSalon.prefWidth = 1000.0
        cleSalon.prefWidth = 1000.0

        numeroSalon.prefHeight = 40.0
        cleSalon.prefHeight = 40.0

        des1.prefWidth = 750.0
        des2.prefWidth = 750.0

        des2.prefHeight = 250.0
        des2.prefHeight = 250.0

        joueur1.prefHeight = 200.0
        joueur2.prefWidth = 200.0
        joueur3.prefWidth = 200.0

        jeu.bottom = joueur1
        jeu.top = des
        jeu.center = pouleCommune

        joueur1.left = dominoJ1
        joueur1.right = scoreJ1
        joueur1.center = actionJ1

        joueur2.top = dominoJ2
        joueur2.bottom = scoreJ2
        joueur2.center = actionJ2

        joueur3.top = dominoJ3
        joueur3.bottom = scoreJ3
        joueur3.center = actionJ3

        des.add(des1, 0, 0)
        des.add(des2, 2, 0)

        dominoJ1.prefWidth = 300.0
        scoreJ1.prefWidth = 300.0

        dominoJ2.prefHeight = 300.0
        scoreJ2.prefHeight = 300.0

        dominoJ3.prefHeight = 300.0
        scoreJ3.prefHeight = 300.0

        infoSalon.hgap = 10.0

        center = jeu
        left = joueur2
        right = joueur3
        top = infoSalon

        numeroSalon.alignment = Pos.CENTER
        cleSalon.alignment = Pos.CENTER

        pouleCommune.alignment = Pos.CENTER
        des1.alignment = Pos.CENTER
        des2.alignment = Pos.CENTER

        dominoJ1.alignment = Pos.CENTER
        dominoJ2.alignment = Pos.CENTER
        dominoJ3.alignment = Pos.CENTER

        actionJ1.alignment = Pos.CENTER
        actionJ2.alignment = Pos.CENTER
        actionJ3.alignment = Pos.CENTER


        infoSalon.add(numeroSalon, 0, 0)
        infoSalon.add(cleSalon, 1, 0)

        actionJ1.add(lancerDes1, 0, 0)
        actionJ1.add(validerChoixDes1, 0, 1)

        actionJ2.add(lancerDes2, 0, 0)
        actionJ2.add(validerChoixDes2, 0, 1)

        actionJ3.add(lancerDes3, 0, 0)
        actionJ3.add(validerChoixDes3, 0, 1)

        joueur3.styleClass.addAll("joueurv")
        joueur2.styleClass.addAll("joueurv")
        joueur1.styleClass.addAll("joueurh")

        lancerDes1.styleClass.addAll("button-action")
        validerChoixDes1.styleClass.addAll("button-action")

        lancerDes2.styleClass.addAll("button-action")
        validerChoixDes2.styleClass.addAll("button-action")

        lancerDes3.styleClass.addAll("button-action")
        validerChoixDes3.styleClass.addAll("button-action")

        dominoJ1.styleClass.addAll("joueur1", "joueur", "bordure")
        dominoJ2.styleClass.addAll("joueur2", "joueur", "bordure")
        dominoJ3.styleClass.addAll("joueur3", "joueur", "bordure")

        scoreJ1.styleClass.addAll("joueur1", "joueur", "bordure")
        scoreJ2.styleClass.addAll("joueur2", "joueur", "bordure")
        scoreJ3.styleClass.addAll("joueur3", "joueur", "bordure")

        actionJ1.styleClass.addAll("joueur1", "joueur", "bordure","action")
        actionJ2.styleClass.addAll("joueur2", "joueur", "bordure","action")
        actionJ3.styleClass.addAll("joueur3", "joueur", "bordure","action")

        pouleCommune.styleClass.add("bordure",)
        des1.styleClass.add("bordure",)
        des2.styleClass.add("bordure",)

        numeroSalon.styleClass.add("bordure")
        cleSalon.styleClass.add("bordure")

        numSalon.styleClass.add("domino")
        clSalon.styleClass.add("domino")

        val marginJeux = Insets(20.0, 10.0, 20.0, 10.0)
        setMargin(jeu, marginJeux)

        val marginPoule = Insets(20.0, 0.0, 20.0, 0.0)
        setMargin(pouleCommune, marginPoule)

        val marginj2 = Insets(20.0, 10.0, 20.0, 20.0)
        setMargin(joueur2, marginj2)

        val marginj3 = Insets(20.0, 20.0, 20.0, 10.0)
        setMargin(joueur3, marginj3)

        val marginHaut = Insets(20.0, 20.0, 0.0, 20.0)
        setMargin(infoSalon, marginHaut)

        des.hgap = 10.0

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

            columnIndexDice2++
            if (columnIndexDice2 == 4) {
                rowIndexDice2++
                columnIndexDice2 = 0
            }

            val imageView2 = ImageView(imageView1.image)

            imageView2.styleClass.add("imageView")
            imageView2.fitWidth = 90.0
            imageView2.fitHeight = 90.0

            imageView1.setOnMouseClicked { event ->
                des1.add(imageView2, col_coordonee[i]!!.toInt(), row_coordonee[i]!!.toInt()) //ajoute l'image clonée depuis la colonne de droite dans la colonne de gauche qui est celle des dés choisis
                des2.children.remove(imageView1) //
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

        }
    }
}