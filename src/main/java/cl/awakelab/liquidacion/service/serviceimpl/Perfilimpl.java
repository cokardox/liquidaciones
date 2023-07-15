package cl.awakelab.liquidacion.service.serviceimpl;

import cl.awakelab.liquidacion.entity.Perfil;
import cl.awakelab.liquidacion.service.IPerfilService;
import org.springframework.stereotype.Service;

@Service("perfilimpl")
public class Perfilimpl implements IPerfilService {
    @Override
    public Perfil obtenerPerfilPorId(int i) {
        return null;
    }

    @Override
    public Perfil obtenerPerfilPorDescripcion(String descripcion) {
        return null;
    }
}
