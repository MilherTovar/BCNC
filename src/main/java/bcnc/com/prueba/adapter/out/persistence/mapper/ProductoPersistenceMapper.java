package bcnc.com.prueba.adapter.out.persistence.mapper;

import bcnc.com.prueba.adapter.out.persistence.entity.ProductoEntity;
import bcnc.com.prueba.domain.model.Producto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoPersistenceMapper {

    ProductoEntity map(Producto src);

    Producto map(ProductoEntity src);
}
