package eu.telecomnancy.visualcards.games.Cartes52;

import eu.telecomnancy.visualcards.games.DeckOfCards;



import java.util.ArrayList;

public class DeckOfCards52 extends DeckOfCards {
    public DeckOfCards52() {
        super(new ArrayList<>());

        for(CardColor52 color : CardColor52.values()) {
            for(CardValue52 value : CardValue52.values()) {
                deck.add(new Card52(value, color));
            }
        }

        shuffle();
    }
}

