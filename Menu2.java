// Matt Gaetz
import java.util.Scanner;
import java.io.IOException;
import java.lang.NumberFormatException;

public class Menu implements{ //java.io.Serializable{
	BST bst = new BST();
	public static void main(String[] args) {
		
System.out.println("Hello, Welcome to our Idea Database!");
/*		System.out.println("Would you like to");
		System.out.println("(A) Start a new blank database");
		System.out.println("(B) Add to a preexisting database");
		String dataInput = in.next();
// De-serialize, put this at the beginning when you want to load something pre-saved in,
// note: it might error out if the text file doesn't exsist/ was wiped from RAM
		try{
			if (dataInput == "B" || "b"){
				try {
			FileInputStream fileIn = new FileInputStream("output.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			BST = (StudentBST) in.readObject();
			QueueA = (IdeaQueue) in.readObject();
			Heap = (IdeaHeap) in.readObject();
			in.close();
			fileIn.close();
			} 
			catch(IOException i) {
			i.printStackTrace();
			} 
			catch(ClassNotFoundException j) {
			
// Note: for these^, BST, QueueA, etc are new objects we are assiging the stuff from the text fileout.close();
			}}
*/
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
			bst.createStudentNode();
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
							int input2 = Integer.parseInt(input6);
							if (input2 > 99999999 && input2 < 1000000000){
								bst.addIdeaStudent(input2); }
						}
						catch(NumberFormatException e){
							System.out.println();
							System.out.println(e + "is an invalid SSN, please try again");}}
				}
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
				System.out.println("Which would you like to do (Ex:'A'): ");
				System.out.println();
				String input7 = in.next();
			if (input7 == "A" || input7 == "a") { // Search using SSN
				try {
					System.out.println("Enter 9-digit SSN: ");
					String input7 = in.next();
					int input3 = Integer.parseInt(input7);
					if (input3 > 99999999 && input3 < 1000000000){
						bst.SearchRecord(input3); 
						System.out.println("Would you like to:");
						System.out.println("(A) Delete the Student Record");
						System.out.println("(B) Edit the Last Name or Login Name of the record");
						System.out.println("Which would you like to do (Ex:'A'): ");
						String input11 = in.next();
							try{
								if (input11 == "A" || input11 == "a"){
									Node a = searchRecord(input3);
									bst.delete(a);
									System.out.println("Student Record has been deleted");
								}
								else if(input11 == "B" || input11 == "b"){
									System.out.println("Would you like to:");
									System.out.println("(A) Change Last Name");
									System.out.println("(B) Change Login Name");
									System.out.println("(C) Change Both");
									String input12 = in.next();
							
								try{
									if (input12 == "A" || input12 == "a"){
										Node a = searchRecord(input3);
										System.out.println("Enter new Last Name: ");
										String input13 = in.next();
										a.setLast(input13);
									}
									else if (input12 == "B" || input12 == "b"){
										Node a = searchRecord(input3);
										System.out.println("Enter new Login Name: ");
										String input14 = in.next();
										a.setEmail(input14);
									}
									else if (input12 == "C" || input12 == "c"){
										Node a = searchRecord(input3);
										System.out.println("Enter new Last Name: ");
										String input13 = in.next();
										a.setLast(input13);
										System.out.println("Enter new Login Name: ");
										String input14 = in.next();
										a.setEmail(input14);
									}
								}
								catch(IOException e) {
									System.out.println("Input Error: " + e);
									System.out.println("That was not a valid entry, please try again.");
									System.out.println();
								}
								}
							}
							catch(IOException e) {
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

			else if (input == "B" || input == "b") {	// Search using student number
				try {
					System.out.println("Enter 4-digit Student Number: ");
					String input8 = in.next();
					int input4 = Integer.parseInt(input8)
					if (input4 > 999 && input4 < 10000){
						bst.SearchEmail(input4); 
					}
				}
				catch(NumberFormatException e){
					System.out.println();
					System.out.println(e + "is an invalid Student Number, please try again");
				}
			}
			}
			catch(IOException e) {
				System.out.println("Input Error: " + e);
				System.out.println("That was not a valid entry, please try again.");
				System.out.println();
			}
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
					bst.addIdeaStudent(input10); 
				}
			}
				catch(NumberFormatException e){
					System.out.println();
					System.out.println(e + "is an invalid SSN, please try again");
				}
		}	
	}
		catch(IOException e) {
			System.out.println("Input Error: " + e);
			System.out.println("That was not a valid entry, please try again.");
			System.out.println();
	}
}
	finally {
		//Serialize, put this right before quitting the program
		/*try {
			FileOutputStream fileOut = new FileOutputStream("output.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(BST);
			out.writeObject(QueueA);
			out.writeObject(Heap);
			out.close();
			fileOut.close();
			System.out.println("Serialized object successfully in output.txt");
			} 
       		   catch(IOException i) {
			  i.printStackTrace();
			}
//De-serialize, put this at the beginning when you want to load something pre-saved in,
  //      note: it might error out if the text file doesn't exsist/ was wiped from RAM
		
//Note: for these^, BST, QueueA, etc are new objects we are assiging the stuff from the text file
*/
		out.close();	
	}
}

}
