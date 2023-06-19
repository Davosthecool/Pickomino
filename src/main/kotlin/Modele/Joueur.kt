package Modele

import iut.info1.pickomino.data.Pickomino

class Joueur(id : Int) {
    var id : Int
    private var pilePickomino = mutableListOf<Pickomino>()
//    private var blacklistJoueur = mutableListOf<>()
    init {
        this.id=id
    }
}