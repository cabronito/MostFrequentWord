
/**
 * determine the word that occurs the most often in a file. If more than one 
 * word occurs as the most often, then return the first such word found
 *
 * @author cabronito
 * @version 2022-02-28 v1.0
 */

import edu.duke.*;
import java.util.ArrayList;

public class WordsFrequencies {
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    /**
     * Constructor of WordsFrequencies
     */
    public WordsFrequencies() {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }

    /**
     * findUnique should first clear both myWords and myFreqs, using 
     * the .clear() method. Then it selects a file and then iterates over 
     * every word in the file, putting the unique words found into myWords. 
     * For each word in the kth position of myWords, it puts the count of 
     * how many times that word occurs from the selected file into the kth 
     * position of myFreqs.
     *
     * @param      none
     * @return     none
     */
    private void findUnique() {
        myWords.clear();
        myFreqs.clear();
        FileResource resource = new FileResource();
        for (String word : resource.words()) {
            word = word.toLowerCase();
            int index = myWords.indexOf(word);
            if (index == -1) {
                myWords.add(word);
                myFreqs.add(1);
            } else {
                int value = myFreqs.get(index);
                myFreqs.set(index, value+1);
            }
        }
    }
    
    /**
     * findIndexOfMax returns an int that is the index location of the 
     * largest value in myFreqs. If there is a tie, then return the first 
     * such value.
     * 
     * @param      none
     * @return     maxIndex
     */
    private int findIndexOfMax() {
        int maxIndex = 0;
        int maxValue = 0;
        for (int i = 0; i < myFreqs.size(); i++) {
            if (myFreqs.get(i) > maxValue) {
                maxValue = myFreqs.get(i);
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    /**
     * tester should call findUnique. Then print out the number of unique 
     * words, and for each unique word, print the frequency of each word and 
     * the word
     *
     * @param      none
     * @return     none
     */
    public void tester() {
        findUnique();
        System.out.println("# unique words: " + myWords.size());
        /*for (int i = 0; i < myWords.size(); i++) {
            System.out.println(myFreqs.get(i) + " : " + myWords.get(i));
        }*/
        int index = findIndexOfMax();
        System.out.println("The word that occurs most often and its count are: "
                            + myWords.get(index) + " " + myFreqs.get(index));
    }
}
