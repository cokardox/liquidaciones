package cl.awakelab.liquidacion.repository;

import cl.awakelab.liquidacion.entity.InstitucionPrevision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInstitucionPrevisionRepository extends JpaRepository<InstitucionPrevision , Integer> {
}
