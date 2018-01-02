package hello.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import hello.Student;

public class MyRequest {
	
	@JsonProperty("data")
	private List<Student> students;

}
