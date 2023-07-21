package cl.awakelab.liquidacion.controller;

import cl.awakelab.liquidacion.entity.*;
import cl.awakelab.liquidacion.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
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
        Trabajador trabajadorEliminar = objTrabajadorService.buscarTrabajadorPorId(idTrabajador);
        model.addAttribute("empleador", trabajadorEliminar);
        return "eliminarTrabajador";


    }

    // CREAR TRABAJADOR
    @GetMapping("/crearTrabajador")
    public String mostrarFormularioCrearTrabajador(Model model) {
        List<Empleador> empleadores = objEmpleadorService.listarEmpleadores();
        List<InstitucionPrevision> previsiones = objPrevisionService.listarInstitucionPrevision();
        List<InstitucionSalud> salud = objSaludService.listarInstitucionSalud();

        model.addAttribute("empleadores", empleadores);
        model.addAttribute("idInstPrevision", previsiones); // Cambiar "previsiones" a "idInstPrevision"
        model.addAttribute("idInstSalud", salud); // Cambiar "salud" a "idInstSalud"
        model.addAttribute("trabajador", new Trabajador());

        return "formTrabajador";
    }

    @PostMapping("/crearTrabajador")
    public String crearTrabajador(@ModelAttribute Trabajador trabajador,
                                  @RequestParam("empleadorId") int idEmpleador,
                                  @RequestParam("idInstPrevision") int idInstPrevision,
                                  @RequestParam("idInstSalud") int idInstSalud) {

        Empleador empleador = objEmpleadorService.buscarEmpleadorPorId(idEmpleador);
        InstitucionPrevision prevision = objPrevisionService.buscarPrevisionPorId(idInstPrevision);
        InstitucionSalud salud = objSaludService.buscarSaludPorId(idInstSalud);

        trabajador.setListaEmpleadores(Collections.singletonList(empleador));
        trabajador.setInstitucionPrevision(prevision);
        trabajador.setInstitucionSalud(salud);

        objTrabajadorService.crearTrabajador(trabajador);

        return "redirect:/trabajador/listTrabajador";
    }








    // ACTUALIZAR TRABAJADOR

    @PostMapping("/actualizar/{idTrabajador}")
    public String actualizarTrabajador(@ModelAttribute Trabajador trabajador, @PathVariable int idTrabajador,
                                       @RequestParam("idInstPrevision") int idInstPrevision,
                                       @RequestParam("idInstSalud") int idInstSalud) {
        InstitucionPrevision prevision = objPrevisionService.buscarPrevisionPorId(idInstPrevision);
        InstitucionSalud salud = objSaludService.buscarSaludPorId(idInstSalud);

        trabajador.setInstitucionPrevision(prevision);
        trabajador.setInstitucionSalud(salud);

        objTrabajadorService.actualizarTrabajador(trabajador, idTrabajador);

        return "redirect:/trabajador";
    }
    @GetMapping("/{idTrabajador}/editar")
    public String mostrarFormularioEditarTrabajador(@PathVariable int idTrabajador, Model model) {
        Trabajador trabajadorEditar = objTrabajadorService.buscarTrabajadorPorId(idTrabajador);
        List<Empleador> empleadores = objEmpleadorService.listarEmpleadores();
        List<InstitucionPrevision> previsiones = objPrevisionService.listarInstitucionPrevision();
        List<InstitucionSalud> salud = objSaludService.listarInstitucionSalud();

        model.addAttribute("empleadores", empleadores);
        model.addAttribute("previsiones", previsiones);
        model.addAttribute("salud", salud);
        model.addAttribute("trabajador", trabajadorEditar);

        return "editarTrabajador";
    }

}