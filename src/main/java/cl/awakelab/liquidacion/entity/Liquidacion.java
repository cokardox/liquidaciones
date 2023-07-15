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
    @Column(name = "id_liquidacion")
    private long idLiquidacion;

    @ManyToOne
    @JoinColumn(name = "id_trabajador")
    private Trabajador trabajador;

    @Column(name = "periodo")
    private LocalDate periodo;

    @Column(name = "sueldo_imponible")
    private int sueldoImponible;

    @Column(name = "sueldo_liquido")
    private int sueldoLiquido;

    @ManyToOne
    @JoinColumn(name = "id_inst_salud")
    private InstitucionSalud institucionSalud;

    @Column(name = "monto_inst_salud")
    private int montoInstSalud;

    @ManyToOne
    @JoinColumn(name = "id_inst_previsional")
    private InstitucionPrevision institucionPrevisional;

    @Column(name = "monto_inst_previsional")
    private int montoInstPrevisional;

    @Column(name = "total_descuento")
    private int totalDescuento;

    @Column(name = "total_haberes")
    private int totalHaberes;

    @Column(name = "anticipo")
    private int anticipo;



}