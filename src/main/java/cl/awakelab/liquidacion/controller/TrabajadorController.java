package cl.awakelab.liquidacion.controller;

import cl.awakelab.liquidacion.entity.*;
import cl.awakelab.liquidacion.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/trabajador")
@Controller
public class TrabajadorController {
    @Autowired
    ITrabajadorService objTrabajadorService;
    @Autowired
    IInstitucionPrevisionService objPrevisionService;
    @Autowired
    IInstitucionSaludService objSaludService;
    @Autowired
    IEmpleadorService   objEmpleadorService;


    // LISTAR EMPLEADOR

    @GetMapping("/listTrabajador")
    public String listarTrabajadores(Model model){
        List<Trabajador> listarTrabajadores= objTrabajadorService.listarTrabajadores();
        model.addAttribute("trabajadores", listarTrabajadores);
        return "listTrabajador";
    }


    // ELIMINAR TRABAJADOR

    @PostMapping("/eliminar/{idTrabajador}")
    public String eliminarTrabajadorPorId(@PathVariable int idTrabajador) {
        objTrabajadorService.eliminarTrabajador(idTrabajador);
        return "redirect:/trabajador/listTrabajador";
    }

    @GetMapping("/{idTrabajador}/eliminar")
    public String mostrarEliminarTrabajador(@PathVariable int idTrabajador, Model model) {
        Trabajador trabajadorEliminar = objTrabajadorService.buscarTrabajadorporId(idTrabajador);
        model.addAttribute("empleador", trabajadorEliminar);
        return "eliminarTrabajador";


    }

    // CREAR TRABAJADOR

    @GetMapping("/crearTrabajador")
    public String mostrarFormularioCrearTrabajador(Model model) {
        List<Empleador> empleadores = objEmpleadorService.listarEmpleadores();
        model.addAttribute("empleadores", empleadores);
        model.addAttribute("trabajador", new Trabajador());
        return "formTrabajador";
    }

    @PostMapping("/actualizar/{idTrabajador}")
    public String actualizarTrabajador(@ModelAttribute Trabajador trabajador, @PathVariable int idTrabajador,
                                       @RequestParam("previsionId") int previsionId,
                                       @RequestParam("saludId") int saludId){
        InstitucionPrevision prevision = objPrevisionService.buscarPrevisionPorId(previsionId);
        InstitucionSalud salud = objSaludService.buscarSaludPorId(saludId);
        trabajador.setInstPrevision(prevision);
        trabajador.setInstSalud(salud);
        objTrabajadorService.actualizarTrabajador(trabajador, idTrabajador);
        return "redirect:/trabajador";
    }



    // ACTUALIZAR TRABAJADOR


}