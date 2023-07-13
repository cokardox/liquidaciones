package cl.awakelab.liquidacion.service;

import cl.awakelab.liquidacion.entity.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> listarUsuarios ();
    Usuario crearUsuario(Usuario usuario);
    Usuario buscarUsuarioPorId(int idUsuario);
    Usuario actualizarUsuario(Usuario usuario, int idUsuario);
    public void eliminarUsuario(Usuario usuario);

}






