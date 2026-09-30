package bcnc.com.prueba.infrastruture;

import bcnc.com.prueba.infrastruture.entities.PrecioEntity;
import bcnc.com.prueba.infrastruture.mappers.PrecioEntityMapper;
import bcnc.com.prueba.infrastruture.repository.PrecioDataRepository;
import bcnc.com.prueba.model.Precio;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class PrecioRepository {

    private static final Logger logger = LoggerFactory.getLogger(PrecioRepository.class);

    @Autowired
    private PrecioDataRepository precioDataRepository;

    @Autowired
    private PrecioEntityMapper precioEntityMapper;

    public Precio savePrecio(Precio precio) {
        logger.info("Saving price: {}, - Repository", precio);
        return this.precioEntityMapper.map(this.precioDataRepository.save(
                this.precioEntityMapper.map(precio)
        ));
    }

    public List<Precio> getPrecios(OffsetDateTime fechaAplication, Long cadenaId, Long productoId){
        logger.info("Get Precios, FechaAplicacion: {}, Cadena: {}, Producto {} - Repository",
        fechaAplication, cadenaId, productoId);
        return this.precioEntityMapper.map(this.precioDataRepository.findAll(
                filter(fechaAplication, cadenaId, productoId)
        ));
    }

    Specification<PrecioEntity> filter(OffsetDateTime fechaAplication, Long cadenaId, Long productoId){
        return (Root<PrecioEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            LocalDateTime fecha = fechaAplication.toLocalDateTime();
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("cadenaId").get("id"), cadenaId));
            predicates.add(criteriaBuilder.equal(root.get("productoId").get("id"), productoId));
            predicates.add(criteriaBuilder.lessThanOrEqualTo(
                    root.<LocalDateTime>get("fechaInicial"), fecha));
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(
                    root.<LocalDateTime>get("fechaFinal"), fecha));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
