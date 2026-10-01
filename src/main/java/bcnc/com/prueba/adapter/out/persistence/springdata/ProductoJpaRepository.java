package bcnc.com.prueba.adapter.out.persistence.springdata;

import bcnc.com.prueba.adapter.out.persistence.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoJpaRepository extends JpaRepository<ProductoEntity, Integer> {
}
