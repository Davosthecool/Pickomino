package Vue

import javafx.scene.layout.*
import javafx.scene.control.*
import javafx.scene.image.Image
import javafx.scene.image.ImageView
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
    val score4 = Label("40")
    //info jeu
    val container_info = VBox()
    val salon = Label("ID du salon : ${id}")
    val cle = Label("Clé du salon : ${key}")
    //joueur3
    val joueur3 = HBox()
    val domino3 : ImageView
    val score3 = Label("40")

    //ligne milieu
    val desChoisi = VBox()
    val pouleCommune = FlowPane()
    val desActif = VBox()

    //ligne bas

    //joueur2
    val joueur2 = HBox()
    val domino2 : ImageView
    val score2 = Label("40")
    //lancer des
    val lanceDes = Button("Lancer le(s) dé(s)")
    //joueur1
    val joueur1 = HBox()
    val domino1 : ImageView
    val score1 = Label("40")
    init {
        //init domino joueur
        domino1= ImageView(Image(FileInputStream("src/main/resources/EmptyPicko.png")))
        domino2= ImageView(Image(FileInputStream("src/main/resources/EmptyPicko.png")))
        domino3= ImageView(Image(FileInputStream("src/main/resources/EmptyPicko.png")))
        domino4= ImageView(Image(FileInputStream("src/main/resources/EmptyPicko.png")))

        domino1.fitWidth = 65.0
        domino1.fitHeight = 130.0
        domino2.fitWidth = 65.0
        domino2.fitHeight = 130.0
        domino3.fitWidth = 65.0
        domino3.fitHeight = 130.0
        domino4.fitWidth = 65.0
        domino4.fitHeight = 130.0
        //init domino poule commune

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
        ligneHaut.styleClass.addAll("ligneHaut")
        ligneMilieu.styleClass.addAll("ligneMilieu")
        ligneBas.styleClass.addAll("ligneBas")
        joueur4.styleClass.addAll("joueur4","joueur")
        domino4.styleClass.addAll("domino4","domino")
        score4.styleClass.addAll("score4","score")
        container_info.styleClass.addAll("container_info-4j")
        salon.styleClass.addAll("salon-4j")
        cle.styleClass.addAll("cle-4j")
        joueur3.styleClass.addAll("joueur3","joueur")
        domino3.styleClass.addAll("domino3","domino")
        score3.styleClass.addAll("score3","score")
        desChoisi.styleClass.addAll("desChoisi")
        pouleCommune.styleClass.addAll("pouleCommune")
        desActif.styleClass.addAll("desActif")
        joueur2.styleClass.addAll("joueur2","joueur")
        domino2.styleClass.addAll("domino2","domino")
        score2.styleClass.addAll("score2","score")
        lanceDes.styleClass.addAll("lanceDes")
        joueur1.styleClass.addAll("joueur1","joueur")
        domino1.styleClass.addAll("domino1","domino")
        score1.styleClass.addAll("score1","score")
    }

    override fun updatePouleCommune(listDomino: MutableList<Int>) {
        TODO("Not yet implemented")
    }

    override fun updateDice(listDe: MutableList<Int>, target: GridPane) {
        TODO("Not yet implemented")
    }

    override fun updateDomino(listDomino: MutableList<MutableList<Int>>) {
        TODO("Not yet implemented")
    }
}