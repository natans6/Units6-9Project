public class Player {
    private  int lives;
    private String name;

    public Player(String name, int  lives){
        this.name =  name;
        this.lives =  lives;
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
}