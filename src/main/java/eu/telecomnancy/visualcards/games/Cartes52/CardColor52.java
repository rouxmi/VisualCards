package eu.telecomnancy.visualcards.games.Cartes52;

import eu.telecomnancy.visualcards.games.CardColor;

public enum CardColor52 implements CardColor {
    TREFLE,CARREAU,COEUR,PIQUE;

    @Override
    public int compareTo(CardColor color) {
        return color.ordinal();
    }
}
