package com.example.demo.repo;

import com.example.demo.entity.Adres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdresRepository extends JpaRepository<Adres,Long> {
}
