package cl.awakelab.liquidacion.service;

import cl.awakelab.liquidacion.entity.Empleador;
import cl.awakelab.liquidacion.entity.InstitucionPrevision;

import java.util.List;

public interface IInstitucionPrevisionService {

    List<InstitucionPrevision> listarInstitucionPrevision ();
    InstitucionPrevision buscarPrevisionPorId(int idInstPrevision);
}
