package Tp.DS.ItemMenu;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import Tp.DS.Exceptions.DAOException;
import Tp.DS.Vendedor.*;
import Tp.DS.Categoria.*;
import Tp.DS.Plato;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.InjectMocks;

import java.util.List;
import java.util.ArrayList;

public class ItemMenuControllerTest {
    private DAOCategoria categoriaDAO = new CategoriaJDBC();
    private DAOVendedor vendedorDAO = new VendedorJDBC();
    @Mock
    private DAOItemMenu itemMenuDAO = new ItemMenuJDBC(categoriaDAO,vendedorDAO);
    @InjectMocks
    private ItemMenuController controller;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        
        controller = ItemMenuController.getInstance(itemMenuDAO);
    }

    @Test
    void testMostrarListaItemsMenu() throws DAOException {
        List<ItemMenu> expectedItems = new ArrayList<>();
        expectedItems.add(new Plato(1, "Pizza", "Pizza Margherita", 10.0, null, null, 1.0, 300.0, true));
        when(itemMenuDAO.listarItemsMenu()).thenReturn(expectedItems);

        List<ItemMenu> actualItems = controller.mostrarListaItemsMenu();

        assertEquals(expectedItems, actualItems);
        verify(itemMenuDAO, times(1)).listarItemsMenu();
    }
    @Test
    void testCrearNuevoItemMenu() throws DAOException {
        Categoria mockCategoria = new Categoria(1, "Comida", "PLATO");
        Vendedor mockVendedor = new Vendedor(1, "Juan", "Calle 123", null);

        controller.crearNuevoItemMenu(
            "PLATO", "Ensalada", "Ensalada César", 8.0,
            mockCategoria, mockVendedor, null, null, 0.5, 200.0, true
        );

        verify(itemMenuDAO, times(1)).crearItemMenu(any(ItemMenu.class));
    }
    @Test
    void testModificarItemMenu() throws DAOException {
        ItemMenu itemExistente = new Plato(1, "Pizza", "Pizza Margherita", 10.0, null, null, 1.0, 300.0, true);
        ItemMenu itemActualizado = new Plato(1, "Pizza", "Pizza Margarita Actualizada", 12.0, null, null, 1.2, 350.0, true);
        when(itemMenuDAO.buscarItemMenuPorId(1)).thenReturn(itemExistente);

        controller.modificarItemMenu(1, itemActualizado, 8.0, false, 0.5, 200, true);

        verify(itemMenuDAO, times(1)).actualizarItemMenu(itemActualizado);
    }
    @Test
    void testEliminarItemMenu() throws DAOException {
        controller.eliminarItemMenu(1);

        verify(itemMenuDAO, times(1)).eliminarItemMenu(1);
    }
    @Test
    void testBuscarItemMenu() throws DAOException {
        ItemMenu expectedItem = new Plato(1, "Pizza", "Pizza Margherita", 10.0, null, null, 1.0, 300.0, true);
        when(itemMenuDAO.buscarItemMenuPorId(1)).thenReturn(expectedItem);

        ItemMenu actualItem = controller.buscarItemMenu(1);

        assertEquals(expectedItem, actualItem);
        verify(itemMenuDAO, times(1)).buscarItemMenuPorId(1);
    }
    @Test
    void testObtenerItemsMenuPorVendedor() throws DAOException {
        Vendedor vendedor = new Vendedor(1, "Juan", "Calle 123", null);
        List<ItemMenu> items = List.of(
            new Plato(1, "Pizza", "Pizza Margherita", 10.0, null, vendedor, 1.0, 300.0, true)
        );
        when(itemMenuDAO.listarItemsMenu()).thenReturn(items);

        List<ItemMenu> actualItems = controller.obtenerItemsMenuPorVendedor(vendedor);

        assertEquals(items, actualItems);
        verify(itemMenuDAO, times(1)).listarItemsMenu();
    }
    @Test
    void testBuscarItemsPorCriterios() throws DAOException {
        Vendedor vendedor = new Vendedor(1, "Juan", "Calle 123", null);
        List<ItemMenu> expectedItems = List.of(
            new Plato(1, "Pizza", "Pizza Margherita", 10.0, null, vendedor, 1.0, 300.0, true)
        );
        when(itemMenuDAO.buscarItemsPorCriterios(1, "Pizza", 10.0, "PLATO", vendedor))
            .thenReturn(expectedItems);

        List<ItemMenu> actualItems = controller.buscarItemsPorCriterios(1, "Pizza", 10.0, "PLATO", vendedor);

        assertEquals(expectedItems, actualItems);
        verify(itemMenuDAO, times(1)).buscarItemsPorCriterios(1, "Pizza", 10.0, "PLATO", vendedor);
    }

}
