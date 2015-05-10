package com.thomas.gameoflife;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author thomas
 */
public class SurroundingPositionProviderTest {

    private SurroundingCellProvider positionProvider;

    @Before
    public void setUp() {
        positionProvider = new SurroundingCellProvider();
    }

    @Test
    public void testSurroundings() {
        Cell cell = new Cell(3, 5);

        List<Cell> surroundings = positionProvider.getSurroundingCells(cell);

        assertThat(surroundings,
                is(Arrays.asList(
                                cell(4, 4), cell(4, 5), cell(4, 6),
                                cell(3, 4), /* 3, 5 */ cell(3, 6),
                                cell(2, 4), cell(2, 5), cell(2, 6)
                        )));
    }

    private Cell cell(int x, int y) {
        return new Cell(x, y);
    }

}
