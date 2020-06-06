package com.cagdasmuldur.shapes;

public class Rectangle extends Shape{
	private double width; 
	private double height; 
	public Rectangle(String name, double[] sides) {
		super(name, sides);
		width = sides[0];
		height = sides[1];
		// TODO Auto-generated constructor stub
	}

	public String toString() {
	    return "Shape: " + name +
	    		" width: " + width + 
	    		" height: " + height +
	    		" Perimeter: " + getPerimeter();
	  }

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getPerimeter() {
		return ( width + height ) * 2;
	}



	public double getWidth() {
		return width;
	}



	public void setWidth(double width) {
		this.width = width;
	}



	public double getHeight() {
		return height;
	}



	public void setHeight(double height) {
		this.height = height;
	}}
