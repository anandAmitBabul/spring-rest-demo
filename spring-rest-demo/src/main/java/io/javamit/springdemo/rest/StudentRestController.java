package io.javamit.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javamit.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	@GetMapping("/students")
	public List<Student> students()
	{
		List<Student> theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Poornima","K"));
		theStudents.add(new Student("John","Doe"));
		theStudents.add(new Student("Mario","Rossi"));
		return theStudents;
	}
}