package isi.deso.tpds.MetodoPago;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PagoMemory implements DAOMetodoPago {
    private Map<Integer, Pago> pagos = new HashMap<>(); 
    private int nextId = 1; 

    @Override
    public Pago buscarPagoPorId(int id) {
        return pagos.get(id); 
    }

    @Override
    public List<Pago> buscarPagoPorMetodo(String metodoPago) {
        List<Pago> resultado = new ArrayList<>();

        for (Pago pago : pagos.values()) {
            if ((metodoPago.equals("Efectivo") && pago instanceof Efectivo) ||
                (metodoPago.equals("MercadoPago") && pago instanceof MercadoPago) ||
                (metodoPago.equals("Transferencia") && pago instanceof Transferencia)) {
                resultado.add(pago);
            }
        }
        return resultado; 
    }

    @Override
    public void guardarPago(Pago pago) {
        pagos.put(nextId, pago);
        nextId++;
    }

    @Override
    public void eliminarPago(int id) {
        pagos.remove(id);
    }
}
