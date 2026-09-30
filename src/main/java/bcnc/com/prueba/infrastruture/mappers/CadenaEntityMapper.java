package bcnc.com.prueba.infrastruture.mappers;

import bcnc.com.prueba.infrastruture.entities.CadenaEntity;
import bcnc.com.prueba.model.Cadena;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CadenaEntityMapper {

    CadenaEntity map(Cadena src);

    Cadena map(CadenaEntity src);
}
