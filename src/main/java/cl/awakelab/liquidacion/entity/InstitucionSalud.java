package cl.awakelab.liquidacion.entity;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="institucion_salud")
public class InstitucionSalud {

    @Id
    @Column(name = "id_inst_salud")
    private int idInstSalud;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "porc_dcto")
    private float porcDcto;


    @OneToMany(mappedBy = "institucionSalud")
    List<Trabajador> listaTrabajadores;

    @OneToMany(mappedBy = "institucionSalud")
    List<Liquidacion> liquidacionesSalud;

}
