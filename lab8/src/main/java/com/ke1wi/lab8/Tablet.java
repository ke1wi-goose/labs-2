package com.ke1wi.lab8;

import java.util.Comparator;

public class Tablet extends Device {

    public Tablet(String name) {
        super(name);
    }

    public Tablet(String name, int yearOfManufacture) {
        super(name, yearOfManufacture);
    }

    public Tablet(String name, int yearOfManufacture, int ram) {
        super(name, yearOfManufacture, ram);
    }

    public Tablet(String name, int yearOfManufacture, int ram, int memory) {
        super(name, yearOfManufacture, ram, memory);
    }

    public Tablet(String name, int yearOfManufacture, int ram, int memory, int price) {
        super(name, yearOfManufacture, ram, memory, price);
    }
}

class TabletNameComparator implements Comparator<Tablet> {
    public int compare(Tablet x, Tablet y) {
        return x.getName().compareTo(y.getName());
    }
}

class TabletPriceComparator implements Comparator<Tablet> {
    public int compare(Tablet x, Tablet y) {
        return x.getPrice() - y.getPrice();
    }
}