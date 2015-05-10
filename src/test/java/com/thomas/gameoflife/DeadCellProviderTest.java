package com.thomas.gameoflife;

import static org.hamcrest.CoreMatchers.*;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author thomas
 */
public class DeadCellProviderTest {

    private DeadCellProvider deadCellProvider;
    
    @Test
    public void testDeadCells() {
        Cell livingCell = new Cell(0, 0);
        deadCellProvider = new DeadCellProvider(Arrays.asList(livingCell));
        
        List<Cell> deadCells = deadCellProvider.deadCells();
        
        assertThat(deadCells.size(), is(8));
        assertThat(deadCells, hasItems(
                new Cell(-1, -1),
                new Cell(-1, 0),
                new Cell(-1, 1),
                
                new Cell(0, -1),
                new Cell(0, 1),
                
                new Cell(1, -1),
                new Cell(1, 0),
                new Cell(1, 1)
        ));
    }

}