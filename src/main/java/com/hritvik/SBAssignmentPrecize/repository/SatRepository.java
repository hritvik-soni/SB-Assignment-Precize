package com.hritvik.SBAssignmentPrecize.repository;

import com.hritvik.SBAssignmentPrecize.model.SatResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SatRepository extends JpaRepository<SatResult,Long> {
    boolean existsByName(String name);

    SatResult findByName(String name);


}
