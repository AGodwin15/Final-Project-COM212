//Andrew Godwin 
//Program Theree QueueA Class 
//October 31, 2016
/* This program implements a queue using an array assuming a max 
size of 100 nodes. This program adds some nodes and tests each of 
the queue functions  */


import java.util.Scanner;
//creates the StackA (array) class 
public class QueueA implements java.io.Serializable{ 
	//instance variables for the class 
	private int n =0;
	private Idea[] array = new Idea[10];
	private int front =0;
	private int end = 0;
	BST bst = new BST();
	//Heap heap = new Heap();
	private int counter =0;

	//creates the QueueA method that defines the array of 10 nodes
	/*public QueueA(){
		array = new Idea[10];

	}*/
	//defines the front method 
	public Idea front(){
		//conditional to check if the array is empty 
		if (n == 0){
			return null;
		}
		//if it is not empty, return the first element of the array 
		else{
			return array[front];
		}
	}
	//creates the dequeue method 
	//this returns and removes the first node of the queue
	public Idea dequeue(){
		int temp = front; 
		front = (front+1)%10;
		//decrement n 
		n--;
		return array[temp];
	}
	//creates the enqueue method with node x as a parameter 
	//this returns the queue with x added as the last element
	public Idea enqueue(Idea x){
		array[end] = x;
		end = (end+1)%10;
		n++;
		return x;
	}
	//creates the isEmpty method 
	public boolean isEmpty(){
		//boolean to see if the number of elements is zero 
		return n == 0;
	}
	//this function adds an idea to the student nodes by accessing the BST after searching with SSN
	public Idea addIdeaStudent(int social){
		Scanner in = new Scanner(System.in);
		//asks the user how many ideas he or she wants to add 
	//	System.out.println("How many ideas would you like to add?");
	//	String userInput = in.next();
	//	int input = Integer.parseInt(userInput);
		
	//	for (int i = 0; i<input; i++){
			/*System.out.println("Enter the social security number: ");
			int SSN = in.nextInt();
			while (true){

				if (SSN < 100000000 || SSN > 999999999){
				System.out.println("That was an invalid SSN, please try again.");
				continue;
			}
			else{
				SSN = SSN;
				break;
			}*/
			//}
			System.out.println("Enter the idea description: ");
			Scanner inn = new Scanner(System.in);
			String description = inn.nextLine();
			int rating = 0;
			while (1==1){
				System.out.println("Enter the idea rating (0-100): ");
				rating = in.nextInt();
				if (rating > 100){
					System.out.println("That was an invalid rating, please try again.");
					continue;
				}
				else{
					break;
				}
			}
			counter++;
			Idea idea = new Idea(counter, social, description, rating);
			//array[i] = idea;
		//adds the idea into the queue of ideas on the student records (latest 10 ideas)
		//inserts the idea node into the heap (pool of ideas) so that it can be updated
			//System.out.println(heap.insert(idea));
			return idea;
		}

	//}

	public int avgRating() {
		int rating = 0;
		if (n>0){

				for (int i=0; i<10; i++){
					if (array[i] == null){
						int avgRating = rating/i;
						return avgRating;
					}
					else {
						int y = array[i].getRating();
						rating = y + rating;
					}
				}
				int avgRating = rating/10;
				return avgRating;
		    }
			else {
				System.out.println("This student currently has no ideas!");
				return 0;
			}
	}
	public Idea setIdeaQueue(int social){
		return enqueue(addIdeaStudent(social));
	}
	public void getIdeaQueue(){
		printQueue();
		//return 1;
	}
	
	// printQueue method for QueueA
    public void printQueue() {
        if (front <= end)
           for(int i = front; i < end; i++) 
               System.out.println(array[i].getDescript());
        else {
           for(int i = front; i < 10; i++) 
               System.out.println(array[i].getDescript());          
           }
    }
}









