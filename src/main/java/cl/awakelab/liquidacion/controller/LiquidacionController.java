package cl.awakelab.liquidacion.controller;


import cl.awakelab.liquidacion.entity.*;
import cl.awakelab.liquidacion.service.IInstitucionPrevisionService;
import cl.awakelab.liquidacion.service.IInstitucionSaludService;
import cl.awakelab.liquidacion.service.ILiquidacionService;
import cl.awakelab.liquidacion.service.ITrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RequestMapping("/liquidacion")
@Controller
public class LiquidacionController {

    @Autowired
    ILiquidacionService objLiquidacionService;
    @Autowired
    ITrabajadorService objTrabajadorService;
    @Autowired
    IInstitucionPrevisionService objPrevisionService;
    @Autowired
    IInstitucionSaludService objSaludService;






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
        List<InstitucionPrevision> previsiones = objPrevisionService.listarInstitucionPrevision();
        List<InstitucionSalud> salud = objSaludService.listarInstitucionSalud();
        model.addAttribute("previsiones", previsiones);
        model.addAttribute("salud", salud);
        model.addAttribute("trabajadores", trabajadores);
        model.addAttribute("liquidacion", new Liquidacion());

        return "formLiquidacion";
    }

    @PostMapping("/crearLiquidacionr")
    public String crearLiquidacion(@ModelAttribute Liquidacion liquidacion,
                                  @RequestParam("TrabajadorId") int idTrabajador,
                                  @RequestParam("idPrevision") int idInstPrevision,
                                  @RequestParam("idSalud") int idInstSalud) {

        Trabajador trabajador = objTrabajadorService.buscarTrabajadorPorId(idTrabajador);
        InstitucionPrevision prevision = objPrevisionService.buscarPrevisionPorId(idInstPrevision);
        InstitucionSalud salud = objSaludService.buscarSaludPorId(idInstSalud);

        liquidacion.setTrabajador(trabajador);
        liquidacion.setInstitucionPrevisional(prevision);
        liquidacion.setInstitucionSalud(salud);

        objLiquidacionService.crearLiquidacion(liquidacion);

        return "redirect:/liquidacion/listLiquidacion";
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