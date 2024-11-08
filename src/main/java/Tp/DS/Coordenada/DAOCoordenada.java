/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tp.DS.Coordenada;

import java.util.List;

/**
 *
 * @author franco
 */
public interface  DAOCoordenada {
    public List<Coordenada> listarCoordenadas();
    public void crearCoordenada(Coordenada coordenada);
    public void actualizarCoordenada(Coordenada coordenada);
    public void eliminarCoordenada(int id);
    public Coordenada buscarCoordenadasPorId(int id);
}

