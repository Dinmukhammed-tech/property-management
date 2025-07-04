package io.proglib.mycompany.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="PROPERTY_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class PropertyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Property_Title", nullable = false)
    private String title;
    private String description;
    private String ownerName;
    @Column(name = "Property_Email",nullable = false)
    private String ownerEmail;
    private Double price;
    private String address;


}
