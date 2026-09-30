package bcnc.com.prueba.infrastruture.mappers;

import bcnc.com.prueba.infrastruture.entities.ProductoEntity;
import bcnc.com.prueba.model.Producto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoEntityMapper {

    ProductoEntity map(Producto src);

    Producto map(ProductoEntity src);
}
