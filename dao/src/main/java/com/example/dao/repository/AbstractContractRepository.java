package com.example.dao.repository;

import com.example.dao.model.Contract;
import com.example.dao.model.TariffPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface AbstractContractRepository extends JpaRepository<Contract,Long> {
    @Transactional
    @Modifying
    @Query("update Contract c set c.tariffPlan = :tariffPlan where c.id = :id")
    void updateTariffPlanById(@Param("tariffPlan") TariffPlan tariffPlan, @Param("id") Long id);
}
