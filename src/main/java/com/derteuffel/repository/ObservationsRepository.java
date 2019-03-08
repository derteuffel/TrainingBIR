package com.derteuffel.repository;

import com.derteuffel.data.Observations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by derteuffel on 07/03/2019.
 */
@Repository
public interface ObservationsRepository extends JpaRepository<Observations,Long> {
    @Query("select o from Observations as o join o.user ou where ou.userId=:id order by o.observationId desc")
    List<Observations> findAllByUser(@Param("id") Long userId);
}
