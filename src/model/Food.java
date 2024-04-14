package model;

public class Food {
    public int x;
    public int y;

    private boolean consumed ;
    public Food(int x, int y){
        this.x = x;
        this.y = y;
        this.consumed = false;
    }

    public boolean isConsumed(){
        return consumed;
    }

    public void setConsumed(){
        this.consumed = true;
    }
}
