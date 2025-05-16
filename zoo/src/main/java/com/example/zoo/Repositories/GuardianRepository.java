package com.example.zoo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.zoo.Entities.Guardian;

public interface GuardianRepository extends JpaRepository<Guardian,Long>{
    @SuppressWarnings("null")
    List<Guardian> findAll();
}