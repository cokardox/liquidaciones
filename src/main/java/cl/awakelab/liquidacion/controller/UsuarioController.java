package cl.awakelab.liquidacion.controller;


import cl.awakelab.liquidacion.entity.Perfil;
import cl.awakelab.liquidacion.entity.Usuario;
import cl.awakelab.liquidacion.repository.IPerfilRepository;
import cl.awakelab.liquidacion.repository.IUsuarioRepository;
import cl.awakelab.liquidacion.service.IPerfilService;
import cl.awakelab.liquidacion.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Controller

public class UsuarioController {
    @Autowired
    IUsuarioService objUsuarioService;
   /* @Autowired
    IPerfilService objPerfilService;
    @Autowired
    IPerfilRepository perfilRepository;
    @Autowired
    IUsuarioRepository usuarioRepository;

*/
    @GetMapping("/registrarse")
    public String registrarse() {return "registrarse";}

   /* @GetMapping("/crearUsuario")
    public String mostrarFormularioUsuario(Model model) {
        Usuario usuario = new Usuario();
        Perfil perfil = new Perfil();
        usuario.setPerfil(perfil);
        model.addAttribute("usuario", usuario);
        return "formUsuario";
    }
*/
 /*  @PostMapping("/crearUsuario")
    public String crearUsuario(@RequestParam("run") int run,
                               @RequestParam("nombre") String nombre,
                               @RequestParam("apellido1") String apellido1,
                               @RequestParam(value = "apellido2", required = false) String apellido2,
                               @RequestParam("telefono") long telefono,
                               @RequestParam("email") String email,
                               @RequestParam("clave") String clave,
                               @RequestParam(value = "empleadorCheck", required = false) boolean empleadorCheck,
                               @RequestParam(value = "contadorCheck", required = false) boolean contadorCheck) {
        Usuario usuario = new Usuario();
        usuario.setRun(run);
        usuario.setNombre(nombre);
        usuario.setApellido1(apellido1);
        usuario.setApellido2(apellido2);
        usuario.setTelefono(telefono);
        usuario.setEmail(email);
        usuario.setClave(clave);

        Perfil perfil = null;
        if (empleadorCheck) {
            perfil = perfilRepository.findById(3).orElseThrow(() -> new NoSuchElementException("Perfil no encontrado")); // Cargar el perfil "Empleador" desde la base de datos
        } else if (contadorCheck) {
            perfil = perfilRepository.findById(2).orElseThrow(() -> new NoSuchElementException("Perfil no encontrado")); // Cargar el perfil "Contador" desde la base de datos
        }

        usuario.setPerfil(perfil);

        usuarioRepository.save(usuario);

        return "redirect:/listUsuario";
    }
*/
   //Crear usuario
   @GetMapping("/crearUsuario")
   public String mostrarFormularioCrearUsuario(Model model){
       return "formUsuario";
   }

    @PostMapping("/crearUsuario")
    public String crearUsuario(@ModelAttribute Usuario usuario){
        usuario.setFechaCreacion(LocalDateTime.now());
        objUsuarioService.crearUsuario(usuario);
        return "redirect:/listUsuario";
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
        return "listUsuario";
    }

  /*  @GetMapping("/{idUsuario}/eliminar")
    public String mostrarEliminarUsuario(@PathVariable int idUsuario, Model model){
        Usuario usuarioEliminar = objUsuarioService.buscarUsuarioPorId(idUsuario);
        model.addAttribute("usuario", usuarioEliminar);
        return "listUsuario";
    }*/
    @PostMapping("/eliminar/{idUsuario}")
    public String eliminarUsuarioPorId(@PathVariable int idUsuario) {
        objUsuarioService.eliminarUsuario2(idUsuario);
        return "redirect:/listUsuario";
    }


    //////ACTUALIZAR



    /*
    @PostMapping("/{idUsuario}/editar")
    public String actualizarUsuario(@PathVariable int idUsuario, @ModelAttribute Usuario usuario){
        objUsuarioService.actualizarUsuario2(usuario);
        return "redirect:/listUsuario";
    }

*/
    @PostMapping("/actualizar/{idUsuario}")
    public String actualizarUsuario(@PathVariable int idUsuario, @ModelAttribute Usuario usuario) {
        objUsuarioService.actualizarUsuario(usuario, idUsuario);
        return "redirect:/listUsuario";
    }
    @GetMapping("/{idUsuario}/editar")
    public String mostrarFormularioEditarUsuario(@PathVariable int idUsuario, Model model) {
        Usuario usuarioParaEditar = objUsuarioService.buscarUsuarioPorId(idUsuario);
        model.addAttribute("usuario", usuarioParaEditar);
        return "editarUsuario";
    }


}
