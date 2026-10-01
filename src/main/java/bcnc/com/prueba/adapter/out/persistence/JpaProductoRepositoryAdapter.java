package bcnc.com.prueba.adapter.out.persistence;

import bcnc.com.prueba.adapter.out.persistence.mapper.ProductoPersistenceMapper;
import bcnc.com.prueba.adapter.out.persistence.springdata.ProductoJpaRepository;
import bcnc.com.prueba.application.port.out.ProductoRepositoryPort;
import bcnc.com.prueba.domain.model.Producto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JpaProductoRepositoryAdapter implements ProductoRepositoryPort {

    private static final Logger logger = LoggerFactory.getLogger(JpaProductoRepositoryAdapter.class);

    @Autowired
    private ProductoJpaRepository productoJpaRepository;

    @Autowired
    private ProductoPersistenceMapper productoPersistenceMapper;

    @Override
    public Producto saveProducto(Producto producto){
        logger.info("Saving Producto: {}, - Repository", producto);
        return this.productoPersistenceMapper.map(this.productoJpaRepository.save(
                this.productoPersistenceMapper.map(producto)
        ));
    }

}
