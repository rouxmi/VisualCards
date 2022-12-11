package eu.telecomnancy.visualcards.Shuffle;

import eu.telecomnancy.visualcards.games.Card;

import java.util.ArrayList;
import java.util.Objects;

/**
 * This class implements a linear-time, in-place in-shuffle algorithm.
 *
 * @author Rodion "rodde" Efremov
 * @version 1.6 (Aug 25, 2017).
 */
public final class InShuffleAlgorithm {

    /**
     * Performs an in-place in-shuffle of the input array.
     *
     * @param array the array to in-shuffle.
     */
    public static void inShuffle(ArrayList<Card> array) {
        Objects.requireNonNull(array, "The input array is null.");

        if (array.size() < 2) {
            // Trivially shuffled.
            return;
        }

        if (array.size() % 2 == 1) {
            // Array has odd number of elements. Put the median element to the
            // end of the array:
            rightCyclicShift(array,
                    array.size() / 2,
                    array.size() / 2 + 1,
                    array.size() / 2);

            // Shuffle omitting the last element:
            inShuffle(array, 0, array.size() - 2);
        } else {
            inShuffle(array, 0, array.size() - 1);
        }
    }

    /**
     * Holds a couple of parameters crucial to the algorithm.
     */
    private static final class Parameters {

        final int m;
        final int k;

        Parameters(int m, int k) {
            this.m = m;
            this.k = k;
        }
    }

    private static void inShuffle(ArrayList<Card> array, int startIndex, int endIndex) {
        while (true) {
            int n = (endIndex - startIndex + 1) / 2;

            Parameters parameters = findParameters(n);

            int m = parameters.m;
            int k = parameters.k;

            rightCyclicShift(array, startIndex + m, n, m);

            for (int i = 0, cycleStartIndex = 1;
                 i < k;
                 i++, cycleStartIndex *= 3) {
                cycleLeader(array,
                        startIndex,
                        cycleStartIndex,
                        m);
            }

            if (m == 0) {
                return;
            }

            startIndex += 2 * m;
        }
    }

    /**
     * Computes the next index from the {@code currentIndex}. Basically, this
     * class method defines the shuffle permutation.
     *
     * @param currentIndex the input index.
     * @param n            the integer such that {@code 2 * n} is the length of
     *                     the actual (sub)array being shuffled.
     * @return             the next index in the permutation.
     */
    private static int getNextIndex(int currentIndex, int n) {
        if (currentIndex < n) {
            return currentIndex << 1;
        } else {
            return ((currentIndex - n) << 1) + 1;
        }
    }

    /**
     * Implements the cycle leader algorithm on logical array
     * {@code array[startIndex], array[startIndex + 1], ..., array[endIndex].
     * @param <T>             the array component type.
     * @param array           the array holding the logical array.
     * @param startIndex      the first inclusive index of the logical array.
     * @param endIndex        the last inclusive index of the logical array.
     * @param cycleStartIndex the starting index in the logical (sub)array.
     * @param order           the cycle order. This will be passed to the index
     *                        generating method.
     */
    private static  void cycleLeader(ArrayList<Card> array,
                                        int startIndex,
                                        int cycleStartIndex,
                                        int order) {
        int nextIndex = getNextIndex(cycleStartIndex, order);
        Card token = array.get(startIndex + cycleStartIndex);
        Card nextToken;

        while (nextIndex != cycleStartIndex) {
            nextToken = array.get(startIndex + nextIndex);
            array.set(startIndex + nextIndex, token);
            token = nextToken;
            nextIndex = getNextIndex(nextIndex, order);
        }

        array.set(startIndex + cycleStartIndex, token);
    }

    /**
     * Finds the values for the algorithm parameters.
     *
     * @param  n the length of the array to shuffle.
     * @return the object holding the parameters.
     */
    private static Parameters findParameters(int n) {
        int t = 3;
        int k = 0;

        while (t <= 2 * n) {
            t *= 3;
            k++;
        }

        return new Parameters(((t / 3) - 1) / 2, k);
    }

    /**
     * Shifts the subarray {@code array[rangeStartIndex] ...
     * array[rangeStartIndex + rangeLength - 1]} {@code shiftLength} elements to
     * the right.
     * @param array           the array holding the range being shifted.
     * @param rangeStartIndex the index at which the range being shifted begins.
     * @param rangeLength     the length of the range being shifted.
     * @param shiftLength     the number of positions to shift each array
     *                        component.
     */
    private static void rightCyclicShift(ArrayList<Card> array,
                                             int rangeStartIndex,
                                             int rangeLength,
                                             int shiftLength) {
        reverse(array, rangeStartIndex, rangeStartIndex + rangeLength - 1);
        reverse(array, rangeStartIndex, rangeStartIndex + shiftLength - 1);
        reverse(array, rangeStartIndex + shiftLength,
                rangeStartIndex + rangeLength - 1);
    }

    /**
     * Reverses the subarray {@code array[startIndex], ..., array[endIndex]}.
     *
     * @param array      the array holding the target range.
     * @param startIndex the index of the first array component belonging to the
     *                   target range.
     * @param endIndex   the index of the last array component belonging to the
     *                   target range.
     */
    private static  void reverse(ArrayList<Card> array, int startIndex, int endIndex) {
        for (; startIndex < endIndex; startIndex++, endIndex--) {
            swap(array, startIndex, endIndex);
        }
    }

    /**
     * Swaps the values of {@code array[index1]} and {@code array[index2]}.
     *
     * @param array  the target array.
     * @param index1 the index of the first target array component.
     * @param index2 the index of the second target array component.
     */
    private static  void swap(ArrayList<Card> array, int index1, int index2) {
        Card tmp = array.get(index1);
        array.set(index1, array.get(index2));
        array.set(index2, tmp);
    }


}
