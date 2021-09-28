package components;

import game.Board;
import interfaces.Movable;
import throwables.InvalidDirectionException;

public class Robot implements Movable {
    private int[] coordinateXY= new int[2];
    private int direction;
    //using int to represent direction. 1 = north, 2 = east, 3 = south, 4 = west.

    public Robot (int x, int y, int direction){
        this.coordinateXY[0] = x;
        this.coordinateXY[1] = y;
        this.direction = direction;
    }

    //getter and setters.
    public int[] getCoordinateXY(){
        return this.coordinateXY;
    }

    public int getDirection(){
        return direction;
    }

    public void setCoordinateXY(int x, int y){
        this.coordinateXY[0] = x;
        this.coordinateXY[1] = y;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    //functions
    public void move(Board board) throws InvalidDirectionException {
        switch (direction) {
            case 1:
                this.coordinateXY[1] = this.coordinateXY[1] < board.getHeight() ? this.coordinateXY[1] + 1 : this.coordinateXY[1];
                break;
            case 2:
                this.coordinateXY[0] = this.coordinateXY[0] < board.getWidth() ? this.coordinateXY[0] + 1 : this.coordinateXY[0];
                break;
            case 3:
                this.coordinateXY[1] = this.coordinateXY[1] > 0 ? this.coordinateXY[1] - 1 : this.coordinateXY[1];
                break;
            case 4:
                this.coordinateXY[0] = this.coordinateXY[0] > 0 ? this.coordinateXY[0] - 1 : this.coordinateXY[0];
                break;
            default:
                throw new InvalidDirectionException("Invalid Direction");
        }
    }

    //todo: how to avoid magic number here?
    public void turnLeft(){
        this.direction = this.direction <= 1 ? 4 : this.direction - 1;
    }

    public void turnRight(){
        this.direction = this.direction >= 4 ? 1 : this.direction + 1;
    }

}
