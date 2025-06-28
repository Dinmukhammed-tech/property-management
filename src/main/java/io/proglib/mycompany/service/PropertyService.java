package io.proglib.mycompany.service;

import io.proglib.mycompany.model.PropertyDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PropertyService {
     PropertyDTO saveProperty(PropertyDTO property);
     List<PropertyDTO> getAllProperties();
     PropertyDTO updateProperty(PropertyDTO property,Long id);
     PropertyDTO updatePropertyDesc(PropertyDTO property,Long id);
     PropertyDTO updatePropertyPrice(PropertyDTO property,Long id);
     void deleteById(Long id);
}
