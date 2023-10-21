package main;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Sprinkler implements Comparable<Sprinkler>{
    private final double centre;
    private final double radius;
    private double start;
    private double end;

    public Sprinkler(final double centre, final double radius) {
        this.centre = centre;
        this.radius = radius;
    }

    public void updateStartEnd(final double gardenLength, final double gardenWidth){
        double halfLength = Math.sqrt(Math.pow(this.radius, 2) - Math.pow(gardenWidth/2, 2));
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

    @Override
    public int compareTo(final Sprinkler o) {
        if (this.centre < o.centre) {
            return -1;
        } else if (this.centre > o.centre) {
            return 1;
        } else {
            return (-1) * Double.compare(this.radius, o.radius);
        }
    }
}
