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
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    @Column
    private int run;
    @Column
    private String clave;
    @Column
    private String nombre;
    @Column
    private String apellido1;
    @Column
    private  String apellido2;
    @Column
    private LocalDate fecha_creacion;
    @Column
    private Long telefono;


}
