package eu.telecomnancy.visualcards.Commands;

import java.io.IOException;

public class AboutCommand extends Command {

    public AboutCommand() {
        super(null);
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
