package io.proglib.mycompany.repository;

import io.proglib.mycompany.dto.PropertyDTO;
import io.proglib.mycompany.entity.PropertyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends CrudRepository<PropertyEntity, Long> {

//    @Query("Select p from PropertyEntity p where p.userEntity.id==:userId and p.title="title)
//    List<PropertyEntity> findAllByUserEntityId(@Param("userId") Long userEntityId,@Param("title") String title);
    List<PropertyEntity> findAllByUserEntityId(Long userEntityId);
}
