package Modele

import Vue.Vue_menu
import iut.info1.pickomino.Connector
import javafx.beans.property.SimpleIntegerProperty

class Modele_jeu(co : Connector) {
    val connector = co
    var nbjoueur = 0
    var isLocal = false
    var key = SimpleIntegerProperty()
    var id = SimpleIntegerProperty()


}