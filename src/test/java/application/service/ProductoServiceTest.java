package application.service;

import bcnc.com.prueba.application.port.out.ProductoRepositoryPort;
import bcnc.com.prueba.application.service.ProductoService;
import bcnc.com.prueba.domain.model.Producto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductoServiceTest {

    @InjectMocks
    private ProductoService productoUseCase;

    @Mock
    private ProductoRepositoryPort productoRepositoryPort;

    @Test
    void when_producto_is_added(){
        Producto producto = Producto.builder()
                .id(1)
                .nombreProducto("ProductoTest")
                .build();
        when(this.productoRepositoryPort.saveProducto(any())).thenReturn(producto);
        Producto result = this.productoUseCase.saveProducto(producto);
        verify(this.productoRepositoryPort).saveProducto(any());
        assertThat(result).isNotNull();
    }
}
