package cl.awakelab.liquidacion.repository;

import cl.awakelab.liquidacion.entity.Liquidacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILiquidacionRepository extends JpaRepository <Liquidacion, Long> {
}
