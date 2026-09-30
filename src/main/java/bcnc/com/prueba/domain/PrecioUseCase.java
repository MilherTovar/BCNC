package bcnc.com.prueba.domain;

import bcnc.com.prueba.model.Precio;

import java.time.OffsetDateTime;
import java.util.List;

public interface PrecioUseCase {
    Precio savePrecio(Precio precio);
    List<Precio> getPrecios(OffsetDateTime fechaAplication, Long cadenaId, Long productoId);
}
