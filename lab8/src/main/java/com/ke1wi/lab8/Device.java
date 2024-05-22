package com.ke1wi.lab8;

public class Device {

    private String name;
    private int yearOfManufacture;
    private int ram;
    private int memory;
    private int price;

    public Device(String name) {
        this.name = name;
    }

    public Device(String name, Integer yearOfManufacture) {
        this.name = name;
        this.yearOfManufacture = yearOfManufacture;

    }

    public Device(String name, int yearOfManufacture, int ram) {
        this.name = name;
        this.yearOfManufacture = yearOfManufacture;
        this.ram = ram;
    }

    public Device(String name, int yearOfManufacture, int ram, int memory) {
        this.name = name;
        this.yearOfManufacture = yearOfManufacture;
        this.ram = ram;
        this.memory = memory;
    }

    public Device(String name, int yearOfManufacture, int ram, int memory, int price) {
        this.name = name;
        this.yearOfManufacture = yearOfManufacture;
        this.ram = ram;
        this.memory = memory;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public int getYearOfManufacture() {
        return this.yearOfManufacture;
    }

    public int getRam() {
        return this.ram;
    }

    public int getMemory() {
        return this.memory;
    }

    public int getPrice() {
        return this.price;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String toString() {
        return String.format("Class %s(Name: %s, Year of manufacture: %s, RAM: %s GB, Memory: %s, Price: %s UAH)",
                this.getClass().getSimpleName(),
                this.getName(),
                this.getYearOfManufacture() != 0 ? this.getYearOfManufacture() : "Unknown",
                this.getRam() != 0 ? this.getRam() : "Unknown",
                this.getMemory() != 0 ? this.getMemory() : "Unknown",
                this.getPrice() != 0 ? this.getPrice() : "Unknown");
    }

    public boolean equals(Object obj) {
        return (this == obj);
    }
}