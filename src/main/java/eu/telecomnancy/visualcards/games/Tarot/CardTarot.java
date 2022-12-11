package eu.telecomnancy.visualcards.games.Tarot;

import eu.telecomnancy.visualcards.games.Card;
import eu.telecomnancy.visualcards.games.CardColor;
import eu.telecomnancy.visualcards.games.CardInterface;
import eu.telecomnancy.visualcards.games.CardValue;
import javafx.scene.image.Image;

import java.util.Arrays;
import java.util.List;

// représente une carte à jouer. Elle a une couleur, une valeur. ELle a aussi une référence vers une représentation visuelle
public class CardTarot extends Card {


    public CardTarot(CardValue value, CardColor color) {
        super(value, color);
        String fileName = getValidFaceNames().get(value.ordinal()) + "_of_" + getValidSuits().get(color.ordinal()) + ".png";
        image = new Image(getClass().getResource("/eu/telecomnancy/visualcards/images/" + fileName).toString());

    }
    public CardTarot(AtoutValue atoutValue, CardColor color) {
        super(atoutValue,color);
        String fileName = getValidAtoutNames().get(atoutValue.ordinal()) + ".png";
        image = new Image(getClass().getResource("/eu/telecomnancy/visualcards/images/" + fileName).toString());

    }


    public static List<String> getValidFaceNames() {
        return Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "jack","knigt",
                "queen", "king", "ace");
    }

    public static List<String> getValidAtoutNames() {
        return Arrays.asList("un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuf", "dix", "onze",
                "douze","treize","quatorze","quinze","seize","dix_sept","dix_huit","dix_neuf","vingt","vingt_et_un",
                "excuse");
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

