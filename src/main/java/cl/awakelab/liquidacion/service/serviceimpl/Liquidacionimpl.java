package cl.awakelab.liquidacion.service.serviceimpl;
import cl.awakelab.liquidacion.entity.InstitucionPrevision;
import cl.awakelab.liquidacion.entity.InstitucionSalud;
import cl.awakelab.liquidacion.repository.ILiquidacionRepository;
import cl.awakelab.liquidacion.entity.Liquidacion;
import cl.awakelab.liquidacion.service.IInstitucionPrevisionService;
import cl.awakelab.liquidacion.service.IInstitucionSaludService;
import cl.awakelab.liquidacion.service.ILiquidacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service("Liquidacionimpl")
public class Liquidacionimpl implements ILiquidacionService {

    @Autowired
    ILiquidacionRepository objLiquidacionRepo;
    @Autowired
    IInstitucionSaludService objInstitucionSaludService;
    @Autowired
    IInstitucionPrevisionService objInstitucionPrevisionService;


    @Override
    public List<Liquidacion> listarLiquidaciones() {
        return objLiquidacionRepo.findAll();
    }

    @Override
    public Liquidacion actualizarLiquidacion(Liquidacion liquidacionActualizar, long idLiquidacion) {
            Liquidacion liquidacion = objLiquidacionRepo.findById(idLiquidacion).orElseThrow(() -> new NoSuchElementException("Liquidación no encontrada"));
            liquidacion.setTrabajador(liquidacionActualizar.getTrabajador());
            liquidacion.setPeriodo(liquidacionActualizar.getPeriodo());
            liquidacion.setSueldoImponible(liquidacionActualizar.getSueldoImponible());
            liquidacion.setSueldoLiquido(liquidacionActualizar.getSueldoLiquido());
            liquidacion.setInstitucionSalud(liquidacionActualizar.getInstitucionSalud());
            liquidacion.setMontoInstSalud(liquidacionActualizar.getMontoInstSalud());
            liquidacion.setInstitucionPrevisional(liquidacionActualizar.getInstitucionPrevisional());
            liquidacion.setMontoInstPrevisional(liquidacionActualizar.getMontoInstPrevisional());
            liquidacion.setTotalDescuento(liquidacionActualizar.getTotalDescuento());
            liquidacion.setTotalHaberes(liquidacionActualizar.getTotalHaberes());
            liquidacion.setAnticipo(liquidacionActualizar.getAnticipo());
            return objLiquidacionRepo.save(liquidacion);
        }


   @Override
    public void eliminarLiquidacion(long idLiquidacion) {
        objLiquidacionRepo.deleteById(idLiquidacion);
    }

    @Override
    public Liquidacion buscarLiquidacionPorId(long idLiquidacion) {
        return objLiquidacionRepo.findById(idLiquidacion).orElseThrow(() -> new NoSuchElementException("Liquidacion no encontrador"));
    }

    @Override
    public Liquidacion crearLiquidacion(Liquidacion liquidacion) {
        return objLiquidacionRepo.save(liquidacion);
    }

    @Override
    public Liquidacion calcularSueldo(Liquidacion liquidacion) {

        InstitucionSalud institucionSalud = objInstitucionSaludService.buscarSaludPorId(liquidacion.getInstitucionSalud().getIdInstSalud());
        InstitucionPrevision institucionPrevisional = objInstitucionPrevisionService.buscarPrevisionPorId(liquidacion.getInstitucionPrevisional().getIdInstPrevision());


        liquidacion.setInstitucionSalud(institucionSalud);
        liquidacion.setInstitucionPrevisional(institucionPrevisional);


        // calculando los dscto

        float descuentoSalud = liquidacion.getSueldoImponible() * (institucionSalud.getPorcDcto() /100);
        float descuentoAFP = liquidacion.getSueldoImponible() * (institucionPrevisional.getPorcDcto() /100);


        //actualizando los campos correspondiente en la liquidacion

        liquidacion.setMontoInstSalud((int) descuentoSalud);
        liquidacion.setMontoInstPrevisional((int) descuentoAFP);


        // guardando los descuentos en una variable destinada descuento total de la tabla liquidacion
        float descuentoTotal = (descuentoAFP + descuentoAFP);
        liquidacion.setTotalDescuento((int) descuentoTotal);
        // seteando el total haberes
        liquidacion.setTotalHaberes(liquidacion.getSueldoImponible());

        // Calcular el sueldo liquido

        int sueldoLiquido = liquidacion.getSueldoImponible() - (int)(descuentoSalud + descuentoAFP) - liquidacion.getAnticipo();

        liquidacion.setSueldoLiquido(sueldoLiquido);



        // Establecer el campo "periodo" con la fecha local actual
        liquidacion.setPeriodo(LocalDate.now());

        //Guardar la Liquidacion

        objLiquidacionRepo.save(liquidacion);




        return liquidacion;
    }


}
