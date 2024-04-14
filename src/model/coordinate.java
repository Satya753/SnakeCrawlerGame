package model;

public class coordinate {
    public int x;
    public int y;
    public char element;

    public coordinate(int x , int y , char element){
        this.x = x;
        this.y = y;
        this.element = element;
    }

    public int isSnakeorFood(){
        if (this.element=='O')
            return 0;
        else if (this.element=='$')
            return 1;
        else
            return 2;
    }

}
