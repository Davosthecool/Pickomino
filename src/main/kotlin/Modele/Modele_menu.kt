package Modele

import Vue.Vue_menu
import javafx.beans.property.BooleanProperty
import javafx.beans.property.SimpleIntegerProperty

class Modele_menu(vue: Vue_menu) {
    var nbjoueur = 0
    var isLocal = false
    var inputkey = SimpleIntegerProperty()
    var inputid = SimpleIntegerProperty()
}