package cl.awakelab.liquidacion.service.serviceimpl;
import cl.awakelab.liquidacion.entity.InstitucionPrevision;
import cl.awakelab.liquidacion.repository.IInstitucionPrevisionRepository;
import cl.awakelab.liquidacion.service.IInstitucionPrevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("InstitucionPrevisionimpl")
public class InstitucionPrevisionimpl implements IInstitucionPrevisionService {
    @Autowired
    IInstitucionPrevisionRepository objInstitucionPrevisionRepository;
    @Override
    public List<InstitucionPrevision> listarInstitucionPrevision() {
        return objInstitucionPrevisionRepository.findAll();
    }

    @Override
    public InstitucionPrevision buscarPrevisionPorId(int idInstPrevision) {
        return objInstitucionPrevisionRepository.findById(idInstPrevision).orElseThrow(()->new NoSuchElementException("prevision no encontrada"));
    }
}
