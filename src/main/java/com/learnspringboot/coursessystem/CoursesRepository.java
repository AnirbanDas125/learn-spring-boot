package com.learnspringboot.coursessystem;

import org.springframework.data.jpa.repository.JpaRepository;

//This is a Repository Interface that we are going to use for data manipulation
//To make it as a Repository We need to extend JpaRepository class and make it generic and put the Entity name and Primary key type
public interface CoursesRepository extends JpaRepository<Course,Long>{
  
}
