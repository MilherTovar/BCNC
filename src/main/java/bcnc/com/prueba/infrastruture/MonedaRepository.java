package bcnc.com.prueba.infrastruture;

import bcnc.com.prueba.infrastruture.mappers.MonedaEntityMapper;
import bcnc.com.prueba.infrastruture.repository.MonedaDataRepository;
import bcnc.com.prueba.model.Moneda;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MonedaRepository {

    private static final Logger logger = LoggerFactory.getLogger(MonedaRepository.class);

    @Autowired
    private MonedaEntityMapper monedaEntityMapper;

    @Autowired
    private MonedaDataRepository monedaDataRepository;

    public Moneda saveMoneda(Moneda moneda){
        logger.info("Saving moneda: {}, - Repository", moneda);
        return this.monedaEntityMapper.map(this.monedaDataRepository.save(
                this.monedaEntityMapper.map(moneda)
        ));
    }
}
