package model;

import java.util.Arrays;
import java.util.List;

public class Board {

    private char[][] grid;
    public Board(){
        this.grid  = new char[20][20];

        for (int  i = 0 ;i < 20 ; i++){
            Arrays.fill(this.grid[i] , '#');
        }
    }

    public boolean checkBoundary(int x , int y){
        if (x < 0 || y < 0 || x>=20  || y>=20)
            return false;
        else
            return true;
    }
    public void clearGrid(){
        for (int i = 0 ; i < 20; i++){
            Arrays.fill(this.grid[i] , '#');
        }
    }
    public void renderGrid(){

        for (int i =0 ; i < 20 ; i++){
            for (int j = 0  ; j < 20 ; j++){
                System.out.print(this.grid[i][j]);
            }
            System.out.println("");
        }
        System.out.println("-----------------------------------------------------------------------");

    }

    public void updateGrid(List< coordinate > snakeCoordinate , coordinate food){
        clearGrid();
        for (coordinate coordinate : snakeCoordinate){
            this.grid[coordinate.x][coordinate.y] = coordinate.element;
        }
        this.grid[food.x][food.y] = '$';
    }

    public coordinate getCoordinate(int x , int y){
        return new coordinate(x , y , this.grid[x][y]);
    }
}
