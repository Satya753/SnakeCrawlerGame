package model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Snake {
    private Deque< coordinate > snakeposition;

    public Snake(){
        this.snakeposition = new ArrayDeque<>();
        this.snakeposition.add(new coordinate(0 , 0 ,'O'));
    }

    public void moveSnake(int x , int y , boolean isFood){
        if (!isFood)
            this.snakeposition.removeLast();
        this.snakeposition.addFirst(new coordinate(x , y , 'O'));
    }

    public coordinate getHead(){
        return this.snakeposition.getFirst();
    }

    public List< coordinate > getSnake(){
        return new ArrayList<>(this.snakeposition);
    }


}
