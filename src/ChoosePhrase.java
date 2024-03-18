import java.util.ArrayList;

public class ChoosePhrase {
    private String level;

    public ChoosePhrase()   {
        level = "easy";
        listOfPhrases();
    }

    public void setLevel(String newLevel)  {
        level = newLevel;
    }

    public void listOfPhrases() {
        ArrayList<String> easyLevel = new ArrayList<>();
        easyLevel.add("Bahamas");
        easyLevel.add("Japan");
        easyLevel.add("China");
        easyLevel.add("Costa Rica");
        ArrayList<String> mediumLevel = new ArrayList<>();
        mediumLevel.add("Binary Search");
        mediumLevel.add("Iteration");
        mediumLevel.add("Data Abstraction");
        mediumLevel.add("Jargon");
        ArrayList<String> hardLevel = new ArrayList<>();
        hardLevel.add("Harry Potter");
        hardLevel.add("Song of Solomon");
        hardLevel.add("Percy Jackson");
        hardLevel.add("To a kill a mocking bird");

        if (level.equals("easy"))    {
            for (int i = 0; i < easyLevel.size(); i++)  {
                WheelOfFortune phrase = new WheelOfFortune(easyLevel.get(i));
                phrase.runWheelOfFortune();
                setLevel("medium");
            }
        } else if (level.equals("medium")){
            for (int i = 0; i < mediumLevel.size(); i++)  {
                WheelOfFortune phrase = new WheelOfFortune(easyLevel.get(i));
                phrase.runWheelOfFortune();
                setLevel("hard");
            }
        } else if (level.equals("hard")){
            for (int i = 0; i < hardLevel.size(); i++)  {
                WheelOfFortune phrase = new WheelOfFortune(easyLevel.get(i));
                phrase.runWheelOfFortune();
            }
        }

    }
}
