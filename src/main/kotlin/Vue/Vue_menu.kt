package Vue
import Modele.Modele_menu
import javafx.collections.FXCollections
import javafx.collections.ObservableArray
import javafx.collections.ObservableList
import javafx.geometry.Pos
import javafx.scene.layout.*
import javafx.scene.control.*

import javafx.scene.control.RadioButton
import javafx.scene.control.ToggleGroup
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.text.TextAlignment
import java.io.FileInputStream

class Vue_menu():VBox() {
    val titre : ImageView
    val partie : HBox
    val creation_menu : VBox
    val create_game : Button
    val setting_game : HBox
    val player_number_container :HBox
    val number_label : Label
    val player_number_game : ChoiceBox<Int>
    val type_game : VBox
    val radio_group :ToggleGroup
    val local_game : RadioButton
    val online_game : RadioButton
    val join_menu : VBox
    val join_game : Button
    val join_setting_game : HBox
    val container_id : HBox
    val container_key : HBox
    val label_id : Label
    val number_id : TextField
    val label_key: Label
    val number_key : TextField
    val options : ObservableList<Int>
    init {
        val im = Image(FileInputStream("ressources/Logo.png"),960.0, 256.0, true, true)
        titre = ImageView(im)
        partie = HBox()
        //dans partie
        creation_menu = VBox()
        //dans creation_menu
        create_game = Button("Créer la partie")
        setting_game = HBox()
        //dans setting_game
            //dans player_number_container
        player_number_container = HBox()
        number_label = Label("Nombre de joueurs")
        options = FXCollections.observableArrayList(2,3,4)
        player_number_game = ChoiceBox(options)

        type_game = VBox()
            //dans type_game
        radio_group = ToggleGroup()
        local_game = RadioButton("En local")
        online_game = RadioButton("En ligne")
        local_game.toggleGroup = radio_group
        online_game.toggleGroup = radio_group

        join_menu = VBox()
        //dans join_menu
        join_game = Button("Rejoindre la partie en ligne")
        join_setting_game = HBox()
        //dans join_setting_game
        container_id = HBox()

            //dans id
        label_id = Label("numéro du salon")
        number_id = TextField()

        container_key = HBox()
            //dans key
        label_key = Label("clé du salon")
        number_key = TextField()

        //ajout elements
        type_game.children.addAll(local_game,online_game)
        player_number_container.children.addAll(number_label,player_number_game)
        setting_game.children.addAll(type_game,player_number_container)
        creation_menu.children.addAll(create_game,setting_game)
        partie.children.addAll(creation_menu,join_menu)
        container_id.children.addAll(label_id,number_id)
        container_key.children.addAll(label_key,number_key)
        join_setting_game.children.addAll(container_id,container_key)
        join_menu.children.addAll(join_game,join_setting_game)
        this.children.addAll(titre,partie)
        //propriétées
        for (i in this.lookupAll("*")) {
            i.style = "-fx-border-color : black"
        }
        //titre
        titre.minWidth(this.width)
        //partie
        partie.alignment = Pos.BOTTOM_CENTER
        //creation_menu
        creation_menu.alignment = Pos.CENTER
        //join_menu
        join_menu.alignment = Pos.CENTER
        //setting_game
        setting_game.alignment = Pos.CENTER
        //create_game
        create_game.style = "-fx-color : lime"
        create_game.alignment = Pos.CENTER
        //type_game
        type_game.alignment = Pos.CENTER
        //player_number_container
        player_number_container.alignment = Pos.CENTER
        //number_label
        number_label.alignment = Pos.CENTER
        //player_number_game
        //local_game
        local_game.alignment = Pos.CENTER
        //online_game
        online_game.alignment = Pos.CENTER
        //join_game
        join_game.style = "-fx-color : lime"
        join_game.alignment = Pos.CENTER
        //join_setting_game
        join_setting_game.alignment = Pos.CENTER
        //container_id
        container_id.alignment = Pos.CENTER
        //container_key
        container_key.alignment = Pos.CENTER
        //label_id
        label_id.alignment = Pos.CENTER
        //number_id
        number_id.alignment = Pos.CENTER
        //label_key
        label_key.alignment = Pos.CENTER
        //number_key
        number_key.alignment = Pos.CENTER
    }
}