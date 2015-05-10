package com.thomas.gameoflife;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author thomas
 */
public class SurroundingCellProvider {

    private static final List<Cell> RELATIVE_POSITIONS = Arrays.asList(
            cell(-1, 1), cell(-1, 0), cell(-1, -1),
            cell(0, 1), /*0, 0*/ cell(0, -1),
            cell(1, 1), cell(1, 0), cell(1, -1)
    );

    public List<Cell> getSurroundingCells(Cell cell) {
        List<Cell> surroundings = new LinkedList<>();

        for (Cell relativeCell : RELATIVE_POSITIONS) {
            surroundings.add(cell(
                    cell.getX() - relativeCell.getX(),
                    cell.getY() - relativeCell.getY()));
        }
        return surroundings;
    }

    private static Cell cell(int x, int y) {
        return new Cell(x, y);
    }
}
