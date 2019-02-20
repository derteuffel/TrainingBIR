package com.derteuffel.repository;

import com.derteuffel.data.Compagnie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by derteuffel on 12/02/2019.
 */
@Repository
public interface CompagnieRepository extends JpaRepository<Compagnie,Long> {

    Compagnie findByCompagnieName(String compagnieName);
}
