package main;

import java.util.List;

public class SprinklerCalculator {
    public static int calculateMinimumSprinklers(final Garden garden) {
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

        int count = 1;
        double current = firstSprinkler.getEnd();
        if (current >= lengthToCover) {
            return count;
        }

        for (int numSprinkler = 1; numSprinkler < size; numSprinkler++) {
            for (int sprinkler = 1; sprinkler < size; sprinkler++) {
                Sprinkler currentSprinkler = sprinklers.get(sprinkler);
                current = currentSprinkler.getEnd();
                double above = memoi[sprinkler - 1][numSprinkler];
                if (current > above) {
                    memoi[sprinkler][numSprinkler] = current;
                    count++;
                }

                if (current >= lengthToCover) {
                    return count;
                }
                if (count == numSprinkler) {
                    break;
                }
            }
        }

        return 0;
    }

    private static boolean isNotPossible(final List<Sprinkler> sprinklers) {
        for (int i = 0; i < sprinklers.size() - 1; i++) {
            if (isNotContinuous(sprinklers.get(i).getEnd(), sprinklers.get(i + 1).getStart())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNotContinuous(double lastEnd, double currentStart) {
        return currentStart > lastEnd;
    }
}
