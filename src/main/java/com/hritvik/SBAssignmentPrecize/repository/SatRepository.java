package com.hritvik.SBAssignmentPrecize.repository;

import com.hritvik.SBAssignmentPrecize.model.SatResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SatRepository extends JpaRepository<SatResult,Long> {
    boolean existsByName(String name);

    SatResult findByName(String name);


    @Query("SELECT COUNT(*) FROM SatResult  WHERE satScore > :currScore")
    int findCountWhereSatScoreGreater(@Param("currScore") int currScore);

    int countBySatScoreGreaterThan (int currScore);

}
