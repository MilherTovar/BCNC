package bcnc.com.prueba.infrastruture;

import bcnc.com.prueba.infrastruture.mappers.CadenaEntityMapper;
import bcnc.com.prueba.infrastruture.repository.CadenaDataRepository;
import bcnc.com.prueba.model.Cadena;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadenaRepository {

    private static final Logger logger = LoggerFactory.getLogger(CadenaRepository.class);

    @Autowired
    private CadenaEntityMapper cadenaEntityMapper;

    @Autowired
    private CadenaDataRepository cadenaDataRepository;

    public Cadena saveCadena(Cadena cadena){
        logger.info("Saving cadena: {}, - Repository", cadena);
        return this.cadenaEntityMapper.map(this.cadenaDataRepository.save(
                this.cadenaEntityMapper.map(cadena)
        ));
    }
}
