package adapter.out.persistence;

import bcnc.com.prueba.adapter.out.persistence.JpaCadenaRepositoryAdapter;
import bcnc.com.prueba.adapter.out.persistence.entity.CadenaEntity;
import bcnc.com.prueba.adapter.out.persistence.mapper.CadenaPersistenceMapperImpl;
import bcnc.com.prueba.adapter.out.persistence.springdata.CadenaJpaRepository;
import bcnc.com.prueba.domain.model.Cadena;
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
public class JpaCadenaRepositoryAdapterTest {

    @InjectMocks
    private JpaCadenaRepositoryAdapter jpaCadenaRepositoryAdapter;

    @Mock
    private CadenaJpaRepository cadenaJpaRepository;

    @Spy
    private CadenaPersistenceMapperImpl cadenaEntityMapper;

    @Test
    void when_cadena_is_saved(){
        CadenaEntity cadenaEntity = new CadenaEntity();
        cadenaEntity.setId(1);
        cadenaEntity.setNombreCadena("Zara-Test");
        lenient().when(this.cadenaJpaRepository.save(any())).thenReturn(
                cadenaEntity);
        Cadena cadena = Cadena.builder()
                .id(1)
                .nombreCadena("Zara-Test")
                .build();
        Cadena result = this.jpaCadenaRepositoryAdapter.saveCadena(cadena);
        verify(this.cadenaJpaRepository).save(any());
        assertThat(result).isNotNull();
    }
}
