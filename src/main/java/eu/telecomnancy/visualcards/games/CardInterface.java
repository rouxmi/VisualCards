package eu.telecomnancy.visualcards.games;


import javafx.scene.image.Image;

public interface CardInterface {

    //Interface of eu.telecomnancy.visualcards.games.Cartes52.Card.java

    //declare all functions

    CardValue getValue();
    CardColor getColor();

    void setValue(CardValue value);

    void setColor(CardColor color);

    String toString();


    int hashCode();


    Image getImage();













}
