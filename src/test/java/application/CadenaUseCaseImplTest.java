package application;

import bcnc.com.prueba.application.CadenaUseCaseImpl;
import bcnc.com.prueba.infrastruture.CadenaRepository;
import bcnc.com.prueba.model.Cadena;
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
public class CadenaUseCaseImplTest {

    @InjectMocks
    private CadenaUseCaseImpl cadenaUseCase;

    @Mock
    private CadenaRepository cadenaRepository;

    @Test
    void when_cadena_is_added(){
        Cadena cadena = Cadena.builder()
                .id(1)
                .nombreCadena("Zara-Test")
                .build();
        lenient().when(this.cadenaRepository.saveCadena(any()))
                .thenReturn(cadena);
        Cadena result = this.cadenaUseCase.saveCadena(cadena);
        verify(this.cadenaRepository).saveCadena(any());
        assertThat(result).isNotNull();
    }
}
