package bcnc.com.prueba.infrastruture;

import bcnc.com.prueba.infrastruture.mappers.ProductoEntityMapper;
import bcnc.com.prueba.infrastruture.repository.ProductoDataRepository;
import bcnc.com.prueba.model.Producto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductoRepository {

    private static final Logger logger = LoggerFactory.getLogger(ProductoRepository.class);

    @Autowired
    private ProductoDataRepository productoDataRepository;

    @Autowired
    private ProductoEntityMapper productoEntityMapper;

    public Producto saveProducto(Producto producto){
        logger.info("Saving Producto: {}, - Repository", producto);
        return this.productoEntityMapper.map(this.productoDataRepository.save(
                this.productoEntityMapper.map(producto)
        ));
    }

}
