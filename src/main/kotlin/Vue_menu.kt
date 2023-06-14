
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.control.Label
import javafx.scene.control.Button

class Vue_menu:VBox() {
    val titre = Label("Pickomino")

    val partie = HBox() //contient  creation_menu et join_menu
    val creation_menu = VBox()

    val create_game = Button()


    val join_menu = VBox()

}