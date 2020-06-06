package com.cagdasmuldur.shapes;

public class Triangle extends Shape{
	private double xSide;
	private double ySide;
	private double zSide;
	public Triangle(String name, double[] sides) {
		super(name, sides);
		xSide=sides[0];
		ySide=sides[1];
		zSide=sides[2];
	}
	public String toString() {
	    return "Shape: " + name + 
	    		" SideX: " + xSide +
	    		" SideY: " + ySide +
	    		" SideZ: " + zSide +
	    		" Perimeter: " + getPerimeter();
	  }

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getPerimeter() {
		return xSide + ySide + zSide;
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

	public double getzSide() {
		return zSide;
	}

	public void setzSide(double zSide) {
		this.zSide = zSide;
	}

}
