package com.cagdasmuldur.shapes;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
public class Main {
	//Filename variable for safer and easier reading
	private static final String fileName = "shapes.txt";

	/** Main method reads the file catches FileNotFoundException
	 *  splits each line until hasNextLine returns null 
	 *  Catches a custom exception if any of the values
	 *  on any line is not correct. Then decrements the
	 *  counter by one to overwrite garbage value
	 *  At last calls the printShapes method to print all shapes*/
	public static void main(String[] args) {

		Shape[] shapes = new Shape[43];
		int i = 0;
		try {
		      File myObj = new File(fileName);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] arrOfData = data.split(",");
		        try {
		        	shapes[i] = setShape(arrOfData);
		        	i++;
		        }catch(InvalidValueException|InvalidShapeException e) {
		        	System.out.println(e.getMessage());
		        	i--;
		        }
		        
		      }
		      myReader.close();
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~Array Of Shapes~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		printShapes(shapes);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~Array Of Shapes Without The Least Perimetered Triangle~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		printShapes(deleteMinTrianglePerimeter(shapes));
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
	/** Gets String array and the side counter by the shapes' need.
	 * 	Returns a double array containing the "valid" array of sides 
	 * 	Checks the each value and if its not valid ( <= 0 ) throws a custom exception
	 * 	Named it doubleArrayParser because of the naming convention in double class */
	public static double[] doubleArrayParser(String[] arrOfData, int sideCount) {
		double[] arrOfSides = new double[sideCount];
		try {
			for(int i=0; i < sideCount; i++) {
				if(Double.parseDouble(arrOfData[i]) <= 0) {
					throw new InvalidValueException();
				}else {
					arrOfSides[i] = Double.parseDouble(arrOfData[i]);					
				}
			}			
		}catch(InvalidValueException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return arrOfSides;
	}
	/** Checks the validity of all sides if there is a 
	 * 	valid value for each side returns true otherwise false */
	public static boolean checkValues(String[] arrOfData, int sideCount) {
		boolean isCorrect = false;
		double[] arrOfSides = new double[sideCount];
		try {
			arrOfSides = doubleArrayParser(arrOfData, sideCount);
			for(double side : arrOfSides) {
				if(side > 0) {
					isCorrect = true;
				}
			}
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		return isCorrect;
	}
	/** Calls appropriate constructor by the first index of the array.
	 * 	Returns a Shape object if there is no match for the shape name
	 *  throws a custom exception 
	 * @throws InvalidShapeException */
	public static Shape setShape(String[] arrOfData) throws InvalidValueException, InvalidShapeException {
		Shape shape = null;
		String[] arrOfSides = Arrays.copyOfRange(arrOfData, 1, arrOfData.length);
		switch(arrOfData[0]) {
		case "Circle":
			if(checkValues(arrOfSides, 1)) {
				double[] radius = doubleArrayParser(arrOfSides, 1);
				shape = new Circle(arrOfData[0], radius);			
			}
			break;
		case "Rectangle":
			if(checkValues(arrOfSides, 2)) {
				double[] sides = doubleArrayParser(arrOfSides, 2);
				shape = new Rectangle(arrOfData[0], sides);			
			}
			break;
		case "Square":
			if(checkValues(arrOfSides, 1)) {
				double[] sides = doubleArrayParser(arrOfSides, 1);
				shape = new Square(arrOfData[0], sides);			
			}
			break;
		case "Triangle":
			if(checkValues(arrOfSides, 3)) {
				double[] sides = doubleArrayParser(arrOfSides, 3);
				shape = new Triangle(arrOfData[0], sides);			
			}
			break;
		case "Parallelogram":
			if(checkValues(arrOfSides, 2)) {
				double[] sides = doubleArrayParser(arrOfSides, 2);
				shape = new Parallelogram(arrOfData[0], sides);			
			}
			break;
		default:
			throw new InvalidValueException("Wrong Shape name!!");
		}
		if(shape == null) {
			throw new InvalidShapeException();
		}
		return shape;
	}

	/** Calls toString function for every Shape element inside the array 
	 *  catches the ArrayIndexOutOfBoundsException and NullPointerException. */
	public static void printShapes(Shape[] shapes) {
		int i= 0;
		try {
			for(i=0;i<=shapes.length;i++) {
				System.out.println(shapes[i].toString());
			}			
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}catch(NullPointerException e) {
			System.out.println("Total Shapes: " + i);
		}
	}
	
	public static Shape[] deleteMinTrianglePerimeter(Shape[] arrOfShapes) {
			double leastPerimeter = 100; 
			int leastPerimeterIndex = 0;
			int i = 0;
			try {
				for(i = 0; i < arrOfShapes.length; i++) {
					if(arrOfShapes[i].getName().equals("Triangle")) {
						if(arrOfShapes[i].getPerimeter() < leastPerimeter) {
							leastPerimeter = arrOfShapes[i].getPerimeter();	
							leastPerimeterIndex = i;
						}
//						else if(arrOfShapes[i].getPerimeter() == leastPerimeter) {
//							System.out.println("There is another min Perimeter");
//							deleteMinTrianglePerimeter(arrOfShapes);
//						}
					}
				}				
			}catch(NullPointerException|ArrayIndexOutOfBoundsException e) {

			}
			return deleteIndexAndPushArray(arrOfShapes, leastPerimeterIndex, i);
		
	}	
	//Works fine
	public static Shape[] deleteIndexAndPushArray(Shape[] arrOfShapes, int leastPerimeterIndex, int lengthOfArr) {
		Shape[] newArrOfShapes = new Shape[lengthOfArr];
//		int i = 0;
		try {
			for(int i = 0; i < newArrOfShapes.length; i++) {
				if(i < leastPerimeterIndex) {
					newArrOfShapes[i] = arrOfShapes[i];					
				}else {
					newArrOfShapes[i] = arrOfShapes[i+1];					
				}
			}			
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		return newArrOfShapes;
	}
}



