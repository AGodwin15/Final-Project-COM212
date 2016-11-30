// Andrew Godwin 
// Test for the Heap array 
//November 9, 2016
//This class allows us to implement our functons and check to see if 
//they are used correctly. This is a supplement to the Heap class. 

//creates TestHeap class 
public class TestHeap {
	//main function 
    public static void main(String[] args){
    //creates the heap 
	Heap a = new Heap();
	//creates nodes 
	Node xNode = new Node("Jane", 123456789);
	Node yNode = new Node("Joe", 934567890);
	Node zNode = new Node("Jack", 223452234);
	Node kNode = new Node("Jill", 934567856);
	Node fNode = new Node("Andrew", 911231000);
	//inserts the nodes in the array
	a.insert(fNode);
	a.insert(xNode);
	a.insert(yNode);
	a.insert(zNode);
	a.insert(kNode);
	a.printTree();
	//implements findMin and deleteMin methods 
	System.out.println("findMin");
	System.out.println(a.findMin().getKey());
	System.out.println();
	a.printTree();
	System.out.println();
	System.out.println(a.deleteMin().getKey());
	System.out.println("deleteMin");
	System.out.println(a.findMin().getKey());
	a.printTree();
	System.out.println();
	while(!a.isEmpty()) {
	    System.out.println(a.deleteMin().getKey());
	    System.out.println();
	}
    	a.printTree();
	System.out.println();
    }
}

	
