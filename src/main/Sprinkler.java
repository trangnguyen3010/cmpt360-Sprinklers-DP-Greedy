package main;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Sprinkler {
    private final double centre;
    private final double radius;
    private final double start;
    private final double end;

    public Sprinkler(final double x, final double y, final double gardenLength, final double gardenWidth) {
        this.centre = x;
        this.radius = y;
        double halfLength = Math.sqrt(Math.pow(radius, 2) - Math.pow(gardenWidth /2, 2));
        System.out.println(halfLength);
        this.start = max(0, centre - halfLength);
        this.end = min(gardenLength, centre + halfLength);
    }

    public double getCentre() {
        return centre;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Sprinkler{" +
                "centre=" + centre +
                ", radius=" + radius +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
