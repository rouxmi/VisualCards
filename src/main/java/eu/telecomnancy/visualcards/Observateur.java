package eu.telecomnancy.visualcards;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class Observateur {

    @FXML
    private Button nextCardButton;
    @FXML
    private ImageView deckImageView;
    @FXML
    private ImageView activeCardImageView;
    @FXML
    private GridPane cardPane;
    private DeckOfCards deck;

    public void refresh() {
        cardPane.getChildren().clear();
        activeCardImageView.setImage(deck.getTopCard().getImage());
        for (int i = 0; i < 4; i++) {
            cardPane.addRow(i);
            cardPane.setVgap(10);
            cardPane.setHgap(10);
            cardPane.gridLinesVisibleProperty().setValue(true);
            for (int j = 0; j < 13; j++) {
                BorderPane cardborder = new BorderPane();
                cardborder.setStyle("-fx-border-color: black");
                ImageView cardj = new ImageView();
                cardj.setFitHeight(120);
                cardj.setFitWidth(70);
                cardj.setImage(deck.getDeck().get(i * 13 + j).getImage());
                cardborder.setCenter(cardj);
                cardPane.addColumn(j, cardborder);
            }

        }
    }
    
    
    
}
