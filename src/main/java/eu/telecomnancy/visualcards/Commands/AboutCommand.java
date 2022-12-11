package eu.telecomnancy.visualcards.Commands;

import eu.telecomnancy.visualcards.games.DeckOfCards;

import java.io.IOException;

public class AboutCommand extends Command {

    public AboutCommand(DeckOfCards deck) {
        super(deck);
    }

    @Override
    public boolean execute() {
        try {
            new ProcessBuilder("x-www-browser", "https://en.wikipedia.org/wiki/Playing_card").start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

}
