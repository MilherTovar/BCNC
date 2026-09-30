package bcnc.com.prueba.infrastruture.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cadena")
@Getter
@Setter
public class CadenaEntity {

    @Id
    private Integer id;

    @Column(name = "nombreCadena")
    private String nombreCadena;
}
