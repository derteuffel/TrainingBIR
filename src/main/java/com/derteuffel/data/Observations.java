package com.derteuffel.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by derteuffel on 07/03/2019.
 */
@Entity
public class Observations implements Serializable {

    @Id
    @GeneratedValue
    private Long observationId;

    private String title;
    private String observation;
    private Date observationDate= new Date();

    private ArrayList<String> observationsFiles= new ArrayList<>();
    @ManyToOne
    private User user;

    public Observations() {
    }

    public Observations(String title, String observation, Date observationDate, ArrayList<String> observationsFiles) {
        this.title = title;
        this.observation = observation;
        this.observationDate = observationDate;
        this.observationsFiles=observationsFiles;
    }


    public ArrayList<String> getObservationsFiles() {
        return observationsFiles;
    }

    public void setObservationsFiles(ArrayList<String> observationsFiles) {
        this.observationsFiles = observationsFiles;
    }

    public Long getObservationId() {
        return observationId;
    }

    public void setObservationId(Long observationId) {
        this.observationId = observationId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Date getObservationDate() {
        return observationDate;
    }

    public void setObservationDate(Date observationDate) {
        this.observationDate = observationDate;
    }

    @JsonIgnore
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
