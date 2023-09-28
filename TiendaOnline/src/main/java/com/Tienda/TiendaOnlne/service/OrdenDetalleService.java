package com.Tienda.TiendaOnlne.service;

import com.Tienda.TiendaOnlne.entities.OrdenDetalle;
import com.Tienda.TiendaOnlne.entities.Producto;
import com.Tienda.TiendaOnlne.entities.Usuario;
import com.Tienda.TiendaOnlne.exception.MiException;
import com.Tienda.TiendaOnlne.repository.OrdenDetalleRepository;
import com.Tienda.TiendaOnlne.repository.ProductoRepository;
import com.Tienda.TiendaOnlne.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdenDetalleService {

    @Autowired
    private OrdenDetalleRepository odr;
    @Autowired
    private UsuarioRepository ur;
    @Autowired
    private ProductoRepository pr;

    @Transactional
    public void crearOrdenDetalle(List<Producto> listaDeProductos, String idProducto, String idUsuario) throws MiException {
        
        validar(listaDeProductos, idProducto, idUsuario);

        Producto producto = pr.findById(idProducto).get();
        Usuario usuario = ur.findById(idUsuario).get();
        OrdenDetalle ordenDetalle = new OrdenDetalle();

        ordenDetalle.setDetalleDeCompra(listaDeProductos);
        ordenDetalle.setDiaDeLaCompra(new Date());

        ordenDetalle.setUsuario(usuario);
        ordenDetalle.setProducto(producto);

        odr.save(ordenDetalle);
    }

    public List<OrdenDetalle> listarOrdenes() {
        List<OrdenDetalle> listasDeOrdenes = new ArrayList();

        listasDeOrdenes = odr.findAll();

        return listasDeOrdenes;
    }

    public void modificarORdenDetalle(String id, String idProducto, String IdUsuario, List<Producto> productos)throws MiException{
        
        validarIds(productos, idProducto, IdUsuario,id); // hice orto validar porque faltaba un dato on el anterior
        
        Optional<OrdenDetalle> orden = odr.findById(id);
        Optional<Producto> repustaproducto = pr.findById(idProducto);
        Optional<Usuario> respuestausuario = ur.findById(IdUsuario);

        Producto producto = new Producto();
        Usuario usuario = new Usuario();

        if (respuestausuario.isPresent()) {
            usuario = respuestausuario.get();

        }

        if (repustaproducto.isPresent()) {
            producto = repustaproducto.get();

        }   

        if (orden.isPresent()) {
            OrdenDetalle ordenD = orden.get();

            ordenD.setDetalleDeCompra(productos);
            ordenD.setUsuario(usuario);
            ordenD.setProducto(producto);

            odr.save(ordenD);
        }
    }
    
    
    private void validar(List<Producto> listaDeProductos, String idProducto, String idUsuari) throws MiException{
        
        if(listaDeProductos.isEmpty()){
            throw new MiException("La lista de productos no puede ser nula! ");
        }
        if(idProducto.isEmpty()){
            throw new MiException("El id de l producto no puede ser nulo!");
        }
        if(idUsuari.isEmpty()){
            throw new MiException("El id del usuario no puede ser nulo");
        }
    }
    
     private void validarIds(List<Producto> listaDeProductos, String idProducto, String idUsuari, String id) throws MiException{
        
        if(listaDeProductos.isEmpty() ||listaDeProductos ==null){
            throw new MiException("La lista de productos no puede ser nula! ");
        }
        if(idProducto.isEmpty()||idProducto ==null){
            throw new MiException("El id de l producto no puede ser nulo!");
        }
        if(idUsuari.isEmpty()||idUsuari ==null){
            throw new MiException("El id del usuario no puede ser nulo");
        }
        
        if(id.isEmpty()||id ==null){
            throw new MiException("El id de la orden  no puede ser nulo");
        }
    }

}
