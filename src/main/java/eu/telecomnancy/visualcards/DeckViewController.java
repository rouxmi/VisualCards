package eu.telecomnancy.visualcards;

import eu.telecomnancy.visualcards.Commands.*;
import eu.telecomnancy.visualcards.Shuffle.ShuffleStrategie;
import eu.telecomnancy.visualcards.Shuffle.StrategieBasique;
import eu.telecomnancy.visualcards.Shuffle.StrategieRandom;
import eu.telecomnancy.visualcards.Shuffle.StrategieRandomLinear;
import eu.telecomnancy.visualcards.games.DeckOfCards;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.image.Image;

import static java.lang.Math.round;

public class DeckViewController implements MyObserver, Initializable {

    @FXML
    private ImageView deckImageView;
    @FXML
    private ImageView activeCardImageView;

    @FXML
    private GridPane cardPane;

    /* Initialisation de DeckOfCards */
    private DeckOfCards deck ;
    
    private Image backOfCardImage;

    private final CommandHistory history = new CommandHistory();
    private ShuffleStrategie Strat;

    /* Relie la classe DeckOfCards au controller*/
    public DeckViewController(DeckOfCards deck) {
        this.deck = deck ;
        this.deck.addObserver(this);
        Strat= new StrategieBasique();
    }
         


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /* deck = new DeckOfCards(); -> il faut initialiser DeckOfCards dans la class correspondant et relier la class au controlleur*/ 
        URL imageFile=getClass().getResource("/eu/telecomnancy/visualcards/images/back_of_card.jpg");
        if (imageFile!=null) {
            setBackOfCardImage(new Image(imageFile.toString()));
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
    public void shuffle(ActionEvent ignoredEvent) {
        executeCommand(new ShuffleCommand(deck,Strat));
    }

    @FXML
    public void sort(ActionEvent ignoredEvent) {
        executeCommand(new SortCommand(deck));
    }

    public void Nextcard(ActionEvent ignoredActionEvent) {
        executeCommand(new NextcardCommand(deck));
    }

    public void Exit(ActionEvent ignoredActionEvent) {
        executeCommand(new ExitCommand());
    }


    public void Undo(ActionEvent ignoredActionEvent) {
        if (!history.isEmpty()) {
            history.pop().undo();
            update();
        }
    }

    public void DrawARandomCard(ActionEvent ignoredActionEvent) {
        executeCommand(new DrawARandomCardCommand(deck));
    }


    public void About(ActionEvent ignoredActionEvent) {
        executeCommand(new AboutCommand(deck));
    }

    public void NewBeloteGame(ActionEvent ignoredActionEvent) {
        executeCommand(new NewBeloteGameCommand(deck));
        while (!history.isEmpty()) {
            history.pop();
        }
    }

    public void NewTarotGame(ActionEvent ignoredActionEvent) {
        executeCommand(new NewTarotGameCommand(deck));
        while (!history.isEmpty()) {
            history.pop();
        }
    }

    public void New52Game(ActionEvent ignoredActionEvent) {
        executeCommand(new NewGame52Command(deck));
        while (!history.isEmpty()) {
            history.pop();
        }
    }

    public void ShuffleBasique(ActionEvent ignoredActionEvent) {
        Strat=new StrategieBasique();
    }

    public void ShuffleRandom(ActionEvent ignoredActionEvent) {
        Strat= new StrategieRandom();
    }

    public void ShuffleLinear(ActionEvent ignoredActionEvent) {
        Strat=new StrategieRandomLinear();
    }

    private void executeCommand(Command command) {
        command.execute() ;
        history.push(command);
        deck=command.deck;
        update();
    }



    public void update() {
        deckImageView.setImage(getBackOfCardImage());
        cardPane.getChildren().clear();
        activeCardImageView.setImage(deck.getTopCard().getImage());
        int rows= 4;
        int cols= 13;
        if (deck.getDeck().size() == 32) {
            cols= 8;
        }
        if(deck.getDeck().size()==78){
            rows= 6;
            cols= 13;
        }
        for (int i = 0; i < rows; i++) {
            cardPane.addRow(i);
            cardPane.setVgap(10);
            cardPane.setHgap(10);
            cardPane.gridLinesVisibleProperty().setValue(true);
            for (int j = 0; j < cols; j++) {
                BorderPane cardborder = new BorderPane();
                cardborder.setStyle("-fx-border-color: black");
                ImageView cardj = new ImageView();
                cardj.setFitHeight(round((510-((rows-1)*10))/(float)rows));
                cardj.setFitWidth(round((1030-((cols-1)*10))/(float)cols));
                cardj.setImage(deck.getDeck().get(i * cols + j).getImage());
                cardborder.setCenter(cardj);
                cardPane.addColumn(j, cardborder);
            }

        }
    }


}

