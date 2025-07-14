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
    private Double price;
    private String address;

    @ManyToOne/*many property belong to one user*/(fetch = FetchType.EAGER)//it will not fetch the data while fetching property
    @JoinColumn(name="USER_ID",nullable = false)
    private UserEntity userEntity;




}
