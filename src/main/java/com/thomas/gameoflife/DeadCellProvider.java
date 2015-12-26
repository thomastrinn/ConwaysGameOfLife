package com.thomas.gameoflife;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author thomas
 */
public class DeadCellProvider {

    private final SurroundingCellProvider surroundingCellProvider = new SurroundingCellProvider();
    private final List<Cell> livingCells;
    private final List<Cell> deadCells;

    public DeadCellProvider(List<Cell> livingCells) {
        this.livingCells = livingCells;
        deadCells = new LinkedList<>();
    }

    public List<Cell> deadCells() {
        deadCells.clear();
        for (Cell livingCell : livingCells) {
            findSurrondingDeadCells(livingCell);
        }

        return deadCells;
    }

    private void findSurrondingDeadCells(Cell livingCell) {
        for (Cell cell : surroundingCellProvider.getSurroundingCells(livingCell)) {
            if (!livingCells.contains(cell) && !deadCells.contains(cell)) {
                deadCells.add(cell);
            }
        }
    }

}
