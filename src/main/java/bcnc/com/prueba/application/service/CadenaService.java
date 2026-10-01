package bcnc.com.prueba.application.service;

import bcnc.com.prueba.application.port.in.CadenaUseCase;
import bcnc.com.prueba.application.port.out.CadenaRepositoryPort;
import bcnc.com.prueba.domain.model.Cadena;

public class CadenaService implements CadenaUseCase {

    private final CadenaRepositoryPort cadenaRepositoryPort;

    public CadenaService(CadenaRepositoryPort cadenaRepositoryPort){
        this.cadenaRepositoryPort = cadenaRepositoryPort;
    }

    @Override
    public Cadena saveCadena(Cadena cadena) {
        return this.cadenaRepositoryPort.saveCadena(cadena);
    }
}
