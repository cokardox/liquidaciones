package cl.awakelab.liquidacion.service.serviceimpl;

import cl.awakelab.liquidacion.entity.Empleador;
import cl.awakelab.liquidacion.entity.Trabajador;
import cl.awakelab.liquidacion.repository.ITrabajadorRepository;
import cl.awakelab.liquidacion.repository.IUsuarioRepository;
import cl.awakelab.liquidacion.service.ITrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return null;
    }

    @Override
    public Trabajador actualizarTrabajador(Trabajador trabajador, int idTrabajador) {
        return null;
    }


    @Override
    public void eliminarTrabajador(int idTrabajador) { objTrabajadorRepository.deleteById(idTrabajador); }



}
