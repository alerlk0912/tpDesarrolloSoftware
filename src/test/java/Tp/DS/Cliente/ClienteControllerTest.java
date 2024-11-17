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
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ClienteControllerTest {

    @Mock
    private DAOCliente clienteDAO = new ClienteJDBC();

    @InjectMocks
    private ClienteController clienteController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        
        clienteController = ClienteController.getInstance(clienteDAO);
    }
    
    @Test
    void testMostrarClientes() {
        List<Cliente> clientesSimulados = Arrays.asList(
            new Cliente("20304050607", "Juan Perez", "juan.perez@gmail.com", "Calle 1", new Coordenada(1, -34.6037, -58.3816)),
            new Cliente("10203040506", "Ana Lopez", "ana.lopez@gmail.com", "Calle 2", new Coordenada(2, -34.5991, -58.3734))
        );

        when(clienteDAO.listarClientes()).thenReturn(clientesSimulados);

        List<Cliente> clientes = clienteController.mostrarClientes();

        assertNotNull(clientes);
        assertEquals(2, clientes.size());
        assertEquals(clientesSimulados, clientes);

        verify(clienteDAO).listarClientes(); // Verifica que se llamó al método
    }

    @Test
    void testCrearNuevoCliente() {
        String cuit = "30405060708";
        String nombre = "Pedro Gomez";
        String email = "pedro.gomez@gmail.com";
        String direccion = "Calle 3";
        Coordenada coordenadas = new Coordenada(3, -34.6158, -58.4452);

        clienteController.crearNuevoCliente(cuit, nombre, email, direccion, coordenadas);

        verify(clienteDAO).agregarCliente(any(Cliente.class)); // Verifica la interacción
    }

    @Test
    void testModificarCliente() {
            int clienteId = 1;
        Cliente clienteExistente = new Cliente("20304050607", "Juan Perez", "juan.perez@gmail.com", "Calle 1",
                new Coordenada(1, -34.6037, -58.3816));
        clienteExistente.setId(clienteId);

        when(clienteDAO.buscarClientePorId(clienteId)).thenReturn(clienteExistente);

        String nuevoCuit = "20909090909";
        String nuevoNombre = "Juan Modificado";
        String nuevoEmail = "nuevo.email@gmail.com";
        String nuevaDireccion = "Nueva Calle";
        Coordenada nuevasCoordenadas = new Coordenada(1, -34.6000, -58.4000);

        clienteController.modificarCliente(clienteId, nuevoCuit, nuevoNombre, nuevoEmail, nuevaDireccion, nuevasCoordenadas);

        ArgumentCaptor<Cliente> captor = ArgumentCaptor.forClass(Cliente.class);
        verify(clienteDAO).actualizarCliente(captor.capture());

        Cliente clienteModificado = captor.getValue();
        assertEquals(clienteId, clienteModificado.getId());
        assertEquals(nuevoCuit, clienteModificado.getCuit());
        assertEquals(nuevoNombre, clienteModificado.getNombre());
        assertEquals(nuevoEmail, clienteModificado.getEmail());
        assertEquals(nuevaDireccion, clienteModificado.getDireccion());
        assertEquals(nuevasCoordenadas.getId(), clienteModificado.getCoordenadas().getId());
        assertEquals(nuevasCoordenadas.getLat(), clienteModificado.getCoordenadas().getLat());
        assertEquals(nuevasCoordenadas.getLng(), clienteModificado.getCoordenadas().getLng());
    }

    @Test
    void testEliminarCliente() {
        // Configuración
        int clienteId = 1;

        // Llamada al método bajo prueba
        clienteController.eliminarCliente(clienteId);

        // Verificación
        verify(clienteDAO).eliminarCliente(clienteId);
    }

    @Test
    void testBuscarCliente() {
        // Cliente existente para buscar
        int clienteId = 10;
        Cliente clienteExistente = new Cliente("10203040506", "Ana Lopez", "ana.lopez@gmail.com", "Calle 2",
                new Coordenada(2, -34.5991, -58.3734));
        clienteExistente.setId(clienteId);

        when(clienteDAO.buscarClientePorId(clienteId)).thenReturn(clienteExistente);

        // Llamada al método bajo prueba
        Cliente cliente = clienteController.buscarCliente(clienteId);

        // Verificaciones
        assertNotNull(cliente);
        assertEquals("Ana Lopez", cliente.getNombre());
        assertEquals("10203040506", cliente.getCuit());
        verify(clienteDAO).buscarClientePorId(clienteId);
    }
}
