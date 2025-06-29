package io.proglib.mycompany.controller;

import io.proglib.mycompany.dto.PropertyDTO;
import io.proglib.mycompany.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class PropertyController {

    @Value("${pms.dummy:}")
    private String dummy;

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO property) {
        property = propertyService.saveProperty(property);
        ResponseEntity<PropertyDTO> response = new ResponseEntity<PropertyDTO>(property, HttpStatus.CREATED);

        return response;
    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDTO>> getAllProperties() {
        System.out.println("This is "+dummy);
        return new ResponseEntity(propertyService.getAllProperties(),HttpStatus.OK);
    }

    @PutMapping("/properties/{id}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO property, @PathVariable long id) {
        return new ResponseEntity(propertyService.updateProperty(property,id),HttpStatus.OK);
    }
    @PatchMapping("/properties/update-desc/{id}")
    public ResponseEntity<PropertyDTO> updatePropertyDesc(@RequestBody PropertyDTO property, @PathVariable long id) {
        return new ResponseEntity<>(propertyService.updatePropertyDesc(property,id),HttpStatus.OK);
    }
    @PatchMapping("/properties/update-price/{id}")
    public ResponseEntity<PropertyDTO> updatePropertyPrice(@RequestBody PropertyDTO property, @PathVariable long id) {
        return new ResponseEntity<>(propertyService.updatePropertyPrice(property,id),HttpStatus.OK);
    }
    @DeleteMapping("/properties/{id}")
    public ResponseEntity<Object> deleteProperty(@PathVariable Long id) {
        propertyService.deleteById(id);
        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }

}
