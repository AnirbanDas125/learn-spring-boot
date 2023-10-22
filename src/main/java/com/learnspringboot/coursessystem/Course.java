package com.learnspringboot.coursessystem;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity//This annotation in crating a table in in memory database H2, This is called Entity mapping and this 
//Annotation is mapping this class Course to a Course table/Entity to the database
//@Entity(name="Custom name") we also can set a custom name for the entity in the database 
public class Course {
    
	@Id //This annotation assigns a particular field name as Primary Key  
	@GeneratedValue //This Annotation will generate a automatic unique value for the Primary key field in DB
	private long id;
	
	//@Column(name="course_name")//This annotation will help customize the column name, by default it would be as the field name 
	private String name;
	private String auther;
	public Course() {
		//Whenever I create an Entity we have to give a default cons. 
	}
	public Course(long id, String name, String auther) {
		super();
		this.id = id;
		this.name = name;
		this.auther = auther;
	}
	@Override
	public String toString() {
		return "Cource [id=" + id + ", name=" + name + ", auther=" + auther + "]";
	}
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAuther() {
		return auther;
	}
	
//We will populate some data in the in memory database with a untitled text called data.sql in src/main/resources 	
}
