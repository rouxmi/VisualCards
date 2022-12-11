package eu.telecomnancy.visualcards.Shuffle;

import eu.telecomnancy.visualcards.games.DeckOfCards;

public class StrategieRandom implements ShuffleStrategie {
    @Override
    public DeckOfCards shuffle(DeckOfCards deck) {
        return new DeckOfCards(ShuffleRand.randomize(deck.getDeck()));
    }
}

