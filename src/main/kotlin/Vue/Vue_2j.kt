package Vue

import javafx.scene.layout.*
import javafx.scene.control.*
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import java.io.FileInputStream
import java.util.*
import kotlin.random.Random

class Vue_2j(theme:String,id:Int,key:Int): BorderPane() {
    val id = id
    val key = key
    val theme = theme
    val jeu = BorderPane()
    val des1 = GridPane()
    val des2 = GridPane()
    val pouleCommune = GridPane()
    val joueur1 = BorderPane()
    var joueur2 = BorderPane()

    val haut = BorderPane()

    val infoSalon = GridPane()
    val numeroSalon = GridPane()
    val cleSalon = GridPane()

    var dominoJ1 = GridPane()
    var scoreJ1 = GridPane()
    var actionJ1 = GridPane()

    var dominoJ2 = GridPane()
    var scoreJ2 = GridPane()
    var actionJ2 = GridPane()

    val lancerDes1 = Button("Lancer les dés")
    val validerChoixDes1 = Button("Valider le choix\n des dés")

    val lancerDes2 = Button("Lancer les dés")
    val validerChoixDes2 = Button("Valider le choix\n des dés")

    init {
        val numSalon = Label("Numéro du Salon : ${this.id}")
        val clSalon = Label("Clé du Salon : ${this.key}")
        //style
        infoSalon.prefHeight = 40.0

        numeroSalon.prefWidth = 1000.0
        cleSalon.prefWidth = 1000.0

        numeroSalon.prefHeight = 40.0
        cleSalon.prefHeight = 40.0

        joueur1.prefHeight = 200.0
        joueur2.prefHeight = 200.0

        des1.prefWidth = 250.0
        des2.prefWidth = 250.0

        infoSalon.hgap = 10.0

        pouleCommune.hgap = 10.0
        pouleCommune.vgap = 10.0

        dominoJ1.prefWidth = 300.0
        scoreJ1.prefWidth = 300.0

        dominoJ2.prefWidth = 300.0
        scoreJ2.prefWidth = 300.0

        numeroSalon.alignment = Pos.CENTER
        cleSalon.alignment = Pos.CENTER

        pouleCommune.alignment = Pos.CENTER
        des1.alignment = Pos.CENTER
        des2.alignment = Pos.CENTER

        dominoJ1.alignment = Pos.CENTER
        dominoJ2.alignment = Pos.CENTER

        actionJ1.alignment = Pos.CENTER
        actionJ2.alignment = Pos.CENTER

        setMargin(jeu, Insets(20.0, 20.0, 20.0, 20.0))
        setMargin(pouleCommune, Insets(0.0, 20.0, 0.0, 20.0))
        setMargin(joueur1, Insets(0.0, 20.0, 20.0, 20.0))
        setMargin(joueur2, Insets(20.0, 0.0, 0.0, 0.0))
        setMargin(haut, Insets(20.0, 20.0, 0.0, 20.0))

        des2.hgap = 10.0
        des2.vgap = 10.0

        des1.hgap = 10.0
        des1.vgap = 10.0

        lancerDes1.styleClass.addAll("button-action")
        validerChoixDes1.styleClass.addAll("button-action")

        lancerDes2.styleClass.addAll("button-action")
        validerChoixDes2.styleClass.addAll("button-action")

        dominoJ1.styleClass.addAll("joueur1", "joueur", "bordure")
        dominoJ2.styleClass.addAll("joueur2", "joueur", "bordure")

        scoreJ1.styleClass.addAll("joueur1", "joueur", "bordure")
        scoreJ2.styleClass.addAll("joueur2", "joueur", "bordure")

        actionJ1.styleClass.addAll("joueur1", "joueur", "bordure","action","joueurh")
        actionJ2.styleClass.addAll("joueur2", "joueur", "bordure","action","joueurh")

        pouleCommune.styleClass.add("bordure")
        des1.styleClass.add("bordure")
        des2.styleClass.add("bordure")

        numeroSalon.styleClass.add("bordure")
        cleSalon.styleClass.add("bordure")

        numSalon.styleClass.add("domino")
        clSalon.styleClass.add("domino")

        //ajout éléments
        numeroSalon.children.add(numSalon)
        cleSalon.children.add(clSalon)

        haut.top = infoSalon
        haut.bottom = joueur2

        jeu.left = des1
        jeu.center = pouleCommune
        jeu.right = des2

        joueur1.left = dominoJ1
        joueur1.right = scoreJ1
        joueur1.center = actionJ1

        joueur2.left = dominoJ2
        joueur2.right = scoreJ2
        joueur2.center = actionJ2

        center = jeu
        bottom = joueur1
        top = haut

        infoSalon.add(numeroSalon, 0, 0)
        infoSalon.add(cleSalon, 1, 0)

        actionJ1.add(lancerDes1, 0, 0)
        actionJ1.add(validerChoixDes1, 0, 1)

        actionJ2.add(lancerDes2, 0, 0)
        actionJ2.add(validerChoixDes2, 0, 1)

        //affichage pickomino poule commune
        val simulatedPouleCommune = mutableListOf(21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36)
        updatePouleCommune(simulatedPouleCommune)
        //lance dés (simulé)
        val simulatedDice = mutableListOf(1,2,3,4,5,6)//MutableList(8) { (1..6).random() }
        updateDice(simulatedDice,des2)

        //Attribution Domino joueur (simulé)
        val simulatedDominoPlayer = mutableListOf(21,23,36)
        val simulatedDominoPlayer1 = mutableListOf(28,24,32)
        val simulatedDominoAll= mutableListOf(simulatedDominoPlayer,simulatedDominoPlayer1)

        updateDomino(simulatedDominoAll)

    }
    fun updatePouleCommune(listDomino:MutableList<Int>) {
        val imagePathsPickominos = mutableListOf<String>()

        for (i in listDomino) {
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
    }
    fun updateDice(listDe:MutableList<Int>,target : GridPane) {
        val row_coordonee = arrayOfNulls<Int>(8)
        val col_coordonee = arrayOfNulls<Int>(8)

        var columnIndexDice2 = 0
        var rowIndexDice2 = 0

        for (i in listDe.indices) {
            val input = FileInputStream("src/main/resources/GameAssets/${this.theme}/Dice/${listDe[i]}.png")
            val image = Image(input)
            val imageView1 = ImageView(image)

            imageView1.styleClass.add("imageView")
            imageView1.fitWidth = 90.0
            imageView1.fitHeight = 90.0

            target.add(imageView1, columnIndexDice2, rowIndexDice2) // ajoute les image de des dans des2 colonne ou les des sont lancés

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
        }
    }
    fun updateDomino(listDomino:MutableList<MutableList<Int>>) {
        var dominoTop = listDomino[0][listDomino[0].size - 1]
        var image = Image(FileInputStream("src/main/resources/GameAssets/${this.theme}/Pickomino/${dominoTop}.png"))

        val imageView1 = ImageView(image)
        imageView1.styleClass.addAll("imageView")
        imageView1.fitWidth = 100.0
        imageView1.fitHeight = 200.0
        dominoJ1.add(imageView1, 0, 0)

        dominoTop = listDomino[1][listDomino[1].size - 1]
        image = Image(FileInputStream("src/main/resources/GameAssets/${this.theme}/Pickomino/${dominoTop}.png"))

        val imageView2 = ImageView(image)
        imageView2.styleClass.addAll("imageView")
        imageView2.fitWidth = 100.0
        imageView2.fitHeight = 200.0
        dominoJ2.add(imageView2, 0, 0)
    }
}