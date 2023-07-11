package cl.awakelab.liquidacion.service.serviceimpl;
import cl.awakelab.liquidacion.entity.Usuario;
import cl.awakelab.liquidacion.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import cl.awakelab.liquidacion.service.IUsuarioService;

@Service
public class Usuarioimpl implements IUsuarioService {
    @Autowired //inyeccion de repositorio y proporcionara la instancia correspondiente
    IUsuarioRepository objUsuarioRepo;//objUsuarioRepo es una instancia de la interfaz IUsuarioRepository
    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return objUsuarioRepo.save(usuario);
    }
    @Override
    public List<Usuario> listarUsuarios() {
        return objUsuarioRepo.findAll();
    }
    @Override
    public Usuario buscarUsuarioPorId(int idUsuario) {
        return objUsuarioRepo.findById(idUsuario).orElseThrow(() -> new NoSuchElementException("Usuario no encontrado"));//si no lo encuentra arroja una exepcion
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuarioActualizar) {
        Usuario usuario = objUsuarioRepo.findById(usuarioActualizar.getIdUsuario()).orElseThrow(()->new NoSuchElementException("Usuario no encontrado"));
        usuario.setRut(usuarioActualizar.getRut());
        usuario.setContrasenia(usuarioActualizar.getContrasenia());
        usuario.setRol(usuarioActualizar.getRol());
        return objUsuarioRepo.save(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        objUsuarioRepo.delete(usuario);
    }



}


