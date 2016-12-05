//Andrew Godwin 
//Program Theree QueueA Class 
//October 31, 2016
/* This program implements a queue using an array assuming a max 
size of 100 nodes. This program adds some nodes and tests each of 
the queue functions  */

//creates the StackA (array) class 
public class QueueA{ 
	//instance variables for the class 
	private int n;
	private Node [] array;
	private int front;
	private int end;

	//creates the QueueA method that defines the array of 100 nodes
	public QueueA(){
		n = 0;
		front = 0;
		array = new Node[10];
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
