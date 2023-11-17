package com.spring.batch.repository;


import com.spring.batch.entity.SlotCategory;
import com.spring.batch.entity.SlotPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SlotCategoryRepository extends JpaRepository<SlotCategory, Integer> {
    @Query(nativeQuery = true, value = "DELETE FROM slot_category WHERE id = :id")
    @Modifying
    void deleteCategory(@Param("id") Integer id);

    @Query(nativeQuery = true, value = "SELECT * FROM slot_category")
    List<SlotCategory> fetchAllRecords();
}
