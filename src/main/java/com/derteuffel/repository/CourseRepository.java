package com.derteuffel.repository;

import com.derteuffel.data.Course;
import com.derteuffel.data.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by neword on 28/02/2019.
 */
@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

   @Query("select n from Note as n  where n.user.userId=:userId and n.course.courseId=:courseId ")
   List<Note> findNotesByCourseIdByUserId(@Param("courseId") Long courseId, @Param("userId") Long userId);

   @Query("select c from Course as c ORDER BY c.courseName ASC ")
   List<Course> findAll1();

   @Query("select n from Note as n where n.course.courseId=:courseId ")
   List<Note> findNotesByCourseId(@Param("courseId") Long courseId);
}
