/*
Done by Nate Brown
11/30
This is the student record structure
*/

public class StudentNode implements java.io.Serializable{
//these are the instance variables for the student record
	//queue of ideas in student Node
	
	//the following are instance variables in the student Node
	private String lastName;
	private String loginName;
	private int socialSecurity;
	private int studentNumber;
	private StudentNode left;
	private StudentNode right;
	private QueueA queue;


//establishing the variables names that are going to be called upon in future programs
	public StudentNode(String Lname, String Ename, int socialSecurityNew, int num) {
		lastName = Lname;
		loginName = Ename;
		socialSecurity = socialSecurityNew;
		studentNumber = num;
		queue = new QueueA();
	}
//sets the variable ect...
	public void setLast(String Lname) {
		lastName = Lname;
	}
//returns the variable ect...
	public String getLast() {
		return lastName;
	}
	public void setEmail(String Ename) {
		loginName = Ename;
	}
	public String getEmail() {
		return loginName;
	}
	//edited by Andrew Godwin 
	public void setSocial(int socialSecurityNew) {
		socialSecurity = (socialSecurityNew % 10000);
	}
	public int getSocial() {
		return socialSecurity;
	}
	public void setStunum(int num) {
		studentNumber = num;
	}
	public int getStunum() {
		return studentNumber;
	}
	public void setLeft(StudentNode l){
		left = l;
	}
//gets the left node
	public StudentNode getLeft() {
		return left;
	}
//sets the right node
	public void setRight(StudentNode r) {
		right = r;
}
//gets the right node
	public StudentNode getRight() {
		return right;
	}
	public int getAvgRating() {
		int rating = queue.avgRating();
		return rating;

	}
}




