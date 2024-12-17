
package Tp.DS.Vendedor;

import isi.deso.tpds.Vendedor.VendedorJDBC;
import isi.deso.tpds.Vendedor.VendedorController;
import isi.deso.tpds.Vendedor.DAOVendedor;
import isi.deso.tpds.Vendedor.Vendedor;
import isi.deso.tpds.Coordenada.Coordenada;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class VendedorControllerTest {
    private VendedorController vendedorController;
    private DAOVendedor vendedorDAO = new VendedorJDBC();

    @BeforeEach
    void setUp() {
        VendedorController.resetInstance();
        vendedorDAO = Mockito.mock(DAOVendedor.class);
        vendedorController = VendedorController.getInstance(vendedorDAO);
    }

    @Test
    void testMostrarListaVendedores() {
        Coordenada coordenada1 = new Coordenada(1, -34.6037, -58.3816);
        Coordenada coordenada2 = new Coordenada(2, -33.4489, -70.6693);

        Vendedor vendedor1 = new Vendedor(1, "Juan", "Calle Falsa 123", coordenada1);
        Vendedor vendedor2 = new Vendedor(2, "Pedro", "Av. Siempre Viva 742", coordenada2);

        when(vendedorDAO.listarVendedores()).thenReturn(Arrays.asList(vendedor1, vendedor2));

        List<Vendedor> vendedores = vendedorController.mostrarListaVendedor();

        assertEquals(2, vendedores.size());
        assertEquals("Juan", vendedores.get(0).getNombre());
        assertEquals("Pedro", vendedores.get(1).getNombre());
        verify(vendedorDAO, times(1)).listarVendedores();
    }

    @Test
    void testCrearNuevoVendedor() {
        Coordenada coordenada = new Coordenada(-34.6037, -58.3816);
        doNothing().when(vendedorDAO).crearVendedor(any(Vendedor.class));

        vendedorController.crearNuevoVendedor("Maria", "Calle Ejemplo 456", coordenada);

        verify(vendedorDAO, times(1)).crearVendedor(argThat(v -> 
            v.getNombre().equals("Maria") &&
            v.getDireccion().equals("Calle Ejemplo 456") &&
            v.getCoordenadas().getLat() == -34.6037 &&
            v.getCoordenadas().getLng() == -58.3816
        ));
    }

    @Test
    void testModificarVendedor() {
        Coordenada coordenada = new Coordenada(1, -34.6037, -58.3816);
        Vendedor vendedorExistente = new Vendedor(1, "Juan", "Calle Falsa 123", coordenada);

        when(vendedorDAO.buscarVendedorPorId(1)).thenReturn(vendedorExistente);
        doNothing().when(vendedorDAO).actualizarVendedor(any(Vendedor.class));

        Coordenada nuevaCoordenada = new Coordenada(-33.4489, -70.6693);

        vendedorController.modificarVendedor(1, "Juan Actualizado", "Av. Nueva 789", nuevaCoordenada);

        verify(vendedorDAO, times(1)).buscarVendedorPorId(1);
        verify(vendedorDAO, times(1)).actualizarVendedor(argThat(v -> 
            v.getId() == 1 &&
            v.getNombre().equals("Juan Actualizado") &&
            v.getDireccion().equals("Av. Nueva 789") &&
            v.getCoordenadas().getLat() == -33.4489 &&
            v.getCoordenadas().getLng() == -70.6693
        ));
    }

    @Test
    void testModificarVendedorNoExistente() {
        when(vendedorDAO.buscarVendedorPorId(99)).thenReturn(null);

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> vendedorController.modificarVendedor(99, "Nombre", "Direccion", new Coordenada(-34.6037, -58.3816))
        );

        assertEquals("El vendedor con ID 99 no existe.", exception.getMessage());

        
        verify(vendedorDAO, times(1)).buscarVendedorPorId(99);
        verify(vendedorDAO, never()).actualizarVendedor(any(Vendedor.class));
    }


    @Test
    void testEliminarVendedor() {
        Coordenada coordenada = new Coordenada(1, -34.6037, -58.3816);
        Vendedor vendedorExistente = new Vendedor(1, "Juan", "Calle Falsa 123", coordenada);

        when(vendedorDAO.buscarVendedorPorId(1)).thenReturn(vendedorExistente);
        doNothing().when(vendedorDAO).eliminarVendedor(1);

        vendedorController.eliminarVendedor(1);

        verify(vendedorDAO, times(1)).buscarVendedorPorId(1);
        verify(vendedorDAO, times(1)).eliminarVendedor(1);
    }

    @Test
    void testEliminarVendedorNoExistente() {
        when(vendedorDAO.buscarVendedorPorId(99)).thenReturn(null);

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> vendedorController.eliminarVendedor(99)
        );

        assertEquals("El vendedor con ID 99 no existe.", exception.getMessage());

        verify(vendedorDAO, times(1)).buscarVendedorPorId(99);
        verify(vendedorDAO, never()).eliminarVendedor(anyInt());
    }

    @Test
    void testBuscarVendedor() {
        Coordenada coordenada = new Coordenada(1, -34.6037, -58.3816);
        Vendedor vendedor = new Vendedor(1, "Juan", "Calle Falsa 123", coordenada);

        when(vendedorDAO.buscarVendedorPorId(1)).thenReturn(vendedor);

        Vendedor resultado = vendedorController.buscarVendedor(1);

        assertNotNull(resultado);
        assertEquals(1, resultado.getId());
        assertEquals("Juan", resultado.getNombre());
        verify(vendedorDAO, times(1)).buscarVendedorPorId(1);
    }

    @Test
    void testBuscarVendedorNoExistente() {
        when(vendedorDAO.buscarVendedorPorId(99)).thenReturn(null);

        Vendedor resultado = vendedorController.buscarVendedor(99);

        assertNull(resultado);
        verify(vendedorDAO, times(1)).buscarVendedorPorId(99);
    }
}
