package bcnc.com.prueba.infrastruture.mappers;

import bcnc.com.prueba.infrastruture.entities.MonedaEntity;
import bcnc.com.prueba.model.Moneda;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MonedaEntityMapper {

    MonedaEntity map(Moneda src);

    Moneda map(MonedaEntity src);
}
