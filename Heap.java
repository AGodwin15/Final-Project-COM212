//Andrew Godwin 
//November 7, 2016 
//Program Five: This program implements a heap (priority queue) class using 
//an array of 120 nodes and implements the functions of a priority queue

//creates the Heap class 
public class Heap implements java.io.Serializable{
	//instance variables for the class to create the array 
	private int n;
	//this allows us to create the array
	private Idea [] array;
	
	//creates the Heap method to create the array with a counter as n for number of elements
	public Heap(){
		int n = 0;
		array = new Idea[120];
	}

	
	//creates the findMin method that returns the root of the tree/first node of the array
	public Idea findMin(){
		/*Idea x;
		x = array[0];
		System.out.println(x);
		System.out.println("LENGTH OF HEAP: "+n);*/
		return array[0];
	}
	
	//creates the isEmpty method that checks if the number of elements in the array is zero 
	public boolean isEmpty(){
		return n == 0;
	}
	
	//creates the insert method that takes in Node x as a parameter
	public Idea insert(Idea x){
		array[n] = x;
		int temp = n;
		//while loop that uses the relationship between the children and parent nodes 
		while(temp != 0 && array[temp].getRating() > array[(temp-1)/2].getRating()){
			//if the child is less than the parent, swap the nodes 
			swap(temp, (temp-1)/2);
			temp = (temp-1)/2;
		}
		n++;
		return array[temp];
	}
	
	//creates the swap method that takes in two nodes as switches their positions in the array or tree
	public void swap(int x, int y){
		Idea tem = array[x];
		array[x] = array[y];
		array[y] = tem;
	}
	
	//creates the getLeftChild method that returns the value of the left child
	public int getLeftChild(int i){
			int o = 2*i + 1;
			return o;
	}
	//creates the getRightChild method that returns the value of the right child 
	public int getRightChild(int i){
			int o = 2*i +2;
			return o; 
	}
	
	//creates the deleteMin method that will delete the first node in the array
	//this will delete the root of the tree
	public Idea deleteMin() {
		//decrement n 
		n--;
		int min = 0;
		swap(min, n);
		//temporary holder for min 
		
		//if the root key is less than one of the children, then we need to check which child is less than
		//the other and then swap the root with the lesser child 
		while (array[min].getRating() > getRightChild(min) || array[min].getRating() > getLeftChild(min)){
			if (getRightChild(min) < getLeftChild(min)){
				//swaps the min and the left child 
				swap(array[min].getRating(), getLeftChild(min));
				min = getLeftChild(min);
			}
			//swaps the min and the right child 
			else{
				swap(array[min].getRating(), getRightChild(min));
				min = getRightChild(min);
			}
		}
		//return the array
		return array[min];
	}
	

	//creates the printTree method that will print out the array in order 
	public void printTree() {
		System.out.println(n);
		for (int i = 0; i < n; i++){
			System.out.print(array[i].getRating());
			System.out.print(" --- ");
			System.out.println(array[i].getDescript());
		}
	}
}
