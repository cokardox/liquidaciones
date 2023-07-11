package cl.awakelab.liquidacion.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name ="trabajador")
public class Trabajador {
    @Id
    @Column(name = "id_trabajador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idTrabajador;
    @Column(name = "run")
    private int run;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido_1")
    private String apellido1;
    @Column(name = "apellido_2")
    private String apellido2;
    @Column(name = "email")
    private String email;
    @ManyToOne
    @JoinColumn(name = "id_inst_prevision")
    private InstitucionPrevision institucionPrevision;

    @ManyToOne
    @JoinColumn(name = "id_inst_salud")
    private InstitucionSalud institucionSalud;

    @Column(name = "telefono")
    private Long telefono;






    @ManyToMany(mappedBy = "trabajadores")
    private Set<Empleador> empleadores;

}
