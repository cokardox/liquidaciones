package cl.awakelab.liquidacion.repository;

import cl.awakelab.liquidacion.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {
}
