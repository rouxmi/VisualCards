package eu.telecomnancy.visualcards.games.Belote;

import eu.telecomnancy.visualcards.games.CardColor;

public enum CardColorBelote implements CardColor {
    TREFLE,CARREAU,COEUR,PIQUE;

    @Override
    public int compareTo(CardColor color) {
        return color.ordinal();
    }
}
