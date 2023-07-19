package cl.awakelab.liquidacion.service.serviceimpl;

import cl.awakelab.liquidacion.entity.InstitucionPrevision;
import cl.awakelab.liquidacion.service.IInstitucionPrevisionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("InstitucionPrevisionimpl")
public class InstitucionPrevisionimpl implements IInstitucionPrevisionService {
    @Override
    public List<InstitucionPrevision> listarInstitucionPrevision() {
        return null;
    }

    @Override
    public InstitucionPrevision buscarPrevisionPorId(int idInstPrevision) {
        return null;
    }
}
