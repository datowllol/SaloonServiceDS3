package com.saloon.repository;

import com.saloon.model.FreeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FreeTableRepository extends JpaRepository<FreeTable, UUID> {
}
