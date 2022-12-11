package eu.telecomnancy.visualcards.Shuffle;

import eu.telecomnancy.visualcards.games.Card;

import java.util.ArrayList;
import java.util.Random;

public class ShuffleRand
{
    // A Function to generate a random permutation of arr[]
    public static ArrayList<Card> randomize(ArrayList<Card> arr)
    {
        int n=arr.size();
        // Creating a object for Random class
        Random r = new Random();

        // Start from the last element and swap one by one. We don't
        // need to run for the first element that's why i > 0
        for (int i = n-1; i > 0; i--) {

            // Pick a random index from 0 to i
            int j = r.nextInt(i+1);

            // Swap arr[i] with the element at random index
            Card temp = arr.get(i);
            arr.set(i,arr.get(j));
            arr.set(j,temp);
        }
        return arr;
    }

}
// This code is contributed by Sumit Ghosh

