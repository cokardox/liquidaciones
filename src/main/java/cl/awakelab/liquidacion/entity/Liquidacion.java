package cl.awakelab.liquidacion.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "liquidacion")
public class Liquidacion {
    @Id
    @Column
    private long idLiquidacion;

    @ManyToOne
    @JoinColumn
    private Trabajador trabajador;

    @Column
    private LocalDate periodo;

    @Column
    private int sueldoImponible;

    @Column
    private int sueldoLiquido;

    @ManyToOne
    @JoinColumn
    private InstitucionSalud institucionSalud;

    @Column
    private int montoInstSalud;

    @ManyToOne
    @JoinColumn
    private InstitucionPrevision institucionPrevisional;

    @Column
    private int montoInstPrevisional;

    @Column
    private int totalDescuento;

    @Column
    private int totalHaberes;

    @Column
    private int anticipo;
}