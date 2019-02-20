package com.derteuffel.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by derteuffel on 12/02/2019.
 */
@Entity
public class Compagnie implements Serializable {
    @Id
    @GeneratedValue
    private Long compagnieId;
    private  String compagnieName;
    private String compagnieAvatar;
    private  String compagnieLocation;
    @OneToMany(mappedBy = "compagnie")
    private Collection<Section> sections;

    public Compagnie() {
    }

    public Compagnie(String compagnieName, String compagnieAvatar, String compagnieLocation) {
        this.compagnieName = compagnieName;
        this.compagnieLocation=compagnieLocation;
        this.compagnieAvatar=compagnieAvatar;
    }


    public String getCompagnieLocation() {
        return compagnieLocation;
    }

    public void setCompagnieLocation(String compagnieLocation) {
        this.compagnieLocation = compagnieLocation;
    }

    public String getCompagnieAvatar() {
        return compagnieAvatar;
    }

    public void setCompagnieAvatar(String compagnieAvatar) {
        this.compagnieAvatar = compagnieAvatar;
    }

    public Collection<Section> getSections() {
        return sections;
    }

    public void setSections(Collection<Section> sections) {
        this.sections = sections;
    }

    public Long getCompagnieId() {
        return compagnieId;
    }

    public void setCompagnieId(Long compagnieId) {
        this.compagnieId = compagnieId;
    }

    public String getCompagnieName() {
        return compagnieName;
    }

    public void setCompagnieName(String compagnieName) {
        this.compagnieName = compagnieName;
    }
}
