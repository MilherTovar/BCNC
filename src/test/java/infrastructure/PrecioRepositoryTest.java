package infrastructure;

import bcnc.com.prueba.infrastruture.PrecioRepository;
import bcnc.com.prueba.infrastruture.entities.CadenaEntity;
import bcnc.com.prueba.infrastruture.entities.PrecioEntity;
import bcnc.com.prueba.infrastruture.mappers.PrecioEntityMapperImpl;
import bcnc.com.prueba.infrastruture.repository.PrecioDataRepository;
import bcnc.com.prueba.model.Precio;
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
public class PrecioRepositoryTest {

    @InjectMocks
    private PrecioRepository precioRepository;

    @Mock
    private PrecioDataRepository precioDataRepository;

    @Spy
    private PrecioEntityMapperImpl precioEntityMapper;

    @Test
    void when_precio_is_saved(){
        PrecioEntity precioEntity = new PrecioEntity();
        precioEntity.setPrecio(35.5);
        Precio precio = Precio.builder()
                .cadenaId(1)
                .productoId(1)
                .build();
        lenient().when(this.precioDataRepository.save(any())).thenReturn(
                precioEntity);
        Precio result = this.precioRepository.savePrecio(precio);
        verify(this.precioDataRepository).save(any());
        assertThat(result).isNotNull();
    }

    @Test
    void when_listado_precios_is_loaded(){
        PrecioEntity precioEntity = new PrecioEntity();
        precioEntity.setPrecio(35.5);
        List<PrecioEntity> precios = List.of(precioEntity);
        lenient().when(this.precioDataRepository.findAll(any(Specification.class)))
                .thenReturn(precios);
        OffsetDateTime fecha = OffsetDateTime.now();
        List<Precio> result = this.precioRepository.getPrecios(fecha, 1L,1L);
        verify(this.precioDataRepository).findAll(any(Specification.class));
        assertThat(result).isNotNull();
    }
}
