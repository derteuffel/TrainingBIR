package com.derteuffel.repository;

import com.derteuffel.data.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by neword on 28/02/2019.
 */
@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
   public  List<Course> findAll();
}
