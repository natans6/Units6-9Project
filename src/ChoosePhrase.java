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
        mediumLevel.add("Algorithm");
        mediumLevel.add("Jargon");
        ArrayList<String> hardLevel = new ArrayList<>();
        hardLevel.add("Harry Potter");
        hardLevel.add("Song of Solomon");
        hardLevel.add("Percy Jackson");
        hardLevel.add("To a kill a mocking bird");

        if (level.equals(easyLevel))    {
            for (int i = 0; i < easyLevel.size(); i++)  {
                WheelOfFortune phrase = new WheelOfFortune(easyLevel.get(i));
                phrase.runWheelOfFortune();
            }
        } else if (level.equals(mediumLevel)){
            for (int i = 0; i < easyLevel.size(); i++)  {
                WheelOfFortune phrase = new WheelOfFortune(easyLevel.get(i));
                phrase.runWheelOfFortune();
            }
        } else if (level.equals(hardLevel)){
            for (int i = 0; i < easyLevel.size(); i++)  {
                WheelOfFortune phrase = new WheelOfFortune(easyLevel.get(i));
                phrase.runWheelOfFortune();
            }
        }

    }
}