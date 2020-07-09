package com.cagdasmuldur.shapes;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import com.cagdasmuldur.shapeAreaCalculator;

public class Rectangle implements Shape {
	protected double width;
	protected double height;
	// shapeAreaCalculator type object got assigned a lambda expression as its' method definition.
	protected shapeAreaCalculator getArea = () -> {
		return this.width * this.height;
	};
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
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.DOWN);
		return this.getClass().getSimpleName() + " { width: " + width + " height: " + height + " } Perimeter: "
				+ df.format(getPerimeter()) + " | Area:" + df.format(getArea.calculate());
	}

	// GETTERS AND SETTERS


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
