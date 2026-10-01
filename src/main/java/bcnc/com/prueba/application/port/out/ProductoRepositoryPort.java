package bcnc.com.prueba.application.port.out;

import bcnc.com.prueba.domain.model.Producto;

public interface ProductoRepositoryPort {
    Producto saveProducto(Producto producto);
}
