package com.derteuffel.repository;

import com.derteuffel.data.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.Collection;

/**
 * Created by derteuffel on 12/02/2019.
 */
@Repository
public interface SectionRepository extends JpaRepository<Section,Long>{

    @Query("select s from Section as s join s.compagnie sc where sc.compagnieId=:id order by s.sectionId desc")
    Collection<Section> findAllByCompagnie(@Param("id") Long compagnieId);
}
