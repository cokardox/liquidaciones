package cl.awakelab.liquidacion.service;

import cl.awakelab.liquidacion.entity.Empleador;

import java.util.List;

public interface IEmpleadorService {
    List<Empleador> listarEmpleadores ();
    Empleador crearEmpleador(Empleador empleador);
    Empleador buscarEmpleadorPorId(int idEmpleador);
    Empleador actualizarEmpleador(Empleador empleador, int idEmpleador);
    public void eliminarEmpleador(Empleador empleador);
    public void eliminarEmpleador2(int idEmpleador);

}
