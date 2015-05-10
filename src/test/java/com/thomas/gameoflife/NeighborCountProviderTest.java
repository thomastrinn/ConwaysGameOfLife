package com.thomas.gameoflife;

import static org.hamcrest.CoreMatchers.*;
import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author thomas
 */
public class NeighborCountProviderTest {

    private NeighborCountProvider neighborCountProvider;

    @Test
    public void testCountLivingNeightbors() {
        Cell cell1 = new Cell(2, 1);
        Cell cell2 = new Cell(3, 2);
        Cell cell3 = new Cell(4, 0);
        Cell selectedCell = new Cell(3, 1);
        
        neighborCountProvider = new NeighborCountProvider(Arrays.asList(cell1, cell2, cell3, selectedCell));
        
        assertThat(neighborCountProvider.countLivingNeightbors(selectedCell), is(equalTo(3)));
    }
}