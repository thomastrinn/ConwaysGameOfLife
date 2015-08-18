package com.thomas.gameoflife;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author thomas
 */
public class CellIncubator {
    
    private final DeadCellProvider deadCellProvider;
    private final NeighborCountProvider neighborCountProvider;
    
    public CellIncubator(final DeadCellProvider deadCellProvider, final NeighborCountProvider neighborCountProvider) {
        this.deadCellProvider = deadCellProvider;
        this.neighborCountProvider = neighborCountProvider;
    }

    public List<Cell> getInfants() {
        List<Cell> infants = new LinkedList<>();
        for (Cell deadCell : deadCellProvider.deadCells()) {
            if (isEnviromentFavorableFor(deadCell)) {
                infants.add(deadCell);
            }
        }
        return infants;
    }
    
    private boolean isEnviromentFavorableFor(Cell cell) {
        final int numberOfLivingNeightbors = neighborCountProvider.countLivingNeighbors(cell);
        return numberOfLivingNeightbors == 3;
    }
}
