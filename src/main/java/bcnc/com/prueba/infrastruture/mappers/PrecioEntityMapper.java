package bcnc.com.prueba.infrastruture.mappers;

import bcnc.com.prueba.infrastruture.entities.PrecioEntity;
import bcnc.com.prueba.model.Precio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PrecioEntityMapper {

    @Mapping(target = "cadenaId.id", source = "cadenaId")
    @Mapping(target = "productoId.id", source = "productoId")
    @Mapping(target = "monedaId.id", source = "monedaId")
    PrecioEntity map(Precio src);

    @Mapping(target = "cadenaId", source = "cadenaId.id")
    @Mapping(target = "productoId", source = "productoId.id")
    @Mapping(target = "monedaId", source = "monedaId.id")
    Precio map(PrecioEntity src);

    List<Precio> map(List<PrecioEntity> src);
}
