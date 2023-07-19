package cl.awakelab.liquidacion.service;

import cl.awakelab.liquidacion.entity.InstitucionPrevision;
import cl.awakelab.liquidacion.entity.InstitucionSalud;

import java.util.List;

public interface IInstitucionSaludService {
    List<InstitucionSalud> listarInstitucionSalud();
    InstitucionSalud buscarSaludPorId(int idInstSalud);

}
