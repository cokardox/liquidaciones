package cl.awakelab.liquidacion.service.serviceimpl;
import cl.awakelab.liquidacion.entity.Empleador;
import cl.awakelab.liquidacion.entity.Usuario;
import cl.awakelab.liquidacion.repository.IEmpleadorRepository;
import cl.awakelab.liquidacion.service.IEmpleadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
@Service("empleadorimpl")
public class Empleadorimpl implements IEmpleadorService {

    @Autowired
    IEmpleadorRepository objEmpleadorRepo;
    @Override
    public List<Empleador> listarEmpleadores() {
        return objEmpleadorRepo.findAll();
    }

    @Override
    public Empleador crearEmpleador(Empleador empleador) {
        return objEmpleadorRepo.save(empleador);
    }

    @Override
    public Empleador buscarEmpleadorPorId(int idEmpleador) {
        return objEmpleadorRepo.findById(idEmpleador).orElseThrow(()-> new NoSuchElementException("usuario no encontrado"));

    }

    @Override
    public Empleador actualizarEmpleador(Empleador empleadorActualizar, int idEmpleador) {
        Empleador empleador = objEmpleadorRepo.findById(idEmpleador).orElseThrow(() -> new NoSuchElementException("Empleador no encontrado"));
        empleador.setRun(empleadorActualizar.getRun());
        empleador.setNombre(empleadorActualizar.getNombre());
        empleador.setApellido1(empleadorActualizar.getApellido1());
        empleador.setApellido2(empleadorActualizar.getApellido2());
        empleador.setDireccion(empleadorActualizar.getDireccion());
        empleador.setEmail(empleadorActualizar.getEmail());
        empleador.setTelefono(empleadorActualizar.getTelefono());
        empleador.setUsuario(empleadorActualizar.getUsuario());
        empleador.setTrabajadores(empleadorActualizar.getTrabajadores());
        return objEmpleadorRepo.save(empleador);
    }

    @Override
    public void eliminarEmpleador(Empleador empleador) {

    }
    @Override
    public void eliminarEmpleador2(int idEmpleador) {
        objEmpleadorRepo.deleteById(idEmpleador);
    }

    @Override
    public void eliminarEmpleador(int idEmpleador) {

        objEmpleadorRepo.deleteById(idEmpleador);
    }

    @Override
    public Empleador buscarEmpleadorporId(int idEmpleador) {
        return objEmpleadorRepo.findById(idEmpleador).orElseThrow(() -> new NoSuchElementException("Empleador no encontrado"));
    }
}


