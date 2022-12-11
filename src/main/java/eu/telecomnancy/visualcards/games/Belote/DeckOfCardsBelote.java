package eu.telecomnancy.visualcards.games.Belote;

import eu.telecomnancy.visualcards.games.DeckOfCards;


import java.util.ArrayList;

public class DeckOfCardsBelote extends DeckOfCards {
    public DeckOfCardsBelote() {
        super(new ArrayList<>());

        for(CardColorBelote color : CardColorBelote.values()) {
            for(CardValueBelote value : CardValueBelote.values()) {
                deck.add(new CardBelote(value, color));
            }
        }

        shuffle();
    }
}

