package Modele

import iut.info1.pickomino.Connector
import iut.info1.pickomino.data.DICE
import iut.info1.pickomino.data.State

class Jeu(modmenu:Menu,vue : Any,theme: String= "Light") {
    var vue = vue
    var isLocal = modmenu.isLocal
    var connect = modmenu.connector
    private var id = modmenu.id.value
    private var key = modmenu.key.value
    private var nbJoueur : Int
    private var theme : String
    private var statut : State
    var listeDes : MutableList<Des> = mutableListOf()
        private set
    var desChoisis : MutableList<Des> = mutableListOf()
        private set
    var desActifs : MutableList<DICE> = mutableListOf()
        private set
    init {
        nbJoueur=connect.gameState(this.id,this.key).score().size
        this.statut=connect.gameState(this.id,this.key).current
        this.theme=theme
        for (i in 0 until 8){
            listeDes.add(Des(i, theme=this.theme ))
        }
        print(nbJoueur)
    }

    fun selectionnerDesUnique(i : Des){
        desChoisis.add(i)
    }
    fun selectionnerDes(valeur : Int){
        for (i in listeDes){
            if (i.valeur==valeur){
                desChoisis.add(i)
            }
        }
    }
}
