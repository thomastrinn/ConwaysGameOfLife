package com.thomas.gameoflife;

import java.util.List;
import java.util.TimerTask;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author thomas
 */
public class CellDrawerTask extends TimerTask {
    
    private static final int CELL_SIZE = 10;

    private static final Color COLOR_GREEN_GOSSIP = Color.rgb(135, 211, 124);

    private final Stage primaryStage;
    private final GraphicsContext gc;
    private final List<Cell> cells;
    private final GameOfLife gameOfLife;

    public CellDrawerTask(final Stage primaryStage, GraphicsContext gc, List<Cell> cells) {
        this.primaryStage = primaryStage;
        this.gc = gc;
        this.cells = cells;
        this.gameOfLife = new GameOfLife(cells);
    }

    @Override
    public void run() {
        gc.clearRect(0, 0, primaryStage.getWidth(), primaryStage.getHeight());

        gc.setFill(COLOR_GREEN_GOSSIP);
        for (Cell cell : cells) {
            gc.fillOval(
                    CELL_SIZE * cell.getX(),
                    CELL_SIZE * cell.getY(),
                    CELL_SIZE,
                    CELL_SIZE);
        }

        gc.restore();

        gameOfLife.nextGeneration();
    }

}
