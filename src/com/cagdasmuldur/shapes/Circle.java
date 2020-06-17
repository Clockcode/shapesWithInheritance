package com.cagdasmuldur.shapes;

public class Circle implements Shape{
	private double radius;
	
	//CONSTRUCTOR
	public Circle(String name, double[] radius) {
		if (radius[0] <= 0) {
			throw new IllegalArgumentException("Input radius must be positive value: " + radius);
		}
		this.radius = radius[0];

	}
	
	//RETURNS A STRING OF EVERY FIELD AND ITS' VALUE
	public String toString() {
	    return "Shape: " + this.getClass().getSimpleName() +
	    		" radius: " + radius +
	    		" Perimeter: " + getPerimeter();
	}
	
	//GETTERS AND SETTERS
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		if (radius <= 0) {
			throw new IllegalArgumentException("Input radius must be positive value: " + radius);
		}
		this.radius = radius;
	}


	@Override
	public double getPerimeter() {
		return radius * 2 * Math.PI;
	}

	@Override
	public String getName() {
		return this.getClass().getSimpleName();
	}
}
