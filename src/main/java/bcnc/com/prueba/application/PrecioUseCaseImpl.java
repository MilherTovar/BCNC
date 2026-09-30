package bcnc.com.prueba.application;

import bcnc.com.prueba.domain.PrecioUseCase;
import bcnc.com.prueba.infrastruture.PrecioRepository;
import bcnc.com.prueba.model.Precio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class PrecioUseCaseImpl implements PrecioUseCase {

    private static final Logger logger = LoggerFactory.getLogger(PrecioUseCaseImpl.class);

    @Autowired
    private PrecioRepository precioRepository;

    @Override
    public Precio savePrecio(Precio precio) {
        logger.info("Error saving precio: {} - UseCase", precio);
        try{
            return this.precioRepository.savePrecio(precio);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error saving precio: "
            + e.getMessage());
        }
    }

    @Override
    public List<Precio> getPrecios(OffsetDateTime fechaAplication, Long cadenaId, Long productoId) {
        logger.info("Get Precios, FechaAplicacion: {}, Cadena: {}, Producto {} - UseCase",
                fechaAplication, cadenaId, productoId);
        try{
            return this.precioRepository.getPrecios(fechaAplication, cadenaId, productoId);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error Obteniendo precios: "
                    + e.getMessage());
        }
    }
}
