
package com.Tienda.TiendaOnlne.repository;

import com.Tienda.TiendaOnlne.entities.Producto;
import com.Tienda.TiendaOnlne.entities.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, String>{
    
    @Query("SELECT p FROM Producto p WHERE p.nombre = :nombre")
    public void buscarPorNombre(@Param("nombre") String nombre);
    
    @Query("SELECT p FROM Producto p WHERE p.marca = :marca")
    public List<Usuario> buscarPorMarca(@Param("marca") String nombre);
    
    @Query("SELECT p FROM Producto p WHERE p.precio = :precio")
    public List<Usuario> buscarPorPrecio(@Param("precio") double precio);
    
     @Query("SELECT p FROM Producto p WHERE p.stock = :stock")
    public List<Usuario> buscarPorStock(@Param("stock") Integer stock);
    
    
}
