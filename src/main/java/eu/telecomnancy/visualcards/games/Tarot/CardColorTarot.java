package eu.telecomnancy.visualcards.games.Tarot;

import eu.telecomnancy.visualcards.games.CardColor;

public enum CardColorTarot implements CardColor {
    TREFLE,CARREAU,COEUR,PIQUE,ATOUT;

    @Override
    public int compareTo(CardColor color) {
        return color.ordinal();
    }
}
