import throwable.InvalidDirectionException;

public interface Moveable {
    void move() throws InvalidDirectionException;
    void turnLeft();
    void turnRight();
}
