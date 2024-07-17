package com.team7.rupiapp.repository;

import com.team7.rupiapp.model.Mutation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MutationRepository extends JpaRepository<Mutation, UUID> {
}
