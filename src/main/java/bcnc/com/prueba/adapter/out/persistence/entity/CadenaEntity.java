package bcnc.com.prueba.adapter.out.persistence.entity;

import jakarta.persistence.*;
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
