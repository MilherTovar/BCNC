package bcnc.com.prueba.infrastruture.repository;

import bcnc.com.prueba.infrastruture.entities.MonedaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonedaDataRepository extends JpaRepository<MonedaEntity, Integer> {
}
