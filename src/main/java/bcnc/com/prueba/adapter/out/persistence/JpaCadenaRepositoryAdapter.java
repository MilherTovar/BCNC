package bcnc.com.prueba.adapter.out.persistence;

import bcnc.com.prueba.adapter.out.persistence.mapper.CadenaPersistenceMapper;
import bcnc.com.prueba.adapter.out.persistence.springdata.CadenaJpaRepository;
import bcnc.com.prueba.application.port.out.CadenaRepositoryPort;
import bcnc.com.prueba.domain.model.Cadena;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JpaCadenaRepositoryAdapter implements CadenaRepositoryPort {

    private static final Logger logger = LoggerFactory.getLogger(JpaCadenaRepositoryAdapter.class);

    @Autowired
    private CadenaPersistenceMapper cadenaPersistenceMapper;

    @Autowired
    private CadenaJpaRepository cadenaJpaRepository;

    @Override
    public Cadena saveCadena(Cadena cadena){
        logger.info("Saving cadena: {}, - Repository", cadena);
        return this.cadenaPersistenceMapper.map(this.cadenaJpaRepository.save(
                this.cadenaPersistenceMapper.map(cadena)
        ));
    }
}
