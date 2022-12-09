package eu.telecomnancy.visualcards.Commands;

import eu.telecomnancy.visualcards.DeckOfCards;

public class DrawARandomCardCommand extends Command {

    public DrawARandomCardCommand(DeckOfCards deck) {
        super(deck);
    }

    @Override
    public boolean execute() {
        backup();
        deck.drawARandomCard();
        deck.notifyObservers();
        return true;
    }

}

