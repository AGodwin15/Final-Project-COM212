/*
This is essentially a program that enlists each idea of
a student into a node within the student node itself
12/5/16
*/

public class Idea{ 
	private int ideaNumber;
	private int studentSSN;
	private String description;
	private int ideaRating;

	  public Idea(int ideaNum, int SSN, String descr, int ideaRate) {
		ideaNumber = ideaNum;
		studentSSN = SSN;
  		description = descr;
	  	ideaRating = ideaRate;
	  }

  	public void setIdeaNum(int ideaNum) {
	  	ideaNumber = ideaNum;
  	}
	  public int getIdeaNum() {
		  return ideaNumber;
  	}
	  public int getSSN() {
	  	return SSN;
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
