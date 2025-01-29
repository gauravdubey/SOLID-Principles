# 📌 5. Dependency Inversion Principle (DIP)
"High-level modules should not depend on low-level modules. Both should depend on abstractions."

✅ Example: Instead of directly using a class, depend on an interface.

## ❌ Bad Example (Violating DIP)
The Laptop class depends on a specific DellBattery implementation.

``` java
class DellBattery {
    void charge() {
        System.out.println("Charging Dell battery...");
    }
}

class Laptop {
    DellBattery battery = new DellBattery(); // ❌ Tight coupling

    void chargeLaptop() {
        battery.charge();
    }
}

````

## ✅ Good Example (Following DIP)
Using an interface, so we can swap batteries easily.

``` java
interface Battery {
    void charge();
}

class DellBattery implements Battery {
    public void charge() {
        System.out.println("Charging Dell battery...");
    }
}

class HPBattery implements Battery {
    public void charge() {
        System.out.println("Charging HP battery...");
    }
}

class Laptop {
    Battery battery; // Dependency Injection

    Laptop(Battery battery) {
        this.battery = battery;
    }

    void chargeLaptop() {
        battery.charge();
    }
}

````
👉 Now, we can switch from DellBattery to HPBattery without modifying Laptop.

