package eu.telecomnancy.visualcards.Commands;

import eu.telecomnancy.visualcards.games.DeckOfCards;

public class DrawARandomCardCommand extends Command {

    public DrawARandomCardCommand(DeckOfCards deck) {
        super(deck);
    }

    @Override
    public void execute() {
        backup();
        deck.drawARandomCard();
        deck.notifyObservers();
    }

}

