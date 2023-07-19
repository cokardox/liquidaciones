package cl.awakelab.liquidacion.service.serviceimpl;

import cl.awakelab.liquidacion.entity.InstitucionSalud;
import cl.awakelab.liquidacion.repository.IInstitucionSaludRepository;
import cl.awakelab.liquidacion.service.IInstitucionSaludService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("InstitucionSaludimpl")
public class InstitucionSaludimpl implements IInstitucionSaludService {
    @Autowired
    IInstitucionSaludRepository objIsaludRepo;
    @Override
    public List<InstitucionSalud> listarInstitucionSalud() {
        return null;
    }

    @Override
    public InstitucionSalud buscarSaludPorId(int idInstSalud) {
        return null;
    }

}
