package Tp.DS.Cliente;

import isi.deso.tpds.Cliente.Cliente;
import isi.deso.tpds.Cliente.ClienteJDBC;
import isi.deso.tpds.Cliente.DAOCliente;
import isi.deso.tpds.Cliente.ClienteController;
import isi.deso.tpds.Coordenada.Coordenada;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;

@ExtendWith(MockitoExtension.class)
class ClienteControllerTest {

    @Mock
    private DAOCliente clienteDAO; // Se elimina la inicialización con ClienteJDBC

    @InjectMocks
    private ClienteController clienteController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ClienteController.resetInstance(); // Reinicia el Singleton
        clienteController = ClienteController.getInstance(clienteDAO); // Inicializa con el mock
    }


    @Test
    void testMostrarClientes() {
        // Configuración de clientes simulados
        List<Cliente> clientesSimulados = Arrays.asList(
            new Cliente("20304050607", "Juan Perez", "juan.perez@gmail.com", "Calle 1", new Coordenada(1, -34.6037, -58.3816)),
            new Cliente("10203040506", "Ana Lopez", "ana.lopez@gmail.com", "Calle 2", new Coordenada(2, -34.5991, -58.3734))
        );

        // Mockeo del método listarClientes
        when(clienteDAO.listarClientes()).thenReturn(clientesSimulados);

        // Llamada al método bajo prueba
        List<Cliente> clientes = clienteController.mostrarClientes();

        // Verificaciones
        assertNotNull(clientes);
        assertEquals(2, clientes.size());
        assertEquals(clientesSimulados, clientes);

        verify(clienteDAO).listarClientes(); // Verificar interacción
    }
    
    @Test
    void testMostrarClientesEmptyList() {
        when(clienteDAO.listarClientes()).thenReturn(Collections.emptyList());
        List<Cliente> clientes = clienteController.mostrarClientes();
        assertNotNull(clientes);
        assertTrue(clientes.isEmpty());
    }


    @Test
    void testCrearNuevoCliente() {
        // Configuración de datos del cliente
        String cuit = "30405060708";
        String nombre = "Pedro Gomez";
        String email = "pedro.gomez@gmail.com";
        String direccion = "Calle 3";
        Coordenada coordenadas = new Coordenada(3, -34.6158, -58.4452);

        // Llamada al método bajo prueba
        clienteController.crearNuevoCliente(cuit, nombre, email, direccion, coordenadas);

        // Verificación de interacción
        verify(clienteDAO).agregarCliente(any(Cliente.class));
    }

    @Test
    void testModificarCliente() {
        // Cliente existente para modificar
        int clienteId = 1;
        Cliente clienteExistente = new Cliente("20304050607", "Juan Perez", "juan.perez@gmail.com", "Calle 1",
                new Coordenada(1, -34.6037, -58.3816));
        clienteExistente.setId(clienteId);

        // Configuración del mock
        when(clienteDAO.buscarClientePorId(clienteId)).thenReturn(clienteExistente);

        // Nuevos datos para el cliente
        String nuevoCuit = "20909090909";
        String nuevoNombre = "Juan Modificado";
        String nuevoEmail = "nuevo.email@gmail.com";
        String nuevaDireccion = "Nueva Calle";
        Coordenada nuevasCoordenadas = new Coordenada(1, -34.6000, -58.4000);

        // Llamada al método bajo prueba
        clienteController.modificarCliente(clienteId, nuevoCuit, nuevoNombre, nuevoEmail, nuevaDireccion, nuevasCoordenadas);

        // Captura del cliente modificado
        ArgumentCaptor<Cliente> captor = ArgumentCaptor.forClass(Cliente.class);
        verify(clienteDAO).actualizarCliente(captor.capture());

        // Verificaciones
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
        verify(clienteDAO, times(1)).eliminarCliente(clienteId);
    }

    @Test
    void testBuscarCliente() {
        // Cliente existente para buscar
        int clienteId = 10;
        Cliente clienteExistente = new Cliente("10203040506", "Ana Lopez", "ana.lopez@gmail.com", "Calle 2",
                new Coordenada(2, -34.5991, -58.3734));
        clienteExistente.setId(clienteId);

        // Configuración del mock
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
