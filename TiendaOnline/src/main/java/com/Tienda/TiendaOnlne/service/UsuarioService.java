package com.Tienda.TiendaOnlne.service;

import com.Tienda.TiendaOnlne.entities.Usuario;
import com.Tienda.TiendaOnlne.exception.MiException;
import com.Tienda.TiendaOnlne.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository ur;

    @Transactional
    public void crearUsuario(String nombre, String apellido, Long dni, String mail, String password) throws MiException {
        validar(nombre, apellido, dni, mail, password);
        Usuario usuario = new Usuario();

        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setDni(dni);
        usuario.setMail(mail);
        usuario.setPassword(password);

        ur.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> listasDeUsuarios = new ArrayList();

        listasDeUsuarios = ur.findAll();

        return listasDeUsuarios;
    }

    public void modificarUsuario(String id, String nombre, String apellido, String mail, Long dni, String password) throws MiException {
        validar(nombre, apellido, dni, mail, password);
        Optional<Usuario> repustaUsuario = ur.findById(id);

        if (repustaUsuario.isPresent()) {
            Usuario usuario = repustaUsuario.get();

            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setMail(mail);
            usuario.setDni(dni);
            usuario.setPassword(password);

            ur.save(usuario);
        }
    }
    
    private void validar(String nombre, String apellido, Long dni, String mail, String password) throws MiException {

        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("El nombre  del usuario  no puede ser nulo!");
        }
        if (dni == null) {
            throw new MiException("El dni del usuario no puede ser nulo");
        }
        if (apellido.isEmpty() || apellido == null) {
            throw new MiException("E apellido del usuario  no puede ser nulo!");
        }
        if (mail.isEmpty() || mail == null) {
            throw new MiException("El mail del usuario no puede ser nulo!");
        }
        if (password == null || password.isEmpty()) {
            throw new MiException("El password del usuario no puede ser nulo!");
        }

    }
}
