package io.proglib.mycompany.repository;

import io.proglib.mycompany.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {
    Optional<UserEntity> findByOwnerEmailAndPassword(String ownerEmail, String password);
    Optional<UserEntity> findByOwnerEmail(String ownerEmail);
}
