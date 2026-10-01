package bcnc.com.prueba.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class Producto {
    Integer id;
    String nombreProducto;
}
