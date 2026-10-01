package bcnc.com.prueba.application.port.in;

import bcnc.com.prueba.domain.model.Producto;

public interface ProductoUseCase {
    Producto saveProducto(Producto producto);
}
