package com.derteuffel.data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by neword on 28/02/2019.
 */
@Entity
public class Course implements Serializable {

    @Id
    @GeneratedValue
    private Long courseId;
    private String courseName;
    private String courseAbreviation;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public Course(){}
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "course")
    private Set<Note> notes = new HashSet<>();

    public String getCourseAbreviation() {
        return courseAbreviation;
    }

    public void setCourseAbreviation(String courseAbreviation) {
        this.courseAbreviation = courseAbreviation;
    }

    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }
}
