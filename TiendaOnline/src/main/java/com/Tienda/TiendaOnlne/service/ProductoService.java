package com.Tienda.TiendaOnlne.service;

import com.Tienda.TiendaOnlne.entities.Producto;
import com.Tienda.TiendaOnlne.entities.Usuario;
import com.Tienda.TiendaOnlne.exception.MiException;
import com.Tienda.TiendaOnlne.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository pr;

    @Transactional
    public void crearProducto(String nombre, String marca, String descripcion, Double precio, Integer stock) throws MiException {
        validar(nombre, marca, precio, descripcion, stock);
        Producto producto = new Producto();

        producto.setMarca(marca);
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setStock(stock);

        pr.save(producto);
    }

    public List<Producto> listarProductos() {
        List<Producto> listasDeProductos = new ArrayList();

        listasDeProductos = pr.findAll();

        return listasDeProductos;
    }

    public void modificearProducto(String nombre, String marca, Double precio, String descripcion, String id, Integer stock) throws MiException {
        validar(nombre, marca, precio, descripcion, stock);
        Optional<Producto> repustaProducto = pr.findById(id);

        if (repustaProducto.isPresent()) {
            Producto producto = repustaProducto.get();

            producto.setNombre(nombre);
            producto.setMarca(marca);
            producto.setDescripcion(descripcion);
            producto.setPrecio(precio);
            producto.setStock(stock);

            pr.save(producto);
        }
    }

    private void validar(String nombre, String marca, Double precio, String descripcion, Integer stock) throws MiException {

        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("El nombre  del producto no puede ser nulo!");
        }
        if (precio == null) {
            throw new MiException("El precio del producto no puede ser nulo");
        }
        if (descripcion.isEmpty() || descripcion == null) {
            throw new MiException("La descripcion   del producto no puede ser nulo!");
        }
        if (marca.isEmpty() || marca == null) {
            throw new MiException("la marca del producto no puede ser nulo!");
        }
        if (stock == null) {
            throw new MiException("El stock del producto no puede ser nulo!");
        }

    }

}
