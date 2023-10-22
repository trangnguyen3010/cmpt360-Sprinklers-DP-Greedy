package main;

import java.util.List;

import static java.lang.Math.max;

public class SprinklerCalculator {
    public static int calculateMinimumSprinklers(final Garden garden) {
        garden.updateStartEndForSprinkler();
        garden.sortSprinklersByStartThenByReversedOrderOfRadius();
        List<Sprinkler> sprinklers = garden.getSprinklers();
        double lengthToCover = (int) garden.getGardenLength();
        int size = sprinklers.size();

        double[][] memoi = new double[size][size];

        if (isNotPossible(sprinklers)) {
            return 0;
        }

        // Fill the first row and column with the first sprinkler's end
        Sprinkler firstSprinkler = sprinklers.get(0);
        for (int i = 0; i < size; i++) {
            memoi[i][0] = firstSprinkler.getEnd();
            memoi[0][i] = firstSprinkler.getEnd();
        }

        double current = firstSprinkler.getEnd();
        if (current >= lengthToCover) {
            return 1;
        }

        for (int numSprinkler = 1; numSprinkler < size; numSprinkler++) {
            for (int sprinkler = 1; sprinkler < size; sprinkler++) {
                Sprinkler currentSprinkler = sprinklers.get(sprinkler);

                double above = memoi[sprinkler - 1][numSprinkler];
                double right = memoi[sprinkler][numSprinkler - 1];
                current = currentSprinkler.getStart() <= right && currentSprinkler.getEnd() >= right ? currentSprinkler.getEnd() : right;
                current = max(current, above);

                memoi[sprinkler][numSprinkler] = current;
                if (current >= lengthToCover) {
                    return numSprinkler + 1;
                }
            }
        }

        return 0;
    }

    private static boolean isNotPossible(final List<Sprinkler> sprinklers) {
        double end = 0;
        int i = 0;
        do {
            if (isNotContinuous(end, sprinklers.get(i).getStart())) {
                return true;
            }
            end = max(end, sprinklers.get(i).getEnd());
            i++;
        } while (i < sprinklers.size());
        return false;
    }

    public static boolean isNotContinuous(double lastEnd, double currentStart) {
        return currentStart > lastEnd;
    }
}
