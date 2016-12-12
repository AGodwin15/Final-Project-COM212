/*Nate Brown
October 31
Program 4: this program is a binary search tree using linked nodes that should 
test each of the BST functions
*/
//NOTE FOR ANDREW: WE PROBABLY DONT NEED ALL OF THESE FUNCTIONS!!! MAKE SURE WE ONLY HAVE THE ONES WE NEED 
//ALSO NOTE FOR ANDREW: CALL THE QUEUE FUNCTIONS IN THIS CLASS TO ADD A NEW IDEA 
//SO, WHEN SEARCHING WITH SSN TO FIND A STUDENT, WE THEN ADD THE IDEA TO THE STUDENT'S NODE 
import java.util.Scanner;
public class BST implements java.io.Serializable{
	//public QueueA QueueA.java
	private StudentNode t;
//create an empty tree	
	public BST() {
		t = null;
	}
//checks if tree is empty
	public boolean isEmptyTree() {
		return t == null;
	}
//searches for the desired node through the given key
	//this search method uses the SSN as the key to get the full student record 
	public StudentNode searchRecord(int key) {
//checks first if tree is empty, returning null
		if (t == null) {
			return null;
		}
//otherwise, continue with the search given the key 
		else {
			return searchRrecord(t, key);
		}
	}
	//Edited by Andrew Godwin 
//search function given the tree and the key to return the student record
	//this function uses the SSN to get the full student record 
	private StudentNode searchRrecord(StudentNode t2, int key) {
		if (t2 == null) {
			return null;
		}
		else if (key == t2.getSocial()) {
			//return student record;
			return t2;
		}
		else if (key < t2.getSocial()) {
			return searchRrecord(t2.getLeft(), key); 
		}	
		else {
			return searchRrecord(t2.getRight(), key);
		}
	}
	
	//searches for the desired node through the given key
	//this search method uses the student as the key to get the student's login email
	public StudentNode searchEmail(int key) {
//checks first if tree is empty, returning null
		if (t == null) {
			return null;
		}
//otherwise, continue with the search given the key 
		else {
			return searchRemail(t, key);
		}
	}
	//Edited by Andrew Godwin 
//search function given the tree and the key to return the student record
	//this function uses the student number to get the student's email login name 
	private StudentNode searchRemail(StudentNode t2, int key) {
		if (t2 == null) {
			return null;
		}
		else if (key == t2.getStunum()) {
			//return student email login 
			System.out.println(t2.getEmail());
			return t2;
		}
		else if (key < t2.getStunum()) {
			return searchRemail(t2.getLeft(), key); 
		}	
		else if (key > t2.getStunum()){
			return searchRemail(t2.getRight(), key);
		}
		else {
			System.out.println("Student email not found.");
			return null;
		}
			
	}
	//Edited by Andrew 
	public void createStudentNode(){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter last name: ");
		String lastName = in.next();
		System.out.println("Enter login name: ");
		String loginName = in.next();
		System.out.println("Enter the SSN: ");
		int socialSecurityNew = in.nextInt();
		try {
			if (99999999 < socialSecurityNew && socialSecurityNew < 1000000000) {
				socialSecurityNew = (socialSecurityNew%10000);
				System.out.println("HELLO THERE");
			}
		}
		catch(IndexOutOfBoundsException e){
			System.out.println("Sorry but " + e + " is not a valid social security number!");
			System.out.println("Please try again!");
			System.out.println("Enter the SSN: ");
			socialSecurityNew = in.nextInt();
		}
			
		System.out.println("Enter student number: ");
		int studentNumber = in.nextInt();
		QueueA queue = new QueueA();
		StudentNode student = new StudentNode(lastName, loginName, socialSecurityNew, studentNumber);
		in.nextLine();
		insert(student);
	}	
		
	
//checks if there is no root, inserting the new node as the root
	public void insert(StudentNode p) {
		if (t == null) {
			t = p;
		}
//otherwise, runs the function insert2	
		else {
			insert2(t,p);
		}
	}
//inserts the desired node into the tree by checking where it
//should be in the tree based on the key and whats in the tree
	private void insert2(StudentNode t3, StudentNode p) {
		if (p.getStunum() < t3.getStunum()) {
			if (t3.getLeft() == null) {
				t3.setLeft(p);
			}
			else {
				insert2(t3.getLeft(), p);
			}
		}
		else {
			if (t3.getRight() == null) {
				t3.setRight(p);
			}
			else {
				insert2(t3.getRight(), p);
			}
		}
	}
//gets the left and right values of the node, and prints out the key
	public void traverse() {
		if (t != null) {
			traverseR(t.getLeft());
			System.out.print(t.getStunum() + " ");
			traverseR(t.getRight());
	}
}
//gets the left and right values of the node, and prints out the key
	private void traverseR(StudentNode t4) {
		if (t4!=null) {
			traverseR(t4.getLeft());
			System.out.print(t4.getStunum() + " ");
			traverseR(t4.getRight());
		}
	}
//delete function for deleting the desired node 
	public void delete(StudentNode p) {
//case if root == desired delete location
		if (p == t) {
			if (t.getRight() == null && t.getLeft() == null) {
				 t = null;
			}
			else if (t.getRight() != null && t.getLeft() != null) {
				StudentNode g = successor(t);
				g.setLeft(t.getLeft());
				if (t.getRight() == g) {
					g.setRight(null);
				}
				else {
	
					if (g.getRight() != null) {
						StudentNode parent = findParent(g);
						parent.setLeft(g.getRight());
					}
					g.setRight(t.getRight());
				}
				t = g; 
				
			}
			else if (t.getRight() == null || t.getLeft() == null) {
				if (t.getLeft() == null) {
					t = t.getRight();
				}
				else {
					t = t.getLeft();
				}
			}
		}
//case if there is a single child
		else if (p.getRight() == null || p.getLeft() == null) {
			StudentNode parent = findParent(p);
	
				if (isLeft(parent, p)) {
					parent.setLeft(p.getLeft());
					p.setLeft(null);
				}
				else {
					parent.setRight(p.getRight());
					p.setRight(null);
				}
			
		}
//case if there are no children
		else if (p.getRight() == null && p.getLeft() == null) {
			StudentNode parent = findParent(p);
			if (isLeft(parent, p)) {
				parent.setLeft(null);
			}
			else {
				parent.setRight(null);
			}
		}
//case if there are two children
		else if (p.getRight() != null && p.getLeft() != null) {
			StudentNode parent = findParent(p);
			StudentNode l = successor(p);
			if (isLeft(parent, p)) {
				parent.setLeft(l);
			}
			else {
				parent.setRight(l);
			}
			
			l.setLeft(p.getLeft());
			if (p.getRight() != l) {
				l.setRight(p.getRight());
			}
		}
	}
//finds the successor of the given node 
	public StudentNode successor(StudentNode d) {
		StudentNode a = d.getRight();
		while (a.getLeft() != null) {
			a = a.getLeft();
		}
		return a;
		}	
//finds the parent of the desired node
	public StudentNode findParent(StudentNode y) {
		StudentNode temp = t;
		while (temp.getRight() != y && temp.getLeft() != y) {
			if (temp.getStunum() > y.getStunum()) {
				temp = temp.getLeft();
			}
			else {
				temp = temp.getRight();
			}
		}
		return temp;
	}
//checks if node h is left of node g
	public boolean isLeft(StudentNode g, StudentNode h) {
		if (g.getLeft() == h) {
			return true;
		}
		else {
			return false;
		}
	}
//prints the new tree
    public void printTree() {
		System.out.println();
		printTree2(t);
		System.out.println();
    }
//prints the new tree's keys based on positions
	//Andrew edited 
    private void printTree2(StudentNode tree) {
	if (tree != null) {
		System.out.print(tree.getStunum() + " ");
		System.out.print(tree.getSocial() + " ");
		System.out.print(tree.getLast() + " ");
		System.out.print(tree.getAvgRating() + " ");		
		
        if (tree.getLeft() != null){
	        System.out.print(tree.getLeft().getStunum() + " ");
			System.out.print(tree.getLeft().getSocial() + " ");
			System.out.print(tree.getLeft().getLast() + " ");
			System.out.print(tree.getLeft().getAvgRating() + " ");
	    }	
        else if (tree.getRight() != null){
			System.out.print(tree.getRight().getStunum() + " ");
			System.out.print(tree.getRight().getSocial() + " ");
			System.out.print(tree.getRight().getLast() + " ");
			System.out.print(tree.getRight().getAvgRating() + " ");	
	    }	
        else {
            System.out.println("There are no student records to show.");
	    }
	}
    } 
}
