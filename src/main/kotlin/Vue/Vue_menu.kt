package Vue
import Modele.Modele_menu
import javafx.collections.FXCollections
import javafx.collections.ObservableArray
import javafx.collections.ObservableList
import javafx.css.converter.StringConverter
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.layout.*
import javafx.scene.control.*

import javafx.scene.control.RadioButton
import javafx.scene.control.ToggleGroup
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.input.KeyEvent
import javafx.scene.paint.Color
import javafx.scene.paint.CycleMethod
import javafx.scene.paint.LinearGradient
import javafx.scene.paint.Stop
import javafx.scene.text.Font
import javafx.scene.text.TextAlignment
import java.io.FileInputStream

class Vue_menu():VBox() {
    val titre : ImageView
    val titre_container : VBox
    val partie : VBox
    val creation_menu : VBox
    val create_game : Button
    val setting_game : VBox
    val player_number_container :HBox
    val number_label : Label
    val player_number_game : ChoiceBox<Int>
    val type_game : HBox
    val radio_group :ToggleGroup
    val local_game : RadioButton
    val online_game : RadioButton
    val join_menu : VBox
    val join_game : Button
    val join_setting_game : VBox
    val container_id : HBox
    val container_key : HBox
    val label_id : Label
    val number_id : TextField
    val label_key: Label
    val number_key : TextField
    val options : ObservableList<Int>
    init {
        //style



        val im = Image(FileInputStream("ressources/Logo.png"),960.0, 256.0, true, true)
        titre = ImageView(im)
        titre_container = VBox()
        partie = VBox()
        //dans partie
        creation_menu = VBox()
        //dans creation_menu
        create_game = Button("Créer la partie")
        setting_game = VBox()
        //dans setting_game
            //dans player_number_container
        player_number_container = HBox()
        number_label = Label("Nombre de joueurs")
        options = FXCollections.observableArrayList(2,3,4)
        player_number_game = ChoiceBox(options)

        type_game = HBox()
            //dans type_game
        radio_group = ToggleGroup()
        local_game = RadioButton("En local")
        online_game = RadioButton("En ligne")
        local_game.toggleGroup = radio_group
        online_game.toggleGroup = radio_group

        join_menu = VBox()
        //dans join_menu
        join_game = Button("Rejoindre la partie en ligne")
        join_setting_game = VBox()
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
        titre_container.children.addAll(titre)
        this.children.addAll(titre_container,partie)
        /////////////////////////////////////////////////////////////////////////////////////////////////
        this.styleClass.add("vue")
        titre_container.styleClass.add("titre_container")
        titre.styleClass.add("titre")
        partie.styleClass.add("partie")
        creation_menu.styleClass.add("creation_menu")
        join_menu.styleClass.add("join_menu")
        setting_game.styleClass.add("setting_game")
        create_game.styleClass.add("create_game")
        type_game.styleClass.add("type_game")
        player_number_container.styleClass.add("player_number_container")
        number_label.styleClass.add("number_label")
        player_number_game.styleClass.add("player_number_game")
        local_game.styleClass.add("local_game")
        online_game.styleClass.add("online_game")
        join_game.styleClass.add("join_game")
        join_setting_game.styleClass.add("join_setting_game")
        container_id.styleClass.add("container_id")
        container_key.styleClass.add("container_key")
        label_id.styleClass.add("label_id")
        number_id.styleClass.add("number_id")
        label_key.styleClass.add("label_key")
        number_key.styleClass.add("number_key")
    }
}