package Modele

import iut.info1.pickomino.Connector
import iut.info1.pickomino.data.DICE
import iut.info1.pickomino.data.Pickomino
import iut.info1.pickomino.data.State
import java.util.Dictionary

class Jeu(modmenu:Menu,vue : Any,theme: String= "Light") {
    var vue = vue
    var isLocal = modmenu.isLocal
    var connect = modmenu.connector
    var id = modmenu.id.value
    var key = modmenu.key.value
    private var nbJoueur : Int
    private var theme : String
    private var statut : State
    var listePickomino : MutableList<Int> = mutableListOf()
        private set
    var dicoPickos = mutableMapOf<Int,Int>()
        private set
    var listeDes : MutableList<Des> = mutableListOf()
        private set
    var desChoisis : MutableList<Des> = mutableListOf()
        private set
    var desActifs : MutableList<Des> = mutableListOf()
        private set
    var valeursChoisis : MutableList<DICE> = mutableListOf()
        private set
    var joueursPickosTop : MutableList<Int> = mutableListOf()
        private set
    var joueursScores : MutableList<Int> = mutableListOf()
        private set
    init {
        nbJoueur=connect.gameState(this.id,this.key).score().size
        this.statut=connect.gameState(this.id,this.key).current
        this.theme=theme
        //Initialise listeDes
        for (i in 0 until 8){ listeDes.add(Des(i, theme=this.theme )) }
        //Initialise desActifs
        desActifs.addAll(listeDes)
        //Initialise listePickomino
        connect.gameState(id, key).accessiblePickos().forEach{ listePickomino.add(it) }
        //Initialise dicoPickos(valeurPicko,nbWorms)
        listePickomino.forEach { dicoPickos[it] = ((it-21)/4)+1 }
        //Initialise scores et pickos joueurs
        for (i in 0 until nbJoueur){
            joueursPickosTop.add(0)
            joueursScores.add(0)
        }

    }

    fun listeDesStr(liste : MutableList<Des>) : MutableList<String>{

        var list = mutableListOf<String>()
        for (i in liste) {
            list.add(i.face.toString())
        }
        return list
    }

    fun listePickosStr(liste : MutableList<Int>) : MutableList<String>{

        var list = mutableListOf<String>()
        for (i in liste) {
            list.add(i.toString())
        }
        return list
    }

    fun selectionnerDes(valeur : Int){

        for (i in desActifs){
            i.select(false)
            if (i.valeur==valeur){
                i.select()
            }
        }
    }

    fun choisirDes(valeur : Int){
        for (i in listeDes){
            if (i.valeur==valeur){
                desChoisis.add(i)
                desActifs.remove(i)
            }
        }
    }

    fun sommeDes(liste: MutableList<Des>) : Int{
        var somme : Int =0
        liste.forEach {
            if (it.valeur==5){
                somme+=5
            }else{
                somme+=it.valeur+1
            }
        }
        return somme
    }

    fun assignDes(list: List<DICE>, desActif : MutableList<Des>){
        for (i in 0..list.size - 1) {
            desActif[i].assignDe(list[i])
        }
    }
    fun prendrePickomino(pick : Int, joueur : Int){
        joueursPickosTop[joueur]=pick
        joueursScores[joueur]+=dicoPickos[pick]!!
        listePickomino.remove(pick)
    }

    fun retirerPickomino(joueur : Int) : Int?{
        if (joueursPickosTop[joueur]==0){
            throw TODO("exception a throw quand le joueur n'a pas de picko mais qu'on veut retirer")
        }
        var pick = joueursPickosTop[joueur]
        joueursScores[joueur]-=dicoPickos[joueursPickosTop[joueur]]!!
        joueursPickosTop[joueur]=0
        TODO("retirer pickomino quand il y en a un autre en dessous")
        return pick
    }
}