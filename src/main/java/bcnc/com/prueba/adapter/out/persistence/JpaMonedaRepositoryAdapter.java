package bcnc.com.prueba.adapter.out.persistence;

import bcnc.com.prueba.adapter.out.persistence.mapper.MonedaPersistenceMapper;
import bcnc.com.prueba.adapter.out.persistence.springdata.MonedaJpaRepository;
import bcnc.com.prueba.application.port.out.MonedaRepositoryPort;
import bcnc.com.prueba.domain.model.Moneda;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JpaMonedaRepositoryAdapter implements MonedaRepositoryPort {

    private static final Logger logger = LoggerFactory.getLogger(JpaMonedaRepositoryAdapter.class);

    @Autowired
    private MonedaPersistenceMapper monedaPersistenceMapper;

    @Autowired
    private MonedaJpaRepository monedaJpaRepository;

    @Override
    public Moneda saveMoneda(Moneda moneda){
        logger.info("Saving moneda: {}, - Repository", moneda);
        return this.monedaPersistenceMapper.map(this.monedaJpaRepository.save(
                this.monedaPersistenceMapper.map(moneda)
        ));
    }
}
