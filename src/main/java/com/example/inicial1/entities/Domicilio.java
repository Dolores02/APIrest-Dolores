package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.Set;

@Entity
@Table(schema = "RBAC", name = "Domicilio")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = {"persona", "localidades"})
@Builder
@Audited
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String calle;
    private int numero;

    @OneToOne(mappedBy = "domicilio")
    private Persona persona;  //bi


    @OneToMany(mappedBy = "domicilio")
    private Set<Localidad> localidades;  //bi

}
