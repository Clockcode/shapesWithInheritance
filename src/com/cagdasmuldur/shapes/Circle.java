package com.cagdasmuldur.shapes;

public class Circle extends Shape{
	private double radius;
	
	public Circle(String name, double[] radius) {
		super(name, radius);
		this.radius = radius[0];
		// TODO Auto-generated constructor stub
	}
	public String toString() {
	    return "Shape: " + name +
	    		" radius: " + radius +
	    		" Perimeter: " + getPerimeter();
	  }
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getPerimeter() {
		return radius * 2 * Math.PI;
	}
}
