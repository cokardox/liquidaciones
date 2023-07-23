package cl.awakelab.liquidacion.controller;


import cl.awakelab.liquidacion.service.ILiquidacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/liquidacion")
@Controller
public class LiquidacionController {

    @Autowired
    ILiquidacionService objLiquidacionService;



    // ELIMINAR LIQUIDACION

    @PostMapping("/eliminar/{idLiquidacion}")
    public String eliminarLiquidacionPorId(@PathVariable long idLiquidacion) {
        objLiquidacionService.eliminarLiquidacion(idLiquidacion);
        return "redirect:/liquidacion/listLiquiacion";
    }

}