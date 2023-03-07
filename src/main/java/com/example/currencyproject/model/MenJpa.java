package com.example.currencyproject.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenJpa extends JpaRepository<Men, Long> {
        Men findByName(String name);
}
