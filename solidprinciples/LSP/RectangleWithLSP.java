package com.gaurav.solidprinciples.lsp;

// LSP : "Subclasses should be substitutable for their base classes without breaking the program."
interface Shape {
    int getArea();
}

/**
 * This class is following the LSP principle
 */
public class RectangleWithLSP implements Shape {

    int width, height;

    RectangleWithLSP(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getArea() {
        return width * height;
    }
}

/**
 * This class is following the LSP principle
 */
class SquareWithLSP implements Shape {
    int side;

    SquareWithLSP(int side) {
        this.side = side;
    }

    @Override
    public int getArea() {
        return side * side;
    }
}