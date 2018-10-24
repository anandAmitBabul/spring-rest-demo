package io.javamit.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javamit.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudents;
	
	@PostConstruct
	public void loadData()
	{
		theStudents = new ArrayList<>();
		theStudents.add(new Student("Poornima","K"));
		theStudents.add(new Student("John","Doe"));
		theStudents.add(new Student("Mario","Rossi"));
	}
	
	@GetMapping("/students")
	public List<Student> students()
	{
		
		return theStudents;
	}
	
	@GetMapping("/students/{studentid}")
	public Student oneStudent(@PathVariable int studentid)
	{	
		if(studentid>=theStudents.size() || studentid <0)
		{
			throw new StudentNotFoundException("Student Id is not found - "+studentid);
		}
		return theStudents.get(studentid);
	}
	
}