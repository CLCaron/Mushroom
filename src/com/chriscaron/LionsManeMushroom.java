package com.chriscaron;

public class LionsManeMushroom extends Mushroom {
    private static final int COLONIZING_MIN_DAYS = 14;
    private static final int COLONIZING_MAX_DAYS = 21;
    private static final int FRUITING_MIN_DAYS = 5;
    private static final int FRUITING_MAX_DAYS = 10;

    private String medicinalProperties;

    public LionsManeMushroom() {
        super("Lion's Mane Mushroom",
                "Large, white, shaggy mushrooms that resemble a lion's mane as they grow." +
                        "They contain bioactive substances that have many beneficial effects on the body, especially the brain, heart, and gut." +
                        "They are delicious when cooked.");

        generateColonizationDays(COLONIZING_MAX_DAYS, COLONIZING_MIN_DAYS);
        generateFruitingDays(FRUITING_MAX_DAYS, FRUITING_MIN_DAYS);
        calculateTotalGrowthDurationInDays();

        this.medicinalProperties = "may improve nerve development and function";
    }

    public String getMedicinalProperties() {
        return medicinalProperties;
    }

    public void setMedicinalProperties(String medicinalProperties) {
        this.medicinalProperties = medicinalProperties;
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
                + " is fruiting! Harvest this before it starts to turn yellow and it will be delicious! Lion's mane may also have medicinal properties, such as: "
                + getMedicinalProperties());
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