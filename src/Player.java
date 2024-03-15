public class Player{
    private int score;
    private String name;
    public Player(String name){
        this.name = name;
    }

    public int getScore(){
        return score;
    }
    public String getName(){
        return name;
    }

    public void greet(){
        System.out.println("Thank you so much for having me! ");
    }
}
