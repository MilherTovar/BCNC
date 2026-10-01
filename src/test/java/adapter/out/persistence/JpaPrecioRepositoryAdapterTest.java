package adapter.out.persistence;

import bcnc.com.prueba.adapter.out.persistence.JpaPrecioRepositoryAdapter;
import bcnc.com.prueba.adapter.out.persistence.entity.PrecioEntity;
import bcnc.com.prueba.adapter.out.persistence.mapper.PrecioPersistenceMapperImpl;
import bcnc.com.prueba.adapter.out.persistence.springdata.PrecioJpaRepository;
import bcnc.com.prueba.domain.model.Precio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.domain.Specification;

import java.time.OffsetDateTime;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.verify;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class JpaPrecioRepositoryAdapterTest {

    @InjectMocks
    private JpaPrecioRepositoryAdapter jpaPrecioRepositoryAdapter;

    @Mock
    private PrecioJpaRepository precioJpaRepository;

    @Spy
    private PrecioPersistenceMapperImpl precioEntityMapper;

    @Test
    void when_precio_is_saved(){
        PrecioEntity precioEntity = new PrecioEntity();
        precioEntity.setPrecio(35.5);
        Precio precio = Precio.builder()
                .cadenaId(1)
                .productoId(1)
                .build();
        lenient().when(this.precioJpaRepository.save(any())).thenReturn(
                precioEntity);
        Precio result = this.jpaPrecioRepositoryAdapter.savePrecio(precio);
        verify(this.precioJpaRepository).save(any());
        assertThat(result).isNotNull();
    }

    @Test
    void when_listado_precios_is_loaded(){
        PrecioEntity precioEntity = new PrecioEntity();
        precioEntity.setPrecio(35.5);
        List<PrecioEntity> precios = List.of(precioEntity);
        lenient().when(this.precioJpaRepository.findAll(any(Specification.class)))
                .thenReturn(precios);
        OffsetDateTime fecha = OffsetDateTime.now();
        List<Precio> result = this.jpaPrecioRepositoryAdapter.getPrecios(fecha, 1L,1L);
        verify(this.precioJpaRepository).findAll(any(Specification.class));
        assertThat(result).isNotNull();
    }
}
