public class Computer extends Player{
    private String name;
    private int lives;
    private int points;
    public Computer(String name, int  lives)    {
        super(name, lives);
        points = 0;
    }

    public boolean guessCorrectLetter()   {
        double random  =  Math.random();
        if (random <= 0.5)  {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public String showPoints(){
        return Colors.getAnsiRed() + getPoints() + Colors.getAnsiReset();
    }



}
