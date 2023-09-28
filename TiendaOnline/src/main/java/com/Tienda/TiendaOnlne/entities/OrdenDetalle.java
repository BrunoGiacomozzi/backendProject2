
package com.Tienda.TiendaOnlne.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import java.util.List;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class OrdenDetalle {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private Long id;
    
    @ManyToOne
    private Usuario usuario;
    
    @ManyToOne
    private Producto producto;
    
    private List <Producto> detalleDeCompra;
    
    @Temporal(TemporalType.DATE)
    private Date DiaDeLaCompra;
    
    
}
