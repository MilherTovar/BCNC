package bcnc.com.prueba.application.service;

import bcnc.com.prueba.application.port.in.MonedaUseCase;
import bcnc.com.prueba.application.port.out.MonedaRepositoryPort;
import bcnc.com.prueba.domain.model.Moneda;

public class MonedaService implements MonedaUseCase {

    private final MonedaRepositoryPort monedaRepositoryPort;

    public MonedaService(MonedaRepositoryPort monedaRepositoryPort){
        this.monedaRepositoryPort = monedaRepositoryPort;
    }

    @Override
    public Moneda saveMoneda(Moneda moneda) {
        return this.monedaRepositoryPort.saveMoneda(moneda);

    }
}
