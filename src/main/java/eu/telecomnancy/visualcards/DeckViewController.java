package eu.telecomnancy.visualcards;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.image.Image;

public class DeckViewController implements MyObserver, Initializable {

    @FXML
    private Button nextCardButton;
    @FXML
    private ImageView deckImageView;
    @FXML
    private ImageView activeCardImageView;

    @FXML
    private GridPane cardPane;

    /* Initialisation de DeckOfCards */
    private final DeckOfCards deck ; 
    
    private Image backOfCardImage;

    /* Relie la classe DeckOfCards au controller*/
    public DeckViewController(DeckOfCards deck) {
        this.deck = deck ;
        this.deck.addObserver(this);
    }
         


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /* deck = new DeckOfCards(); -> il faut initialiser DeckOfCards dans la class correspondant et relier la class au controlleur*/ 
        URL imageFile=getClass().getResource("images/black_joker.png");
        if (imageFile!=null) {
            backOfCardImage = new Image(imageFile.toString());
        }
    
        update();
    }


    public Image getBackOfCardImage() {
        return backOfCardImage;
    }

    public void setBackOfCardImage(Image backOfCardImage) {
        this.backOfCardImage = backOfCardImage;
    }

    @FXML
    public void nextCardButtonPushed() {
        activeCardImageView.setImage(deck.dealTopCard().getImage());
    }

    @FXML
    public void shuffle(ActionEvent event) {
        deck.shuffle();
    }

    @FXML
    public void sort(ActionEvent event) {
        deck.sort();
    }



    public void update() {
        deckImageView.setImage(getBackOfCardImage());
        cardPane.getChildren().clear();
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

