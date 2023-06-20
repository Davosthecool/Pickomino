package Vue

import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.layout.*
import javafx.scene.control.*
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import java.io.FileInputStream
import java.util.*
import kotlin.random.Random

class Vue_2j(theme:String,id:Int,key:Int): VBox(),Vue_jeu {
    val theme = theme

    //ligne principals
    val ligneHaut = HBox()
    val ligneMilieu = HBox()
    val ligneBas = HBox()


    //ligne haut
    //info jeu
    val salon = Label("ID du salon : ${id}")
    val cle = Label("Clé du salon : ${key}")

    //ligne milieu
    val desChoisi = VBox()
    val pouleCommune = FlowPane()
    override val desActif = VBox()

    //ligne bas
    //joueur2
    val joueur2 = HBox()
    val domino2 : ImageView
    val score2 = Label("40")
    //lancer des
    override val lanceDes = Button("Lancer le(s) dé(s)")
    //joueur1
    val joueur1 = HBox()
    val domino1 : ImageView
    val score1 = Label("40")
    init {
        domino1= ImageView(Image(FileInputStream("src/main/resources/GameAssets/$theme/Pickomino/EmptyPicko.png")))
        domino2= ImageView(Image(FileInputStream("src/main/resources/GameAssets/$theme/Pickomino/EmptyPicko.png")))

        domino1.fitWidth = 70.0
        domino1.fitHeight = 140.0
        domino2.fitWidth = 70.0
        domino2.fitHeight = 140.0

        //init domino poule commune
        val simulatedDomino = MutableList(16) { index -> index + 21 }
        updatePouleCommune(simulatedDomino)
        //init dés poule commune


        /////////////////////
        //test domino joueur nouvel valeur
        updateDomino(mutableListOf(21,22))
        /////////////////////


        //ajout items
        this.children.addAll(ligneHaut,ligneMilieu,ligneBas)

        joueur2.children.addAll(domino2,score2)
        joueur1.children.addAll(domino1,score1)

        ligneHaut.children.addAll(salon,cle)

        ligneMilieu.children.addAll(desChoisi,pouleCommune,desActif)

        ligneBas.children.addAll(joueur2,lanceDes,joueur1)
        //style
        this.styleClass.addAll("vue-jeu")
        ligneHaut.styleClass.addAll("ligneHaut")
        ligneMilieu.styleClass.addAll("ligneMilieu")
        ligneBas.styleClass.addAll("ligneBas")
        salon.styleClass.addAll("salon-2j","grosTexte")
        cle.styleClass.addAll("cle-2j","grosTexte")
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
        desActif.children.removeAll(target.children)

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
    }

    override fun fixeBouton(bouton : Button,ecouteur : EventHandler<ActionEvent>){
        bouton.onAction=ecouteur
    }
}