package sample.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;
import sample.board.Board;
import sample.util.Randomizer;

public abstract class MovingUnit extends Unit {

    protected int destX;
    protected int destY;
    private int mouthAngle = Randomizer.nextInt(45);
    private int mouthAngleStep = 1;
    boolean isMoving;

    protected MovingUnit(GraphicsContext gc, Board board, int xCell, int yCell) {
        super(gc, board, xCell, yCell);
        destX = x;
        destY = y;
    }

    protected abstract int getSpeed();

    protected void drawPacman() {
        double x = getShiftedX(0.1);
        double y = getShiftedY(0.1);
        double size = getShiftedSize(0.1);

        gc.fillArc(x, y, size, size, mouthAngle, 360 - mouthAngle * 2, ArcType.ROUND);
        gc.strokeArc(x, y, size, size, mouthAngle, 360 - mouthAngle * 2, ArcType.ROUND);

        mouthAngle += mouthAngleStep;
        if (mouthAngle <= 0) {
            mouthAngleStep = 1;
        }
        if (mouthAngle >= 45) {
            mouthAngleStep = -1;
        }
    }

    @Override
    public double getRadius() {
        return super.getRadius() * 0.9;
    }

    protected void makeStep() {
        if (Math.abs(x - destX) <= getSpeed()) {
            x = destX;
            xCell = x / SIZE;
        } else {
            if (x > destX) {
                x -= getSpeed();
            } else {
                x += getSpeed();
            }
        }

        if (Math.abs(y - destY) <= getSpeed()) {
            y = destY;
            yCell = y / SIZE;
        } else {
            if (y > destY) {
                y -= getSpeed();
            } else {
                y += getSpeed();
            }
        }

        if (x == destX && y == destY) {
            isMoving = false;
        }
    }


}
