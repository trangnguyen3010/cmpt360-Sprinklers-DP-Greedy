package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SprinklerProgram {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        // Write code to read the standard input
        // and print the output.
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        String[] firstLineArray = firstLine.split(" ");
        // verify firstLineArray length is 3
        System.out.println(firstLineArray.length);
        if (firstLineArray.length != 3) {
            System.out.println("Invalid input");
            return;
        }
        // verify the first two elements of firstLineArray are a decimal number
        // and the third element is a integer
        double L = Double.parseDouble(firstLineArray[0]);
        double M = Double.parseDouble(firstLineArray[1]);
        int N = Integer.parseInt(firstLineArray[2]);

        // verify L, M, N are bigger than 0
        if (L <= 0 || M <= 0 || N <= 0) {
            System.out.println("Invalid input");
            return;
        }

        // Read the next N lines, each line contains two decimal numbers
        // separated by a space
        List<double[]> sprinklerLocations = new ArrayList<>();
        for (int i = 0; i < N; i++){
            String line = scanner.nextLine();
            String[] lineArray = line.split(" ");
            // verify lineArray length is 2
            if (lineArray.length != 2) {
                System.out.println("Invalid input");
                return;
            }
            // verify the first two elements of lineArray are a decimal number
            double x = Double.parseDouble(lineArray[0]);
            double y = Double.parseDouble(lineArray[1]);

            // verify x, y are bigger than 0
            if (x < 0 || y < 0) {
                System.out.println("Invalid input");
                return;
            }
            double[] sprinklerLocation = new double[]{x, y};
            sprinklerLocations.add(sprinklerLocation);

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
}
