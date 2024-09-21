package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(schema = "RBAC", name="Persona")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = "domicilio")
@Builder
@Audited
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_domicilio")
    private Domicilio domicilio;

    @Builder.Default
    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "persona",orphanRemoval = true)
    private Set<Libro> libros = new HashSet<>(); //COMPOSICION

}


