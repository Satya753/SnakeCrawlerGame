import model.Board;
import model.Snake;
import service.movementservice;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static  int[] dx = new int[]{0 , 1 , -1 , 0};
    public static  int[] dy = new int[]{1 , 0 , 0 , -1};
    public static void main(String[] args) throws InterruptedException {

        Random random = new Random();
        Board board = new Board();
        movementservice movementservice = new movementservice(board);
        Scanner  scanner = new Scanner(System.in);

        while(true){
            int arrow = scanner.nextInt();
            if (arrow==5)
                break;
            if (movementservice.makeSnakeMovement(dx[arrow] , dy[arrow])==false){
                System.out.println("Game over");
            }
            board.renderGrid();
        }

    }
}