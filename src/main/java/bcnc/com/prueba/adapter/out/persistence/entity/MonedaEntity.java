package bcnc.com.prueba.adapter.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "moneda")
@Getter
@Setter
public class MonedaEntity {

    @Id
    private Integer id;

    @Column(name = "nombreMoneda")
    private String monedaNombre;
}
