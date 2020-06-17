package com.cagdasmuldur.shapes;

public class Rectangle implements Shape {
	protected double width;
	protected double height;

	// CONSTRUCTOR
	public Rectangle(String name, double[] sides) {
		if (sides[0] <= 0) {
			throw new IllegalArgumentException("Input width must be positive value: " + width);
		}
		width = sides[0];
		try{
			if (sides[1] <= 0) {
				throw new IllegalArgumentException("Input height must be positive value: " + height);
			}
			height = sides[1];
		}catch(ArrayIndexOutOfBoundsException e){
			// e.printStackTrace();
		}
	}

	// RETURNS A STRING OF EVERY FIELD AND ITS' VALUE
	public String toString() {
		return "Shape: " + this.getClass().getSimpleName() + " width: " + width + " height: " + height + " Perimeter: "
				+ getPerimeter();
	}

	// GETTERS AND SETTERS
	public double getArea() {
		return 0;
	}

	public double getPerimeter() {
		return (width + height) * 2;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		if (width <= 0) {
			throw new IllegalArgumentException("Input width must be positive value: " + width);
		}
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		if (height <= 0) {
			throw new IllegalArgumentException("Input height must be positive value: " + height);
		}
		this.height = height;
	}

	public String getName() {
		return this.getClass().getSimpleName();
	}

}
