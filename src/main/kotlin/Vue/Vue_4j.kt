package Vue

import javafx.geometry.Orientation
import javafx.scene.layout.*
import javafx.scene.control.*
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.paint.Color
import javafx.scene.paint.CycleMethod
import javafx.scene.paint.RadialGradient
import javafx.scene.paint.Stop
import java.io.FileInputStream


class Vue_4j(theme:String,id:Int,key:Int): VBox(),Vue_jeu {
    val theme = theme

    //ligne principals
    val ligneHaut = HBox()
    val ligneMilieu = HBox()
    val ligneBas = HBox()


    //ligne haut
    //joueur4
    val joueur4 = HBox()
    val domino4 : ImageView
    val score4 = Label("SCORE : 40")
    //info jeu
    val container_info = VBox()
    val salon = Label("ID du salon : ${id}")
    val cle = Label("Clé du salon : ${key}")
    //joueur3
    val joueur3 = HBox()
    val domino3 : ImageView
    val score3 = Label("SCORE : 40")

    //ligne milieu
    val desChoisi = VBox()
    val pouleCommune = FlowPane()
    val desActif = VBox()

    //ligne bas

    //joueur2
    val joueur2 = HBox()
    val domino2 : ImageView
    val score2 = Label("SCORE : 40")
    //lancer des
    val lanceDes = Button("Lancer le(s) dé(s)")
    //joueur1
    val joueur1 = HBox()
    val domino1 : ImageView
    val score1 = Label("SCORE : 40")
    init {
        //init domino joueur
        domino1= ImageView(Image(FileInputStream("src/main/resources/GameAssets/$theme/Pickomino/EmptyPicko.png")))
        domino2= ImageView(Image(FileInputStream("src/main/resources/GameAssets/$theme/Pickomino/EmptyPicko.png")))
        domino3= ImageView(Image(FileInputStream("src/main/resources/GameAssets/$theme/Pickomino/EmptyPicko.png")))
        domino4= ImageView(Image(FileInputStream("src/main/resources/GameAssets/$theme/Pickomino/EmptyPicko.png")))

        domino1.fitWidth = 70.0
        domino1.fitHeight = 140.0
        domino2.fitWidth = 70.0
        domino2.fitHeight = 140.0
        domino3.fitWidth = 70.0
        domino3.fitHeight = 140.0
        domino4.fitWidth = 70.0
        domino4.fitHeight = 140.0
        //init dés
        val simulatedDice = mutableListOf("d1","d2","d3","d4","d5","worm","worm","d5")
        updateDice(simulatedDice,desActif)
        //init domino poule commune
        val simulatedDomino = MutableList(16) { index -> index + 21 }
        updatePouleCommune(simulatedDomino)


        /////////////////////
        //test domino joueur nouvel valeur
        updateDomino(mutableListOf(21,22,23,24))
        /////////////////////


        //ajout items
        this.children.addAll(ligneHaut,ligneMilieu,ligneBas)

        joueur4.children.addAll(domino4,score4)
        joueur3.children.addAll(domino3,score3)
        joueur2.children.addAll(domino2,score2)
        joueur1.children.addAll(domino1,score1)

        container_info.children.addAll(salon,cle)

        ligneHaut.children.addAll(joueur3,container_info,joueur4)

        ligneMilieu.children.addAll(desChoisi,pouleCommune,desActif)

        ligneBas.children.addAll(joueur2,lanceDes,joueur1)
        //style
        this.styleClass.addAll("vue-jeu")
        ligneHaut.styleClass.addAll("ligneHaut")
        ligneMilieu.styleClass.addAll("ligneMilieu")
        ligneBas.styleClass.addAll("ligneBas")
        joueur4.styleClass.addAll("joueur4","joueur")
        domino4.styleClass.addAll("domino4","domino")
        score4.styleClass.addAll("score4","score","grosTexte")
        container_info.styleClass.addAll("container_info-4j")
        salon.styleClass.addAll("salon-4j","grosTexte")
        cle.styleClass.addAll("cle-4j","grosTexte")
        joueur3.styleClass.addAll("joueur3","joueur")
        domino3.styleClass.addAll("domino3","domino")
        score3.styleClass.addAll("score3","score","grosTexte")
        desChoisi.styleClass.addAll("desChoisi","tapisMilieu")
        pouleCommune.styleClass.addAll("pouleCommune","tapisMilieu")
        desActif.styleClass.addAll("desActif","tapisMilieu")
        joueur2.styleClass.addAll("joueur2","joueur")
        domino2.styleClass.addAll("domino2","domino")
        score2.styleClass.addAll("score2","score","grosTexte")
        lanceDes.styleClass.addAll("lanceDes","grosTexte")
        joueur1.styleClass.addAll("joueur1","joueur")
        domino1.styleClass.addAll("domino1","domino")
        score1.styleClass.addAll("score1","score","grosTexte")
    }
    override fun updatePouleCommune(listDomino: MutableList<Int>) {
        println(listDomino)
        var cpt=0
        for (j in pouleCommune.children) {
            pouleCommune.children.remove(j)
        }
        for (i in listDomino) {
            val picko = ImageView(Image(FileInputStream("src/main/resources/GameAssets/$theme/Pickomino/$i.png")))
            picko.userData=cpt
            picko.fitWidth = 80.0
            picko.fitHeight = 160.0
            pouleCommune.children.add(picko)
            cpt++
        }
    }

    override fun updateDice(listDe: MutableList<String>, target: VBox) {
        var cpt = 0
        for (j in target.children) {
            pouleCommune.children.remove(j)
        }
        for (i in listDe) {
            val de = ImageView(Image(FileInputStream("src/main/resources/GameAssets/$theme/Dice/$i.png")))
            de.userData=cpt
            de.fitWidth = 60.0
            de.fitHeight = 60.0
            desActif.children.add(de)
            cpt++
        }
    }

    override fun updateDomino(listDomino: MutableList<Int>) {
        var url = "src/main/resources/GameAssets/$theme/Pickomino/${listDomino[0]}.png"
        domino1.image=Image(FileInputStream(url))
        url = "src/main/resources/GameAssets/$theme/Pickomino/${listDomino[1]}.png"
        domino2.image=Image(FileInputStream(url))
        url = "src/main/resources/GameAssets/$theme/Pickomino/${listDomino[2]}.png"
        domino3.image=Image(FileInputStream(url))
        url = "src/main/resources/GameAssets/$theme/Pickomino/${listDomino[3]}.png"
        domino4.image=Image(FileInputStream(url))
    }
}