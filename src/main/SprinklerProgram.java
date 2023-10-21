package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SprinklerProgram {
    public static void main(String[] args) {
        // Write code to read the standard input
        // and print the output.
        Scanner scanner = new Scanner(System.in);
        double L;
        double M;
        int N;
        L = getNextDouble(scanner);
        M = getNextDouble(scanner);
        N = getNextInt(scanner);
        scanner.nextLine();

        // Read the next N lines, each line contains two decimal numbers
        // separated by a space
        List<double[]> sprinklerLocations = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            // verify the first two elements of lineArray are a decimal number
            double x = getNextDouble(scanner);
            double y = getNextDouble(scanner);

            double[] sprinklerLocation = new double[] {x, y};
            sprinklerLocations.add(sprinklerLocation);
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        }

        // Print all the input lines
        System.out.println("Given input:");
        System.out.println("L:" + L);
        System.out.println("M:" + M);
        System.out.println("N:" + N);
        System.out.println("Sprinkler locations:");
        // print all the sprinkler locations
        for (double[] sprinklerLocation : sprinklerLocations) {
            System.out.println(sprinklerLocation[0] + "," + sprinklerLocation[1]);
        }
    }

    private static int getNextInt(final Scanner scanner) {
        if (scanner.hasNextInt()) {
            int number =  scanner.nextInt();
            verifyBiggerThanZero(number);
            return number;
        } else {
            throw new IllegalArgumentException("Expected a integer! But got: " + scanner.next() + "!");
        }
    }

    private static double getNextDouble(final Scanner scanner) {
        if (scanner.hasNextDouble()) {
            double number =  scanner.nextDouble();
            verifyBiggerThanZero(number);
            return number;
        } else {
            throw new IllegalArgumentException("Expected a number! But got: " + scanner.next() + "!");
        }
    }

    private static void verifyBiggerThanZero(final double number) {
        if (number < 0) {
            throw new IllegalArgumentException("Expected a number bigger than 0! But got: " + number + "!");
        }
    }
}
