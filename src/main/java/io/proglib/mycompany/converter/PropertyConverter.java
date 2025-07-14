package io.proglib.mycompany.converter;

import io.proglib.mycompany.entity.PropertyEntity;
import io.proglib.mycompany.dto.PropertyDTO;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {
    public PropertyEntity convertPropertyDTOToPropertyEntity(PropertyDTO propertyDTO) {
        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setTitle(propertyDTO.getTitle());
        propertyEntity.setDescription(propertyDTO.getDescription());
        propertyEntity.setAddress(propertyDTO.getAddress());
        propertyEntity.setPrice(propertyDTO.getPrice());
        return propertyEntity;
    }
    public PropertyDTO convertPropertyEntityToPropertyDTO(PropertyEntity propertyEntity) {
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setId(propertyEntity.getId());
        propertyDTO.setTitle(propertyEntity.getTitle());
        propertyDTO.setDescription(propertyEntity.getDescription());
        propertyDTO.setAddress(propertyEntity.getAddress());
        propertyDTO.setPrice(propertyEntity.getPrice());
        propertyDTO.setUserId(propertyEntity.getUserEntity().getId());
        return propertyDTO;
    }
}
