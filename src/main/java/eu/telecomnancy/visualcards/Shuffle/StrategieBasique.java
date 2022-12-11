package eu.telecomnancy.visualcards.Shuffle;

import eu.telecomnancy.visualcards.games.DeckOfCards;

public class StrategieBasique implements ShuffleStrategie {
    @Override
    public DeckOfCards shuffle(DeckOfCards deck) {
        deck.shuffle();
        return deck;
    }
}

