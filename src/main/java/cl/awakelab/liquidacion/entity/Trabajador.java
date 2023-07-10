package cl.awakelab.liquidacion.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="trabajador")
public class Trabajador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column int idTrabajador;




}
