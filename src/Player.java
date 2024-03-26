public class Player {
    private  int lives;
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
    public void  increaseLives(){
        lives++;
    }
    public String showLives(){
        return name + " has " + lives + " lives!";
    }
    public void addPoints(int amt){
        points+=amt;
    }
    public int getPoints(){
        return points;
    }
}