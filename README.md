# SOLID-Principles

The SOLID principles are five design principles that help in writing maintainable, scalable, and testable software. They are particularly useful in object-oriented programming.

# 🔥 SOLID Principles Overview
1.  S – Single Responsibility Principle (SRP)
2.  O – Open/Closed Principle (OCP)
3.  L – Liskov Substitution Principle (LSP)
4.  I – Interface Segregation Principle (ISP)
5.  D – Dependency Inversion Principle (DIP)

# 📌 1. Single Responsibility Principle (SRP)
"A class should have only one reason to change."

**✅ Example:** A class should focus on a single task. If it does multiple things, it's harder to maintain.

## ❌ Bad Example (Violating SRP)
A class that handles both user data and file saving:

``` java
class User {
    String name;
    String email;

    void saveToFile() {  // ❌ This method doesn't belong here
        System.out.println("Saving user data to file...");
    }
}

````
## ✅ Good Example (Following SRP)
We separate file handling into another class:
``` java
class User {
    String name;
    String email;
}

class UserRepository {
    void saveToFile(User user) {
        System.out.println("Saving user data to file...");
    }
}


```
👉 Now, User only handles user data, and UserRepository handles saving logic.

# 📌 2. Open/Closed Principle (OCP)
"A class should be open for extension but closed for modification."

✅ Example: If we want to add new functionality, we should extend instead of modifying existing code.

## ❌ Bad Example (Violating OCP)
Adding discount logic directly into the class:

``` java

class Invoice {
    double calculateDiscount(String type) {
        if (type.equals("NewCustomer")) {
            return 10; // 10% discount
        } else if (type.equals("LoyalCustomer")) {
            return 20; // 20% discount
        }
        return 0;
    }
}


```

❌ If we want to add a new discount type, we need to modify the Invoice class.

## ✅ Good Example (Following OCP)
Using polymorphism to extend functionality:

``` java

interface Discount {
    double getDiscount();
}

class NewCustomerDiscount implements Discount {
    public double getDiscount() {
        return 10; // 10% discount
    }
}

class LoyalCustomerDiscount implements Discount {
    public double getDiscount() {
        return 20; // 20% discount
    }
}

class Invoice {
    double calculateDiscount(Discount discount) {
        return discount.getDiscount();
    }
}


```

👉 Now, we can add new discount types without modifying existing code.

# 📌 3. Liskov Substitution Principle (LSP)
"Subclasses should be substitutable for their base classes without breaking the program."

✅ Example: If a function expects a parent class object, it should work with any child class object too.

## ❌ Bad Example (Violating LSP)
A Rectangle class is extended by Square, but Square changes behavior unexpectedly.

``` java

class Rectangle {
    int width, height;

    void setWidth(int width) {
        this.width = width;
    }

    void setHeight(int height) {
        this.height = height;
    }

    int getArea() {
        return width * height;
    }
}

class Square extends Rectangle {
    void setWidth(int width) {
        this.width = width;
        this.height = width; // ❌ Breaks expected behavior
    }

    void setHeight(int height) {
        this.width = height;
        this.height = height; // ❌ Breaks expected behavior
    }
}


````
❌ A Square should behave like a Rectangle, but it doesn’t.

## ✅ Good Example (Following LSP)
Instead of forcing Square to extend Rectangle, we separate the hierarchy:

``` java
interface Shape {
    int getArea();
}

class Rectangle implements Shape {
    int width, height;

    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

class Square implements Shape {
    int side;

    Square(int side) {
        this.side = side;
    }

    public int getArea() {
        return side * side;
    }
}


````
👉 Now, Rectangle and Square behave correctly and can be used interchangeably.

# 📌 4. Interface Segregation Principle (ISP)
"A class should not be forced to implement interfaces it does not use."

✅ Example: Instead of creating a large interface, split it into smaller, specific interfaces.

## ❌ Bad Example (Violating ISP)
A general interface forces all classes to implement unrelated methods.

``` java

interface Worker {
    void work();
    void eat();
}

class Developer implements Worker {
    public void work() {
        System.out.println("Writing code...");
    }

    public void eat() { // ❌ Not all workers need an eat method
        System.out.println("Eating lunch...");
    }
}

````
## ✅ Good Example (Following ISP)
We create separate interfaces for different behaviors.

``` java

interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class Developer implements Workable {
    public void work() {
        System.out.println("Writing code...");
    }
}


````
👉 Now, Developer only implements what it actually needs.

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

# 🎯 Conclusion
- ✅ SRP: Each class should have only one reason to change.
- ✅ OCP: Extend functionality via new classes, don’t modify existing ones.
- ✅ LSP: Subtypes must be replaceable without breaking the program.
- ✅ ISP: Create small, focused interfaces instead of one large interface.
- ✅ DIP: Depend on abstractions (interfaces), not concrete implementations.

