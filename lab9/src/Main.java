import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Phone[] phones = new Phone[] {
                new Phone("Звичайний телефон", 20),
                new Smartphone("Смартфон", 100, "Android"),
                new Landline("Стаціонарний телефон", 5, true),
                null
        };

        Comparator<Phone> nameComparator = Comparator.comparing(phone -> phone != null ? phone.getName() : "");
        Arrays.sort(phones, nameComparator);
        System.out.println("Сортування за назвою в порядку зростання:");
        for (Phone phone : phones) {
            if (phone != null) {
                outputInformation(phone);
            }
        }

        Comparator<Phone> nameComparatorReversed = nameComparator.reversed();
        Arrays.sort(phones, nameComparatorReversed);
        System.out.println("\nСортування за назвою у зворотньому порядку:");
        for (Phone phone : phones) {
            if (phone != null) {
                outputInformation(phone);
            }
        }

        Comparator<Phone> batteryAndNameComparator = Comparator
                .comparingInt((Phone phone) -> phone != null ? phone.getBatteryLife() : 0)
                .thenComparing((Phone phone) -> phone != null ? phone.getName() : "");
        Arrays.sort(phones, batteryAndNameComparator);
        System.out.println("\nСортування за тривалістю роботи батареї, а у разі співпадіння - за назвою:");
        for (Phone phone : phones) {
            if (phone != null) {
                outputInformation(phone);
            }
        }

        Comparator<Phone> batteryLifeComparatorWithNulls = Comparator
                .nullsLast(Comparator.comparingInt(Phone::getBatteryLife));
        Arrays.sort(phones, batteryLifeComparatorWithNulls);
        System.out.println("\nСортування з урахуванням null-посилань за тривалістю роботи батареї:");
        for (Phone phone : phones) {
            if (phone != null) {
                outputInformation(phone);
            }
        }

        TreeSet<Phone> phoneTreeSet = new TreeSet<>(nameComparator);
        for (Phone phone : phones) {
            if (phone != null) {
                phoneTreeSet.add(phone);
            }
        }
        System.out.println("\nТелефони у TreeSet, відсортовані за назвою:");
        for (Phone phone : phoneTreeSet) {
            outputInformation(phone);
        }
    }

    public static void outputInformation(Phone phone) {
        System.out.println(phone);
        if (phone != null) {
            phone.call();
        }
    }
}

class Phone {
    public String name;
    public Integer batteryLife;

    public Phone(String name, Integer batteryLife) {
        this.name = name;
        this.batteryLife = batteryLife;
    }

    public void call() {
        System.out.println("Дзвінок з тривалістю батареї " + batteryLife + " годин");
    }

    public String getName() {
        return name;
    }

    public Integer getBatteryLife() {
        return batteryLife;
    }

    @Override
    public String toString() {
        return "Телефон: " + name + ", тривалість роботи батареї: " + batteryLife + " годин";
    }
}

class Smartphone extends Phone {
    private String operatingSystem;

    public Smartphone(String name, Integer batteryLife, String operatingSystem) {
        super(name, batteryLife);
        this.operatingSystem = operatingSystem;
    }

    @Override
    public void call() {
        System.out.println(
                "Смартфон з ОС " + operatingSystem + " дзвонить з тривалістю батареї " + batteryLife + " годин");
    }

    @Override
    public String toString() {
        return "Смартфон: " + name + ", ОС: " + operatingSystem + ", тривалість роботи батареї: " + batteryLife
                + " годин";
    }
}

class Landline extends Phone {
    private boolean hasAnsweringMachine;

    public Landline(String name, Integer batteryLife, boolean hasAnsweringMachine) {
        super(name, batteryLife);
        this.hasAnsweringMachine = hasAnsweringMachine;
    }

    @Override
    public void call() {
        System.out.println("Стаціонарний телефон з автовідповідачем: " + (hasAnsweringMachine ? "так" : "ні")
                + ", тривалість роботи батареї: " + batteryLife + " годин");
    }

    @Override
    public String toString() {
        return "Стаціонарний телефон: " + name + ", автовідповідач: " + (hasAnsweringMachine ? "так" : "ні")
                + ", тривалість роботи батареї: " + batteryLife + " годин";
    }
}
