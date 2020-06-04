package com.cagdasmuldur.shapes;

import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
public class Main {

	public static void main(String[] args) {
// If a line is not properly formatted or it does not contain the 
//necessary number of values to correctly describe a shape, your 
//program must ignore that line.
		try {
		      File myObj = new File("shapes.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] arrOfData = data.split(",");
		        
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
//If you cannot build the geometrical shapes with the given values
//(ex. zero or negative values for dimensions, wrong values for 
//three sides of a triangle, etc.), you should throw an exception.
//Therefore, there is a need to define some custom Exception classes
//for some of your classes.

//Your program must be capable of storing all the geometrical shapes 
//read from the file in one data structure. 
//Since arrays are the only data structure that we have covered so far,
//you must use just one array to contain all the shapes in this assignment. 


	}

}
