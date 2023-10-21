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
        double W;
        int N;
        L = getNextDouble(scanner);
        W = getNextDouble(scanner);
        N = getNextInt(scanner);
        scanner.nextLine();

        // Read the next N lines, each line contains two decimal numbers
        // separated by a space
        List<Sprinkler> sprinklerLocations = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            // verify the first two elements of lineArray are a decimal number
            double x = getNextDouble(scanner);
            double y = getNextDouble(scanner);

            sprinklerLocations.add(new Sprinkler(x, y, L, W));
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        }

        SprinkerCalculator calculator = new SprinkerCalculator(L, W, sprinklerLocations);
        // Print all the input lines
        System.out.println("Given input:");
        System.out.println(calculator);
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
