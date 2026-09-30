package bcnc.com.prueba.application;

import bcnc.com.prueba.domain.CadenaUseCase;
import bcnc.com.prueba.infrastruture.CadenaRepository;
import bcnc.com.prueba.model.Cadena;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CadenaUseCaseImpl implements CadenaUseCase {

    private static final Logger logger = LoggerFactory.getLogger(CadenaUseCaseImpl.class);

    @Autowired
    private CadenaRepository cadenaRepository;

    @Override
    public Cadena saveCadena(Cadena cadena) {
        logger.info("Saving Cadena: {} - UseCase", cadena);
        try{
            return this.cadenaRepository.saveCadena(cadena);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Error saving cadena: " + e.getMessage());
        }
    }
}
