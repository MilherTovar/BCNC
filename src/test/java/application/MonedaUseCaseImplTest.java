package application;

import bcnc.com.prueba.application.MonedaUseCaseImpl;
import bcnc.com.prueba.infrastruture.MonedaRepository;
import bcnc.com.prueba.model.Moneda;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.verify;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class MonedaUseCaseImplTest {

    @InjectMocks
    private MonedaUseCaseImpl monedaUseCase;

    @Mock
    private MonedaRepository monedaRepository;

    @Test
    void when_moneda_is_added(){
        Moneda moneda = Moneda.builder()
                .id(1)
                .monedaNombre("Euro-test")
                .build();
        lenient().when(this.monedaRepository.saveMoneda(any())).thenReturn(moneda);
        Moneda result = this.monedaUseCase.saveMoneda(moneda);
        verify(this.monedaRepository).saveMoneda(any());
        assertThat(result).isNotNull();
    }
}
