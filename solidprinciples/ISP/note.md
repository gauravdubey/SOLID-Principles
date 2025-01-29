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



