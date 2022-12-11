module eu.telecomnancy.visualcards {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens eu.telecomnancy.visualcards to javafx.fxml;
    exports eu.telecomnancy.visualcards;
    exports eu.telecomnancy.visualcards.Commands;
    opens eu.telecomnancy.visualcards.Commands to javafx.fxml;
    exports eu.telecomnancy.visualcards.games.Cartes52;
    opens eu.telecomnancy.visualcards.games.Cartes52 to javafx.fxml;
    exports eu.telecomnancy.visualcards.games;
    opens eu.telecomnancy.visualcards.games to javafx.fxml;
}