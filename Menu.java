// Matt Gaetz
import java.util.Scanner;
import java.io.IOException;
import java.lang.NumberFormatException;

public class Menu {;
	BST bst = new BST();
	public static void main(String[] args) {
		
System.out.println("Hello, Welcome to our Idea Database!");
	while (input != "E" || input !=  "e"){	// while loop
		try {		
		Scanner in = new Scanner(System.in);
		System.out.println("Choose from one of the following options to proceed:");
		System.out.println();
		System.out.println("(A) Create a new student record");
		System.out.println("(B) Search for existing Student record");
		System.out.println("(C) Print out list every student's name with their student #, SSN and avg score");
		System.out.println("(D) Add new Idea using SSN search");
		System.out.println("(E) Exit the program");
		System.out.println();
		System.out.println("What would you like to do? (Ex:'A'): "); // user prompt
		String input = in.next();
		if (input == "A" || input == "a") {	
			bst.createStudentNode()
			while (input5 != "B" || input5 != "b"){
				try{
					System.out.println("Would you like to enter an Idea? (Ex. A) ");
					System.out.println("(A) Yes");
					System.out.println("(B) No");
					String input5 = in.next();
					if (input5 == "A" || input5 ==  "a"){
						try{
							System.out.println("Enter 9-digit SSN: ");
							String input6 = in.next();
							int input2 = Integer.parseInt(input6)
							if (input2 > 99999999 && input2 < 1000000000){
								bst.addIdeaStudent(input2); }}
						catch(NumberFormatException e){
							System.out.println();
							System.out.println(e + "is an invalid SSN, please try again");}}}
				catch(IOException e) {
					System.out.println("Input Error: " + e);
					System.out.println("That was not a valid entry, please try again.");
					System.out.println();}}
		}	
		else if (input == "B" || input == "b") {	
			try {
			Scanner in = new Scanner(System.in);
			System.out.println();
			System.out.println("(A) Search using SSN");
			System.out.println("(B) Search using Student Number");
			System.out.println("Which would you like to do (Ex:'A': ");
			System.out.println();
			String input7 = in.next();
			if (input7 == "A" || input7 == "a") { // Search using SSN
				try {
				System.out.println("Enter 9-digit SSN: ");
				String input7 = in.next();
				int input3 = Integer.parseInt(input7)
				if (input3 > 99999999 && input3 < 1000000000){
					bst.SearchRecord(input3); }}
				catch(NumberFormatException e){
					System.out.println();
					System.out.println(e + "is an invalid SSN, please try again");
			}}
			else if (input == "B" || input == "b") {	// Search using student number
				try {
				System.out.println("Enter 4-digit Student Number: ");
				String input8 = in.next();
				int input4 = Integer.parseInt(input8)
				if (input4 > 999 && input4 < 10000){
					bst.SearchEmail(input4); }}
				catch(NumberFormatException e){
					System.out.println();
					System.out.println(e + "is an invalid Student Number, please try again");
			}}}
			catch(IOException e) {
				System.out.println("Input Error: " + e);
				System.out.println("That was not a valid entry, please try again.");
				System.out.println();}
			}
			
		else if (input == "C" || input == "c") {
			bst.printTree();
		}	
		else if (input == "D" || input == "d") {
			try {
				System.out.println("Input the SSN of the student you would like to add the idea to: ");
				String input9 = in.next();
				int input10 = Integer.parseInt(input9)
				if (input10 > 99999999 && input10 < 1000000000){
					bst.addIdeaStudent(input10); }}
				catch(NumberFormatException e){
					System.out.println();
					System.out.println(e + "is an invalid SSN, please try again");}
		}	
	}
		catch(IOException e) {
			System.out.println("Input Error: " + e);
			System.out.println("That was not a valid entry, please try again.");
			System.out.println();
	}

	finally {
		out.close();
	}
}}}
