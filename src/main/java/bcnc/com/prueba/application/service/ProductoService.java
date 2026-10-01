package bcnc.com.prueba.application.service;

import bcnc.com.prueba.application.port.in.ProductoUseCase;
import bcnc.com.prueba.application.port.out.ProductoRepositoryPort;
import bcnc.com.prueba.domain.model.Producto;

public class ProductoService implements ProductoUseCase {

    private final ProductoRepositoryPort productoRepositoryPort;

    public ProductoService(ProductoRepositoryPort productoRepositoryPort){
        this.productoRepositoryPort = productoRepositoryPort;
    }


    @Override
    public Producto saveProducto(Producto producto) {
        return this.productoRepositoryPort.saveProducto(producto);
    }
}
