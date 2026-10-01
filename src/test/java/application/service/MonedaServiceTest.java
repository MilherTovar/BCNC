package application.service;

import bcnc.com.prueba.application.port.out.MonedaRepositoryPort;
import bcnc.com.prueba.application.service.MonedaService;
import bcnc.com.prueba.domain.model.Moneda;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MonedaServiceTest {

    @InjectMocks
    private MonedaService monedaUseCase;

    @Mock
    private MonedaRepositoryPort monedaRepositoryPort;

    @Test
    void when_moneda_is_added(){
        Moneda moneda = Moneda.builder()
                .id(1)
                .monedaNombre("Euro-test")
                .build();
        when(this.monedaRepositoryPort.saveMoneda(any())).thenReturn(moneda);
        Moneda result = this.monedaUseCase.saveMoneda(moneda);
        verify(this.monedaRepositoryPort).saveMoneda(any());
        assertThat(result).isNotNull();
    }
}
