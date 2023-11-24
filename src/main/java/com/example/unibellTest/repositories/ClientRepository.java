package com.example.unibellTest.repositories;

import com.example.unibellTest.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерфейс репозитория клиентской сущности
 */

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {


}
