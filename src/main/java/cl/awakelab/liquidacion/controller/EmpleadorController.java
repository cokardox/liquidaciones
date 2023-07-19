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


    //Listar Empleados
    @GetMapping("/listEmpleador")
    public String listarUsuarios(Model model){
        List<Empleador> listarEmpleadores = objEmpleadorService.listarEmpleadores();
        model.addAttribute("empleadores", listarEmpleadores);
        return "listEmpleador";
    }

    // Crear Empleados

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



    //Eliminar Empleados

    @PostMapping("/eliminar/{idEmpleador}")
    public String eliminarEmpleadorPorId(@PathVariable int idEmpleador) {
        objEmpleadorService.eliminarEmpleador2(idEmpleador);
        return "redirect:/empleador";
    }

    @GetMapping("/{idEmpleador}/eliminar")
    public String mostrarEliminarEmpleador(@PathVariable int idEmpleador, Model model) {
        Empleador empleadorEliminar = objEmpleadorService.buscarEmpleadorporId(idEmpleador);
        model.addAttribute("empleador", empleadorEliminar);
        return "eliminarEmpleador";


    }
    }



