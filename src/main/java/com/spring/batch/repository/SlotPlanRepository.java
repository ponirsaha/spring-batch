package com.spring.batch.repository;


import com.spring.batch.entity.SlotPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface SlotPlanRepository extends JpaRepository<SlotPlan, Integer> {
    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM slot_plan WHERE id = :id")
    void deleteData(@Param("id") Integer id);
    @Query(nativeQuery = true, value = "SELECT count(*) FROM slot_plan")
    Long fetchAllRecords();
}
