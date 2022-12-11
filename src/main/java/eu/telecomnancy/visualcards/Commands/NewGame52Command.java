package eu.telecomnancy.visualcards.Commands;

import eu.telecomnancy.visualcards.games.Cartes52.DeckOfCards52;
import eu.telecomnancy.visualcards.games.DeckOfCards;

public class NewGame52Command extends Command {

    public NewGame52Command(DeckOfCards deck) {
        super(deck);
    }

    @Override
    public void execute() {
        deck= new DeckOfCards52();
    }

}

