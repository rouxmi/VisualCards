package eu.telecomnancy.visualcards.games.Tarot;

import eu.telecomnancy.visualcards.games.Card;
import eu.telecomnancy.visualcards.games.Cartes52.CardColor52;
import eu.telecomnancy.visualcards.games.Cartes52.CardValue52;
import eu.telecomnancy.visualcards.games.DeckOfCards;

import java.util.ArrayList;

public class DeckOfCardsTarot extends DeckOfCards {
    public DeckOfCardsTarot() {
        super(new ArrayList<>());

        for(CardColorTarot color : CardColorTarot.values()) {
            if (color == CardColorTarot.ATOUT) {
                for(AtoutValue value : AtoutValue.values()) {
                    deck.add(new CardTarot(value, color));
                }
            } else {
                for(CardValueTarot value : CardValueTarot.values()) {
                    deck.add(new CardTarot(value, color));
                }
            }

        }

        shuffle();
    }
}

