package com.thomas.gameoflife;

import java.util.List;

/**
 *
 * @author thomas
 */
public class NeighborCountProvider {
    
    private final List<Cell> livingCells;

    public NeighborCountProvider(List<Cell> livingCells) {
        this.livingCells = livingCells;
    }

    public int countLivingNeightbors(Cell cell) {
        int neightbors = 0;
        for (Cell livingCell : livingCells) {
            if (cell.isNeighborOf(livingCell)) {
                neightbors++;
            }
        }
        return neightbors;
    }
}
