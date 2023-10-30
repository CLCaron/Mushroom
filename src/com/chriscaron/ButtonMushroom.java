package com.chriscaron;

public class ButtonMushroom extends Mushroom {
    private static final int COLONIZING_MIN_DAYS = 12;
    private static final int COLONIZING_MAX_DAYS = 21;
    private static final int FRUITING_MIN_DAYS = 7;
    private static final int FRUITING_MAX_DAYS = 21;

    public ButtonMushroom() {
        super("Button Mushroom",
                "Button mushrooms, also called white mushrooms or white button mushrooms, are the most popular mushroom variety in the United States, making up 90% of the mushrooms consumed in the country." +
                        "They're also the least expensive, and have the mildest flavor. These mushrooms are the immature form of the edible fungus Agaricus bisporus." +
                        "The more mature stages of this mushroom's life are cremini mushrooms and portobello mushrooms.");

        generateColonizationDays(COLONIZING_MAX_DAYS, COLONIZING_MIN_DAYS);
        generateFruitingDays(FRUITING_MAX_DAYS, FRUITING_MIN_DAYS);
        calculateTotalGrowthDurationInDays();
    }

    @Override
    protected void germinate() {
        System.out.println("The " + getName() + " spores are germinating!");
    }

    @Override
    protected void colonize() {
        System.out.println("The " + getName() + " mycelium is colonizing!");
    }

    @Override
    protected void fruit() {
        System.out.println("The " + getName()
                + " is fruiting! You can harvest these while they are white button mushrooms, baby bella mushrooms, or wait until they are fully grown portobello mushrooms!");
    }

    @Override
    protected void sporulate() {
        System.out.println("The " + getName() + " has dropped its spores!");
    }

    @Override
    protected void ageGracefully() {
        System.out.println("The " + " " + getName() + " colony is aging gracefully");
    }

}