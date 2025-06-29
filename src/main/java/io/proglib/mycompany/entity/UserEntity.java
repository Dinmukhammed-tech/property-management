package io.proglib.mycompany.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="USER_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String ownerName;
    @Column(name="Email",nullable=false)
    private String ownerEmail;
    private String phoneNumber;
    private String password;

}
