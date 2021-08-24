/************************************
 * Workshop #9
 * Course: JAC444 - Semester 4
 * Last Name: Truong
 * First Name: Hung
 * ID: 147779193
 * Section: NEE
 * This assignment represents my own work in accordance with Seneca Academic Policy.
 * Signature
 * Date: 04/03/2021
 */

package workshop9.task1;

public class TestClass {
	public static void main(String[] arg) {
		double[][] testA1 = {{1, 2, 3}, {4, 5, 6}};
		double[][] testB1 = {{7,8},{9,10},{11,12}};
		long start = 0;
		long end = 0;
		
		int squareSize = 2000;
		
		double[][] testA = MultiplyMatrix.randomMatrix(squareSize, squareSize);
		double[][] testB = MultiplyMatrix.randomMatrix(squareSize, squareSize);
		
		System.out.println("Workshop 9 Task 1");
		System.out.println("----------------------------------------------");
		System.out.println("Demonstrating a simple Matrices Multiplication");
		System.out.println("----------------------------------------------");
		double[][] testC1 = MultiplyMatrix.parallelMultiplyMatrix(testA1, testB1);
		System.out.println("Parallel");
		MultiplyMatrix.displayMatrix(testA1);
		System.out.println("\nmultiplies\n");
		MultiplyMatrix.displayMatrix(testB1);
		System.out.println("\nequals\n");
		MultiplyMatrix.displayMatrix(testC1);
		
		double[][] testC2 = MultiplyMatrix.sequentialMultiplyMatrix(testA1, testB1);
		System.out.println("\nSequetial");
		MultiplyMatrix.displayMatrix(testA1);
		System.out.println("\nmultiplies\n");
		MultiplyMatrix.displayMatrix(testB1);
		System.out.println("\nequals\n");
		MultiplyMatrix.displayMatrix(testC2);
		
		System.out.println("\n----------------------------------------------");
		System.out.println("Demonstrating Sequential Matrices Multiplication");
		System.out.println("----------------------------------------------\n");
		
		System.out.println("Time to multiple 2 2000 by 2000 matrices using sequential processes.");
		
		start = System.currentTimeMillis();
		double[][] testC = MultiplyMatrix.sequentialMultiplyMatrix(testA, testB);
		end = System.currentTimeMillis();
		
		System.out.println("\nProcess done.\nThe time it took to multiple 2 2000 by 2000 matrices "
				+ "using sequential process is: " + (end - start) + "ms");
		
		System.out.println("\n----------------------------------------------");
		System.out.println("Demonstrating Parallel Matrix Multiplication using Threads");
		System.out.println("----------------------------------------------");
		
		start = System.currentTimeMillis();
		double[][] testD = MultiplyMatrix.parallelMultiplyMatrix(testA, testB);
		end = System.currentTimeMillis();
		
		System.out.println("\nProcess done.\nThe time it took to multiple 2 2000 by 2000 matrices "
				+ "using sequential process is: " + (end - start) + "ms\n");
		
		System.out.println("End of Workshop 9 Task 1 Demonstration");
	}
}
