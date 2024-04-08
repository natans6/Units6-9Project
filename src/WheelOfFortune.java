import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class WheelOfFortune {
    private String phrase;
    private String[][] phraseFound;
    private String[][] actualPhrase;
    private String[] categories;
    private String[] words;
    private String[] constants;
    private int round;
    Scanner scanner = new Scanner(System.in);
    public WheelOfFortune(){
        categories = new String[]{"BAHAMAS", "JAPAN", "CHINA", "COSTA RICA", "BINARY SEARCH", "ITERATION", "ALGORITHM", "ENGINEERING", "HARRY POTTER", "SONG OF SOLOMON", "PERCY JACKSON", "TO KILL A MOCKING BIRD"};
        constants = new String[]{"B", "C", "D", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "V", "W", "X", "Y", "Z"};
    }


    public void play(){
        introduction();
        runGame();
    }


    public void introduction(){
        System.out.println("Welcome to the Wheel of Fortune Java project, where luck and strategy collide in a whirlwind of excitement! \nPrepare to spin the wheel, solve puzzles, and test your fortune in this thrilling interactive game experience. \nIn order to guess a vowel, you need to have at least 300 points.");
        System.out.println();
    }


    public void runGame() {
        System.out.print("Game Host: What is your name? ");
        String name = scanner.nextLine();
        Player player1 = new Player(name, 5);
        Computer computer = new Computer("COMPUTER", 1000);
        System.out.println("Game Host: Well " + player1.getName() + ", I wish you good luck in finding your true worth and fortune!");
        System.out.println("You will have a total of " + Colors.getAnsiPurple() + player1.getLives() + Colors.getAnsiReset() + " lives to reach the fortune...");
        for (round = 1; round < 13; round++) {
            System.out.println();
            System.out.println("<---------------------------------------------------------->");
            System.out.println();
            if(round < 5){
                System.out.println(Colors.getAnsiBlue() + "- - - - - Category : Countries - - - - - " + Colors.getAnsiReset());
                System.out.println();
            }  else  if (round < 9){
                System.out.println(Colors.getAnsiBlue() + "- - - - - Category : Computer Science Terms - - - - - " + Colors.getAnsiReset());
                System.out.println();
            }  else {
                System.out.println(Colors.getAnsiBlue() + "- - - - - Category : Names of Books - - - - - " + Colors.getAnsiReset());
                System.out.println();
            }
            boolean ready = false;
            System.out.println(Colors.getAnsiPurple() + "Round " + round + " is now commencing..." + Colors.getAnsiReset());
            setPhraseFound();
            fillActualPhrase();
            showPhrase();
            while (!ready && player1.getLives() > 0) {
                System.out.println("Player Points: " + player1.showPoints());
                System.out.println("Computer Points: " + computer.showPoints());
                System.out.println();
                System.out.print("Would you like to guess the whole phrase? (y for yes / l for guessing a letter): ");
                String answer = scanner.nextLine();
                if (answer.equals("y")) {
                    System.out.println();
                    System.out.print("What do you think the phrase is: ");
                    String guessedAnswer = scanner.nextLine();
                    if (checkIfCompletePhraseGuessedCorrectly(guessedAnswer.toUpperCase())) {
                        for (int i = 0; i < categories.length; i++) {
                            if (categories[i].equals(phrase)) {
                                if (i < 4) {
                                    player1.addPoints(500);
                                } else if (i < 8) {
                                    player1.addPoints(800);
                                } else {
                                    player1.addPoints(1000);
                                }
                            }
                        }


                        ready = true;
                    } else {
                        System.out.println("Sorry the phrase you guessed was incorrect...");
                        player1.decreaseLives();
                    }
                } else if (answer.equals("l")) {
                    System.out.print("What letter would you like to guess: ");
                    String letter = scanner.nextLine();
                    if (checkLetterVowel(letter.toUpperCase())) {
                        if (player1.getPoints() >= 300) {
                            System.out.println(Colors.getAnsiUnderline() + "You spent 300 points in order to purchase a vowel." + Colors.getAnsiReset());
                            player1.subtractPoints(300);

                        } else {
                            System.out.println(Colors.getAnsiUnderline() + "You do not have 300 or more points in order to buy a vowel, guess a consonant..." + Colors.getAnsiReset());
                            System.out.print("What letter would you like to guess: ");
                            letter = scanner.nextLine();
                            while (checkLetterVowel(letter.toUpperCase())) {
                                System.out.println("That letter is not a vowel, try again!");
                                System.out.print("What letter would you like to guess: ");
                                letter = scanner.nextLine();
                            }
                        }
                    }
                    if (checkIfLetterMatches(letter.toUpperCase())) {
                        removeConstant(letter.toUpperCase());
                        System.out.println(Colors.getAnsiUnderline() + "\nYou guessed a correct letter!\n" + Colors.getAnsiReset());
                        int amtTimes = arrayOfIndexes(letter);
                        if (amtTimes == 1) {
                            player1.addPoints(100);
                            System.out.println(Colors.getAnsiBlue() + "That letter was found once.\n100 points added to your score." + Colors.getAnsiReset());
                        } else {
                            player1.addPoints(amtTimes * 100);
                            System.out.println(Colors.getAnsiBlue() + "That letter was found " + amtTimes + " times. " + amtTimes * 100 + " points added to your score." + Colors.getAnsiReset());
                        }

                    } else {
                        player1.decreaseLives();
                        System.out.println(Colors.getAnsiBlue() + "That letter is not in the phrase..." + Colors.getAnsiReset());
                    }
                }
                else if(answer.equals("d")){
                    System.out.println(Colors.getAnsiBlue() + "SECRET DEVELOPER PASSWORD REQUIRED" + Colors.getAnsiReset());
                    String dev = scanner.nextLine();
                    if(dev.equals("b55")){
                        System.out.println(Colors.getAnsiGreen() + "Welcome developer! For program testing purposes, 1000000 points have been added to your player!" + Colors.getAnsiReset());
                        player1.addPoints(1000000);
                    }else{
                        System.out.println(Colors.getAnsiRed() + "Get out of here! You are not a real developer. 1 Life taken away since you are trying to hack the program." + Colors.getAnsiReset());
                        player1.decreaseLives();
                    }

                }

                System.out.println();
                System.out.println(player1.showLives());

                if (checkIfPhraseCompleted()) {
                    String[] temp = {"B", "C", "D", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "V", "W", "X", "Y", "Z"};
                    constants = temp;
                    ready = true;
                    System.out.println(Colors.getAnsiGreen() + "CONGRATULATIONS FOR PASSING ROUND " + round + "!" + Colors.getAnsiReset());
                    if (round == 12) {
                        System.out.println();
                        showPhrase();
                        System.out.println();
                        System.out.println("<---------------------------------------------------------->");
                        System.out.println("YOU HAVE COMPLETED THE GAME AND HAVE WON A GRAND TOTAL OF " + player1.getPoints() + " POINTS!");
                        System.out.println("Now it is time for us to leave, have a good one!");
                        break;
                    }
                }
                if (!(checkIfPhraseCompleted())) {
                    if (computer.guessCorrectLetter() && checkForConstants()) {
                        boolean notValid = true;
                        int randomIdx = 0;
                        while (notValid) {
                            randomIdx = (int) (Math.random() * phrase.length());
                            for (int i = 0; i < constants.length; i++) {
                                if ((constants[i]).contains(phrase.substring(randomIdx, randomIdx + 1))) {
                                    notValid = false;
                                }
                            }
                        }
                        removeConstant(phrase.substring(randomIdx, randomIdx + 1).toUpperCase());
                        System.out.println("The Computer guessed " + phrase.substring(randomIdx, randomIdx + 1));
                        int amtTimes = arrayOfIndexes(phrase.substring(randomIdx, randomIdx + 1));
                        if (amtTimes == 1) {
                            computer.addPoints(100);
                            System.out.println(Colors.getAnsiRed() + "That letter was found once. 100 points added to the computer's score." + Colors.getAnsiReset());
                        } else {
                            computer.addPoints(amtTimes * 100);
                            System.out.println(Colors.getAnsiRed() + "That letter was found " + amtTimes + " times. " + amtTimes * 100 + " points added to the computer's score." + Colors.getAnsiReset());
                        }

                    } else {
                        int randomConstant = (int) (Math.random() * constants.length);
                        if (checkIfLetterMatches(constants[randomConstant].toUpperCase())) {
                            System.out.println(Colors.getAnsiRed() + "The Computer guessed " + constants[randomConstant].toUpperCase());
                            int amtTimes = arrayOfIndexes(constants[randomConstant].toUpperCase());
                            if (amtTimes == 1) {
                                computer.addPoints(100);
                                System.out.println(Colors.getAnsiRed() + "That letter was found once. 100 points added to the computer's score." + Colors.getAnsiReset());
                            } else {
                                computer.addPoints(amtTimes * 100);
                                System.out.println(Colors.getAnsiRed() + "That letter was found " + amtTimes + " times. " + amtTimes * 100 + " points added to the computer's score." + Colors.getAnsiReset());
                            }
                            removeConstant(constants[randomConstant].toUpperCase());
                        } else {
                            System.out.println(Colors.getAnsiRed() + "The computer has guessed incorrectly" + Colors.getAnsiReset());
                        }
                    }
                }
                System.out.println();
                showPhrase();
            }
            if (player1.getLives() <= 0) {
                System.out.println("<---------------------------------------------------------->");
                System.out.println("Sorry, you " + Colors.getAnsiRed() + "lost" + Colors.getAnsiReset() + " the game.");
                System.out.println("You ended the game with " + Colors.getAnsiGreen() + player1.getPoints() + Colors.getAnsiReset() + " points!");
                System.out.println("The word that you were not able to guess correctly was: " + Colors.getAnsiUnderline() + phrase + Colors.getAnsiReset());
                break;
            }

        }
        System.out.println("<---------------------------------------------------------->");
        ArrayList<Player> currentPlayers = new ArrayList<Player>();
        currentPlayers.add(player1);
        currentPlayers.add(computer);
        for (Player currentPlayer : currentPlayers) {
            System.out.println(Colors.getAnsiGreen() + currentPlayer.getName() + Colors.getAnsiReset() + " has " + currentPlayer.getPoints() + " points!");
        }
        if (player1.getPoints() > computer.getPoints()){
            System.out.println(player1.getName() + " has more points than the computer!!!");
        } else if (player1.getPoints() < computer.getPoints()){
            System.out.println("The computer has more points than you. Sorry not sorry...");
        } else {
            System.out.println("Looks like there has been a tie! Too bad...");
        }
        System.out.println("<---------------------------------------------------------->");
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

    public void removeConstant(String letter)    {
        ArrayList<String> newConstants = new ArrayList<>();
        for (int i = 0; i < constants.length; i++)  {
            newConstants.add(constants[i]);
        }
        for (int i = 0; i < newConstants.size(); i++)   {
            if ((newConstants.get(i)).contains(letter.toUpperCase())) {
                newConstants.remove(i);
            }
        }
        String[] temp = new String[newConstants.size() - 1 ];
        for (int i = 0; i < temp.length; i++)   {
            temp[i] += newConstants.get(i);
        }
        constants = temp;
    }

    public boolean checkForConstants()  {
        for (int i = 0; i < constants.length; i++)  {
            for (int j = 0; j < phrase.length(); j++)   {
                if (constants[i].contains(phrase.substring(j,j + 1)))  {
                    return true;
                }
            }
        }
        return false;
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

    public boolean checkIfLetterMatches(String letter){
        boolean check  = false;
        if(arrayOfIndexes(letter)!=0){
            check=true;
        }
        return check;
    }
    public int arrayOfIndexes(String letter){
        int total = 0;
        for (int i = 0; i < actualPhrase.length;  i++){
            for (int j = 0; j < actualPhrase[i].length;  j++){
                if (actualPhrase[i][j].equals(letter.toUpperCase())){
                    phraseFound[i][j] = letter.toUpperCase();
                    total++;
                }
            }
        }
        return total;
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
    public  boolean checkLetterVowel(String letter){
        return letter.equals("A") || letter.equals("E") || letter.equals("I") || letter.equals("O") || letter.equals("U");
    }
}
