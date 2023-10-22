package com.learnspringboot.coursessystem;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CourseController {
	
	@Autowired
	private CoursesRepository repo;
	
	
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return Arrays.asList(new Course(1,"Java Spring Boot","Anirban"),
				new Course(2,"React js. & Node js.","Anirban")); // hard coded values
	}
	
//	@GetMapping("/courses/1")
//	public String getFirstCourse() {
//		return getCourses().get(0).toString();
//	}
//	
	@GetMapping("/courses/1")
	public Course getFirstCourse() {
		return new Course(1,"Java Spring Boot","Anirban");
	}
	

	@GetMapping("/allcourses/{id}")
	public Course getFirstCourseUsingVars(@PathVariable long id) { //This annotation will create and pass a var. 
		Optional<Course> singleCourse = repo.findById(id);/*This is called a Optional class. Optional is a class introduced in Java 8
		 that is part of the java.util package. It is used to represent an object that may or may not contain a non-null value. 
		 Optional is designed to help developers handle situations where a value might be absent,
		  reducing the risk of null pointer exceptions and providing a more expressive way to deal with such cases.
		  The syntax is, this is a generic class that we requires a class type whose object may or may not be empty.
		  The method findById() returns a Optional class object. */
		
		if(singleCourse.isEmpty()) { // Simple check statement to check if the object is empty or not 
			throw new RuntimeException("Could not find a course of id "+id);
		}
		return singleCourse.get(); //This Optional class offers a method called get() to return the original type object
		}
//This bean is returning the data from in memory database and data is being fetched by CoursesRepository data member automatically 
	
	@PostMapping("/allcourses") //This annotation will map a new entry to the DB
	public void createNewCourse(@RequestBody Course course) { //For that to happen it need to accept a json body
		                                                       //this is what @RequestBody does
		repo.save(course);//This method is used to perform POST operation 
	}
	
	@GetMapping("/allcourses")
	public List<Course> getAllCourses(){
		return repo.findAll();
	}
	
	@PutMapping("/allcourses/{id}") //This annotation is for PUT request 
	public void updateCourse(@RequestBody Course course, @PathVariable long id ) { /*This method is using @RequestBody to take
	the updated json body as input, and @PathVariable to take primary key value as input so that we can update the values by PK*/
		repo.save(course);//This method is use for new entry and modify the old entry
	}
	
	@DeleteMapping("/allcourses/{id}")//This annotation is used for Delete operation
	public void deleteCourse(@PathVariable long id) { //Taking course ID as @PathVariable 
		repo.deleteById(id); //This method is deleting the entire json body by ID(the var we passed)
	}

}
