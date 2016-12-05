/*Nate Brown
October 31
Program 4: this program is a binary search tree using linked nodes that should 
test each of the BST functions
*/
//NOTE FOR ANDREW: WE PROBABLY DONT NEED ALL OF THESE FUNCTIONS!!! MAKE SURE WE ONLY HAVE THE ONES WE NEED 

public class BST {
	private Node t;
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
	public Node searchRecord(int key) {
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
	private Node searchRrecord(Node t2, int key) {
		if (t2 == null) {
			return null;
		}
		else if (key == t2.getSocial()) {
			//return student record;
			t2.getEmail();
			t2.getSocial();
			t2.getStunum();
			t2.getLast();
			t2.getavgRating();
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
	public Node searchEmail(int key) {
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
	private Node searchRemail(Node t2, int key) {
		if (t2 == null) {
			return null;
		}
		else if (key == t2.getStunum()) {
			//return student email login 
			t2.getEmail();
		}
		else if (key < t2.getStunum()) {
			return searchRemail(t2.getLeft(), key); 
		}	
		else {
			return searchRemail(t2.getRight(), key);
		}
	}
	
//checks if there is no root, inserting the new node as the root
	public void insert(Node p) {
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
	private void insert2(Node t3, Node p) {
		if (p.getKey() < t3.getKey()) {
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
			System.out.print(t.getKey() + " ");
			traverseR(t.getRight());
	}
}
//gets the left and right values of the node, and prints out the key
	private void traverseR(Node t4) {
		if (t4!=null) {
			traverseR(t4.getLeft());
			System.out.print(t4.getKey() + " ");
			traverseR(t4.getRight());
		}
	}
//delete function for deleting the desired node 
	public void delete(Node p) {
//case if root == desired delete location
		if (p == t) {
			if (t.getRight() == null && t.getLeft() == null) {
				 t = null;
			}
			else if (t.getRight() != null && t.getLeft() != null) {
				Node g = successor(t);
				g.setLeft(t.getLeft());
				if (t.getRight() == g) {
					g.setRight(null);
				}
				else {
	
					if (g.getRight() != null) {
						Node parent = findParent(g);
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
			Node parent = findParent(p);
	
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
			Node parent = findParent(p);
			if (isLeft(parent, p)) {
				parent.setLeft(null);
			}
			else {
				parent.setRight(null);
			}
		}
//case if there are two children
		else if (p.getRight() != null && p.getLeft() != null) {
			Node parent = findParent(p);
			Node l = successor(p);
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
	public Node successor(Node d) {
		Node a = d.getRight();
		while (a.getLeft() != null) {
			a = a.getLeft();
		}
		return a;
		}	
//finds the parent of the desired node
	public Node findParent(Node y) {
		Node temp = t;
		while (temp.getRight() != y && temp.getLeft() != y) {
			if (temp.getKey() > y.getKey()) {
				temp = temp.getLeft();
			}
			else {
				temp = temp.getRight();
			}
		}
		return temp;
	}
//checks if node h is left of node g
	public boolean isLeft(Node g, Node h) {
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
    private void printTree2(Node tree) {
	if (tree != null) {
	    System.out.print(tree.getKey() + " ");
            if (tree.getLeft() != null)
	        System.out.print("Left: " + tree.getLeft().getKey() + " ");
            else
                System.out.print("Left: null ");
            if (tree.getRight() != null)
	        System.out.println("Right: " + tree.getRight().getKey() + " ");
            else
                System.out.println("Right: null ");
	    printTree2(tree.getLeft());
	    printTree2(tree.getRight());
	}
    }
}
