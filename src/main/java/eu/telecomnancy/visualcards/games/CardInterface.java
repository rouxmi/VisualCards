package eu.telecomnancy.visualcards.games;


import javafx.scene.image.Image;

public interface CardInterface {

    //Interface of eu.telecomnancy.visualcards.games.Cartes52.Card.java

    //declare all functions

    public CardValue getValue();
    public CardColor getColor();

    public void setValue(CardValue value);

    public void setColor(CardColor color);

    public String toString();


    public int hashCode();

    public Image getImage();

    public void setImage(Image image);

    public String getSuit();









}
