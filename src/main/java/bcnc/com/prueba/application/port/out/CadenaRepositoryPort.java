package bcnc.com.prueba.application.port.out;

import bcnc.com.prueba.domain.model.Cadena;

public interface CadenaRepositoryPort {
    Cadena saveCadena(Cadena cadena);
}