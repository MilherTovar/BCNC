package bcnc.com.prueba.adapter.out.persistence.springdata;

import bcnc.com.prueba.adapter.out.persistence.entity.CadenaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadenaJpaRepository extends JpaRepository<CadenaEntity, Integer> {
}
