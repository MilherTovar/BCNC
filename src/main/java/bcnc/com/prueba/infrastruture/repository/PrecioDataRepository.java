package bcnc.com.prueba.infrastruture.repository;

import bcnc.com.prueba.infrastruture.entities.PrecioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PrecioDataRepository extends JpaRepository<PrecioEntity, Integer>,
        JpaSpecificationExecutor<PrecioEntity> {
}
