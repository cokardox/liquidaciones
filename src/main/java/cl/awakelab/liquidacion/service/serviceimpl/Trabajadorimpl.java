package cl.awakelab.liquidacion.service.serviceimpl;
import cl.awakelab.liquidacion.entity.Trabajador;
import cl.awakelab.liquidacion.repository.ITrabajadorRepository;
import cl.awakelab.liquidacion.service.ITrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("TrabajadorImpl")
public class Trabajadorimpl implements ITrabajadorService {

    @Autowired
    ITrabajadorRepository objTrabajadorRepository;
    @Override
    public List<Trabajador> listarTrabajadores() {return objTrabajadorRepository.findAll();}
    @Override
    public Trabajador crearTrabajador(Trabajador trabajador) {
        return objTrabajadorRepository.save(trabajador);
    }

    @Override
    public Trabajador buscarTrabajadorPorId(int idTrabajador) {
        return objTrabajadorRepository.findById(idTrabajador).orElseThrow(() -> new NoSuchElementException("Trabajador no encontrador"));
    }


    @Override
    public Trabajador actualizarTrabajador(Trabajador trabajadorActualizar, int idTrabajador) {
        Trabajador trabajador = objTrabajadorRepository.findById(idTrabajador).orElseThrow(() -> new NoSuchElementException("Trabajador no"));
        trabajador.setRun(trabajadorActualizar.getRun());
        trabajador.setNombre(trabajadorActualizar.getNombre());
        trabajador.setApellido1(trabajadorActualizar.getApellido1());
        trabajador.setApellido2(trabajadorActualizar.getApellido2());
        trabajador.setEmail(trabajadorActualizar.getEmail());
        trabajador.setInstitucionPrevision(trabajadorActualizar.getInstitucionPrevision());
        trabajador.setInstitucionSalud(trabajadorActualizar.getInstitucionSalud());
        trabajador.setTelefono(trabajadorActualizar.getTelefono());
        return objTrabajadorRepository.save(trabajador);
    }
    @Override
    public void eliminarTrabajador(int idTrabajador) { objTrabajadorRepository.deleteById(idTrabajador); }



}
