package eu.telecomnancy.visualcards.Commands;

import eu.telecomnancy.visualcards.games.DeckOfCards;
import eu.telecomnancy.visualcards.games.Tarot.DeckOfCardsTarot;

public class NewTarotGameCommand extends Command {

    public NewTarotGameCommand(DeckOfCards deck) {
        super(deck);
    }

    @Override
    public boolean execute() {
        deck= new DeckOfCardsTarot();
        return true;
    }

}
