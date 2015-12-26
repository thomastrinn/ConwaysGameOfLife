package com.thomas.gameoflife;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author thomas
 */
public class GameOfLifeTest {

    @Test
    public void testBlinker() {
        final List<Cell> cells = new LinkedList<>(Arrays.asList(
                new Cell(-1, 0),
                new Cell(0, 0),
                new Cell(1, 0)
        ));
        
        GameOfLife gameOfLife = new GameOfLife(cells);
        gameOfLife.nextGeneration();
        
        assertThat(cells, is(Arrays.asList(
                new Cell(0, 0),
                new Cell(0, -1),
                new Cell(0, 1)
        )));
        
        gameOfLife.nextGeneration();
        
        assertThat(cells, is(Arrays.asList(
                new Cell(0, 0),
                new Cell(1, 0),
                new Cell(-1, 0)
        )));
    }

    @Test
    public void testGlider() {
        final List<Cell> cells = new LinkedList<>(Arrays.asList(
                new Cell(0, 0),
                new Cell(1, 0),
                new Cell(2, 0),
                new Cell(2, 1),
                new Cell(1, 2)
        ));
        
        GameOfLife gameOfLife = new GameOfLife(cells);
        gameOfLife.nextGeneration();
        
        assertThat(cells, is(Arrays.asList(
                new Cell(1, 0),
                new Cell(2, 0),
                new Cell(2, 1),
                new Cell(1, -1),
                new Cell(0, 1)
        )));
        
        gameOfLife.nextGeneration();
        
        assertThat(cells, is(Arrays.asList(
                new Cell(2, 0),
                new Cell(2, 1),
                new Cell(1, -1),
                new Cell(2, -1),
                new Cell(0, 0)
        )));
        
        gameOfLife.nextGeneration();
        
        assertThat(cells, is(Arrays.asList(
                new Cell(2, 0),
                new Cell(1, -1),
                new Cell(2, -1),
                new Cell(3, 0),
                new Cell(1, 1)
        )));
        
        gameOfLife.nextGeneration();
        
        assertThat(cells, is(Arrays.asList(
                new Cell(1, -1),
                new Cell(2, -1),
                new Cell(3, 0),
                new Cell(3, -1),
                new Cell(2, 1)
        )));
    }
}
