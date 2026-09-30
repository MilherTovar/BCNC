package bcnc.com.prueba.infrastruture.repository;

import bcnc.com.prueba.infrastruture.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoDataRepository extends JpaRepository<ProductoEntity, Integer> {
}
