package bcnc.com.prueba.application.service;

import bcnc.com.prueba.application.port.in.PrecioUseCase;
import bcnc.com.prueba.application.port.out.PrecioRepositoryPort;
import bcnc.com.prueba.domain.model.Precio;

import java.time.OffsetDateTime;
import java.util.List;

public class PrecioService implements PrecioUseCase {

    private final PrecioRepositoryPort precioRepositoryPort;

    public PrecioService(PrecioRepositoryPort precioRepositoryPort){
        this.precioRepositoryPort = precioRepositoryPort;
    }

    @Override
    public Precio savePrecio(Precio precio) {
        return this.precioRepositoryPort.savePrecio(precio);
    }

    @Override
    public List<Precio> getPrecios(OffsetDateTime fechaAplication, Long cadenaId, Long productoId) {
        return this.precioRepositoryPort.getPrecios(fechaAplication, cadenaId, productoId);
    }
}
