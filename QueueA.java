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
	private int n;
	private Idea [] array;
	private int front;
	private int end;
	BST bst = new BST();
	BST bst2 = new BST2();
	Heap heap = new Heap();
	private int counter;

	//creates the QueueA method that defines the array of 10 nodes
	public QueueA(){
		n = 0;
		front = 0;
		array = new Idea[10];
		counter = 0;
	}
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
	public void enqueue(Idea x){
		end = (front + n)%10;
		array[end] = x;
		end++;
		n++;
	}
	//creates the isEmpty method 
	public boolean isEmpty(){
		//boolean to see if the number of elements is zero 
		return n == 0;
	}
	//this function adds an idea to the student nodes by accessing the BST after searching with SSN
	public void addIdeaStudent(int searchKey){
		bst2.searchRecord(searchKey);
		Scanner in = new Scanner(System.in);
		//asks the user how many ideas he or she wants to add 
		System.out.println("How many ideas would you like to add?");
		String userInput = in.next();
		int input = Integer.parseInt(userInput);
		for (int i = 0; i<input; i++){
			System.out.println("Enter the social security number: ");
			int SSN = in.nextInt();
			System.out.println("Enter the idea description: ");
			String description = in.nextLine();
			System.out.println("Enter the idea rating: ");
			int rating = in.nextInt();
			counter++;
			Idea idea = new Idea(counter, SSN, description, rating);

			in.nextLine();
			array[i] = idea;
		//adds the idea into the queue of ideas on the student records (latest 10 ideas) 
		enqueue(idea);
		//inserts the idea node into the heap (pool of ideas) so that it can be updated
		heap.insert(idea);	
		}
	}
	public int avgRating() {
	int rating = 0;
	if (array[0] != null){
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
	
	// printQueue method for QueueA
    public void printQueue() {
        System.out.println(front);
        System.out.println(end);
        if (front <= end)
           for(int i = front; i < end; i++) 
               System.out.println(array[i].getSSN());
        else {
           for(int i = front; i < 10; i++) 
               System.out.println(array[i].getSSN());          
           }
    }
}
