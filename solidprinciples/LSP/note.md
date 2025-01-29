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


