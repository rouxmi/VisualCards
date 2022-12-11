package eu.telecomnancy.visualcards.Shuffle;

import eu.telecomnancy.visualcards.games.DeckOfCards;

public class StrategieRandomLinear implements ShuffleStrategie {
    @Override
    public DeckOfCards shuffle(DeckOfCards deck) {
        InShuffleAlgorithm.inShuffle(deck.getDeck());
        return deck;
    }
}
