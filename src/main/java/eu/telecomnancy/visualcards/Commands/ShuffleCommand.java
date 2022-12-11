package eu.telecomnancy.visualcards.Commands;

import eu.telecomnancy.visualcards.Shuffle.ShuffleStrategie;
import eu.telecomnancy.visualcards.games.DeckOfCards;

public class ShuffleCommand extends Command {

    private final ShuffleStrategie shuffleStrategie;
    public ShuffleCommand(DeckOfCards deck, ShuffleStrategie shuffleStrategie) {
        super(deck);
        this.shuffleStrategie = shuffleStrategie;
    }


    public void execute() {
        backup();
        shuffleStrategie.shuffle(deck);
        deck.notifyObservers();
    }

}
