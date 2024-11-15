package Tp.DS.Coordenada;

import java.util.List;

public interface  DAOCoordenada {
    public List<Coordenada> listarCoordenadas();
    public void crearCoordenada(Coordenada coordenada);
    public void actualizarCoordenada(Coordenada coordenada);
    public void eliminarCoordenada(int id);
    public Coordenada buscarCoordenadasPorId(int id);
}

