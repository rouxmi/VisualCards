package eu.telecomnancy.visualcards.Commands;

import eu.telecomnancy.visualcards.Shuffle.InShuffleAlgorithm;
import eu.telecomnancy.visualcards.Shuffle.ShuffleRand;
import eu.telecomnancy.visualcards.Shuffle.ShuffleStrategie;
import eu.telecomnancy.visualcards.games.DeckOfCards;

public class ShuffleCommand extends Command {

    private final ShuffleStrategie shuffleStrategie;
    public ShuffleCommand(DeckOfCards deck, ShuffleStrategie shuffleStrategie) {
        super(deck);
        this.shuffleStrategie = shuffleStrategie;
    }

    @Override
    public boolean execute() {
        backup();
        shuffleStrategie.shuffle(deck);
        deck.notifyObservers();
        return true;
    }

}
