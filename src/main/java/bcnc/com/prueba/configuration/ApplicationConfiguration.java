package bcnc.com.prueba.configuration;

import bcnc.com.prueba.application.port.in.CadenaUseCase;
import bcnc.com.prueba.application.port.in.MonedaUseCase;
import bcnc.com.prueba.application.port.in.PrecioUseCase;
import bcnc.com.prueba.application.port.in.ProductoUseCase;
import bcnc.com.prueba.application.port.out.CadenaRepositoryPort;
import bcnc.com.prueba.application.port.out.MonedaRepositoryPort;
import bcnc.com.prueba.application.port.out.PrecioRepositoryPort;
import bcnc.com.prueba.application.port.out.ProductoRepositoryPort;
import bcnc.com.prueba.application.service.CadenaService;
import bcnc.com.prueba.application.service.MonedaService;
import bcnc.com.prueba.application.service.PrecioService;
import bcnc.com.prueba.application.service.ProductoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public CadenaUseCase cadenaUseCase(CadenaRepositoryPort cadenaRepositoryPort){
        return new CadenaService(cadenaRepositoryPort);
    }

    @Bean
    public MonedaUseCase monedaUseCase(MonedaRepositoryPort monedaRepositoryPort){
        return new MonedaService(monedaRepositoryPort);
    }

    @Bean
    public PrecioUseCase precioUseCase(PrecioRepositoryPort precioRepositoryPort){
        return new PrecioService(precioRepositoryPort);
    }

    @Bean
    public ProductoUseCase productoUseCase(ProductoRepositoryPort productoRepositoryPort){
        return new ProductoService(productoRepositoryPort);
    }
}
