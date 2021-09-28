package interfaces;

import game.Board;
import throwables.InvalidDirectionException;

public interface Movable {
    void move(Board board) throws InvalidDirectionException;
    void turnLeft();
    void turnRight();
}
