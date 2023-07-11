package cl.awakelab.liquidacion.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name ="usuario")
public class Usuario {
    @Id
    @Column(name ="id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    @Column(name = "run", unique = true)
    private int run;

    @Column(name = "clave")
    private String clave;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido_1")
    private String apellido1;

    @Column(name = "apellido_2")
    private String apellido2;

    @ManyToOne
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;

    @Column(name = "email")
    private String email;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "telefono")
    private long telefono;


}
