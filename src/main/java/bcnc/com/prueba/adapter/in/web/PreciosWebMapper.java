package bcnc.com.prueba.adapter.in.web;

import bcnc.com.prueba.adapter.in.web.dto.PreciosDTO;
import bcnc.com.prueba.domain.model.Precio;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PreciosWebMapper {

    @Mapping(target = "tarifa", source = "id")
    @Mapping(target = "fecha", expression = "java(fecha)")
    PreciosDTO map(Precio src, @Context String fecha);

    List<PreciosDTO> map (List<Precio> src, @Context String fecha);
}
