package com.example.dao.repository;

import com.example.dao.model.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

public interface AbstractPhoneNumberRepository extends JpaRepository<PhoneNumber,Long> {
    @Transactional
    @Modifying
    @Query("update PhoneNumber p set p.active = :active where p.id = :id")
    void updateActiveById(@Param("active") Boolean active, @Param("id") Long id);


    PhoneNumber findByActive(Boolean active);
}

