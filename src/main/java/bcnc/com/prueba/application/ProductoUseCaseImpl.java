package bcnc.com.prueba.application;

import bcnc.com.prueba.domain.ProductoUseCase;
import bcnc.com.prueba.infrastruture.ProductoRepository;
import bcnc.com.prueba.model.Producto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProductoUseCaseImpl implements ProductoUseCase {

    private static final Logger logger = LoggerFactory.getLogger(ProductoUseCaseImpl.class);

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto saveProducto(Producto producto) {
        logger.info("Saving producto: {}, - UseCase", producto);
        try{
            return this.productoRepository.saveProducto(producto);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error saving producto: " +
                    e.getMessage());
        }
    }
}
