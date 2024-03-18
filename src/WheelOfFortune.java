import java.util.ArrayList;

public class WheelOfFortune {
    private String[][] WheelOfFortunePhrase;
    private String[] words;
    private int lives;
    public WheelOfFortune(String phrase){
        lives = 3;
        words = phrase.split(" ");
        int count = 0;
        String largestWord = "";
        for (int j = 0; j < words.length; j++)  {
            if (words[j].length() > largestWord.length())    {
                largestWord = words[j];
            }
            count++;
        }
        WheelOfFortunePhrase = new String[largestWord.length() + 2][count + 2];
    }

    // adds a phrase to 2D array
    public void runWheelOfFortune() {

    }
}
