package com.derteuffel.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by neword on 28/02/2019.
 */

@Entity

public class  Note implements Serializable{


    @Id
    @GeneratedValue
    private Long noteId;

    public double getNoteVal() {
        return noteVal;
    }

    public void setNoteVal(double noteVal) {
        this.noteVal = noteVal;
    }

    private double noteVal;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "courseId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Course course;


    public Sequence getSequence() {
        return sequence;
    }

    public void setSequence(Sequence sequence) {
        this.sequence = sequence;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sequenceId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Sequence sequence;


    public Note(double mNoteVal,User mUser, Course mCourse, Sequence mSequence)
    {

        noteVal= mNoteVal;
        user = mUser;
        course = mCourse;
        sequence = mSequence;
    }
    public Note()
    {

    }
    public Long getNoteId() {
        return noteId;
    }

    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }
}
