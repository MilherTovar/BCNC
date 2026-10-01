package bcnc.com.prueba.adapter.in.web;

import bcnc.com.prueba.adapter.in.web.dto.PreciosDTO;
import bcnc.com.prueba.application.port.in.PrecioUseCase;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "api/precio")
@CrossOrigin(origins = "*")
@Tag(name = "Recursos de Precios")
public class PreciosController {

    private static final Logger logger = LoggerFactory.getLogger(PreciosController.class);

    @Autowired
    private PrecioUseCase precioUseCase;

    @Autowired
    private PreciosWebMapper preciosWebMapper;

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/busquedaPrecios",
            produces = { "application/json" }
    )
    ResponseEntity<List<PreciosDTO>> getPrecios(
            @NotNull @Parameter(name = "fechaAplicacion", description = "Fecha Aplicacion", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "fechaAplicacion", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime fechaAplicacion,
            @NotNull @Parameter(name = "cadenaId", description = "Cadena del producto", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "cadenaId", required = true) Long cadenaId,
            @NotNull @Parameter(name = "productoId", description = "Id del producto", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "productoId", required = true) Long productoId
    ) {
        logger.info("Get Precios, FechaAplicacion: {}, Cadena: {}, Producto {} - Controller",
                fechaAplicacion, cadenaId, productoId);
        List<PreciosDTO>precios = this.preciosWebMapper.map(this.precioUseCase.getPrecios(fechaAplicacion, cadenaId, productoId), fechaAplicacion.toString());
        if (precios.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(precios, HttpStatus.OK);
    }
}
