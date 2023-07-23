package cl.awakelab.liquidacion.controller;


import cl.awakelab.liquidacion.entity.Empleador;
import cl.awakelab.liquidacion.entity.Liquidacion;
import cl.awakelab.liquidacion.entity.Trabajador;
import cl.awakelab.liquidacion.entity.Usuario;
import cl.awakelab.liquidacion.service.ILiquidacionService;
import cl.awakelab.liquidacion.service.ITrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/liquidacion")
@Controller
public class LiquidacionController {

    @Autowired
    ILiquidacionService objLiquidacionService;

    @Autowired
    ITrabajadorService objTrabajadorService;





    // LISTAR LIQUIDACION
     @GetMapping("/listLiquidacion")
     public String listarliquidaciones(Model model){
         List<Liquidacion> listarLiquidaciones = objLiquidacionService.listarLiquidaciones();
         model.addAttribute("liquidaciones", listarLiquidaciones);
         return "listLiquidacion";
     }






    // ELIMINAR LIQUIDACION

    @PostMapping("/eliminar/{idLiquidacion}")
    public String eliminarLiquidacionPorId(@PathVariable long idLiquidacion) {
        objLiquidacionService.eliminarLiquidacion(idLiquidacion);
        return "redirect:/liquidacion/listLiquiacion";
    }


    // CREAR LIQUIDACION


    @GetMapping("/crearLiquidacion")
    public String mostrarFormularioCrearLiquidacion(Model model) {
        List<Trabajador> trabajadores = objTrabajadorService.listarTrabajadores();
        model.addAttribute("trabajadores", trabajadores);
        model.addAttribute("liquidacion", new Liquidacion());
        return "formEmpleador";
    }


    /*
    @PostMapping("/crearEmpleador")
    public String crearEmpleador(@ModelAttribute Empleador empleador,
                                 @RequestParam("usuarioId") int usuarioId) {
        Usuario usuario = objUsuarioService.buscarUsuarioPorId(usuarioId);
        empleador.setUsuario(usuario);
        objEmpleadorService.crearEmpleador(empleador);
        return "redirect:/empleador/listEmpleador";
    }
*/
}