package com.derteuffel.repository;

import com.derteuffel.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Created by derteuffel on 25/01/2019.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserMilitaryCodeIgnoreCase(String userMilitaryCode);
    User findByUserCNINumberIgnoreCase(String userCNINumber);

    @Query("select u from User as u join u.section us where us.sectionId=:id order by u.userId desc")
    List<User> findBySection(@Param("id") Long sectionId);

    List<User> findAllByStatus(long status);
}
