package cl.awakelab.liquidacion.controller;


import cl.awakelab.liquidacion.entity.Empleador;
import cl.awakelab.liquidacion.entity.Usuario;
import cl.awakelab.liquidacion.service.IEmpleadorService;
import cl.awakelab.liquidacion.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
@RequestMapping("/empleador")
@Controller
public class EmpleadorController {
    @Autowired
    IEmpleadorService objEmpleadorService;
    @Autowired
    IUsuarioService objUsuarioService;


    //LISTAR EMPLEADOR
    @GetMapping("/listEmpleador")
    public String listarUsuarios(Model model){
        List<Empleador> listarEmpleadores = objEmpleadorService.listarEmpleadores();
        model.addAttribute("empleadores", listarEmpleadores);
        return "listEmpleador";
    }

    // CREAR EMPLEADOR

    @GetMapping("/crearEmpleador")
    public String mostrarFormularioCrearEmpleador(Model model) {
        List<Usuario> usuarios = objUsuarioService.listarUsuarios();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("empleador", new Empleador());
        return "formEmpleador";
    }

    @PostMapping("/crearEmpleador")
    public String crearEmpleador(@ModelAttribute Empleador empleador,
                                 @RequestParam("usuarioId") int usuarioId) {
        Usuario usuario = objUsuarioService.buscarUsuarioPorId(usuarioId);
        empleador.setUsuario(usuario);
        objEmpleadorService.crearEmpleador(empleador);
        return "redirect:/empleador/listEmpleador";
    }



    //ELIMINAR EMPLEADOR

    @PostMapping("/eliminar/{idEmpleador}")
    public String eliminarEmpleadorPorId(@PathVariable int idEmpleador) {
        objEmpleadorService.eliminarEmpleador2(idEmpleador);
        return "redirect:/empleador/listEmpleador";
    }

    @GetMapping("/{idEmpleador}/eliminar")
    public String mostrarEliminarEmpleador(@PathVariable int idEmpleador, Model model) {
        Empleador empleadorEliminar = objEmpleadorService.buscarEmpleadorporId(idEmpleador);
        model.addAttribute("empleador", empleadorEliminar);
        return "eliminarEmpleador";


    }



    // ACTUALIZAR EMPLEADOR

    @PostMapping("/actualizar/{idEmpleador}")
    public String actualizarEmpleador(@PathVariable int idEmpleador, @ModelAttribute Empleador empleador, @RequestParam("usuarioId") int usuarioId) {
    Usuario usuario = objUsuarioService.buscarUsuarioPorId(usuarioId);
    empleador.setUsuario(usuario);
    objEmpleadorService.actualizarEmpleador(empleador, idEmpleador);
        return "redirect:/empleador/listEmpleador";
    }

    @PostMapping("/editar/{idEmpleador}")
    public String mostrarFormEditarEmpleador(@PathVariable int idEmpleador, Model model) {
        model.addAttribute("empleador", objEmpleadorService.buscarEmpleadorPorId(idEmpleador));
        List<Usuario> usuarios = objUsuarioService.listarUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "editarEmpleador";

    }
/*
    @GetMapping("/{idEmpleador}/editar")
    public String mostrarFormEditarEmpleador(@PathVariable int idEmpleador, Model model) {
        Empleador empleadorParaEditar = objEmpleadorService.buscarEmpleadorPorId(idEmpleador);
        List<Usuario> usuarios = objUsuarioService.listarUsuarios();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("empleador", empleadorParaEditar);
        return "editarEmpleador";
    }

*/



    @GetMapping("/{idEmpleador}")
    public String buscarEmpleadorPorId(@PathVariable int idEmpleador, Model model) {
        Empleador empleador = objEmpleadorService.buscarEmpleadorPorId(idEmpleador);
        model.addAttribute("empleador", empleador);
        return "redirect:/empleador";
    }
}


