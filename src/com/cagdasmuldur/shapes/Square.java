package com.cagdasmuldur.shapes;

public class Square extends Shape{
	private double side;
	public static class Builder {
		private double side;

		Builder(){};
		public void setSide(double side) {
			xDimension = side;
		}
		public double getSide() {
			return xDimension;
		}
		
	}
	public Square(String nameParam, double xParam) {
		super(nameParam, xParam, 0, 0);
		// TODO Auto-generated constructor stub
	}
	@Override /** Return perimeter */
	  public double getPerimeter() {
	    return xDimension * 4;
	  }

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}
}
