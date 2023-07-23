package cl.awakelab.liquidacion.service.serviceimpl;
import cl.awakelab.liquidacion.entity.InstitucionSalud;
import cl.awakelab.liquidacion.repository.IInstitucionSaludRepository;
import cl.awakelab.liquidacion.service.IInstitucionSaludService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("InstitucionSaludimpl")
public class InstitucionSaludimpl implements IInstitucionSaludService {
    @Autowired
    IInstitucionSaludRepository objIsaludRepo;
    @Override
    public List<InstitucionSalud> listarInstitucionSalud() {

        return objIsaludRepo.findAll();
    }

    @Override
    public InstitucionSalud buscarSaludPorId(int idInstSalud) {
        return objIsaludRepo.findById(idInstSalud).orElseThrow(()->new IllegalArgumentException("Salud no encontrada"));
    }

}

