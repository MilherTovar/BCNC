package infrastructure;

import bcnc.com.prueba.infrastruture.MonedaRepository;
import bcnc.com.prueba.infrastruture.entities.MonedaEntity;
import bcnc.com.prueba.infrastruture.mappers.MonedaEntityMapperImpl;
import bcnc.com.prueba.infrastruture.repository.MonedaDataRepository;
import bcnc.com.prueba.model.Moneda;
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
public class MonedaRepositoryTest {

    @InjectMocks
    private MonedaRepository monedaRepository;

    @Mock
    private MonedaDataRepository monedaDataRepository;

    @Spy
    private MonedaEntityMapperImpl monedaEntityMapper;

    @Test
    void when_moneda_is_saved(){
        MonedaEntity monedaEntity = new MonedaEntity();
        monedaEntity.setId(1);
        monedaEntity.setMonedaNombre("Euro-test");
        Moneda moneda = Moneda.builder()
                .id(1)
                .monedaNombre("Euro-Test")
                .build();
        lenient().when(this.monedaDataRepository.save(any())).thenReturn(monedaEntity);
        Moneda result = this.monedaRepository.saveMoneda(moneda);
        verify(this.monedaDataRepository).save(any());
        assertThat(result).isNotNull();
    }
}
