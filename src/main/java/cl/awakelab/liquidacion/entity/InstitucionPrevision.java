package cl.awakelab.liquidacion.entity;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "institucion_prevision")
public class InstitucionPrevision {
    @Id
    @Column(name = "id_inst_prevision")
    private int idInstPrevision;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "porc_dcto")
    private float porcDcto;


}