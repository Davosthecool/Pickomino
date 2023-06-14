
import javafx.collections.FXCollections
import javafx.scene.layout.*
import javafx.scene.control.*

import javafx.scene.control.RadioButton
import javafx.scene.control.ToggleGroup

class Vue_menu:VBox() {
    init {
        val titre = Label("Pickomino")
        val partie = HBox()
        //dans partie
        val creation_menu = VBox()
            //dans creation_menu
        val create_game = Button("Créer la partie")
        val setting_game = HBox()
                //dans setting_game
                    //dans player_number_game
        val options = FXCollections.observableArrayList("2", "3", "4")
        val player_number_game =  ChoiceBox(options)
        player_number_game.selectionModel.selectFirst()

        val type_game = VBox()
                    //dans type_game
        val radio_group:ToggleGroup? = ToggleGroup()
        val local_game = RadioButton("En local")
        val online_game = RadioButton("En ligne")
        local_game.toggleGroup = radio_group
        online_game.toggleGroup = radio_group

        val join_menu = VBox()
            //dans join_menu


        //ajout elements
        type_game.children.addAll(local_game,online_game)
        setting_game.children.addAll(type_game,player_number_game)
        creation_menu.children.addAll(create_game,setting_game)
        partie.children.addAll(creation_menu,join_menu)
        this.children.addAll(titre,partie)
        //propriétées
        for (i in partie.lookupAll("*")) {
            i.minWidth(Double.MAX_VALUE)
            i.minHeight(Double.MAX_VALUE)
            i.style = "-fx-border-color : black"
        }
        //titre
        //partie
        //creation_menu
        //join_menu
        //setting_game
        //create_game
        //type_game
        //player_number_game
        //local_game
        //online_game

    }


}