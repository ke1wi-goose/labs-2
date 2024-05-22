package com.ke1wi.lab8;

import java.util.Comparator;

public class Laptop extends Device {

    public Laptop(String name) {
        super(name);
    }

    public Laptop(String name, int yearOfManufacture) {
        super(name, yearOfManufacture);

    }

    public Laptop(String name, int yearOfManufacture, int ram) {
        super(name, yearOfManufacture, ram);
    }

    public Laptop(String name, int yearOfManufacture, int ram, int memory) {
        super(name, yearOfManufacture, ram, memory);
    }

    public Laptop(String name, int yearOfManufacture, int ram, int memory, int price) {
        super(name, yearOfManufacture, ram, memory, price);
    }
}

class LaptopNameComparator implements Comparator<Laptop> {
    public int compare(Laptop x, Laptop y) {
        return x.getName().compareTo(y.getName());
    }
}

class LaptopPriceComparator implements Comparator<Laptop> {
    public int compare(Laptop x, Laptop y) {
        return x.getPrice() - y.getPrice();
    }
}
