/*
Done by Nate Brown
11/30
This is the student record structure
*/

public class Student {
//these are the instance variables for the student record
	//queue of ideas in student Node
	QueueA queue = new QueueA();
	//the following are instance variables in the student Node
	private String lastName;
	private String loginName;
	private int SSN;
	private int studentNumber;
	private int avgRating;

//establishing the variables names that are going to be called upon in future programs
	public Student(String Lname, String Ename, int SSN0, int num, int avg, QueueA ideaQueue) {
		lastName = Lname;
		loginName = Ename;
		SSN = SSN0;
		studentNumber = num;
		avgRating = avg;
		queue = ideaQueue;
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
	public void setSocial(int SSN) {
		SSN = SSN0%10000;
	}
	public int getSocial() {
		return SSN;
	}
	public void setStunum(int num) {
		studentNumber = num;
	}
	public int getStunum() {
		return studentNumber;
	}
	//Nate* Changed getStunum() to getKey() for the purpose of organizing the BST in terms of the student number
	public void setKey(int num) {
		studentNumber = num;
	}
	public int getKey() {
		return studentNumber;
	}
	public void setAvg(int avg) {
		avgRating = avg;
	}
	public int getAvg() {
		return avgRating;
	}
}
