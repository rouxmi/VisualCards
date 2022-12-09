module eu.telecomnancy.visualcards {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens eu.telecomnancy.visualcards to javafx.fxml;
    exports eu.telecomnancy.visualcards;
    exports eu.telecomnancy.visualcards.Commands;
    opens eu.telecomnancy.visualcards.Commands to javafx.fxml;
}