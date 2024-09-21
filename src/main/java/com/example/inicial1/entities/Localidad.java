package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;


@Table(schema = "RBAC", name = "Localidad")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Audited
public class Localidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String denominacion;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_domicilio")
    private Domicilio domicilio;
}
