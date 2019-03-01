package com.derteuffel.repository;

import com.derteuffel.data.Sequence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by neword on 01/03/2019.
 */
@Repository
public interface SequenceRepository extends JpaRepository<Sequence,Long> {
}
