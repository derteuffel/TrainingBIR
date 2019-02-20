package com.derteuffel.data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by derteuffel on 12/02/2019.
 */
@Entity
public class Section implements Serializable {

    @Id
    @GeneratedValue
    private Long sectionId;

    private String sectionName;
    @ManyToOne
    private Compagnie compagnie;
    @OneToMany(mappedBy = "section")
    private Collection<User> users;

    public Section(String sectionName) {
        this.sectionName = sectionName;
    }

    public Section() {
    }

    public Section(String sectionName, Compagnie compagnie) {
        this.sectionName = sectionName;
        this.compagnie = compagnie;
    }

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Compagnie getCompagnie() {
        return compagnie;
    }

    public void setCompagnie(Compagnie compagnie) {
        this.compagnie = compagnie;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
