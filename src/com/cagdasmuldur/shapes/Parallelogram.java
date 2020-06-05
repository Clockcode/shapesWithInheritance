package com.cagdasmuldur.shapes;

public class Parallelogram extends Shape{
	private double base;
	private double height;
	private double side;
	public static class Builder {
		private String name;
		private double base;
		private double height;
		private double side;

		Builder(){};
		public double getBase() {
			return this.xDimension;
		}
		public void setBase(double base) {
			xDimension = base;
		}
		public void setSide(double side) {
			yDimension = side;
		}
		public double getSide() {
			return yDimension;
		}
		public void setHeight(double height) {
			zDimension = height;
		}
		public double getHeight() {
			return zDimension;
		}
		
	}
	public Parallelogram(String nameParam, double xParam, double yParam, double zParam) {
		super(nameParam, xParam, yParam, zParam);
		// TODO Auto-generated constructor stub
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

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 0;
	}

}
