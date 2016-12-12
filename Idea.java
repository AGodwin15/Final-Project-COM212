/*
Nate Brown
This is essentially a program that enlists each idea of
a student into a node within the student node itself
12/5/16
*/
//Idea class
public class Idea implements java.io.Serializable{ 
//instance variables for the idea class
	private int ideaNumber;
	private int studentSSN;
	private String description;
	private int ideaRating;


//establishing the instance variables and what they aree going to be called in the future for future programs
	public Idea(int ideaNum, int sSNumber, String descr, int ideaRate) {
		ideaNumber = ideaNum;
		studentSSN = sSNumber;
  		description = descr;
	  	ideaRating = ideaRate;
	}
//sets the idea num ect...
  	public void setIdeaNum(int ideaNum) {
	  	ideaNumber = ideaNum;
  	}
//gets the idea num ect...
	public int getIdeaNum() {
		  return ideaNumber;
  	}
	public void setSSN(int sSNumber){
	  	studentSSN = sSNumber;
	}
	public int getSSN() {
		return studentSSN;
	}
	public void setDescription(String descr){
		description = descr;
	}
	public String getDescript() {
	  	return description;
	}
	public void setRating(int ideaRate) {
	  	ideaRating = ideaRate;
	}
	public int getRating() {
		return ideaRating;
	}
	
}




