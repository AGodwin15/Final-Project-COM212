// Matt Gaetz
import java.util.Scanner;

public class Menu {;
	BST bst = new BST();
	public static void main(String[] args) {
		
System.out.println("Hello, Welcome to our Idea Database!");
	while (input != "E" || "e"){	// while loop
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
		if (input == "A" || "a") {	
			System.out.println("Enter the Student's Last Name: ");
			String input1 = in.next();
			System.out.println("Enter the Student's Email Login Name: ");
			String input2 = in.next();
			System.out.println("Enter the Student's Student Number: ");
			int input3 = in.next();
			System.out.println("Enter the Student's SSN: ");
			int input4 = in.next();
			Student student = new Student(input1, input2, input4, imput3);
			while (input5 != "B" || "b"){
				try{
					System.out.println("Would you like to enter an Idea? (Ex. A) ");
					System.out.println("(A) Yes");
					System.out.println("(B) No");
					String input5 = in.next();
					if (input5 == "A" || "a"){
						try{
							System.out.println("Enter 9-digit SSN: ");
							int input6 = in.next();
							if (input6 > 99999999 && input6 < 1000000000){
								bst.addIdeaStudent(input6); }}
						catch(NumberFormatException e){
							System.out.println();
							System.out.println(e + "is an invalid SSN, please try again");}}}
				catch(IOException e) {
					System.out.println("Input Error: " + e);
					System.out.println("That was not a valid entry, please try again.");
					System.out.println();}}
		}	
		else if (input == "B" || "b") {	
			try {
			Scanner in = new Scanner(System.in);
			System.out.println();
			System.out.println("(A) Search using SSN");
			System.out.println("(B) Search using Student Number");
			System.out.println("Which would you like to do (Ex:'A': ");
			System.out.println();
			String input = in.next();
			if (input == "A" || "a") { // Search using SSN
				try {
				System.out.println("Enter 9-digit SSN: ");
				int input = in.next();
				if (input > 99999999 && input < 1000000000){
					bst.SearchRecord(input); }}
				catch(NumberFormatException e){
					System.out.println();
					System.out.println(e + "is an invalid SSN, please try again");
			}}
			else if (input == "B" || "b") {	// Search using student number
				try {
				System.out.println("Enter 4-digit Student Number: ");
				int input = in.next();
				if (input > 999 && input < 10000){
					bst.SearchEmail(input); }}
				catch(NumberFormatException e){
					System.out.println();
					System.out.println(e + "is an invalid Student Number, please try again");
			}}}
			catch(IOException e) {
				System.out.println("Input Error: " + e);
				System.out.println("That was not a valid entry, please try again.");
				System.out.println();}
			}
			
		else if (input == "C" || "c") {
			bst.printTree();
		}	
		else if (input == "D" || "d") {
			
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