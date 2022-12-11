package eu.telecomnancy.visualcards.games.Belote;

import eu.telecomnancy.visualcards.games.Card;
import eu.telecomnancy.visualcards.games.CardColor;
import eu.telecomnancy.visualcards.games.CardInterface;
import eu.telecomnancy.visualcards.games.CardValue;
import javafx.scene.image.Image;

import java.util.Arrays;
import java.util.List;

// représente une carte à jouer. Elle a une couleur, une valeur. ELle a aussi une référence vers une représentation visuelle
public class CardBelote extends Card {


    public CardBelote(CardValue value, CardColor color) {
        super(value, color);
        String fileName = getValidFaceNames().get(value.ordinal()) + "_of_" + getValidSuits().get(color.ordinal()) + ".png";
        image = new Image(getClass().getResource("/eu/telecomnancy/visualcards/images/" + fileName).toString());

    }


    public static List<String> getValidFaceNames() {
        return Arrays.asList( "7", "8", "9", "10", "jack",
                "queen", "king", "ace");
    }

    /**
     * This method will return a list of valid suits
     *
     * @return spades, hearts, clubs, diamonds
     */
    public static List<String> getValidSuits() {
        return Arrays.asList("hearts", "diamonds", "spades", "clubs");
    }
}

