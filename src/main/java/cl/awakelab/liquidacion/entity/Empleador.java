package cl.awakelab.liquidacion.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "empleador")
public class Empleador {
    @Id
    @Column(name = "id_empleador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpleador;
    @Column(name = "run")
    private int run;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido_1")
    private String apellido1;
    @Column(name = "apellido_2")
    private String apellido2;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "email")
    private String email;
    @Column(name = "telefono")
    private Long telefono;
    @ManyToMany
    @JoinTable(
            name = "empl_trab",
            joinColumns = @JoinColumn(name = "id_empleador"),
            inverseJoinColumns = @JoinColumn(name = "id_trabajador")
    )
    private Set<Trabajador> trabajadores;

}
