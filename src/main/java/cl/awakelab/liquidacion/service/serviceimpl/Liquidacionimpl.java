package cl.awakelab.liquidacion.service.serviceimpl;
import cl.awakelab.liquidacion.repository.ILiquidacionRepository;
import cl.awakelab.liquidacion.entity.Liquidacion;
import cl.awakelab.liquidacion.service.ILiquidacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("Liquidacionimpl")
public class Liquidacionimpl implements ILiquidacionService {

    @Autowired
    ILiquidacionRepository objLiquidacionRepo;

    @Override
    public List<Liquidacion> listarLiquidaciones() {
        return objLiquidacionRepo.findAll();
    }
    @Override
    public Liquidacion actualizarLiquidacion(Liquidacion liquidacion, long idLiquidacion) {
        return null;
    }

   @Override
    public void eliminarLiquidacion(long idLiquidacion) {
        objLiquidacionRepo.deleteById(idLiquidacion);


    }

    @Override
    public Liquidacion buscarLiquidacionPorId(long idLiquidacion) {
        return objLiquidacionRepo.findById(idLiquidacion).orElseThrow(() -> new NoSuchElementException("Liquidacion no encontrador"));
    }

    @Override
    public Liquidacion crearLiquidacion(Liquidacion liquidacion) {
        return objLiquidacionRepo.save(liquidacion);
    }


    }
