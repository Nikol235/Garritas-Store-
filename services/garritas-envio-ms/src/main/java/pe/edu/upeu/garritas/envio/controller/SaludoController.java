package pe.edu.upeu.garritas.envio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {
    @GetMapping("/saludo")
    public String saludo() {
        return "garritas-envio-ms activo";
    }
}