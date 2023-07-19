package cl.awakelab.liquidacion.repository;

import cl.awakelab.liquidacion.entity.Trabajador;
import cl.awakelab.liquidacion.service.ITrabajadorService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrabajadorRepository extends JpaRepository <Trabajador, Integer> {
}
