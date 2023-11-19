package com.spring.batch.repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;


@Repository
public class SlotPlanRepository {
    @PersistenceContext
    private EntityManager entityManager;

    //@Modifying
/*    public int deleteData(Integer id) {
        String query = "DELETE FROM slot_plan WHERE id = ?1";
        return entityManager
                .createNativeQuery(query)
                .setParameter(1, id)
                .executeUpdate();

    }*/

    public Long fetchAllRecords() {
        Query query = entityManager.createNativeQuery("SELECT count(*) FROM slot_plan");
        return query.getSingleResult() != null ? Long.parseLong(query.getSingleResult().toString()) : 0;
    }
}
