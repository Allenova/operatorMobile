package com.example.dao.repository;

import com.example.dao.model.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbstractPassportRepository extends JpaRepository<Passport,Long> {
}
