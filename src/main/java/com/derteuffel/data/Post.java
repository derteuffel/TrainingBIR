package com.derteuffel.data;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by neword on 28/02/2019.
 */
@Entity
public class Post implements Serializable {

    @Id
    @GeneratedValue
    private Long postId;
    private String postTitle;
    private String postDescription;
    private Date postDate;

    public Post(String postDescription, String postTitle, Date postDate) {
        this.postDescription = postDescription;
        this.postTitle = postTitle;
        this.postDate = postDate;
    }

    public Post()
    {

    }
    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }
}
