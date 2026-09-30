package infrastructure;

import bcnc.com.prueba.infrastruture.ProductoRepository;
import bcnc.com.prueba.infrastruture.entities.ProductoEntity;
import bcnc.com.prueba.infrastruture.mappers.ProductoEntityMapperImpl;
import bcnc.com.prueba.infrastruture.repository.ProductoDataRepository;
import bcnc.com.prueba.model.Producto;
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
public class ProductoRepositoryTest {

    @InjectMocks
    private ProductoRepository productoRepository;

    @Mock
    private ProductoDataRepository productoDataRepository;

    @Spy
    private ProductoEntityMapperImpl productoEntityMapper;

    @Test
    void when_producto_is_saved() {
        ProductoEntity productoEntity = new ProductoEntity();
        productoEntity.setId(1);
        productoEntity.setNombreProducto("Producto-test");
        Producto producto = Producto.builder()
                .id(1)
                .nombreProducto("Producto-test")
                .build();
        lenient().when(this.productoDataRepository.save(any())).thenReturn(productoEntity);
        Producto result = this.productoRepository.saveProducto(producto);
        verify(this.productoDataRepository).save(any());
        assertThat(result).isNotNull();
    }
}
