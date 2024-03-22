import java.util.Arrays;
import java.util.Scanner;

public class WheelOfFortune {
    private String phrase;
    private String[][] phraseFound;
    private String[][] actualPhrase;
    private String[] categories;
    private String[] words;
    private int round;
    Scanner scanner = new Scanner(System.in);
    public WheelOfFortune(){
        categories = new String[]{"BAHAMAS", "JAPAN", "CHINA", "COSTA RICA", "BINARY SEARCH", "ITERATION", "ALGORITHM", "JARGON", "HARRY POTTER", "SONG OF SOLOMON", "PERCY JACKSON", "TO KILL A MOCKING BIRD"};
    }

    public void play(){
        introduction();
        runGame();
    }

    public void introduction(){
        System.out.println("Welcome to the Wheel of Fortune Java project, where luck and strategy collide in a whirlwind of excitement! \nPrepare to spin the wheel, solve puzzles, and test your fortune in this thrilling interactive game experience.");
    }

    public void runGame(){
        System.out.println("Game Host: What is your name? ");
        String name = scanner.nextLine();
        Player player = new Player(name, 3);
        System.out.print("Game Host: Well " + player.getName() + ", I wish you good luck in finding your true worth and fortune!");
        System.out.println(" You will have a total of " + Colors.getAnsiPurple() + player.getLives() + Colors.getAnsiReset() + " lives to reach the fortune...");
        for (round = 1; round < 13; round++){
            System.out.println("╰── ⋅ ⋅ ── ✩ ── ⋅ ⋅ ──╯");
            boolean ready = false;
            System.out.println(Colors.getAnsiPurple() + "Round " + round  +  " is now commencing..." + Colors.getAnsiReset());
            setPhraseFound();
            fillActualPhrase();
            showPhrase();
            while(!ready){
                System.out.println("Would you like to guess the whole phrase? (y for yes / l for guessing a letter): ");
                String answer =  scanner.nextLine();
                if (answer.equals("y")){
                    System.out.println("What do you think the phrase is: ");
                    String guessedAnswer = scanner.nextLine();
                    if (checkIfCompletePhraseGuessedCorrectly(guessedAnswer.toUpperCase())){
                        ready =  true;
                    } else {
                        System.out.println("Sorry the phrase you guessed was incorrect...");
                    }
                } else if  (answer.equals("l")){
                    System.out.print("What letter would you like to guess: ");
                    String letter =  scanner.nextLine();
                    if (checkIfLetterMatches(letter.toUpperCase())){
                        System.out.println("You guessed a correct letter!");
                    } else{
                        System.out.println("That letter is not in the phrase...");
                    }
                }
                showPhrase();
                if (checkIfPhraseCompleted()){
                    ready = true;
                    System.out.println(Colors.getAnsiGreen() + "CONGRATULATIONS FOR PASSING ROUND " + round + "!" + Colors.getAnsiReset());
                }
            }
        }
    }
    public void getPhrase(){
        phrase = categories[round - 1];
    }
    public void setPhraseFound(){
        getPhrase();
        words = phrase.split(" ");
        String largestWord = "";
        for (int j = 0; j < words.length; j++)  {
            if (words[j].length() > largestWord.length())    {
                largestWord = words[j];
            }
        }
        phraseFound = new String[words.length][largestWord.length()];
        for (String[] strings : phraseFound) {
            Arrays.fill(strings, "＿");
        }
        actualPhrase  = new String[words.length][largestWord.length()];
    }
    public void fillActualPhrase(){
        String[] words = phrase.split(" ");
        int wordIndex = 0;
        for (int i = 0; i < actualPhrase.length; i++) {
            if (wordIndex < words.length) {
                String word = words[wordIndex++];
                String[] charactersOfWord = word.split("");
                for (int j = 0; j < actualPhrase[i].length && j < charactersOfWord.length; j++) {
                    actualPhrase[i][j] = charactersOfWord[j];
                }
                for (int j = charactersOfWord.length; j < actualPhrase[i].length; j++) {
                    actualPhrase[i][j] = "X";
                }
            } else {
                for (int j = 0; j < actualPhrase[i].length; j++) {
                    actualPhrase[i][j] = "X";
                }
            }
        }
    }
    // Shows what user will see
    public void showPhrase(){
        System.out.println(Colors.getAnsiCyan() + "*****************" +  Colors.getAnsiReset());
        for (int i = 0;  i <  phraseFound.length; i++){
            for (int  j = 0; j < phraseFound[i].length;  j++){
                if (actualPhrase[i][j].equals(" ") || actualPhrase[i][j].equals("X")){
                    phraseFound[i][j] = Colors.getAnsiCyan() + "X" +  Colors.getAnsiReset();
                }
                System.out.print(phraseFound[i][j]);
            }
            System.out.println();
        }
        System.out.println(Colors.getAnsiCyan() + "*****************" +  Colors.getAnsiReset());
    }
    // Used to compare to what the user guesses
    public void showAnswerPhrase(){
        for (int i = 0; i < actualPhrase.length; i++){
            for (int  j = 0; j < actualPhrase[i].length;  j++){
                if (actualPhrase[i][j].equals(" ")){
                    actualPhrase[i][j] = "X";
                }
                System.out.print(actualPhrase[i][j]);
            }
            System.out.println();
        }
    }
    public boolean checkIfLetterMatches(String letter){
        boolean check  = false;
        for (int i = 0; i < actualPhrase.length;  i++){
            for (int j = 0; j < actualPhrase[i].length;  j++){
                if (actualPhrase[i][j].equals(letter)){
                    phraseFound[i][j] = letter.toUpperCase();
                    check = true;
                }
            }
        }
        return check;
    }
    public boolean checkIfCompletePhraseGuessedCorrectly(String phraseGuessed){
        if  (phraseGuessed.equals(phrase)){
            phraseFound = actualPhrase;
            return true;
        }  else  {
            return false;
        }
    }
    public boolean checkIfPhraseCompleted(){
        for (int i = 0; i < phraseFound.length; i++){
            for (int j = 0; j < phraseFound[i].length; j++){
                if (phraseFound[i][j].equals("＿")){
                    return false;
                }
            }
        }
        return true;
    }
}