package com.derteuffel.repository;

import com.derteuffel.data.Course;
import com.derteuffel.data.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by neword on 28/02/2019.
 */
@Repository
public interface NoteRepository extends JpaRepository<Note,Long> {

}
