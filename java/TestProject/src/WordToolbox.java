

import java.lang.reflect.Array;
import java.util.HashMap;

/**
 * Created by posam on 2016-11-21.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
public class WordToolbox implements IWordToolbox {
    private String stringHeld;

    public WordToolbox(String stringHeld) {
        setS(stringHeld);

    }
    public boolean isAnAnagram(String stringToCheck) {
        HashMap<Character, Integer> h1 = countAllLetters(stringToCheck);
        HashMap<Character, Integer> h2 = countAllLetters(getS());

        if (h1.equals(h2)) {
            return true;
        }
        return false;
    }

    @Override
    public void WaitingItOut() {

    }

    public int countHowMany(char charToFind) {
        int f = 0;
        for (int i = 0; i <stringHeld.length(); i++) {
            if (Character.toLowerCase(charToFind) == stringHeld.toLowerCase().charAt(i)) {
                f++;
            }
        }
        return f;
    }
    public int countHowMany(char charToFind, String stringToFindIn) {
        int f = 0;
        for (int i = 0; i <stringToFindIn.length(); i++) {
            if (Character.toLowerCase(charToFind) == stringToFindIn.toLowerCase().charAt(i)) {
                f++;
            }
        }
        return f;
    }

    public HashMap<Character, Integer> countAllLetters(String word) {
        HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
        for (char c = 97; c < 123; c++) {
            if (word.contains(String.valueOf(c))) {
                hash.put(c, countHowMany(c, word));
            }
        }
        return hash;
    }
    @Override
    public void setS(String s) {
        this.stringHeld = s;

    }

    @Override
    public String getS() {
        return stringHeld;
    }
}
