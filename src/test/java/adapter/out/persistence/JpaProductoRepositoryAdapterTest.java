package adapter.out.persistence;

import bcnc.com.prueba.adapter.out.persistence.JpaProductoRepositoryAdapter;
import bcnc.com.prueba.adapter.out.persistence.entity.ProductoEntity;
import bcnc.com.prueba.adapter.out.persistence.mapper.ProductoPersistenceMapperImpl;
import bcnc.com.prueba.adapter.out.persistence.springdata.ProductoJpaRepository;
import bcnc.com.prueba.domain.model.Producto;
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
public class JpaProductoRepositoryAdapterTest {

    @InjectMocks
    private JpaProductoRepositoryAdapter jpaProductoRepositoryAdapter;

    @Mock
    private ProductoJpaRepository productoJpaRepository;

    @Spy
    private ProductoPersistenceMapperImpl productoEntityMapper;

    @Test
    void when_producto_is_saved() {
        ProductoEntity productoEntity = new ProductoEntity();
        productoEntity.setId(1);
        productoEntity.setNombreProducto("Producto-test");
        Producto producto = Producto.builder()
                .id(1)
                .nombreProducto("Producto-test")
                .build();
        lenient().when(this.productoJpaRepository.save(any())).thenReturn(productoEntity);
        Producto result = this.jpaProductoRepositoryAdapter.saveProducto(producto);
        verify(this.productoJpaRepository).save(any());
        assertThat(result).isNotNull();
    }
}
