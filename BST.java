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
	private StudentNode s;
	//BST2 bst2 = new BST2();

//create an empty tree	
	public BST() {
		t = null;
		s = null;
	}
//checks if tree is empty
	public boolean isEmptyTree() {
		return t == null;
	}
//searches for the desired node through the given key
	//this search method uses the SSN as the key to get the full student record 
//FOR SSN
	public StudentNode searchRecordSSN(int key) {
//checks first if tree is empty, returning null

		if (s == null) {
			return null;
		}
//otherwise, continue with the search given the key 
		else {
			return searchRrecordSSN(s, key);
		}
	}
	//Edited by Andrew Godwin 
//search function given the tree and the key to return the student record
	//this function uses the SSN to get the full student record 
//FOR SSN
	private StudentNode searchRrecordSSN(StudentNode s2, int key) {
		if (s2 == null) {
			return null;
		}
		else if (key == s2.getSocial()) {
			//return student record;
			return s2;
		}
		else if (key < s2.getSocial()) {
			return searchRrecordSSN(s2.getLeft2(), key); 
		}	
		else {
			return searchRrecordSSN(s2.getRight2(), key);
		}
	}
//FOR STU NUM
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
		else if (key == t2.getStunum()) {
			//return student record;
			return t2;
		}
		else if (key < t2.getStunum()) {
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

	//Edited by Nate
	//FOR SSN 
public void insertSSN(StudentNode p) {
		if (s == null) {
			s = p;
		}
//otherwise, runs the function insert2	
		else {
			insertSSN2(s,p);
		}
	}
	
//inserts the desired node into the tree by checking where it
//should be in the tree based on the key and whats in the tree
	private void insertSSN2(StudentNode s3, StudentNode p) {
		if (p.getSocial() < s3.getSocial()) {
			if (s3.getLeft2() == null) {
				s3.setLeft2(p);
			}
			else {
				insertSSN2(s3.getLeft2(), p);
			}
		}
		else {
			if (s3.getRight2() == null) {
				s3.setRight2(p);
			}
			else {
				insertSSN2(s3.getRight2(), p);
			}
		}
	}
		
//FOR STU NUM
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
	public void traverseSSN() {
		if (s != null) {
			traverseRSSN(s.getLeft2());
			System.out.print(s.getSocial() + " ");
			traverseRSSN(s.getRight2());
	}
}
//gets the left and right values of the node, and prints out the key
	private void traverseRSSN(StudentNode s4) {
		if (s4!=null) {
			traverseRSSN(s4.getLeft2());
			System.out.print(s4.getSocial() + " ");
			traverseRSSN(s4.getRight());
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

//FOR SSN
public void deleteSSN(StudentNode p) {
//case if root == desired delete location
		if (p == s) {
			if (s.getRight2() == null && s.getLeft2() == null) {
				 s = null;
			}
			else if (s.getRight2() != null && s.getLeft2() != null) {
				StudentNode g = successorSSN(s);
				g.setLeft2(s.getLeft2());
				if (s.getRight2() == g) {
					g.setRight2(null);
				}
				else {
	
					if (g.getRight() != null) {
						StudentNode parent = findParentSSN(g);
						parent.setLeft2(g.getRight());
					}
					g.setRight2(s.getRight2());
				}
				s = g; 
				
			}
			else if (s.getRight2() == null || s.getLeft2() == null) {
				if (s.getLeft2() == null) {
					s = s.getRight2();
				}
				else {
					s = s.getLeft2();
				}
			}
		}
//case if there is a single child
		else if (p.getRight2() == null || p.getLeft2() == null) {
			StudentNode parent = findParentSSN(p);
	
				if (isLeft(parent, p)) {
					parent.setLeft2(p.getLeft2());
					p.setLeft2(null);
				}
				else {
					parent.setRight2(p.getRight2());
					p.setRight2(null);
				}
			
		}
//case if there are no children
		else if (p.getRight2() == null && p.getLeft2() == null) {
			StudentNode parent = findParentSSN(p);
			if (isLeft(parent, p)) {
				parent.setLeft2(null);
			}
			else {
				parent.setRight2(null);
			}
		}
//case if there are two children
		else if (p.getRight2() != null && p.getLeft2() != null) {
			StudentNode parent = findParentSSN(p);
			StudentNode l = successorSSN(p);
			if (isLeft(parent, p)) {
				parent.setLeft2(l);
			}
			else {
				parent.setRight2(l);
			}
			
			l.setLeft2(p.getLeft2());
			if (p.getRight2() != l) {
				l.setRight2(p.getRight2());
			}
		}
	}

//FOR STU NUM
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
//FOR SSN
	public StudentNode successorSSN(StudentNode d) {
		StudentNode a = d.getRight2();
		while (a.getLeft2() != null) {
			a = a.getLeft2();
		}
		return a;
		}
//FOR SSN
	public StudentNode findParentSSN(StudentNode y) {
		StudentNode temp = s;
		while (temp.getRight2() != y && temp.getLeft2() != y) {
			if (temp.getSocial() > y.getSocial()) {
				temp = temp.getLeft2();
			}
			else {
				temp = temp.getRight2();
			}
		}
		return temp;
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
//FOR SSN
	public boolean isLeftSSN(StudentNode g, StudentNode h) {
		if (g.getLeft2() == h) {
			return true;
		}
		else {
			return false;
		}
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
		System.out.print("Student Number: " + tree.getStunum());
		System.out.println();
		System.out.print("Social Security Number: " + tree.getSocial());
		System.out.println();
		System.out.print("Last Name: " + tree.getLast());
		System.out.println();
		System.out.print("Idea Average Rating: " + tree.getAvgRating());	
		System.out.println();
		
		//To get idea list:
		//tree.getQueue().getIdeaQueue();

        if (tree.getLeft() != null){
        	System.out.println();
	        System.out.print("Student Number: " + tree.getLeft().getStunum());
	        System.out.println();
			System.out.print("Social Security Number: " + tree.getLeft().getSocial());
			System.out.println();
			System.out.print("Last Name: " + tree.getLeft().getLast());
			System.out.println();
			System.out.print("Idea Average Rating: " + tree.getLeft().getAvgRating());
			System.out.println();
	    }	
        else if (tree.getRight() != null){
        	System.out.println();
			System.out.print("Student Number: " + tree.getRight().getStunum());
			System.out.println();
			System.out.print("Social Security Number: " + tree.getRight().getSocial());
			System.out.println();
			System.out.print("Last Name: " + tree.getRight().getLast());
			System.out.println();
			System.out.print("Idea Average Rating: " + tree.getRight().getAvgRating());
			System.out.println();	
	    }	
        else {
            System.out.println("There are no more student records to show.");
	    }
	}
    } 
}

