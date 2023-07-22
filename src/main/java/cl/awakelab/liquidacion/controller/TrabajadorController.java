package cl.awakelab.liquidacion.controller;
import cl.awakelab.liquidacion.entity.InstitucionPrevision;
import cl.awakelab.liquidacion.entity.InstitucionSalud;
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
    IEmpleadorService objEmpleadorService;


    // LISTAR EMPLEADOR

    @GetMapping("/listTrabajador")
    public String listarTrabajadores(Model model) {
        List<Trabajador> listarTrabajadores = objTrabajadorService.listarTrabajadores();
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
        model.addAttribute("previsiones", previsiones);
        model.addAttribute("salud", salud);
        model.addAttribute("trabajador", new Trabajador());

        return "formTrabajador";
    }


    @PostMapping("/crearTrabajador")
    public String crearTrabajador(@ModelAttribute Trabajador trabajador,
                                  @RequestParam("empleadorId") int idEmpleador,
                                  @RequestParam("idPrevision") int idInstPrevision,
                                  @RequestParam("idSalud") int idInstSalud) {

        Empleador empleador = objEmpleadorService.buscarEmpleadorPorId(idEmpleador);
        InstitucionPrevision prevision = objPrevisionService.buscarPrevisionPorId(idInstPrevision);
        InstitucionSalud salud = objSaludService.buscarSaludPorId(idInstSalud);

        trabajador.setListaEmpleadores(Collections.singletonList(empleador));
        trabajador.setInstitucionPrevision(prevision);
        trabajador.setInstitucionSalud(salud);

        objTrabajadorService.crearTrabajador(trabajador);

        return "redirect:/trabajador/listTrabajador";
    }


    // ACTUALIZAR TRABAJADOR oscar



    @GetMapping("/{idTrabajador}")
    public String buscarTrabajadorPorId(@PathVariable int idTrabajador, Model model){
        Trabajador trabajador = objTrabajadorService.buscarTrabajadorPorId(idTrabajador);
        model.addAttribute("trabajador", trabajador);
        return "redirect:/trabajador";
    }


   // ACTUALIZAR TRABAJADOR V2

  /*
    @PostMapping("/actualizar/{idTrabajador}")
    public String actualizarTrabajador(@ModelAttribute Trabajador trabajador, @PathVariable int idTrabajador,
                                       @RequestParam("idPrevision") int idPrevision,
                                       @RequestParam("idSalud") int idSalud,
                                       @RequestParam("empleadorId") int idEmpleador) {
        InstitucionPrevision prevision = objPrevisionService.buscarPrevisionPorId(idPrevision);
        InstitucionSalud salud = objSaludService.buscarSaludPorId(idSalud);
        Empleador empleador = objEmpleadorService.buscarEmpleadorPorId(idEmpleador);

        trabajador.setInstitucionPrevision(prevision);
        trabajador.setInstitucionSalud(salud);
        trabajador.setListaEmpleadores(Collections.singletonList(empleador));

        objTrabajadorService.actualizarTrabajador(trabajador, idTrabajador);

        return "redirect:/trabajador/listTrabajador";

*/


    //ACTUALIZAR V1
        @PostMapping("/actualizar/{idTrabajador}")
        public String actualizarTrabajador(@ModelAttribute Trabajador trabajador, @PathVariable int idTrabajador,
        @RequestParam("idPrevision") int idPrevision,
        @RequestParam("idSalud") int idSalud) {
            InstitucionPrevision prevision = objPrevisionService.buscarPrevisionPorId(idPrevision);
            InstitucionSalud salud = objSaludService.buscarSaludPorId(idSalud);
           // Empleador empleador = objEmpleadorService.buscarEmpleadorPorId(idEmpleador);

            trabajador.setInstitucionPrevision(prevision);
            trabajador.setInstitucionSalud(salud);
           // trabajador.setListaEmpleadores(Collections.singletonList(empleador));

            objTrabajadorService.actualizarTrabajador(trabajador, idTrabajador);

            return "redirect:/trabajador/listTrabajador";
            }













    @GetMapping("/editar/{idTrabajador}")
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






    //ACTUALIZAR TRABAJADOR CINTIA

/*
    @GetMapping("/{idTrabajador}")
    public String buscarTrabajadorPorId(@PathVariable int idTrabajador, Model model){
        Trabajador trabajador = objTrabajadorService.buscarTrabajadorPorId(idTrabajador);
        model.addAttribute("trabajador", trabajador);
        return "redirect:/trabajador";
    }

    @GetMapping("/editar/{idTrabajador}")
    public String mostrarFormTrabajador(@PathVariable int idTrabajador, Model model){
        model.addAttribute("trabajador", objTrabajadorService.buscarTrabajadorPorId(idTrabajador));
        List<InstitucionPrevision> prevision = objPrevisionService.listarInstitucionPrevision();
        List<InstitucionSalud> salud = objSaludService.listarInstitucionSalud();
        model.addAttribute("prevision", prevision);
        model.addAttribute("salud", salud);
        return "editarTrabajador";
    }

    @PostMapping("/actualizar/{idTrabajador}")
    public String actualizarTrabajador(@ModelAttribute Trabajador trabajador, @PathVariable int idTrabajador,
                                       @RequestParam("IdPrevision") int previsionId,
                                       @RequestParam("IdSalud") int saludId){
        InstitucionPrevision prevision = objPrevisionService.buscarPrevisionPorId(previsionId);
        InstitucionSalud salud = objSaludService.buscarSaludPorId(saludId);
        trabajador.setInstitucionPrevision(prevision);
        trabajador.setInstitucionSalud(salud);
        objTrabajadorService.actualizarTrabajador(trabajador, idTrabajador);
        return "redirect:/trabajador";
    }
*/
}