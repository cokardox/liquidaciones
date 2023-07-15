package cl.awakelab.liquidacion.service;

import cl.awakelab.liquidacion.entity.Perfil;

public interface IPerfilService {
    Perfil obtenerPerfilPorId(int i);

    Perfil obtenerPerfilPorDescripcion(String descripcion);
}
