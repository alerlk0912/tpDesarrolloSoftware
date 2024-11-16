package Tp.DS.ItemPedido;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import Tp.DS.ItemMenu.*;
import Tp.DS.Pedido.*;
import Tp.DS.Exceptions.DAOException;
import Tp.DS.Plato;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


class ItemsPedidoControllerTest {
    private ItemsPedidoController controller;
    private DAOItemsPedido mockitemsPedidoDAO;
    private ItemMenuController mockItemMenuController;
    private PedidoController mockPedidoController;
    private ItemMenu mockItemMenu;

    @BeforeEach
    void setup() {
        mockitemsPedidoDAO = mock(DAOItemsPedido.class);
        mockItemMenuController = mock(ItemMenuController.class);
        mockPedidoController = mock(PedidoController.class);
        controller = ItemsPedidoController.getInstance(mockitemsPedidoDAO, mockPedidoController, mockItemMenuController);
        
        mockItemMenu = mock(ItemMenu.class);
        when(mockItemMenu.getId()).thenReturn(1);
        when(mockItemMenu.getNombre()).thenReturn("Mock ItemMenu");
        when(mockItemMenu.getPrecio()).thenReturn(100.0);
        
    }

    @Test
    void testCrearNuevoItemPedido() throws DAOException {
        ItemMenu mockItemMenu = new Plato(1, "Pizza", "Pizza Margherita", 10.0, null, null, 1.0, 300.0, true);
        when(mockItemMenuController.buscarItemMenu(1)).thenReturn(mockItemMenu);

        controller.crearNuevoItemPedido(1, 3);

        verify(mockitemsPedidoDAO, times(1)).crearItemPedido(any(ItemsPedido.class));
    }
    
    @Test
    void testMostrarListaItemsPedido() throws DAOException {
        ItemsPedido item1 = new ItemsPedido(mockItemMenu, 2);
        ItemsPedido item2 = new ItemsPedido(mockItemMenu, 5);
        when(mockitemsPedidoDAO.listarItemsPedido()).thenReturn(Arrays.asList(item1, item2));

        List<ItemsPedido> result = controller.mostrarListaItemsPedido();

        assertEquals(2, result.size());
        verify(mockitemsPedidoDAO, times(1)).listarItemsPedido();
    }

    @Test
    void testCrearNuevoItemPedido_Exito() throws DAOException {
        mockItemMenu.setId(1);

        when(mockItemMenuController.buscarItemMenu(1)).thenReturn(mockItemMenu);

        controller.crearNuevoItemPedido(1, 3);

        verify(mockitemsPedidoDAO, times(1)).crearItemPedido(any(ItemsPedido.class));
    }

    @Test
    void testCrearNuevoItemPedido_ItemMenuNoEncontrado() throws DAOException {
        when(mockItemMenuController.buscarItemMenu(1)).thenReturn(null);

        DAOException exception = assertThrows(DAOException.class, () -> {
            controller.crearNuevoItemPedido(1, 3);
        });

        assertEquals("Pedido o ItemMenu no encontrado", exception.getMessage());
        verify(mockitemsPedidoDAO, never()).crearItemPedido(any(ItemsPedido.class));
    }

    @Test
    void testModificarItemPedido_Exito() throws DAOException {
        ItemsPedido existingItemPedido = new ItemsPedido(mockItemMenu, 5);
        existingItemPedido.setId(1);
        ItemMenu newItemMenu = mockItemMenu;
        newItemMenu.setId(2);

        when(mockitemsPedidoDAO.buscarItemPedidoPorId(1)).thenReturn(existingItemPedido);
        when(mockItemMenuController.buscarItemMenu(2)).thenReturn(newItemMenu);

        controller.modificarItemPedido(1, 2, 10);

        assertEquals(2, existingItemPedido.getItemMenu().getId());
        assertEquals(10, existingItemPedido.getCantidad());
        verify(mockitemsPedidoDAO, times(1)).actualizarItemPedido(existingItemPedido);
    }

    @Test
    void testModificarItemPedido_NoEncontrado() throws DAOException {
        when(mockitemsPedidoDAO.buscarItemPedidoPorId(1)).thenReturn(null);

        DAOException exception = assertThrows(DAOException.class, () -> {
            controller.modificarItemPedido(1, 2, 10);
        });

        assertEquals("ItemPedido no encontrado", exception.getMessage());
        verify(mockitemsPedidoDAO, never()).actualizarItemPedido(any(ItemsPedido.class));
    }

    @Test
    void testEliminarItemPedido() throws DAOException {
        controller.eliminarItemPedido(1);

        verify(mockitemsPedidoDAO, times(1)).eliminarItemPedido(1);
    }

    @Test
    void testBuscarItemPedido() throws DAOException {
        ItemsPedido mockItemPedido = new ItemsPedido(mockItemMenu, 5);
        mockItemPedido.setId(1);

        when(mockitemsPedidoDAO.buscarItemPedidoPorId(1)).thenReturn(mockItemPedido);

        ItemsPedido result = controller.buscarItemPedido(1);

        assertNotNull(result);
        assertEquals(1, result.getId());
        verify(mockitemsPedidoDAO, times(1)).buscarItemPedidoPorId(1);
    }
}

