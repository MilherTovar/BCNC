package bcnc.com.prueba.application;

import bcnc.com.prueba.domain.MonedaUseCase;
import bcnc.com.prueba.infrastruture.MonedaRepository;
import bcnc.com.prueba.model.Moneda;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MonedaUseCaseImpl implements MonedaUseCase {

    private static final Logger logger = LoggerFactory.getLogger(MonedaUseCaseImpl.class);

    @Autowired
    private MonedaRepository monedaRepository;

    @Override
    public Moneda saveMoneda(Moneda moneda) {
        logger.info("Saving Moneda: {}, - Use Case", moneda);
        try{
            return this.monedaRepository.saveMoneda(moneda);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error saving Moneda: "
            + e.getMessage());
        }
    }
}
