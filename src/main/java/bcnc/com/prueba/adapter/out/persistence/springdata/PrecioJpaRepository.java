package bcnc.com.prueba.adapter.out.persistence.springdata;

import bcnc.com.prueba.adapter.out.persistence.entity.PrecioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PrecioJpaRepository extends JpaRepository<PrecioEntity, Integer>,
        JpaSpecificationExecutor<PrecioEntity> {
}
