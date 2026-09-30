package bcnc.com.prueba.controller;

import bcnc.com.prueba.model.Precio;
import bcnc.com.prueba.model.PreciosDTO;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PreciosMapper {

    @Mapping(target = "tarifa", source = "id")
    @Mapping(target = "fecha", expression = "java(fecha)")
    PreciosDTO map(Precio src, @Context String fecha);

    List<PreciosDTO> map (List<Precio> src, @Context String fecha);
}
