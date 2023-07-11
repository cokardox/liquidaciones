package cl.awakelab.liquidacion.controller;


import cl.awakelab.liquidacion.entity.Usuario;
import cl.awakelab.liquidacion.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    IUsuarioService objUsuarioService;
    @PostMapping// tipo de request //enviar informacion
    public Usuario crearUsuario(@RequestBody Usuario usuario)
    {
        return objUsuarioService.crearUsuario(usuario);
    }
    @GetMapping("/{idUsuario}") //traer informacion
    public Usuario buscarUsuarioPorId(@PathVariable int idUsuario){
        return objUsuarioService.buscarUsuarioPorId(idUsuario);
    }
    @GetMapping
    public List<Usuario> listarUsuarios(){
        return objUsuarioService.listarUsuarios();
    }

    @PostMapping("/{idUsuario}/editar")
    public String actualizarUsuario(@PathVariable int idUsuario, @ModelAttribute Usuario usuario){
        objUsuarioService.actualizarUsuario(usuario);
        return "redirect:/usuarios";
    }

    @DeleteMapping //Eliminar
    public void eliminarUsuario(@RequestBody Usuario usuario)
    {
        objUsuarioService.eliminarUsuario(usuario);

    }


}
