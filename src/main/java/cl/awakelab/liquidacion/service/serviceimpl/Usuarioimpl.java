package cl.awakelab.liquidacion.service.serviceimpl;
import cl.awakelab.liquidacion.entity.Usuario;
import cl.awakelab.liquidacion.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import cl.awakelab.liquidacion.service.IUsuarioService;

@Service("usuarioImpl")
public class Usuarioimpl implements IUsuarioService {

    @Autowired
    IUsuarioRepository objUsuarioRepo;
    @Override
    public List<Usuario> listarUsuarios() {
        return objUsuarioRepo.findAll();
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return objUsuarioRepo.save(usuario);
    }

    @Override
    public Usuario buscarUsuarioPorId(int idUsuario) {
        return objUsuarioRepo.findById(idUsuario).orElseThrow(()-> new NoSuchElementException("usuario no encontrado"));

    }

    @Override
    public Usuario actualizarUsuario(Usuario usuarioActualizar, int idUsuario) {
        Usuario usuario = objUsuarioRepo.findById(idUsuario).orElseThrow(() -> new NoSuchElementException("Usuario no encontrado"));
        usuario.setRun(usuarioActualizar.getRun());
        usuario.setNombre(usuarioActualizar.getNombre());
        usuario.setClave(usuarioActualizar.getClave());
        usuario.setApellido1(usuarioActualizar.getApellido1());
        usuario.setApellido2(usuarioActualizar.getApellido2());
        usuario.setEmail(usuarioActualizar.getEmail());
        usuario.setTelefono(usuarioActualizar.getTelefono());
        return objUsuarioRepo.save(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {

    }
    @Override
    public void eliminarUsuario2(int idUsuario) {
        objUsuarioRepo.deleteById(idUsuario);
    }
}


