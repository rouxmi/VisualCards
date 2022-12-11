package eu.telecomnancy.visualcards.Commands;


import eu.telecomnancy.visualcards.games.Card;
import eu.telecomnancy.visualcards.games.DeckOfCards;

import java.util.ArrayList;

public abstract class Command {

    public DeckOfCards deck;
    private ArrayList<Card> backup;

    public Command(DeckOfCards deck) {
        this.deck = deck;
    }


    public abstract boolean execute();

    public void undo() {
        deck.setDeck(backup);
    }

    public void backup() {
        backup = new ArrayList<>();
        backup.addAll(deck.getDeck());
    }


}
