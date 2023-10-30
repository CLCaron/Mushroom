package com.chriscaron;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Mushroom> mushrooms = new ArrayList<>();
        populateMushrooms(mushrooms, scanner);

        System.out.println("Press enter to start the growth process!");
        scanner.nextLine();

        startMushroomGrowth(mushrooms);

        scanner.close();
    }

    private static void populateMushrooms(List<Mushroom> mushrooms, Scanner scanner) {
        System.out
                .println("Welcome to your mushroom growing simulator! Select from the mushrooms below to watch them 'grow'!");
        System.out.println();
        System.out.println("Available mushrooms:");
        System.out.println("1. Lion's Mane Mushroom");
        System.out.println("2. Oyster Mushroom");
        System.out.println("3. Button Mushroom");
        System.out
                .println("Enter the numbers of the mushrooms you want to grow (one at a time, followed by pressing enter).");
        System.out.println("Enter '0' when you are finished selecting mushrooms.");

        boolean finishedSelection = false;

        while (!finishedSelection) {
            try {
                System.out.println("Enter mushroom selection: ");
                int selection = scanner.nextInt();
                scanner.nextLine();

                switch (selection) {
                    case 1 -> {
                        mushrooms.add(new LionsManeMushroom());
                        System.out.println("Great choice! " + mushrooms.get(mushrooms.size() - 1).getDescription());
                    }
                    case 2 -> {
                        System.out.println("Available options for Oyster Mushroom:");
                        System.out.println("1. Blue Oyster Mushroom");
                        System.out.println("2. Pink Oyster Mushroom");
                        System.out.println("3. King Oyster Mushroom");
                        System.out.println("4. Pearl Oyster Mushroom");
                        System.out.println("Enter the number of the type of oyster mushroom to grow.");
                        int oysterOption = scanner.nextInt();
                        scanner.nextLine();
                        switch (oysterOption) {
                            case 1 -> mushrooms.add(new OysterMushroom("Blue"));
                            case 2 -> mushrooms.add(new OysterMushroom("Pink"));
                            case 3 -> mushrooms.add(new OysterMushroom("King"));
                            case 4 -> mushrooms.add(new OysterMushroom("Pearl"));
                            default -> System.out.println("Invalid oyster mushroom type selected. Please try again.");
                        }
                        System.out.println("Great choice! " + mushrooms.get(mushrooms.size() - 1).getDescription());
                    }
                    case 3 -> {
                        mushrooms.add(new ButtonMushroom());
                        System.out.println("Great choice! " + mushrooms.get(mushrooms.size() - 1).getDescription());
                    }
                    case 0 -> finishedSelection = true;
                    default -> {
                        System.out.println("Invalid selection. Please try again.");
                        System.out.println();
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid selection.");
                scanner.nextLine();
            }
        }
    }

    private static void startMushroomGrowth(List<Mushroom> mushrooms) {
        int currentDay = 1;
        System.out.println("Starting the growth process for all mushrooms...");

        int totalDays = determineMaxGrowthDuration(mushrooms);

        while (!allMushroomsFullyGrown(mushrooms, totalDays)) {
            System.out.println("Day " + currentDay++ + ": Mushrooms are growing...");

            for (Mushroom mushroom : mushrooms) {
                mushroom.simulateGrowth();
            }

            // This simulates a "day" by pausing the program for 1 second. this will need to be more elegant as the project grows
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All mushrooms have completed their growth!");
    }

    private static int determineMaxGrowthDuration(List<Mushroom> mushrooms) {
        int maxGrowthDuration = 0;

        for (Mushroom mushroom : mushrooms) {
            int growthDuration = mushroom.getTotalGrowthDurationInDays();
            if (growthDuration > maxGrowthDuration) {
                maxGrowthDuration = growthDuration;
            }
        }

        return maxGrowthDuration;
    }

    private static boolean allMushroomsFullyGrown(List<Mushroom> mushrooms, int totalDays) {
        for (Mushroom mushroom : mushrooms) {
            if (mushroom.getAge() < totalDays) {
                return false;
            }
        }

        return true;
    }
}
