
package Tp.DS.Vendedor;

import Tp.DS.Coordenada.Coordenada;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class VendedorControllerTest {
    @Mock
    private DAOVendedor vendedorDAO = new VendedorJDBC();
    @InjectMocks
    private VendedorController vendedorController;
    

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        
        vendedorController = VendedorController.getInstance(vendedorDAO);
    }

    @Test
    void testMostrarListaVendedores() {

        List<Vendedor> vendedoresSimulados = Arrays.asList(
            new Vendedor(1, "Juan", "Calle Falsa 123", new Coordenada(1, -34.6037, -58.3816)),
            new Vendedor(2, "Pedro", "Av. Siempre Viva 742", new Coordenada(2, -33.4489, -70.6693))
        );
        
        when(vendedorDAO.listarVendedores()).thenReturn(vendedoresSimulados);

        List<Vendedor> vendedores = vendedorController.mostrarListaVendedor();

        assertNotNull(vendedores);
        assertEquals(2, vendedores.size());
        assertEquals(vendedoresSimulados, vendedores);
        verify(vendedorDAO).listarVendedores(); // Verifica que se llamó al método
    }

    @Test
    void testCrearNuevoVendedor() {
        Coordenada coordenada = new Coordenada(-34.6037, -58.3816);
        doNothing().when(vendedorDAO).crearVendedor(any(Vendedor.class));

        // Ejecución del método
        vendedorController.crearNuevoVendedor("Maria", "Calle Ejemplo 456", coordenada);

        // Verificación
        verify(vendedorDAO, times(1)).crearVendedor(any(Vendedor.class));
    }

    @Test
    void testModificarVendedor() {
        Coordenada coordenada = new Coordenada(1, -34.6037, -58.3816);
        Vendedor vendedorExistente = new Vendedor(1, "Juan", "Calle Falsa 123", coordenada);

        when(vendedorDAO.buscarVendedorPorId(1)).thenReturn(vendedorExistente);
        doNothing().when(vendedorDAO).actualizarVendedor(any(Vendedor.class));

        // Ejecución del método
        Coordenada nuevaCoordenada = new Coordenada(-33.4489, -70.6693);
        vendedorController.modificarVendedor(1, "Juan Actualizado", "Av. Nueva 789", nuevaCoordenada);

        // Verificación
        verify(vendedorDAO, times(1)).buscarVendedorPorId(1);
        verify(vendedorDAO, times(1)).actualizarVendedor(any(Vendedor.class));
    }

    @Test
    void testModificarVendedorNoExistente() {
        when(vendedorDAO.buscarVendedorPorId(99)).thenReturn(null);

        // Verificación de excepción
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> vendedorController.modificarVendedor(99, "Nombre", "Direccion", new Coordenada(-34.6037, -58.3816))
        );

        assertEquals("El vendedor con ID 99 no existe.", exception.getMessage());
        verify(vendedorDAO, times(1)).buscarVendedorPorId(99);
        verify(vendedorDAO, times(0)).actualizarVendedor(any(Vendedor.class));
    }

    @Test
    void testEliminarVendedor() {
        Coordenada coordenada = new Coordenada(1, -34.6037, -58.3816);
        Vendedor vendedorExistente = new Vendedor(1, "Juan", "Calle Falsa 123", coordenada);

        when(vendedorDAO.buscarVendedorPorId(1)).thenReturn(vendedorExistente);
        doNothing().when(vendedorDAO).eliminarVendedor(1);

        // Ejecución del método
        vendedorController.eliminarVendedor(1);

        // Verificación
        verify(vendedorDAO, times(1)).buscarVendedorPorId(1);
        verify(vendedorDAO, times(1)).eliminarVendedor(1);
    }

    @Test
    void testEliminarVendedorNoExistente() {
        when(vendedorDAO.buscarVendedorPorId(99)).thenReturn(null);

        // Verificación de excepción
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> vendedorController.eliminarVendedor(99)
        );

        assertEquals("El vendedor con ID 99 no existe.", exception.getMessage());
        verify(vendedorDAO, times(1)).buscarVendedorPorId(99);
        verify(vendedorDAO, times(0)).eliminarVendedor(99);
    }
    

    @Test
    void testBuscarVendedor() {
        Coordenada coordenada = new Coordenada(1, -34.6037, -58.3816);
        Vendedor vendedor = new Vendedor(1, "Juan", "Calle Falsa 123", coordenada);

        when(vendedorDAO.buscarVendedorPorId(1)).thenReturn(vendedor);

        // Ejecución del método
        Vendedor resultado = vendedorController.buscarVendedor(1);

        // Verificación
        assertNotNull(resultado);
        assertEquals(1, resultado.getId());
        assertEquals("Juan", resultado.getNombre());
        verify(vendedorDAO, times(1)).buscarVendedorPorId(1);
    }

    @Test
    void testBuscarVendedorNoExistente() {
        when(vendedorDAO.buscarVendedorPorId(99)).thenReturn(null);

        // Ejecución del método
        Vendedor resultado = vendedorController.buscarVendedor(99);

        // Verificación
        assertNull(resultado);
        verify(vendedorDAO, times(1)).buscarVendedorPorId(99);
    }
}
