
package Tp.DS.Cliente;

import Tp.DS.Coordenada.Coordenada;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

class ClienteControllerTest {
    @Mock
    private DAOCliente clienteDAO; // Mock de la interfaz DAOCliente.

    private ClienteController clienteController;

    @BeforeEach
    void setUp() {
        // Inicializa los mocks y el controlador.
        MockitoAnnotations.openMocks(this);
        clienteController = ClienteController.getInstance(clienteDAO);
    }

    @Test
    void testMostrarClientes() {
        // Configuración del mock: Simulamos que `listarClientes` devuelve una lista de clientes.
        List<Cliente> clientesSimulados = Arrays.asList(
            new Cliente("20304050607", "Juan Perez", "juan.perez@gmail.com", "Calle 1", new Coordenada(1, -34.6037, -58.3816)),
            new Cliente("10203040506", "Ana Lopez", "ana.lopez@gmail.com", "Calle 2", new Coordenada(2, -34.5991, -58.3734))
        );
        when(clienteDAO.listarClientes()).thenReturn(clientesSimulados);

        // Llamada al método bajo prueba.
        List<Cliente> clientes = clienteController.mostrarClientes();

        // Verificaciones.
        assertNotNull(clientes);
        assertEquals(2, clientes.size());
        verify(clienteDAO, times(1)).listarClientes(); // Verificamos que se haya llamado a listarClientes() exactamente una vez.
    }

    @Test
    void testCrearNuevoCliente() {
        // Creamos un cliente de prueba.
        Cliente cliente = new Cliente("30405060708", "Pedro Gomez", "pedro.gomez@gmail.com", "Calle 3", new Coordenada(3, -34.6158, -58.4452));

        // Llamada al método bajo prueba.
        clienteController.crearNuevoCliente(
            cliente.getCuit(),
            cliente.getNombre(),
            cliente.getEmail(),
            cliente.getDireccion(),
            cliente.getCoordenadas()
        );

        // Verificamos que se haya llamado al método agregarCliente con el cliente correcto.
        ArgumentCaptor<Cliente> captor = ArgumentCaptor.forClass(Cliente.class);
        verify(clienteDAO, times(1)).agregarCliente(captor.capture());

        Cliente clienteCapturado = captor.getValue();
        assertEquals("Pedro Gomez", clienteCapturado.getNombre());
        assertEquals("30405060708", clienteCapturado.getCuit());
        assertEquals("pedro.gomez@gmail.com", clienteCapturado.getEmail());
        assertEquals("Calle 3", clienteCapturado.getDireccion());
    }

    @Test
    void testModificarCliente() {
        // Configuramos un cliente existente.
        Cliente clienteExistente = new Cliente("20304050607", "Juan Perez", "juan.perez@gmail.com", "Calle 1", new Coordenada(1, -34.6037, -58.3816));
        clienteExistente.setId(1);

        // Simulamos que `buscarClientePorId` devuelve el cliente existente.
        when(clienteDAO.buscarClientePorId(1)).thenReturn(clienteExistente);

        // Modificamos los datos del cliente.
        clienteController.modificarCliente(
            1,
            "20909090909",
            "Juan Modificado",
            "nuevo.email@gmail.com",
            "Nueva Calle",
            new Coordenada(1, -34.6000, -58.4000)
        );

        // Verificamos que se haya llamado al método `actualizarCliente` con los datos correctos.
        ArgumentCaptor<Cliente> captor = ArgumentCaptor.forClass(Cliente.class);
        verify(clienteDAO, times(1)).actualizarCliente(captor.capture());

        Cliente clienteCapturado = captor.getValue();
        assertEquals(1, clienteCapturado.getId());
        assertEquals("20909090909", clienteCapturado.getCuit());
        assertEquals("Juan Modificado", clienteCapturado.getNombre());
        assertEquals("nuevo.email@gmail.com", clienteCapturado.getEmail());
        assertEquals("Nueva Calle", clienteCapturado.getDireccion());
    }

    @Test
    void testEliminarCliente() {
        // Llamada al método bajo prueba.
        clienteController.eliminarCliente(1);

        // Verificamos que se haya llamado al método `eliminarCliente` con el ID correcto.
        verify(clienteDAO, times(1)).eliminarCliente(1);
    }

    @Test
    void testBuscarCliente() {
        // Configuramos un cliente existente.
        Cliente clienteExistente = new Cliente("10203040506", "Ana Lopez", "ana.lopez@gmail.com", "Calle 2", new Coordenada(2, -34.5991, -58.3734));
        clienteExistente.setId(2);

        // Simulamos que `buscarClientePorId` devuelve el cliente existente.
        when(clienteDAO.buscarClientePorId(2)).thenReturn(clienteExistente);

        // Llamada al método bajo prueba.
        Cliente cliente = clienteController.buscarCliente(2);

        // Verificaciones.
        assertNotNull(cliente);
        assertEquals("Ana Lopez", cliente.getNombre());
        assertEquals("10203040506", cliente.getCuit());
        verify(clienteDAO, times(1)).buscarClientePorId(2); // Verificamos que se haya llamado a buscarClientePorId.
    }
}

