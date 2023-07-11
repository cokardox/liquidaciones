package cl.awakelab.liquidacion.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "perfil")
public class Perfil {
    @Id
    @Column(name = "id_perfil")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPerfil;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private int estado;
}
