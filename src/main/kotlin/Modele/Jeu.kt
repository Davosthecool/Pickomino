package Modele

import iut.info1.pickomino.Connector
import iut.info1.pickomino.data.State

class Jeu(modmenu:Menu,vue : Any) {
    var vue = vue
    var isLocal = modmenu.isLocal
    var connect = modmenu.connector
    private var id = modmenu.id.value
    private var key = modmenu.key.value
    private var nbJoueur : Int
    private var statut : State
    private var desTotaux : MutableList<Des> = mutableListOf()
    private var desChoisis : MutableList<Des> = mutableListOf()
    private var desActifs : MutableList<Des> = mutableListOf()
    init {
        nbJoueur=connect.gameState(this.id,this.key).score().size
        this.statut=connect.gameState(this.id,this.key).current
        print(nbJoueur)
    }
}
