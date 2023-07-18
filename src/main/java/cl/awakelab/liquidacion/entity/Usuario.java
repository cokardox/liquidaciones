package cl.awakelab.liquidacion.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;

    @Column(name = "email")
    private String email;

    @Column(name = "fecha_creacion")
    @CreationTimestamp
    private LocalDateTime fechaCreacion;

    @Column(name = "telefono")
    private long telefono;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL) //hace referencia al atributo tipo Usuario de la clase empleador
    private List<Empleador> empleadores;







}
