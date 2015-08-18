package com.thomas.gameoflife;

import java.util.Arrays;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.argThat;
import org.mockito.Mock;
import static org.mockito.Mockito.doReturn;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author thomas
 */
@RunWith(MockitoJUnitRunner.class)
public class CellIncubatorTest {

    @Mock
    private NeighborCountProvider neighborCountProvider;
    @Mock
    private DeadCellProvider deadCellProvider;
    @InjectMocks
    private CellIncubator cellIncubator;
    
    @Test
    public void testDeadCellWithExactlyThreeLivingNeightborWillComeToLive() {
        Cell deadCell = new Cell(0, 0);
        doReturn(Arrays.asList(deadCell)).when(deadCellProvider).deadCells();
        doReturn(3).when(neighborCountProvider).countLivingNeighbors(argThat(is(equalTo(deadCell))));
        
        assertThat(cellIncubator.getInfants(), is(Arrays.asList(new Cell(0, 0))));
    }
    
    @Test
    public void testDeadCellWithLessThreeLivingNeightborWontComeToLive() {
        Cell deadCell = new Cell(0, 0);
        doReturn(Arrays.asList(deadCell)).when(deadCellProvider).deadCells();
        doReturn(2).when(neighborCountProvider).countLivingNeighbors(argThat(is(equalTo(deadCell))));
        
        assertThat(cellIncubator.getInfants().isEmpty(), is(true));
    }
    
    @Test
    public void testDeadCellWithMoreThreeLivingNeightborWontComeToLive() {
        Cell deadCell = new Cell(0, 0);
        doReturn(Arrays.asList(deadCell)).when(deadCellProvider).deadCells();
        doReturn(4).when(neighborCountProvider).countLivingNeighbors(argThat(is(equalTo(deadCell))));
        
        assertThat(cellIncubator.getInfants().isEmpty(), is(true));
    }

}