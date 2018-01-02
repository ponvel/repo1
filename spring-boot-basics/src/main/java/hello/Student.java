/**
 * 
 */
package hello;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author punitha
 *
 */
public class Student {
	
	private int rollNum;
	private String studentName;
	
	public Student() {
		
	}
	
	public Student(int rollNum, String studentName) {
		setRollNum(rollNum);
		setStudentName(studentName);
	}
	
	public int getRollNum() {
		return rollNum;
	}
	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("postConstruct");
	}

	@PreDestroy
	public void preDestroy() {

		System.out.println("preDestroy");

	}
	

}
