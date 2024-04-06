public class Player {
    private int lives;
    private String name;
    private int points;

    public Player(String name, int  lives){
        this.name =  name;
        this.lives =  lives;
        this.points = 0;
    }

    public String getName(){
        return name;
    }
    public int getLives(){
        return  lives;
    }
    public void decreaseLives(){
        lives--;
    }
    public String showLives(){
        return name + " has " + lives + " live(s)!";
    }
    public void addPoints(int amt){
        points += amt;
    }
    public void subtractPoints(int amt){
        points -= amt;
    }
    public int getPoints(){
        return points;
    }
    public String showPoints()  {
        return Colors.getAnsiBlue() + points + Colors.getAnsiReset();
    }
}