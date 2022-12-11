package eu.telecomnancy.visualcards.games;

import eu.telecomnancy.visualcards.MyObservable;
import eu.telecomnancy.visualcards.games.Cartes52.CardColor52;
import eu.telecomnancy.visualcards.games.Cartes52.CardValue52;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

// Représente un jeu de cartes. Une variable référence l'image représentant le dos d'une carte.
public class DeckOfCards extends MyObservable {
    protected ArrayList<Card> deck;

    int topCard=0;

    /**
     * This is a 1 argument constructor that passes in a collection
     * of Card objects
     * @param deck le jeu de carte pour initialiser le jeu
     */
    public DeckOfCards(ArrayList<Card> deck) {
        this.deck =deck;
    }

    /**
     * This is a zero argument constructor that will build a full Deck of Cards
     */


    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
        notifyObservers();
    }

   

    /**
     * This method will "deal" the top card off the deck. At the end of the deck we start over at the beginning
     */
    public Card dealTopCard()
    {
        Card result=deck.get(topCard);
        topCard=topCard+1;
        if (topCard>51) {
            topCard=0;
        }
        notifyObservers();
        return result;
    }



    /**
     * This method will shuffle the deck of cards
     */
    public void shuffle()
    {
        Collections.shuffle(deck);
        notifyObservers();
    }

    /**
     * This method will "sort" the deck
     */
    public void sort() {
        Collections.sort(deck);
        notifyObservers();
    }

    /**
     * This method will draw a card from the deck at a defined place (i)
     */
    public Card drawACard(int i) {
        return deck.get(i);
    }

    /**
     * This method will draw a card from the deck at a random place
     */
    public Card drawARandomCard() {
        var index=new Random().nextInt(52);
        Card result=deck.get(index);
        topCard=index;
        notifyObservers();
        return result;

    }


    public Card getTopCard() {
        return deck.get(topCard);
    }

}
