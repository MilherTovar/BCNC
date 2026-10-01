package bcnc.com.prueba.adapter.out.persistence.mapper;

import bcnc.com.prueba.adapter.out.persistence.entity.MonedaEntity;
import bcnc.com.prueba.domain.model.Moneda;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MonedaPersistenceMapper {

    MonedaEntity map(Moneda src);

    Moneda map(MonedaEntity src);
}
