package main;

import java.util.List;
import java.util.stream.Collectors;

public class Garden {
    private final double gardenLength;
    private final double gardenWidth;
    private final List<Sprinkler> sprinklers;

    public Garden(final double gardenLength, final double gardenWidth, final List<Sprinkler> sprinklers) {
        this.gardenLength = gardenLength;
        this.gardenWidth = gardenWidth;
        this.sprinklers = sprinklers.stream()
                .sorted(Sprinkler::compareTo)
                .collect(Collectors.toList());
        updateStartEndForSprinkler();
    }

    private void updateStartEndForSprinkler(){
        this.sprinklers.forEach(sprinkler -> sprinkler.updateStartEnd(this.gardenLength, this.gardenWidth));
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
