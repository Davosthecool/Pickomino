package Modele

import iut.info1.pickomino.Connector
import iut.info1.pickomino.data.State

class Jeu(id : Int, key : Int, connector: Connector) {
    var connect : Connector
    private var id : Int
    private var key : Int
    private var nbJoueur : Int
    private var statut : State
    private var desTotaux : MutableList<Des> = mutableListOf()
    private var desChoisis : MutableList<Des> = mutableListOf()
    private var desActifs : MutableList<Des> = mutableListOf()
    init {
        connect=connector
        this.id=id
        this.key=key
        nbJoueur=connect.gameState(id,key).score().size
        this.statut=connect.gameState(id,key).current
        print(nbJoueur)

    }
}
