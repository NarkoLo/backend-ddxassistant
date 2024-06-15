package com.ddxfitness.backend_ddxassistant.auth.repository;

import com.ddxfitness.backend_ddxassistant.auth.entity.DDXUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DDXUserRepository extends CrudRepository<DDXUser, Long> {
    Optional<DDXUser> findByEmail(String email);
    Optional<DDXUser> findById(Long id);
}
