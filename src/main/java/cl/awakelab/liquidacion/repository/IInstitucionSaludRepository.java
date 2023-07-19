package cl.awakelab.liquidacion.repository;

import cl.awakelab.liquidacion.entity.InstitucionSalud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInstitucionSaludRepository extends JpaRepository <InstitucionSalud , Integer> {
}
