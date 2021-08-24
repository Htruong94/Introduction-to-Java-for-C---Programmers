/************************************
 * Workshop #1
 * Course: JAC444 - Semester 4
 * Last Name: Truong
 * First Name: Hung
 * ID: 147779193
 * Section: NEE
 * This assignment represents my own work in accordance with Seneca Academic Policy.
 * Signature
 * Date: 1/29/2021
 */

import java.util.Scanner;
import java.lang.Integer;


public class pivot {
	public static void main(String[] args) {
		int[] numList = getArray();
		int[] pivotList = new int [numList[0]]; //first number in numList indicating the number of elements in the list
		
		int pivotIndex = indexLocate(numList);
		int numBigger = pivotIndex + 1;
		int numSmaller = 0;
		pivotList[pivotIndex] = numList[1];
		
		for(int i = 2; i < numList.length; i++) { //starts after number elements and pivot number
			if(numList[i] <= numList[1]) { //if number is less than or equal to pivot number, place number on element before pivot
				pivotList[numSmaller++] = numList[i];
			}
			else { //if number is greater than pivot number, place number after the pivot element
				pivotList[numBigger++] = numList[i];
			}
		}
		
		System.out.print("After the partition, the list is: ");
		
		for(int i = 0; i < pivotList.length; i++) {
			System.out.print(pivotList[i] + " ");
		}
	}
	
	public static int[] getArray() { //returns an array of integer from user
		
		System.out.print("Enter list: ");
		
		int[] arr = {};

		String numString = getString();
		
		String[] numStringSplit = numString.split(" ");
		
		arr = new int[numStringSplit.length];
		
		for(int i = 0; i < numStringSplit.length; i++) {
			arr[i] = Integer.parseInt(numStringSplit[i]);
		}

		return arr;
	}
	
	public static String getString() {
		Scanner scan = new Scanner(System.in);
		String string = scan.nextLine();
		scan.close();
		return string;
	}
	
	public static int indexLocate(int[] numList) {
		int index = 0;
		
		for(int i = 2; i < numList.length; i++) {
			if(numList[1] > numList[i]) {
				index++;
			}
		}
		
		return index;
	}
	
}
