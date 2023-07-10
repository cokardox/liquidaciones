package cl.awakelab.liquidacion.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name ="trabajador")
public class Trabajador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column int idTrabajador;



    @ManyToMany(mappedBy = "trabajadores")
    private Set<Empleador> empleadores;

}
