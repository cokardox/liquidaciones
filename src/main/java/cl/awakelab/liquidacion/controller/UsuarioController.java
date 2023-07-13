package cl.awakelab.liquidacion.controller;


import cl.awakelab.liquidacion.entity.Usuario;
import cl.awakelab.liquidacion.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UsuarioController {
    @GetMapping("/registrarse")
    public String index() {return "registrarse";}

}
