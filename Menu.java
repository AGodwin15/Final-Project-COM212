import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		
Scanner in = new Scanner(System.in);
System.out.println("Hello, Welcome to our Idea Database!");
	while (input != "E"){	// while loop
		System.out.println("Choose from one of the following options to proceed:");
		System.out.println();
		System.out.println("(A) Create a new student record");
		System.out.println("(B) Search for existing Student record");
		System.out.println("(C) Print out every student's name with their student #, SSN and avg score");
		System.out.println("(D) Add new Idea using SSN search");
		System.out.println("(E) Exit the program");
		System.out.println();
		System.out.println("What would you like to do? (Ex: A): "); // user prompt
		String input = in.next();
		if (input == "A" || "a") {	
			
			
		else if (input == "B" || "b") {	
			
			
		else if (input == "C" || "c") {
			
			
		else if (input == "D" || "d") {
			
			
		else {
			System.out.println("That was not a valid entry, please try again.");
			// Try Catch
