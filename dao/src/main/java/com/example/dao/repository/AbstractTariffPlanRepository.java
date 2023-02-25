package com.example.dao.repository;

import com.example.dao.model.TariffPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface AbstractTariffPlanRepository extends JpaRepository<TariffPlan,Long> {
    @Transactional
    @Modifying
    @Query("update TariffPlan t set t.freeMinute = :freeMinute, t.price = :price, t.isArchive = :isArchive " +
            "where t.id = :id")
    int updateFreeMinuteAndPriceAndIsArchiveById(@Param("freeMinute") Long freeMinute, @Param("price") Double price, @Param("isArchive") Boolean isArchive, @Param("id") Long id);

    TariffPlan findByPriceAndFreeMinute(Double price, Long freeMinute);
}
