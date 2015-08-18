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
public class LivingCellDestinyEvaluatorTest {
    
    @Mock
    private NeighborCountProvider neighborCountProvider;
    @InjectMocks
    private LivingCellDestinyEvaluator destinyEvaulator;

    @Test
    public void testAliveCellWithOneLivingNeigtborWillDieBecuseOfUnderPopulation() {
        Cell cell = new Cell(0, 0);
        doReturn(1).when(neighborCountProvider).countLivingNeighbors(argThat(is(equalTo(cell))));
        
        assertThat(destinyEvaulator.evaluateDestinyOf(cell), is(equalTo(CellDestiny.DEATH)));
        
        verify(neighborCountProvider).countLivingNeighbors(argThat(is(equalTo(cell))));
    }
    
    @Test
    public void testAliveCellWithNoLivingNeighborWillDieBecuseOfUnderPopulation() {
        Cell cell = new Cell(0, 0);
        doReturn(0).when(neighborCountProvider).countLivingNeighbors(argThat(is(equalTo(cell))));
        
        assertThat(destinyEvaulator.evaluateDestinyOf(cell), is(equalTo(CellDestiny.DEATH)));
        
        verify(neighborCountProvider).countLivingNeighbors(argThat(is(equalTo(cell))));
    }
    
    @Test
    public void testAliveCellWithTwoLivingNeighborLivesOn() {
        Cell cell = new Cell(0, 0);
        doReturn(2).when(neighborCountProvider).countLivingNeighbors(argThat(is(equalTo(cell))));
        
        assertThat(destinyEvaulator.evaluateDestinyOf(cell), is(equalTo(CellDestiny.LIVES_ON)));
        verify(neighborCountProvider).countLivingNeighbors(argThat(is(equalTo(cell))));
    }
    
    @Test
    public void testAliveCellWithThreeLivingNeighborLivesOn() {
        Cell cell = new Cell(0, 0);
        doReturn(3).when(neighborCountProvider).countLivingNeighbors(argThat(is(equalTo(cell))));
        
        assertThat(destinyEvaulator.evaluateDestinyOf(cell), is(equalTo(CellDestiny.LIVES_ON)));
        verify(neighborCountProvider).countLivingNeighbors(argThat(is(equalTo(cell))));
    }
    
    @Test
    public void testAliveCellWithMoreThenThreeLivingNeighborWillDieBecauseOfOvercrowding() {
        Cell cell = new Cell(0, 0);
        doReturn(4).when(neighborCountProvider).countLivingNeighbors(argThat(is(equalTo(cell))));
        
        assertThat(destinyEvaulator.evaluateDestinyOf(cell), is(equalTo(CellDestiny.DEATH)));
        verify(neighborCountProvider).countLivingNeighbors(argThat(is(equalTo(cell))));
    }
}
