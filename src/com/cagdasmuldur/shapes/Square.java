package com.cagdasmuldur.shapes;

public class Square extends Shape{
	private double side;
	public Square(String name, double[] sides) {
		super(name, sides);
		this.side = sides[0];
		// TODO Auto-generated constructor stub
	}
	public String toString() {
	    return "Shape: " + name +
	    		" Side: " + side + 
	    		" Perimeter: " + getPerimeter();
	  }
	public double getSide() {
		return side;
	}
	public void setSide(double side) {
		this.side = side;
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double getPerimeter() {
		return side * 4;
	}

}
