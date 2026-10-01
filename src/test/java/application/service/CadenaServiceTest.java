package application.service;

import bcnc.com.prueba.application.port.out.CadenaRepositoryPort;
import bcnc.com.prueba.application.service.CadenaService;
import bcnc.com.prueba.domain.model.Cadena;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class CadenaServiceTest {

    @InjectMocks
    private CadenaService cadenaUseCase;

    @Mock
    private CadenaRepositoryPort cadenaRepositoryPort;

    @Test
    void when_cadena_is_added(){
        Cadena cadena = Cadena.builder()
                .id(1)
                .nombreCadena("Zara-Test")
                .build();
        when(this.cadenaRepositoryPort.saveCadena(any())).thenReturn(cadena);
        Cadena result = this.cadenaUseCase.saveCadena(cadena);
        verify(this.cadenaRepositoryPort).saveCadena(any());
        assertThat(result).isNotNull();
    }
}
