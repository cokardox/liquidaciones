package cl.awakelab.liquidacion.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "empleador")
public class Empleador {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpleador;
    @Column
    private int run;
    @Column
    private String nombre;
    @Column
    private String apellido1;
    @Column
    private String apellido2;
    @Column
    private String direccion;
    @Column
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
