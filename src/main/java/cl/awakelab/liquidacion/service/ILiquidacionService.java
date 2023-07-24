package cl.awakelab.liquidacion.service;

import cl.awakelab.liquidacion.entity.Liquidacion;


import java.util.List;

public interface ILiquidacionService {

    List<Liquidacion> listarLiquidaciones ();

    Liquidacion actualizarLiquidacion(Liquidacion liquidacion, long idLiquidacion);
    public void eliminarLiquidacion(long idLiquidacion);
    Liquidacion buscarLiquidacionPorId(long idLiquidacion);

    Liquidacion crearLiquidacion(Liquidacion liquidacion);

    Liquidacion calcularSueldo(Liquidacion liquidacion);



}
