package com.thomas.gameoflife;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author thomas
 */
public class CellTest {
    
    @Test
    public void testIsNeighbor() {
        Cell selectedCell = new Cell(1, 3);
        
        assertThat(selectedCell.isNeighborOf(new Cell(1, 4)), is(true));
        assertThat(selectedCell.isNeighborOf(new Cell(1, 2)), is(true));
        assertThat(selectedCell.isNeighborOf(new Cell(2, 2)), is(true));
        assertThat(selectedCell.isNeighborOf(new Cell(2, 3)), is(true));
        assertThat(selectedCell.isNeighborOf(new Cell(2, 4)), is(true));
        assertThat(selectedCell.isNeighborOf(new Cell(0, 2)), is(true));
        assertThat(selectedCell.isNeighborOf(new Cell(0, 3)), is(true));
        assertThat(selectedCell.isNeighborOf(new Cell(0, 4)), is(true));
        assertThat(selectedCell.isNeighborOf(new Cell(4, 4)), is(false));
        assertThat(selectedCell.isNeighborOf(selectedCell), is(false));
    }
    
}
