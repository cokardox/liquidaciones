package cl.awakelab.liquidacion.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name ="trabajador")
public class Trabajador {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idTrabajador;
    @Column
    private int run;
    @Column
    private String nombre;
    @Column
    private String apellido1;
    @Column
    private String apellido2;
    @Column
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
