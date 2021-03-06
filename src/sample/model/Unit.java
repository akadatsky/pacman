package sample.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import sample.Config;
import sample.board.Board;

public abstract class Unit {

    protected static final int SIZE = Config.CELL_SIZE;

    protected final GraphicsContext gc;
    protected final Board board;
    protected int xCell;
    protected int yCell;
    protected int x;
    protected int y;
    private final double radius = SIZE / 2.0;

    protected Unit(GraphicsContext gc, Board board, int xCell, int yCell) {
        this.gc = gc;
        this.board = board;
        this.xCell = xCell;
        this.yCell = yCell;
        this.x = xCell * SIZE;
        this.y = yCell * SIZE;
    }

    public abstract void draw();

    public void move() {

    }

    public void keyPressed(KeyCode code) {

    }

    public int getXCell() {
        return xCell;
    }

    public int getYCell() {
        return yCell;
    }

    public double getXCenter() {
        return x + radius;
    }

    public double getYCenter() {
        return y + radius;
    }

    protected double getShiftedX(double shift) {
        return x + SIZE * shift;
    }

    protected double getShiftedY(double shift) {
        return y + SIZE * shift;
    }

    protected static double getShiftedSize(double shift) {
        return SIZE - 2 * SIZE * shift;
    }

    public double getRadius() {
        return radius;
    }
}
