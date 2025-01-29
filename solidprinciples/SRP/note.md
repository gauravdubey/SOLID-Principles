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

