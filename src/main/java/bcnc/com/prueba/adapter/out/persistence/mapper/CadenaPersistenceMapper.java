package bcnc.com.prueba.adapter.out.persistence.mapper;

import bcnc.com.prueba.adapter.out.persistence.entity.CadenaEntity;
import bcnc.com.prueba.domain.model.Cadena;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CadenaPersistenceMapper {

    CadenaEntity map(Cadena src);

    Cadena map(CadenaEntity src);
}
