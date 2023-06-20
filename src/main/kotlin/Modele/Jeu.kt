package Modele

import iut.info1.pickomino.Connector
import iut.info1.pickomino.data.DICE
import iut.info1.pickomino.data.State

class Jeu(modmenu:Menu,vue : Any,theme: String= "Light") {
    var vue = vue
    var isLocal = modmenu.isLocal
    var connect = modmenu.connector
    var id = modmenu.id.value
    var key = modmenu.key.value
    private var nbJoueur : Int
    private var theme : String
    private var statut : State
    var listeDes : MutableList<Des> = mutableListOf()
        private set
    var desChoisis : MutableList<Des> = mutableListOf()
        private set
    var desActifs : MutableList<Des> = mutableListOf()
        private set
    init {
        nbJoueur=connect.gameState(this.id,this.key).score().size
        this.statut=connect.gameState(this.id,this.key).current
        this.theme=theme
        for (i in 0 until 8){
            listeDes.add(Des(i, theme=this.theme ))
        }
        desActifs.addAll(listeDes)
    }

    fun ajouteDes(i : Des,liste : MutableList<Des>){
        liste.add(i)
    }

    fun listeDesStr(liste : MutableList<Des>) : MutableList<String>{

        var list = mutableListOf<String>()
        for (i in liste) {
            list.add(i.face.toString())
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


    fun assignDes(list: List<DICE>, desActif : MutableList<Des>){
        for (i in 0..list.size - 1) {
            desActif[i].assignDe(list[i])
        }
    }

    fun resetListe(liste: MutableList<Des>){
        liste.removeAll(liste)
    }

}