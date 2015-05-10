package com.thomas.gameoflife;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author thomas
 */
@RunWith(MockitoJUnitRunner.class)
public class LivingCellDestinyEvaulatorTest {
    
    @Mock
    private NeighborCountProvider neighborCountProvider;
    @InjectMocks
    private LivingCellDestinyEvaulator destinyEvaulator;

    @Test
    public void testAliveCellWithOneLivingNeightborWillDieBecuseOfUnderPopulation() {
        Cell cell = new Cell(0, 0);
        doReturn(1).when(neighborCountProvider).countLivingNeightbors(argThat(is(equalTo(cell))));
        
        assertThat(destinyEvaulator.evaulateDestinyOf(cell), is(equalTo(CellDestiny.DEATH)));
        
        verify(neighborCountProvider).countLivingNeightbors(argThat(is(equalTo(cell))));
    }
    
    @Test
    public void testAliveCellWithNoLivingNeightborWillDieBecuseOfUnderPopulation() {
        Cell cell = new Cell(0, 0);
        doReturn(0).when(neighborCountProvider).countLivingNeightbors(argThat(is(equalTo(cell))));
        
        assertThat(destinyEvaulator.evaulateDestinyOf(cell), is(equalTo(CellDestiny.DEATH)));
        
        verify(neighborCountProvider).countLivingNeightbors(argThat(is(equalTo(cell))));
    }
    
    @Test
    public void testAliveCellWithTwoLivingNeightborLivesOn() {
        Cell cell = new Cell(0, 0);
        doReturn(2).when(neighborCountProvider).countLivingNeightbors(argThat(is(equalTo(cell))));
        
        assertThat(destinyEvaulator.evaulateDestinyOf(cell), is(equalTo(CellDestiny.LIVES_ON)));
        verify(neighborCountProvider).countLivingNeightbors(argThat(is(equalTo(cell))));
    }
    
    @Test
    public void testAliveCellWithThreeLivingNeightborLivesOn() {
        Cell cell = new Cell(0, 0);
        doReturn(3).when(neighborCountProvider).countLivingNeightbors(argThat(is(equalTo(cell))));
        
        assertThat(destinyEvaulator.evaulateDestinyOf(cell), is(equalTo(CellDestiny.LIVES_ON)));
        verify(neighborCountProvider).countLivingNeightbors(argThat(is(equalTo(cell))));
    }
    
    @Test
    public void testAliveCellWithMoreThenThreeLivingNeightborWillDieBecauseOfOvercrowding() {
        Cell cell = new Cell(0, 0);
        doReturn(4).when(neighborCountProvider).countLivingNeightbors(argThat(is(equalTo(cell))));
        
        assertThat(destinyEvaulator.evaulateDestinyOf(cell), is(equalTo(CellDestiny.DEATH)));
        verify(neighborCountProvider).countLivingNeightbors(argThat(is(equalTo(cell))));
    }
}
