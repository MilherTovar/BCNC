package bcnc.com.prueba.adapter.out.persistence.mapper;

import bcnc.com.prueba.adapter.out.persistence.entity.PrecioEntity;
import bcnc.com.prueba.domain.model.Precio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PrecioPersistenceMapper {

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
