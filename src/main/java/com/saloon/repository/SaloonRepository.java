package com.saloon.repository;

import com.saloon.model.Saloon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SaloonRepository extends JpaRepository<Saloon, UUID> {
}
