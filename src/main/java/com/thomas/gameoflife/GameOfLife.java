package com.thomas.gameoflife;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author thomas
 */
public class GameOfLife {

    private final List<Cell> livingCells;
    private final LivingCellDestinyEvaulator livingCellDestinyEvaulator;
    private final CellIncubator incubator;

    public GameOfLife(List<Cell> livingCells) {
        this.livingCells = Objects.requireNonNull(livingCells);

        final NeighborCountProvider neighborCountProvider = new NeighborCountProvider(livingCells);
        final DeadCellProvider deadCellProvider = new DeadCellProvider(livingCells);
        livingCellDestinyEvaulator = new LivingCellDestinyEvaulator(neighborCountProvider);
        incubator = new CellIncubator(deadCellProvider, neighborCountProvider);
    }

    public void nextGeneration() {
        List<Cell> dying = findDyingCells();
        List<Cell> infants = incubator.getInfants();

        livingCells.removeAll(dying);
        livingCells.addAll(infants);
    }

    private List<Cell> findDyingCells() {
        final List<Cell> dyingCells = new LinkedList<>();
        for (Cell cell : livingCells) {
            if (shouldTheCellDie(cell)) {
                dyingCells.add(cell);
            }
        }
        return dyingCells;
    }

    private boolean shouldTheCellDie(Cell cell) {
        return CellDestiny.DEATH == livingCellDestinyEvaulator.evaulateDestinyOf(cell);
    }
}
