package com.thomas.gameoflife;

import static com.thomas.gameoflife.CellDestiny.*;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author thomas
 */
public class LivingCellDestinyEvaluator {
    
    private static final List<Integer> FAVORABLE_ENVIRONMENT = Arrays.asList(2, 3);

    private final NeighborCountProvider neighborCountProvider;

    public LivingCellDestinyEvaluator(NeighborCountProvider neighborCountProvider) {
        this.neighborCountProvider = neighborCountProvider;
    }

    public CellDestiny evaluateDestinyOf(Cell cell) {
        if (isEnviromentFavorableFor(cell)) {
            return LIVES_ON;
        }
        return DEATH;
    }
    
    private boolean isEnviromentFavorableFor(Cell cell) {
        final int numberOfNeightbors = neighborCountProvider.countLivingNeighbors(cell);
        return FAVORABLE_ENVIRONMENT.contains(numberOfNeightbors);
    }

}
