package bcnc.com.prueba.application.port.out;

import bcnc.com.prueba.domain.model.Precio;

import java.time.OffsetDateTime;
import java.util.List;

public interface PrecioRepositoryPort {
    Precio savePrecio(Precio precio);
    List<Precio> getPrecios(OffsetDateTime fechaAplication, Long cadenaId, Long productoId);
}
