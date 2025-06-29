package io.proglib.mycompany.service.impl;

import io.proglib.mycompany.converter.PropertyConverter;
import io.proglib.mycompany.entity.PropertyEntity;
import io.proglib.mycompany.dto.PropertyDTO;
import io.proglib.mycompany.repository.PropertyRepository;
import io.proglib.mycompany.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyConverter propertyConverter;

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public PropertyDTO saveProperty(PropertyDTO property) {
        PropertyEntity propertyEntity = propertyConverter.convertPropertyDTOToPropertyEntity(property);

        propertyEntity = propertyRepository.save(propertyEntity);

        return propertyConverter.convertPropertyEntityToPropertyDTO(propertyEntity);
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        Iterable<PropertyEntity> list = propertyRepository.findAll();
        List<PropertyDTO> propertyDTOList = new ArrayList<>();
        for (PropertyEntity propertyEntity : list) {
            propertyDTOList.add(propertyConverter.convertPropertyEntityToPropertyDTO(propertyEntity));
        }
        return propertyDTOList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO property, Long id) {
        Optional<PropertyEntity> optEn = propertyRepository.findById(id);
        PropertyDTO dto = null;

        if(optEn.isPresent()) {
            PropertyEntity propertyEntity = optEn.get();
            propertyEntity.setTitle(property.getTitle());
            propertyEntity.setDescription(property.getDescription());
            propertyEntity.setPrice(property.getPrice());
            propertyEntity.setAddress(property.getAddress());
            propertyEntity.setOwnerName(property.getOwnerName());
            propertyEntity.setOwnerEmail(property.getOwnerEmail());

            dto = propertyConverter.convertPropertyEntityToPropertyDTO(propertyEntity);

            propertyRepository.save(propertyEntity);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyDesc(PropertyDTO property, Long id) {
        Optional<PropertyEntity> optEn = propertyRepository.findById(id);
        PropertyDTO dto = null;
        if(optEn.isPresent()) {
            PropertyEntity propertyEntity = optEn.get();
            propertyEntity.setDescription(property.getDescription());

            dto = propertyConverter.convertPropertyEntityToPropertyDTO(propertyEntity);
            propertyRepository.save(propertyEntity);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO property, Long id) {
        Optional<PropertyEntity> optEn = propertyRepository.findById(id);
        PropertyDTO dto = null;
        if(optEn.isPresent()) {
            PropertyEntity propertyEntity = optEn.get();
            propertyEntity.setPrice(property.getPrice());
            dto = propertyConverter.convertPropertyEntityToPropertyDTO(propertyEntity);
            propertyRepository.save(propertyEntity);

        }
        return dto;
    }

    @Override
    public void deleteById(Long id) {
        propertyRepository.deleteById(id);
    }
}
