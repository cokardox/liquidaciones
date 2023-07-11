package cl.awakelab.liquidacion.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;

@Data
@Entity
@Table(name ="usuario")
public class Usuario {
    @Id
    @Column(name ="id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    @Column(name = "run")
    private int run;
    @Column(name = "clave")
    private String clave;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido_1")
    private String apellido1;
    @Column(name = "apellido_2")
    private  String apellido2;
    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;
    @Column(name = "telefono")
    private Long telefono;


}
