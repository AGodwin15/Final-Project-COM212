/*
11/30
This is the student record structure
*/

public class Student {
	private String lastName;
	private String loginName;
	private int SSN;
	private int studentNumber;
	private Node idea;
	private int avgRating;

	public Student(String Lname, String Ename, int SSN0, int num, Node idea0, int avg) {
		lastName = Lname;
		loginName = Ename;
		SSN = SSN0;
		studentNumber = num;
		idea = idea0;
		avgRating = avg;
	}
	
	public void setLast(String Lname) {
		lastName = Lname;
	}
	public String getLast() {
		return lastName;
	}
	public void setEmail(String Ename) {
		loginName = Ename;
	}
	public String getEmail() {
		return loginName;
	}
	public void setSocial(int SSN) {
		SSN = SSN0[]
	}
	public String getSocial() {
		return SSN[]
	}
	public void setStunum(int num) {
		studentNumber = num;
	}
	public String getStunum() {
		return studentNumber;
	}
	public void setAvg(int avg) {
		avgRating = avg;
	}
	public int getAvg() {
		return avgRating;
	}
}
