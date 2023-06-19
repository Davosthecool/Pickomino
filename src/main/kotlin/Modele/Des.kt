package Modele

import iut.info1.pickomino.data.DICE

class Des(id : Int, face : DICE = DICE.worm, theme : String) {
    var id : Int
    var image : String
    var face : DICE
    var valeur : Int
    init {
        this.face=face
        valeur=face.ordinal
        this.id=id
        image="\"src/main/resources/GameAssets/$theme/Dice/${valeur+1}.png\""
    }
}