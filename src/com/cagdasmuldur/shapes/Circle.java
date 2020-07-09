package com.cagdasmuldur.shapes;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import com.cagdasmuldur.shapeAreaCalculator;

public class Circle implements Shape {
	private double radius;
	// shapeAreaCalculator type object got assigned a lambda expression as its' method definition.
	private final shapeAreaCalculator getArea = () -> {
		return Math.pow(radius, 2) * Math.PI;
	};

	// CONSTRUCTOR
	public Circle(final String name, final double[] radius) {
		if (radius[0] <= 0) {
			throw new IllegalArgumentException("Input radius must be positive value: " + radius);
		}
		this.radius = radius[0];

	}

	// RETURNS A STRING OF EVERY FIELD AND ITS' VALUE
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.DOWN);
		return this.getClass().getSimpleName() + " { radius: " + radius + " } Perimeter: " + df.format(getPerimeter())
				+ " Area:" + df.format(getArea.calculate());
	}

	// GETTERS AND SETTERS
	public double getRadius() {
		return radius;
	}

	public void setRadius(final double radius) {
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
