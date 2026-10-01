package bcnc.com.prueba.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Builder
@Getter
@Setter
public class Precio {
    Integer id;
    LocalDateTime fechaInicial;
    LocalDateTime fechaFinal;
    Double precio;
    Integer cadenaId;
    Integer productoId;
    Integer prioridad;
    Integer monedaId;
}
