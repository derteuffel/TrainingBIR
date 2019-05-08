package com.derteuffel.repository;

import com.derteuffel.data.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by derteuffel on 12/02/2019.
 */
@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

}
