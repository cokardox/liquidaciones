package cl.awakelab.liquidacion.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "perfil")
public class Perfil {
    @Id
    @Column(name = "id_perfil")

    private int idPerfil;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private int estado;

    @OneToMany(mappedBy = "perfil")
    private List<Usuario> usuarios;
}
