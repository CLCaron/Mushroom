package com.chriscaron;

public class OysterMushroom extends Mushroom {
    private static final int COLONIZING_MIN_DAYS = 7;
    private static final int COLONIZING_MAX_DAYS = 21;
    private static final int FRUITING_MIN_DAYS = 4;
    private static final int FRUITING_MAX_DAYS = 12;

    // There are many different oyster mushrooms: Pink oyster, blue oyster, king
    // oyster to name a few.. These could easily become their own derived classes
    // later on
    private String oysterType;

    public OysterMushroom() {
        super("Oyster Mushroom",
                "Oyster mushrooms are beloved around the world over for their delicate texture and mild, savory flavor." +
                        "The mushrooms typically have broad, thin, oyster- or fan-shaped caps and are white, gray, or tan, with gills lining the underside. " +
                        "The caps are sometimes frilly-edged and can be found in clusters of small mushrooms or individually as larger mushrooms.");

        generateColonizationDays(COLONIZING_MAX_DAYS, COLONIZING_MIN_DAYS);
        generateFruitingDays(FRUITING_MAX_DAYS, FRUITING_MIN_DAYS);
        calculateTotalGrowthDurationInDays();
    }

    // Overloaded constructor
    public OysterMushroom(String oysterType) {
        this();
        this.oysterType = oysterType;
    }

    public String getOysterType() {
        return oysterType;
    }

    public void setOysterType(String oysterType) {
        this.oysterType = oysterType;
    }

    @Override
    protected void germinate() {
        System.out.println("The " + getOysterType() + " " + getName() + " spores are germinating!");
    }

    @Override
    protected void colonize() {
        System.out.println("The " + getOysterType() + " " + getName() + " mycelium is colonizing!");
    }

    @Override
    protected void fruit() {
        System.out.println(getOysterType() + " " + getName()
                + " is fruiting! If you harvest this right before its spores drop, it will be delicious when cooked!");
    }

    @Override
    protected void sporulate() {
        System.out.println(getOysterType() + " " + getName() + " has dropped its spores!");
    }

    @Override
    protected void ageGracefully() {
        System.out.println("The " + getOysterType() + " " + getName() + " colony is aging gracefully");
    }

}