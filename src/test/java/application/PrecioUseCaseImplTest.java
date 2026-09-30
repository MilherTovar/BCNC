package application;

import bcnc.com.prueba.application.PrecioUseCaseImpl;
import bcnc.com.prueba.infrastruture.PrecioRepository;
import bcnc.com.prueba.model.Precio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.verify;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class PrecioUseCaseImplTest {

    @InjectMocks
    private PrecioUseCaseImpl precioUseCase;

    @Mock
    private PrecioRepository precioRepository;

    @Test
    void when_precio_is_added(){
        Precio precio = Precio.builder()
                .productoId(32)
                .cadenaId(1)
                .build();
        lenient().when(this.precioRepository.savePrecio(any()))
                .thenReturn(precio);
        Precio result = this.precioUseCase.savePrecio(precio);
        verify(this.precioRepository).savePrecio(any());
        assertThat(result).isNotNull();
    }

    @Test
    void when_listado_precios_is_load(){
        Precio precio = Precio.builder()
                .productoId(32)
                .cadenaId(1)
                .build();
        List<Precio>precios = List.of(precio);
        lenient().when(this.precioRepository.getPrecios(any(), any(), any()))
                .thenReturn(precios);
        List<Precio> result = this.precioUseCase.getPrecios(any(), any(), any());
        verify(this.precioRepository).getPrecios(any(), any(), any());
        assertThat(result).isNotNull();
    }
}
