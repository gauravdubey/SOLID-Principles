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

