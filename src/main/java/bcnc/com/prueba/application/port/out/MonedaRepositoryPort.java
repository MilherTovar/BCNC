package bcnc.com.prueba.application.port.out;

import bcnc.com.prueba.domain.model.Moneda;

public interface MonedaRepositoryPort {
    Moneda saveMoneda(Moneda moneda);
}
