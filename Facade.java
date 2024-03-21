package ru.unlimit.javapro.patterns;

public class Facade {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.useComputer();
    }

    public void useComputer() {
        Computer computer = new Computer();
        computer.copy();
    }
}
class Computer {
    Power power = new Power();
    DVDRom dvd = new DVDRom();
    HDD hdd = new HDD();

    void copy() {
        if (!power.isOn()) {
            power.on();
        }
        dvd.load();
        hdd.copyFromDVD(dvd);
        if (power.isOn()) {
            power.off();
        }
    }
}
class Power {
    private boolean isOn = false;
    boolean isOn() {
        return isOn;
    }

    void on() {
        if (!isOn) {
            System.out.println("Включение питания");
            isOn = true;
        }
    }

    void off() {
        if (isOn) {
            System.out.println("Выключение питания");
            isOn = false;
        }
    }
}

class DVDRom {
    private boolean data = false;

    public boolean hasData() {
        return data;
    }

    void load() {
        data = true;
    }

    void unload() {
        System.out.println("Вставьте диск с данными");
    }
}

class HDD {
    void copyFromDVD(DVDRom dvd) {
        if (dvd.hasData()) {
            System.out.println("Происходит копирование данных с диска");
        } else {
            dvd.load();
            System.out.println("Вставьте диск с данными");
        }
    }
}


