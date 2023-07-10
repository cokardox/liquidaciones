package cl.awakelab.liquidacion.entity;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@Table(name="institucion_salud")
public class InstitucionSalud {

    @Id
    @Column(name = "id_inst_salud")
    private int idInstSalud;

    @Column
    private String descripcion;

    @Column
    private float porcDcto;
}
