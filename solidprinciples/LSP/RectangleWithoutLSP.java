package com.gaurav.solidprinciples.lsp;

/**
 * This class is not following the LSP principle
 */
public class RectangleWithoutLSP {
    double width;
    double height;

    void setWidth(int width){
        this.width = width;
    }

    void setHeight(int height){
        this.height = height;
    }
    public double getArea(){
        return width * height;
    }
}

/**
 * This class is following the LSP principle
 */
class Square extends RectangleWithoutLSP{

    void setWidth(int width){
        this.width = width;
        this.height = width; // Breaks expected behavior
    }

    void setHeight(int height){
        this.width = height; // Breaks expected behavior
        this.height = height;
    }
}
