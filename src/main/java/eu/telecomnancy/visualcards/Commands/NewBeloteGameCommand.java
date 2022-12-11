package eu.telecomnancy.visualcards.Commands;

import eu.telecomnancy.visualcards.games.Belote.DeckOfCardsBelote;
import eu.telecomnancy.visualcards.games.DeckOfCards;


public class NewBeloteGameCommand extends Command {

    public NewBeloteGameCommand(DeckOfCards deck) {
        super(deck);
    }

    @Override
    public boolean execute() {
        deck= new DeckOfCardsBelote();
        return true;
    }

}
