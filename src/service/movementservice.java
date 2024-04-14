package service;

import model.Board;
import model.Food;
import model.Snake;
import model.coordinate;

import java.util.Random;

public class movementservice {


    public Board board;
    Random random = new Random();
    public Snake snake;

    public Food food;

    public movementservice(Board board){
        this.board = board;
        this.snake = new Snake();
        this.food = new Food(15 , 15);
    }

    public boolean checkValidSquare(int x , int y){
        if ((board.getCoordinate(x , y).isSnakeorFood()==0))
                return false;
        if (board.getCoordinate(x , y).isSnakeorFood()==1)
            food.setConsumed();
       return true;
    }

    public coordinate getNextFoodCoordinate(){
        int x = random.nextInt(20);
        int y = random.nextInt(20);

        while(board.getCoordinate(x , y).isSnakeorFood()==0){
            x = random.nextInt(20);
            y = random.nextInt(20);
        }

        return new coordinate(x , y , '$');
    }
    public boolean makeSnakeMovement(int x , int y){
        coordinate  head = this.snake.getHead();
        int nx = head.x + x;
        int ny = head.y + y;
        nx = (nx + 20)%20;
        ny = (ny + 20)%20;

        if (checkValidSquare(nx , ny)==false)
            return false;
        boolean isFood = this.board.getCoordinate(nx , ny).isSnakeorFood()==1;
        System.out.println(nx + " " + ny);

        this.snake.moveSnake(nx , ny, isFood);

        coordinate foodCoordinate = new coordinate(food.x , food.y , '$');
        if (food.isConsumed()==true) {
            foodCoordinate = getNextFoodCoordinate();
            food = new Food(foodCoordinate.x , foodCoordinate.y);
        }
        this.board.updateGrid(this.snake.getSnake() , foodCoordinate);
        return true;

    }
}
