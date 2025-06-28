package io.proglib.mycompany.repository;

import io.proglib.mycompany.entity.PropertyEntity;
import io.proglib.mycompany.model.PropertyDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends CrudRepository<PropertyEntity, Long> {
}
