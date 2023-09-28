package com.Tienda.TiendaOnlne.controller;

import com.Tienda.TiendaOnlne.exception.MiException;
import com.Tienda.TiendaOnlne.repository.UsuarioRepository;
import com.Tienda.TiendaOnlne.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/usuario")// localhost:8080/usuario
public class Usuarioontroller {

    @Autowired
    private UsuarioService us;

    @GetMapping("/registrar")// localhost:8080/usuario/registrar
    public String registrar() {
        return "usuario_form.html";
    }

    // los parametros que lleguen del html, en el input name="" y el nombre del atributo
    // @RequestParam paa indicar que es un parametro de la url(html) creado y se jecua cuando se hace el formulario
    @PostMapping("/registro") //
    public String registro(@RequestParam String nombre, @RequestParam String apellido, @RequestParam Long dni,
            @RequestParam String mail, @RequestParam String password) {

        try {
            us.crearUsuario(nombre, apellido, dni, mail, password);

        } catch (MiException ex) {
            ex.getMessage();
            return "usuario_form.html";
        }

        return "usuario_form.html";
    }
}
