package cl.awakelab.liquidacion.repository;

import cl.awakelab.liquidacion.entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPerfilRepository extends JpaRepository <Perfil, Integer>{
}
