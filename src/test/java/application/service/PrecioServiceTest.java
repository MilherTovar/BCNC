package application.service;

import bcnc.com.prueba.application.port.out.PrecioRepositoryPort;
import bcnc.com.prueba.application.service.PrecioService;
import bcnc.com.prueba.domain.model.Precio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PrecioServiceTest {

    @InjectMocks
    private PrecioService precioUseCase;

    @Mock
    private PrecioRepositoryPort precioRepositoryPort;


    @Test
    void when_precio_is_added(){
        Precio precio = Precio.builder()
                .productoId(32)
                .cadenaId(1)
                .build();
        when(this.precioRepositoryPort.savePrecio(any())).thenReturn(precio);
        Precio result = this.precioUseCase.savePrecio(precio);
        verify(this.precioRepositoryPort).savePrecio(any());
        assertThat(result).isNotNull();
    }

    @Test
    void when_listado_precios_is_load(){
        Precio precio = Precio.builder()
                .productoId(32)
                .cadenaId(1)
                .build();
        List<Precio>precios = List.of(precio);
        when(this.precioRepositoryPort.getPrecios(any(), any(), any())).thenReturn(precios);
        List<Precio> result = this.precioUseCase.getPrecios(any(), any(), any());
        verify(this.precioRepositoryPort).getPrecios(any(), any(), any());
        assertThat(result).isNotNull();
    }
}
