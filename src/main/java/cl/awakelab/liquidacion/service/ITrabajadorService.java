package cl.awakelab.liquidacion.service;

import cl.awakelab.liquidacion.entity.Empleador;
import cl.awakelab.liquidacion.entity.Trabajador;

import java.util.List;

public interface ITrabajadorService {

    List<Trabajador> listarTrabajadores ();

    Trabajador buscarTrabajadorPorId(int idTrabajador);
    Trabajador actualizarTrabajador(Trabajador trabajador, int idTrabajador);
    public void eliminarTrabajador(int idTrabajador);
    Trabajador buscarTrabajadorporId(int idTrabajador);
}




