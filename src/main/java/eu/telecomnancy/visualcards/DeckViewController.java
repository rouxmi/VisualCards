package eu.telecomnancy.visualcards;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class DeckViewController implements Initializable {

    @FXML private Button nextCardButton;
    @FXML private ImageView deckImageView;
    @FXML private ImageView activeCardImageView;
    @FXML private GridPane cardPane;
    private DeckOfCards deck;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        deck = new DeckOfCards();
        //deck.shuffle();
        deckImageView.setImage(deck.getBackOfCardImage());
        for (int i=0;i<4;i++) {
            cardPane.addRow(i);
            cardPane.setVgap(10);
            cardPane.setHgap(10);
            cardPane.gridLinesVisibleProperty().setValue(true);
            for (int j=0;j<13;j++) {
                System.out.println(j);
                ImageView cardj = new ImageView();
                cardj.setFitHeight(120);
                cardj.setFitWidth(70);
                cardj.setImage(deck.getDeck().get(i*13+j).getImage());
                cardPane.addColumn(j,cardj);
            }

        }
    }

    @FXML public void nextCardButtonPushed()
    {
       activeCardImageView.setImage(deck.dealTopCard().getImage());
    }
}