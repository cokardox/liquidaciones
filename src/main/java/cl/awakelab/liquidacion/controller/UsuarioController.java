package cl.awakelab.liquidacion.controller;

import cl.awakelab.liquidacion.entity.Usuario;
import cl.awakelab.liquidacion.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/usuario")
@Controller
public class UsuarioController {
    @Autowired
    IUsuarioService objUsuarioService;

    @GetMapping("/registrarse")
    public String registrarse() {return "registrarse";}


   //Crear usuario

    @GetMapping("/crearUsuario")

   public String mostrarFormularioCrearUsuario(Model model){
       return "formUsuario";
   }

    @PostMapping("/crearUsuario")
    public String crearUsuario(@ModelAttribute Usuario usuario){
        usuario.setFechaCreacion(LocalDateTime.now());
        objUsuarioService.crearUsuario(usuario);
        return "redirect:/usuario/listUsuario";
    }

    @PostMapping("/registrarse")
    public String registrarse(@ModelAttribute Usuario usuario){
        usuario.setFechaCreacion(LocalDateTime.now());
        objUsuarioService.crearUsuario(usuario);
        return "redirect:/";
    }


    @GetMapping("/listUsuario")
    public String listarUsuarios(Model model){
        List<Usuario> listaUsuarios = objUsuarioService.listarUsuarios();
        model.addAttribute("usuarios", listaUsuarios);
        return "/listUsuario";
    }

    @PostMapping("/eliminar/{idUsuario}")
    public String eliminarUsuarioPorId(@PathVariable int idUsuario) {
        objUsuarioService.eliminarUsuario2(idUsuario);
        return "redirect:/usuario/listUsuario";
    }


    //////ACTUALIZAR

    @PostMapping("/actualizar/{idUsuario}")
    public String actualizarUsuario(@PathVariable int idUsuario, @ModelAttribute Usuario usuario) {
        objUsuarioService.actualizarUsuario(usuario, idUsuario);
        return "redirect:/usuario/listUsuario";
    }
    @GetMapping("/{idUsuario}/editar")
    public String mostrarFormularioEditarUsuario(@PathVariable int idUsuario, Model model) {
        Usuario usuarioParaEditar = objUsuarioService.buscarUsuarioPorId(idUsuario);
        model.addAttribute("usuario", usuarioParaEditar);
        return "editarUsuario";
    }


}
