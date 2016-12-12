// Matt Gaetz
import java.util.Scanner;
import java.io.IOException;
import java.lang.NumberFormatException;
import java.io.*;

public class MenuFinal implements java.io.Serializable {
	public static void main(String[] args) {
	BST bst = new BST();
	BST2 bst2 = new BST2();
	QueueA queue = new QueueA();
	Heap heap = new Heap();
	
System.out.println("Hello, Welcome to our Idea Database!");
	while(1==1){	
		System.out.println("Would you like to");
		System.out.println("(A) Start a new blank database");
		System.out.println("(B) Add to a preexisting database");
		Scanner in = new Scanner(System.in);
		String dataInput = in.next();
// De-serialize, put this at the beginning when you want to load something pre-saved in,
// note: it might error out if the text file doesn't exsist/ was wiped from RAM
			if (dataInput.equals("B") || dataInput.equals("b")){
				try {
						FileInputStream fileIn = new FileInputStream("output.txt");
						ObjectInputStream inn = new ObjectInputStream(fileIn);
						bst = (BST) inn.readObject();
						queue = (QueueA) inn.readObject();
						heap = (Heap) inn.readObject();
						bst2 = (BST2) inn.readObject();
						inn.close();
						fileIn.close();
						} 

						catch(IOException i) {
							i.printStackTrace();
						} 
						catch(ClassNotFoundException j) {
							j.printStackTrace();
						}
				break;
			}
			else if (dataInput.equals("A") || dataInput.equals("a")){
				break;
			}
			else{
				continue;
			}
// Note: for these^, BST, QueueA, etc are new objects we are assiging the stuff from the text fileout.close();
		}

	String input = "t";
	while (!input.equals("E") || !input.equals("e")){	// while loop
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
		input = in.next();
		if (input.equals("A") || input.equals("a")) {	
			bst.createStudentNode();
			

			String input5 = "t";
			while (!input5.equals("B") || !input5.equals("b")){
					System.out.println("Would you like to enter an Idea? (Ex. A) ");
					System.out.println("(A) Yes");
					System.out.println("(B) No");
					input5 = in.next();
					while (input5.equals("A") || input5.equals("a")){
							System.out.println("Enter 9-digit SSN: ");
							String input6 = in.next();
							int input2 = Integer.parseInt(input6);
							if (input2 < 99999999 || input2 > 1000000000){
								System.out.println("That is an invalid SSN, please try again");
								continue;
							}
							else if (input2 > 99999999 && input2 < 1000000000){
								queue.addIdeaStudent(input2);
								break;
							}
							else{
								continue;
							}
						}
					if (input5.equals("B") || input5.equals("b")){
						break;
				}
			}
		}	
		else if (input.equals("B") || input.equals("b")) {	
			try {
				//Scanner in = new Scanner(System.in);
				System.out.println();	
				System.out.println("(A) Search using SSN");
				System.out.println("(B) Search using Student Number");
				System.out.println("Which would you like to do (Ex:'A'): ");
				System.out.println();
				String input7 = in.next();
			if (input7.equals("A") || input7.equals("a")) { // Search using SSN
				try {
					System.out.println("Enter 9-digit SSN: ");
					input7 = in.next();
					int input3 = Integer.parseInt(input7);
					if (input3 > 99999999 && input3 < 1000000000){
						StudentNode u = bst2.searchRecord(input3); 
							if (u != null){
							System.out.println("Student Found! Here is their information:");
							System.out.println("Email: " + u.getEmail()); 
						    System.out.println("SSN: " + u.getSocial());
						    System.out.println("Student Number: " + u.getStunum());
						    System.out.println("Last Name: " + u.getLast()); 
						    System.out.println("Average Idea Rating: " + u.getAvgRating());
							}
							else if (u == null) { 
							System.out.println("Sorry that student record was not found!");
							continue;
						}	
							System.out.println("Would you like to:");
							System.out.println("(A) Delete the Student Record");
							System.out.println("(B) Edit the Last Name or Login Name of the record");
							System.out.println("Which would you like to do (Ex:'A'): ");
							String input11 = in.next();
						
							try{
								if (input11.equals("A") || input11.equals("a")){
									StudentNode a = bst2.searchRecord(input3);
									bst.delete(a);
									bst2.delete(a);
									System.out.println("Student Record has been deleted");
								}
								else if(input11.equals("B") || input11.equals("b")){
									System.out.println("Would you like to:");
									System.out.println("(A) Change Last Name");
									System.out.println("(B) Change Login Name");
									System.out.println("(C) Change Both");
									String input12 = in.next();
							
								try{
									if (input12.equals("A") || input12.equals("a")){
										StudentNode a = bst2.searchRecord(input3);
										System.out.println("Enter new Last Name: ");
										String input13 = in.next();
										a.setLast(input13);
									}
									else if (input12.equals("B") || input12.equals("b")){
										StudentNode a = bst2.searchRecord(input3);
										System.out.println("Enter new Login Name: ");
										String input14 = in.next();
										a.setEmail(input14);
									}
									else if (input12.equals("C") || input12.equals("c")){
										StudentNode a = bst2.searchRecord(input3);
										System.out.println("Enter new Last Name: ");
										String input13 = in.next();
										a.setLast(input13);
										System.out.println("Enter new Login Name: ");
										String input14 = in.next();
										a.setEmail(input14);
									}
								}
								catch(Exception e) {
									System.out.println("Input Error: " + e);
									System.out.println("That was not a valid entry, please try again.");
									System.out.println();
								}
								}
							}
							catch(Exception e) {
								System.out.println("Input Error: " + e);
								System.out.println("That was not a valid entry, please try again.");
								System.out.println();
							}		
					}
				}
				catch(NumberFormatException e){
					System.out.println();
					System.out.println(e + "is an invalid SSN, please try again");
				}
			}

			else if (input.equals("B") || input.equals("b")) {	// Search using student number
				try {
					System.out.println("Enter 4-digit Student Number: ");
					String input8 = in.next();
					int input4 = Integer.parseInt(input8);
					if (input4 > 999 && input4 < 10000){
						bst.searchEmail(input4); 
					}
				}
				catch(NumberFormatException e){
					System.out.println();
					System.out.println(e + "is an invalid Student Number, please try again");
				}
			}
			}
			catch(Exception e) {
				System.out.println("Input Error: " + e);
				System.out.println("That was not a valid entry, please try again.");
				System.out.println();
			}
		}
			
		else if (input.equals("C") || input.equals("c")) {
			bst.printTree();
		}	
		else if (input.equals("D") || input.equals("d")) {
			try {
				System.out.println("Input the SSN of the student you would like to add the idea to: ");
				String input9 = in.next();
				int input10 = Integer.parseInt(input9);
				if (input10 > 99999999 && input10 < 1000000000){
					queue.addIdeaStudent(input10); 
				}
			}
				catch(NumberFormatException e){
					System.out.println();
					System.out.println(e + "is an invalid SSN, please try again");
				}
		}
		else if (input.equals("E") || input.equals("e")) {
			System.out.println("Thanks for using our program, have a lovely day");
			System.exit(0);
		}	
	}
		catch(Exception e) {
			System.out.println("Input Error: " + e);
			System.out.println("That was not a valid entry, please try again.");
			System.out.println();
	}

		//Serialize, put this right before quitting the program
		try {
			FileOutputStream fileOut = new FileOutputStream("output.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(bst);
			out.writeObject(queue);
			out.writeObject(heap);
			out.writeObject(bst2);
			out.close();
			fileOut.close();
			System.out.println("Serialized object successfully in output.txt");
			} 
       		   catch(IOException i) {
			  i.printStackTrace();
			}
	}

	System.exit(0);
}

}
