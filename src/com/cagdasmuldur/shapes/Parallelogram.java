package com.cagdasmuldur.shapes;

public class Parallelogram extends Shape{
	private double xSide;
	private double ySide;
	public Parallelogram(String name, double[] sides) {
		super(name, sides);
		xSide=sides[0];
		ySide=sides[1];
	}
	public String toString() {
	    return "Shape: " + name + " SideX: " + xSide + " SideY: " + ySide;
	  }

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getPerimeter() {
		return ( xSide + ySide ) * 2;
	}

	public double getxSide() {
		return xSide;
	}

	public void setxSide(double xSide) {
		this.xSide = xSide;
	}

	public double getySide() {
		return ySide;
	}

	public void setySide(double ySide) {
		this.ySide = ySide;
	}

}
