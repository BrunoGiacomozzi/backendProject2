
package com.Tienda.TiendaOnlne.repository;

import com.Tienda.TiendaOnlne.entities.OrdenDetalle;
import com.Tienda.TiendaOnlne.entities.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface OrdenDetalleRepository extends JpaRepository<OrdenDetalle, String>{
    
    @Query("SELECT o FROM OrdenDetalle o WHERE o.usuario.nombre = :nombre")
    public void buscarUsuarioPorNombre(@Param("nombre") String nombre);
    
    @Query("SELECT o FROM OrdenDetalle o WHERE o.usuario.apellido = :apellido")
    public void buscarUsuarioPorApellido(@Param("apellido") String apellido);
    
    @Query("SELECT o FROM OrdenDetalle o WHERE o.usuario.dni = :dni")
    public void buscarUsuarioPorDni(@Param("dni") Long dni);
    
    @Query("SELECT o FROM OrdenDetalle o WHERE o.usuario.mail = :mail")
    public void buscarUsuarioMail(@Param("mail") String mail);
    
    @Query("SELECT o FROM OrdenDetalle o WHERE o.producto.nombre = :nombre")
    public void buscarPorNombre(@Param("nombre") String nombre);
    
    @Query("SELECT o FROM OrdenDetalle o WHERE o.producto.marca = :marca")
    public List<Usuario> buscarPorMarca(@Param("marca") String nombre);
    
    @Query("SELECT o FROM OrdenDetalle o WHERE o.producto.precio = :precio")
    public List<Usuario> buscarPorPrecio(@Param("precio") double precio);
    
     @Query("SELECT o FROM OrdenDetalle o WHERE o.producto.stok = :stock")
    public List<Usuario> buscarPorStock(@Param("stock") Integer stock);
    
}
