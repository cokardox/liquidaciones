package cl.awakelab.liquidacion.controller;


import cl.awakelab.liquidacion.entity.Usuario;
import cl.awakelab.liquidacion.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    IUsuarioService objectUsuarioService;

    @GetMapping("/registrarse")
    public String registrarse() {return "registrarse";}

    @GetMapping("/formUsuario")
    public String formUsuario() {return "formUsuario";}

    @GetMapping("/listUsuario")
    public String listUsuario() {return "listUsuario";}

}
