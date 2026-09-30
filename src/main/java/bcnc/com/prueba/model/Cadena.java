package bcnc.com.prueba.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class Cadena {
    Integer id;
    String nombreCadena;
}
