package com.example.inicial1.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;

@Table(schema = "RBAC", name="Autor")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Audited
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String biografia;

    @Builder.Default
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Libro> libro = new ArrayList<>();


}
