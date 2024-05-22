package com.ke1wi.lab8;

import java.util.Comparator;

public class Pc extends Device {

    private String whose;

    public Pc(String name) {
        super(name);
    }

    public Pc(String name, int yearOfManufacture) {
        super(name, yearOfManufacture);

    }

    public Pc(String name, int yearOfManufacture, int ram) {
        super(name, yearOfManufacture, ram);
    }

    public Pc(String name, int yearOfManufacture, int ram, int memory) {
        super(name, yearOfManufacture, ram, memory);
    }

    public Pc(String name, int yearOfManufacture, int ram, int memory, int price) {
        super(name, yearOfManufacture, ram, memory, price);
    }

    public Pc(String name, int yearOfManufacture, int ram, int memory, int price, String whose) {
        super(name, yearOfManufacture, ram, memory, price);
        this.whose = whose;
    }

    public String getWhose() {
        return this.whose;
    }

    public void setWhose(String whose) {
        this.whose = whose;
    }

    @Override
    public String toString() {
        return String.format(
                "Class %s(Name: %s, Year of manufacture: %s, RAM: %s GB, Memory: %s, Price: %s UAH, Whose: %s)",
                this.getClass().getSimpleName(),
                this.getName(),
                this.getYearOfManufacture() != 0 ? this.getYearOfManufacture() : "Unknown",
                this.getRam() != 0 ? this.getRam() : "Unknown",
                this.getMemory() != 0 ? this.getMemory() : "Unknown",
                this.getPrice() != 0 ? this.getPrice() : "Unknown",
                this.getWhose() != null ? this.getWhose() : "Unknown");
    }

}

class PcNameComparator implements Comparator<Pc> {
    public int compare(Pc x, Pc y) {
        return x.getName().compareTo(y.getName());
    }
}

class PcPriceComparator implements Comparator<Pc> {
    public int compare(Pc x, Pc y) {
        return x.getPrice() - y.getPrice();
    }
}