// Matt Gaetz
import java.util.Scanner;
import java.io.IOException;
import java.lang.NumberFormatException;
import java.io.*;

public class MenuFinal implements java.io.Serializable {
	public static void main(String[] args) {
	BST bst = new BST();
	//QueueA queue = new QueueA();
	Heap heap = new Heap();
	QueueA queue = new QueueA();
	
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
						heap = (Heap) inn.readObject();
						inn.close();
						fileIn.close();
						System.out.println("Database successfully found!");
						System.out.println();
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
		Scanner in = new Scanner(System.in);
		System.out.println("Choose from one of the following options to proceed:");
		System.out.println();
		System.out.println("(A) Create a new student record");
		System.out.println("(B) Search for existing Student record");
		System.out.println("(C) Print out list every student's name with their student #, SSN and avg score");
		System.out.println("(D) Add new Idea using SSN search");
		System.out.println("(E) Print best idea");
		System.out.println("(F) Exit the program");
		System.out.println();
		System.out.println("What would you like to do? (Ex:'A'): "); // user prompt
		input = in.next();
		if (input.equals("A") || input.equals("a")) {	
			//bst.createStudentNode();
		//Scanner in = new Scanner(System.in);
			System.out.println("Enter last name: ");
			String lastName = in.next();
			System.out.println("Enter login name: ");
			String loginName = in.next();
			String oldSSN;
			int newSSN;
			while(1==1){
				System.out.println("Enter 9-Digit SSN: ");
				oldSSN = in.next();

				newSSN = Integer.parseInt(oldSSN);
				if (newSSN < 100000000 || newSSN > 999999999) {
					System.out.println("That is an invalid SSN, please try again");
					continue;
				}
				else{
					//newSSN = newSSN % 10000;
					break;
				}
			}
			int studentNumber = 0;	
			while(1==1){
				System.out.println("Enter student number: ");
				studentNumber = in.nextInt();
				if (studentNumber < 1000 || studentNumber > 9999){
					System.out.println("That is an invalid Student Number, please try again");
					continue;}
				else{
					break;
				}
			}
			StudentNode student = new StudentNode(lastName, loginName, newSSN, studentNumber);
			in.nextLine();
//HERE U NEED TO FIGURE OUT
			bst.insert(student);
			bst.insertSSN(student);

		

			/*String input5 = "g";
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
								StudentNode o = bst.searchRecordSSN(input2);
								System.out.println(o.getLast());
								
								o.getQueue().setIdeaQueue(input2);
								break;
							}
							else{
								continue;
							}
					}
					if (input5.equals("B") || input5.equals("b")){
						break;
					}
			}*/
			System.out.println();
			System.out.println("Student Added!");
			System.out.println("Redirecting back to the main menu...");
			System.out.println();
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
						StudentNode u = bst.searchRecordSSN(input3); 
							if (u != null){
								System.out.println();
								System.out.println("Student Found! Here is their information:");
								System.out.println("Email: " + u.getEmail()); 
							    System.out.println("SSN: " + u.getSocial());
							    System.out.println("Student Number: " + u.getStunum());
							    System.out.println("Last Name: " + u.getLast()); 
							    System.out.println("Average Idea Rating: " + u.getAvgRating());
							    System.out.println();
							    System.out.println("Redirecting back to main menu...");
							    //continue;
								}
							else if (u == null) { 
								System.out.println("Sorry that student record was not found!");
								System.out.println("Redirecting...");
								continue;
							}	
							System.out.println("Would you like to:");
							System.out.println("(A) Delete Student Record");
							System.out.println("(B) Edit Student Login credentials");
							System.out.println("(C) Return to main menu");
							System.out.println();
							System.out.println("Which would you like to do?");
							String input11 = in.next();
						
							try {
								if (input11.equals("A") || input11.equals("a")){
									StudentNode a = bst.searchRecordSSN(input3);
									bst.delete(a);
									bst.deleteSSN(a);
									System.out.println("Student Record has been deleted");
									System.out.println("Redirecting...");
								}
								else if(input11.equals("B") || input11.equals("b")){
									System.out.println("Would you like to:");
									System.out.println("(A) Change Last Name");
									System.out.println("(B) Change Login Name");
									System.out.println("(C) Change Both");
									String input12 = in.next();
							
									try{
										if (input12.equals("A") || input12.equals("a")){
											StudentNode a = bst.searchRecordSSN(input3);
											System.out.println("Enter new Last Name: ");
											String input13 = in.next();
											a.setLast(input13);
											a.setLastSSN(input13);
											System.out.println("Last name successfully updated!");
										}
										else if (input12.equals("B") || input12.equals("b")){
											StudentNode a = bst.searchRecordSSN(input3);
											System.out.println("Enter new Login Name: ");
											String input14 = in.next();
											a.setEmailSSN(input14);
											a.setEmail(input14);
											System.out.println("Login name successfully updated!");
										}
										else if (input12.equals("C") || input12.equals("c")){
											StudentNode a = bst.searchRecordSSN(input3);
											System.out.println("Enter new Last Name: ");
											String input13 = in.next();
											a.setLast(input13);
											a.setLastSSN(input13);
											System.out.println("Last name successfully updated!");
											System.out.println();
											System.out.println("Enter new Login Name: ");
											String input14 = in.next();
											a.setEmail(input14);
											a.setEmailSSN(input14);
											System.out.println("Login name successfully updated!");
										}

									else if(input11.equals("C") || input12.equals("c")) {
										System.out.println("Redirecting...");
										continue;

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
					System.out.println();
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
					System.out.println("That is an invalid Student Number, please try again");
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
					StudentNode x = bst.searchRecordSSN(input10);
					System.out.println(x.getLast());
					Idea newIdea = x.getQueue().setIdeaQueue(input10);
					heap.insert(newIdea);
				}
			}
				catch(NumberFormatException e){
					System.out.println();
					System.out.println(e + "is an invalid SSN, please try again");
				}
			}
			
		else if (input.equals("E") || input.equals("e")) {
			System.out.println("Description: " + heap.findMin().getDescript());
			System.out.println("Rating: " + heap.findMin().getRating());
			try{
				System.out.println("What would you like to do with the best idea?");
				System.out.println();
				System.out.println("(A) Sell");
				System.out.println("(B) Return To Menu");
				String input100 = in.next();

				if (input100.equals("A") || input100.equals("a")) {
					System.out.println("The idea '" + heap.findMin().getDescript() + "' has been sold!");
					System.out.println();
					System.out.println("Redirecting to main menu...");
					heap.deleteMin();
					continue;
				}
				else if(input100.equals("B") || input100.equals("b")){
					System.out.println("Redirecting....");
					continue;
				}
			}
			catch(Exception e) {
				System.out.println();
			}
			
		}
	
		else if (input.equals("F") || input.equals("f")) {
			System.out.println("Thanks for using our program, have a lovely day!!!");
			
System.out.println("                 ____              ");	
			System.out.println("                |    |  ");		
			System.out.println("          ------------------				");
			System.out.println("	   _|		 |_ 		");
			System.out.println("	 _|	O    O	   |_		");
			System.out.println("  	O_	  ii	    _O 		");
			System.out.println("	  |_		  _|  		");
			System.out.println("	    |_	 WWWW   _|  		");
			System.out.println("              ----------    		");		
			System.out.println("                  VV 				");		

			System.out.println();
			
			try {
				FileOutputStream fileOut = new FileOutputStream("output.txt");
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(bst);
				out.writeObject(heap);

				out.close();
				fileOut.close();
				System.out.println("Serialized object successfully in output.txt");
			} 
       	
       		catch(IOException i) {
				i.printStackTrace();
			}
			
			System.exit(0);
		}

		else {
			continue;
		}
	}
}
}
