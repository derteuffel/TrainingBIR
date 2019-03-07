package com.derteuffel.repository;

import com.derteuffel.data.Observations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by derteuffel on 07/03/2019.
 */
@Repository
public interface ObservationsRepository extends JpaRepository<Observations,Long> {
}
