//Andrew Godwin 
//Program Theree QueueA Class 
//October 31, 2016
/* This program implements a queue using an array assuming a max 
size of 100 nodes. This program adds some nodes and tests each of 
the queue functions  */


import java.util.Scanner;
//creates the StackA (array) class 
public class QueueA{ 
	//instance variables for the class 
	private int n;
	private Node [] array;
	private int front;
	private int end;
	BST bst = new BST();
	Heap heap = new Heap();
	private int counter;

	//creates the QueueA method that defines the array of 100 nodes
	public QueueA(){
		n = 0;
		front = 0;
		array = new Node[10];
		counter = 0;
	}
	//defines the front method 
	public Node front(){
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
	public Node dequeue(){
		int temp = front; 
		front = (front+1)%10;
		//decrement n 
		n--;
		return array[temp];
	}
	//creates the enqueue method with node x as a parameter 
	//this returns the queue with x added as the last element
	public void enqueue(Node x){
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
		bst.BSTsearchRecord(searchKey);
		Scanner in = new Scanner(System.in);
		//asks the user how many ideas he or she wants to add 
		System.out.println("How many ideas would you like to add?");
		String userInput = in.next();
		int input = Integer.parseInt(userInput);
		for (int i = 0; i<input; i++){
			System.out.println("Enter the social security number: ");
			int SSN = in.nextInt();
			System.out.println("Enter the idea description: ");
			String description = in.next();
			System.out.println("Enter the idea rating: ");
			int rating = in.nextInt();
			counter++;
			Node idea = new Node(SSN, description, rating, counter);
			in.nextLine();
			array[i] = idea;
		//adds the idea into the queue of ideas on the student records (latest 10 ideas) 
		enqueue(idea);
		//inserts the idea node into the heap (pool of ideas) so that it can be updated
		heap.HeapInsert(idea);	
		}
	}
	
	// printQueue method for QueueA
    public void printQueue() {
        System.out.println(front);
        System.out.println(end);
        if (front <= end)
           for(int i = front; i < end; i++) 
               System.out.println(array[i].getKey());
        else {
           for(int i = front; i < 10; i++) 
               System.out.println(array[i].getKey());          
           for(int i = 0; i < end; i++) 
               System.out.println(array[i].getKey());
        }          
    }
}
