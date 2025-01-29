package com.gaurav.solidprinciples.dip;

/**
 * DIP : "Depend upon abstractions, not concretions."
 */
class DellBattery {
    void charge() {
        System.out.println("Dell Laptop is charging ...");
    }
}

public class LaptopWithoutDIP {
    DellBattery battery = new DellBattery(); // ❌ Tight coupling

    void chargeBattery() {
        battery.charge();
    }
}
