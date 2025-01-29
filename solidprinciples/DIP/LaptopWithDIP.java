package com.gaurav.solidprinciples.dip;

/**
 * DIP : ""High-level modules should not depend on low-level modules. Both should depend on abstractions.""
 */

interface Battery {
    void charge();
}

/**
 * This class is following the DIP principle
 */
class DellBatteryWithDIP implements Battery {
    @Override
    public void charge() {
        System.out.println("Dell Laptop is charging ...");
    }
}

/**
 * This class is following the DIP principle
 */
class HPBattery implements Battery {
    @Override
    public void charge() {
        System.out.println("HP Laptop is charging ...");
    }
}

/**
 * This class is following the DIP principle
 */
public class LaptopWithDIP {

    Battery battery;

    public LaptopWithDIP(Battery battery) {
        this.battery = battery;
    }

    void chargeBattery() {
        battery.charge();
    }
}
