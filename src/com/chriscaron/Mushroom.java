package com.chriscaron;

import java.util.Random;

public abstract class Mushroom {
    private static final int GERMINATION_MIN_DAYS = 3;
    private static final int GERMINATION_MAX_DAYS = 7;

    private String name;
    private String description;
    private int age;
    private int germinationDurationInDays;
    private int colonizationDurationInDays;
    private int fruitingDurationInDays;
    private int totalGrowthDurationInDays;

    /**
     * Lifestages:
     * 0 = Spores Germinating, 3-7 days
     * 1 = Mycelium Colonizing
     * 2 = Mushroom Fruiting
     * 3 = Sporulating
     * 4 = Aging Gracefully - When all mushrooms are aging gracefully, the program
     * will terminate (for now.)
     **/
    private int lifeStage;

    public Mushroom(String name, String description) {
        this.name = name;
        this.description = description;

        this.germinationDurationInDays = generateGerminationDays();
    }

    protected abstract void germinate();

    protected abstract void colonize();

    protected abstract void fruit();

    protected abstract void sporulate();

    protected abstract void ageGracefully();

    public void simulateGrowth() {
        incrementAge();

        if (getAge() == getGerminationDurationInDays()) {
            setLifeStage(1);
        } else if (getAge() == getGerminationDurationInDays() + getColonizationDurationInDays()) {
            setLifeStage(2);
        } else if (getAge() == getGerminationDurationInDays() + getColonizationDurationInDays()
                + getFruitingDurationInDays()) {
            setLifeStage(3);
        } else if (getAge() > getGerminationDurationInDays() + getColonizationDurationInDays()
                + getFruitingDurationInDays()) {
            setLifeStage(4);
        }
    }

    protected void incrementAge() {
        age++;
        performLifestageActions();
    }

    protected void performLifestageActions() {
        switch (lifeStage) {
            case 0 -> germinate();
            case 1 -> colonize();
            case 2 -> fruit();
            case 3 -> sporulate();
            case 4 -> ageGracefully();
            default -> System.out.println(name + ": There is no action for age: " + age);
        }
    }

    protected int generateGerminationDays() {
        Random random = new Random();

        return random.nextInt(GERMINATION_MAX_DAYS - GERMINATION_MIN_DAYS + 1) + GERMINATION_MIN_DAYS;
    }

    public void generateColonizationDays(int colonizationMaxDays, int colonizationMinDays) {
        int colonizationDays = new Random().nextInt(colonizationMaxDays - colonizationMinDays + 1) + colonizationMinDays;
        setColonizationDurationInDays(colonizationDays);
    }

    public void generateFruitingDays(int fruitingMaxDays, int fruitingMinDays) {
        int fruitingDays = new Random().nextInt(fruitingMaxDays - fruitingMinDays + 1) + fruitingMinDays;
        setFruitingDurationInDays(fruitingDays);
    }

    public void calculateTotalGrowthDurationInDays() {
        int germinationDays = getGerminationDurationInDays();
        int colonizationDays = getColonizationDurationInDays();
        int fruitingDays = getFruitingDurationInDays();
        setTotalGrowthDurationInDays(germinationDays + colonizationDays + fruitingDays);
    }

    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGerminationDurationInDays() {
        return germinationDurationInDays;
    }

    public void setGerminationDurationInDays(int germinationDurationInDays) {
        this.germinationDurationInDays = germinationDurationInDays;
    }

    public int getColonizationDurationInDays() {
        return colonizationDurationInDays;
    }

    public void setColonizationDurationInDays(int colonizationDurationInDays) {
        this.colonizationDurationInDays = colonizationDurationInDays;
    }

    public int getFruitingDurationInDays() {
        return fruitingDurationInDays;
    }

    public void setFruitingDurationInDays(int fruitingDurationInDays) {
        this.fruitingDurationInDays = fruitingDurationInDays;
    }

    public int getTotalGrowthDurationInDays() {
        return totalGrowthDurationInDays;
    }

    public void setTotalGrowthDurationInDays(int totalGrowthDurationInDays) {
        this.totalGrowthDurationInDays = totalGrowthDurationInDays;
    }

    public int getLifeStage() {
        return lifeStage;
    }

    public void setLifeStage(int lifeStage) {
        this.lifeStage = lifeStage;
    }

}