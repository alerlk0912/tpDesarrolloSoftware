package isi.deso.tpds.Coordenada;

import java.util.List;

public interface  DAOCoordenada {
    List<Coordenada> listarCoordenadas();
    void crearCoordenada(Coordenada coordenada);
    void actualizarCoordenada(Coordenada coordenada);
    void eliminarCoordenada(int id);
    Coordenada buscarCoordenadasPorId(int id);
}

