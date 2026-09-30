package infrastructure;

import bcnc.com.prueba.infrastruture.CadenaRepository;
import bcnc.com.prueba.infrastruture.entities.CadenaEntity;
import bcnc.com.prueba.infrastruture.mappers.CadenaEntityMapperImpl;
import bcnc.com.prueba.infrastruture.repository.CadenaDataRepository;
import bcnc.com.prueba.model.Cadena;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.verify;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class CadenaRepositoryTest {

    @InjectMocks
    private CadenaRepository cadenaRepository;

    @Mock
    private CadenaDataRepository cadenaDataRepository;

    @Spy
    private CadenaEntityMapperImpl cadenaEntityMapper;

    @Test
    void when_cadena_is_saved(){
        CadenaEntity cadenaEntity = new CadenaEntity();
        cadenaEntity.setId(1);
        cadenaEntity.setNombreCadena("Zara-Test");
        lenient().when(this.cadenaDataRepository.save(any())).thenReturn(
                cadenaEntity);
        Cadena cadena = Cadena.builder()
                .id(1)
                .nombreCadena("Zara-Test")
                .build();
        Cadena result = this.cadenaRepository.saveCadena(cadena);
        verify(this.cadenaDataRepository).save(any());
        assertThat(result).isNotNull();
    }
}
