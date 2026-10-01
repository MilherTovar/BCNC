package adapter.out.persistence;

import bcnc.com.prueba.adapter.out.persistence.JpaMonedaRepositoryAdapter;
import bcnc.com.prueba.adapter.out.persistence.entity.MonedaEntity;
import bcnc.com.prueba.adapter.out.persistence.mapper.MonedaPersistenceMapperImpl;
import bcnc.com.prueba.adapter.out.persistence.springdata.MonedaJpaRepository;
import bcnc.com.prueba.domain.model.Moneda;
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
public class JpaMonedaRepositoryAdapterTest {

    @InjectMocks
    private JpaMonedaRepositoryAdapter jpaMonedaRepositoryAdapter;

    @Mock
    private MonedaJpaRepository monedaJpaRepository;

    @Spy
    private MonedaPersistenceMapperImpl monedaEntityMapper;

    @Test
    void when_moneda_is_saved(){
        MonedaEntity monedaEntity = new MonedaEntity();
        monedaEntity.setId(1);
        monedaEntity.setMonedaNombre("Euro-test");
        Moneda moneda = Moneda.builder()
                .id(1)
                .monedaNombre("Euro-Test")
                .build();
        lenient().when(this.monedaJpaRepository.save(any())).thenReturn(monedaEntity);
        Moneda result = this.jpaMonedaRepositoryAdapter.saveMoneda(moneda);
        verify(this.monedaJpaRepository).save(any());
        assertThat(result).isNotNull();
    }
}
