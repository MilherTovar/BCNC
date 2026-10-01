package adapter.in.web;

import bcnc.com.prueba.PruebaApplication;
import bcnc.com.prueba.adapter.in.web.PreciosController;
import bcnc.com.prueba.adapter.in.web.PreciosWebMapper;
import bcnc.com.prueba.adapter.in.web.dto.PreciosDTO;
import bcnc.com.prueba.application.port.in.PrecioUseCase;
import bcnc.com.prueba.domain.model.Precio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PreciosController.class)
@ContextConfiguration(classes = PruebaApplication.class)
public class PreciosControllerTest {

    @MockitoBean
    private PrecioUseCase precioUseCase;

    @MockitoBean
    private PreciosWebMapper preciosWebMapper;

    @Autowired
    private MockMvc mockMvc;

    private static final String PATH = "http://localhost:8080/api/precio";

    @Test
    void when_search_is_correct() throws Exception {
        Precio precio = Precio.builder()
                .cadenaId(1)
                .productoId(34)
                .build();
        List<Precio> precios = List.of(precio);
        PreciosDTO preciosDTO = new PreciosDTO();
        preciosDTO.setCadenaId(1L);
        preciosDTO.setProductoId(35L);
        List<PreciosDTO> preciosDTOs = List.of(preciosDTO);
        when(this.precioUseCase.getPrecios(any(), any(), any()))
                .thenReturn(precios);
        when(this.preciosWebMapper.map(Collections.singletonList(any()), any())).thenReturn(preciosDTOs);
        final var response = this.mockMvc.perform(MockMvcRequestBuilders.get(PATH + "/busquedaPrecios?fechaAplicacion=2020-06-16T00:00:00Z&cadenaId=1&productoId=35455"));
        verify(this.precioUseCase).getPrecios(any(), any(), any());
        response.andExpect(status().isOk());
    }
}
