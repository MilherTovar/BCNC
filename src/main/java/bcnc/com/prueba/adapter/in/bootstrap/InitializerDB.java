package bcnc.com.prueba.adapter.in.bootstrap;

import bcnc.com.prueba.application.port.in.CadenaUseCase;
import bcnc.com.prueba.application.port.in.MonedaUseCase;
import bcnc.com.prueba.application.port.in.PrecioUseCase;
import bcnc.com.prueba.application.port.in.ProductoUseCase;
import bcnc.com.prueba.domain.model.Cadena;
import bcnc.com.prueba.domain.model.Moneda;
import bcnc.com.prueba.domain.model.Precio;
import bcnc.com.prueba.domain.model.Producto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class InitializerDB implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(InitializerDB.class);

    @Autowired
    private CadenaUseCase cadenaUseCase;

    @Autowired
    private MonedaUseCase monedaUseCase;

    @Autowired
    private ProductoUseCase productoUseCase;

    @Autowired
    private PrecioUseCase precioUseCase;

    public void initializer(){
        logger.info("Inicializando base de datos");
        Cadena cadena = Cadena.builder()
                .id(1)
                .nombreCadena("Zara")
                .build();
        this.cadenaUseCase.saveCadena(cadena);
        Moneda moneda = Moneda.builder()
                .id(1)
                .monedaNombre("ERU")
                .build();
        this.monedaUseCase.saveMoneda(moneda);
        Producto producto = Producto.builder()
                .id(35455)
                .nombreProducto("Producto")
                .build();
        this.productoUseCase.saveProducto(producto);
        Precio precio = Precio.builder()
                .id(1)
                .precio(35.50)
                .fechaInicial(LocalDateTime.of(2020,6,14,0,0,0))
                .fechaFinal(LocalDateTime.of(2020,12,31,23,59,59))
                .prioridad(0)
                .cadenaId(cadena.getId())
                .productoId(producto.getId())
                .monedaId(moneda.getId())
                .build();
        this.precioUseCase.savePrecio(precio);
        precio.setId(2);
        precio.setFechaInicial(LocalDateTime.of(2020,6,14,15,0,0));
        precio.setFechaFinal(LocalDateTime.of(2020,6,14,18,30,0));
        precio.setPrioridad(1);
        precio.setPrecio(25.45);
        this.precioUseCase.savePrecio(precio);
        precio.setId(3);
        precio.setFechaInicial(LocalDateTime.of(2020,6,15,0,0,0));
        precio.setFechaFinal(LocalDateTime.of(2020,6,15,11,0,0));
        precio.setPrecio(30.50);
        this.precioUseCase.savePrecio(precio);
        precio.setId(4);
        precio.setFechaInicial(LocalDateTime.of(2020,6,15,16,0,0));
        precio.setFechaFinal(LocalDateTime.of(2020,12,31,23,59,59));
        precio.setPrecio(38.95);
        this.precioUseCase.savePrecio(precio);
    }

    @Override
    public void run(String... args) throws Exception {
        initializer();
    }
}
