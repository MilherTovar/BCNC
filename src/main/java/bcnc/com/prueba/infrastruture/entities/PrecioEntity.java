package bcnc.com.prueba.infrastruture.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "precio")
@Getter
@Setter
public class PrecioEntity {

    @Id
    private Integer id;

    @Column(name = "fechaInicial")
    private LocalDateTime fechaInicial;

    @Column(name = "fechaFinal")
    private LocalDateTime fechaFinal;

    @Column(name = "precio")
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "cadenaId", foreignKey = @ForeignKey(name = "fk_cadena_precio"))
    private CadenaEntity cadenaId;

    @ManyToOne
    @JoinColumn(name = "productoId", foreignKey = @ForeignKey(name = "fk_producto_precio"))
    private ProductoEntity productoId;

    @Column(name = "prioridad")
    private Integer prioridad;

    @ManyToOne
    @JoinColumn(name = "monedaId", foreignKey = @ForeignKey(name = "fk_moneda_precio"))
    private MonedaEntity monedaId;
}
