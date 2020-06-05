package com.cagdasmuldur.shapes;

public class Rectangle extends Shape{
	private double width;
	private double height;
	public static class Builder {
		private double height;
		private double width;

		Builder(){};
		public void setWidth(double width) {
			this.width = width;
		}
		public double getWidth() {
			return width;
		}
		public void setHeight(double height) {
			this.height = height;
		}
		public double getHeight() {
			return height;
		}
		
	}
	public Rectangle(String nameParam, double width, double height) {
		super(nameParam);
		// TODO Auto-generated constructor stub
	}
	
	@Override /** Return perimeter */
	  public double getPerimeter() {
	    return (xDimension + yDimension) * 2;
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
