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
	
	//String array parser to double. 
	//Named it doubleArrayParser because of the naming convention in double class
	/** Gets String array and the side counter by the shapes' need.
	 Returns a double array containing the "valid" array of sides */
	/** Checks the each value and if its not valid ( <= 0 ) throws a custom exception*/
	public static double[] doubleArrayParser(String[] arrOfData, int sideCount) {
		double[] arrOfSides = new double[sideCount];
		try {
			for(int i=0; i < sideCount; i++) {
				arrOfSides[i] = Double.parseDouble(arrOfData[i]);
				if(arrOfSides[i] <= 0) {
					throw new InvalidValueException();
				}
			}			
		}catch(InvalidValueException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return arrOfSides;
	}
	//Checks the 
	public static boolean checkValues(String[] arrOfData, int sideCount) {
		boolean isCorrect = true;
		double[] arrOfSides = null;
		try {
			arrOfSides = doubleArrayParser(arrOfData, sideCount);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			isCorrect = false;
		}
		if(arrOfSides.length < sideCount) {
			isCorrect = false;
		}
		return isCorrect;
	}
	
	public static Shape setShape(String[] arrOfData) throws InvalidValueException {
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
		return shape;
	}
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
		        }catch(InvalidValueException e) {
		        	System.out.println(e.getMessage());
		        	i--;
		        }
		        i++;
		      }
		      myReader.close();
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		printShapes(shapes);
	}

//Your program must be capable of storing all the geometrical shapes 
//read from the file in one data structure. 
//Since arrays are the only data structure that we have covered so far,
//you must use just one array to contain all the shapes in this assignment. 
	public static void printShapes(Shape[] shapes) {
		try {
			for(int i=0;i<=shapes.length;i++) {
				System.out.println(shapes[i].toString());
			}			
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}catch(NullPointerException e) {
			System.out.println("END");
		}
	}
}



