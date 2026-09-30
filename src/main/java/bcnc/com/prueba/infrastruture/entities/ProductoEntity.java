package bcnc.com.prueba.infrastruture.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "producto")
@Getter
@Setter
public class ProductoEntity {

    @Id
    private Integer id;

    @Column(name = "nombreProducto")
    private String nombreProducto;
}
