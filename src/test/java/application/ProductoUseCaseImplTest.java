package application;

import bcnc.com.prueba.application.ProductoUseCaseImpl;
import bcnc.com.prueba.infrastruture.ProductoRepository;
import bcnc.com.prueba.model.Producto;
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
public class ProductoUseCaseImplTest {

    @InjectMocks
    private ProductoUseCaseImpl productoUseCase;

    @Mock
    private ProductoRepository productoRepository;

    @Test
    void when_producto_is_added(){
        Producto producto = Producto.builder()
                .id(1)
                .nombreProducto("ProductoTest")
                .build();
        lenient().when(this.productoRepository.saveProducto(any()))
                .thenReturn(producto);
        Producto result = this.productoUseCase.saveProducto(producto);
        verify(this.productoRepository).saveProducto(any());
        assertThat(result).isNotNull();
    }
}
