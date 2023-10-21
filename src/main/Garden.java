package main;

import java.util.List;
import java.util.stream.Collectors;

public class Garden {
    private final double gardenLength;
    private final double gardenWidth;
    private List<Sprinkler> sprinklers;

    public Garden(final double gardenLength, final double gardenWidth, final List<Sprinkler> sprinklers) {
        this.gardenLength = gardenLength;
        this.gardenWidth = gardenWidth;
        this.sprinklers = sprinklers;
    }

    public List<Sprinkler> getSprinklers() {
        return sprinklers;
    }

    public void updateStartEndForSprinkler() {
        this.sprinklers.forEach(sprinkler -> sprinkler.updateStartEnd(this.gardenLength, this.gardenWidth));
    }

    public void sortSprinklersByStartThenByReversedOrderOfRadius() {
        this.sprinklers = sprinklers.stream()
                .sorted(Sprinkler::compareTo)
                .collect(Collectors.toList());
    }

    public double getGardenLength() {
        return gardenLength;
    }

    @Override
    public String toString() {
        return "SprinkerCalculator{" + "\n" +
                "gardenLength=" + gardenLength + ",\n" +
                "gardenWidth=" + gardenWidth + ",\n" +
                "sprinklers=[" + "\n" +
                sprinklers.stream().map(Sprinkler::toString).collect(Collectors.joining("\n")) + "\n" +
                ']' + "\n" +
                '}';
    }
}
