package com.Tienda.TiendaOnlne.repository;

import com.Tienda.TiendaOnlne.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, String>{

    @Query("SELECT  s FROM Usuario s WHERE s.apellido = :apellido")
    public void buscarUsuarioPorApellido(@Param("apellido") String apellido);

    @Query("SELECT s FROM Usuario s WHERE s.nombre = :nombre")
    public void buscarUsuarioPorNombre(@Param("nombre") String nombre);

    @Query("SELECT s FROM Usuario s WHERE s.dni = :dni")
    public void buscarUsuarioPorDni(@Param("dni") Long dni);

    @Query("SELECT s FROM Usuario s WHERE s.mail = :mail")
    public void buscarUsuarioPorMail(@Param("mail") String mail);

}
