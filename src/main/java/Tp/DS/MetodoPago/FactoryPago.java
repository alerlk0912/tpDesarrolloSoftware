
package Tp.DS.MetodoPago;

public class FactoryPago {
    public static Pago crearPago(String tipoPago, String... datos) {
        switch (tipoPago) {
            case "Efectivo":
                return new Efectivo();

            case "MercadoPago":
                if (datos.length < 1) throw new IllegalArgumentException("Alias requerido para MercadoPago");
                return new MercadoPago(datos[0]);

            case "Transferencia":
                if (datos.length < 2) throw new IllegalArgumentException("CBU y CUIT requeridos para Transferencia");
                return new Transferencia(datos[0], datos[1]);

            default:
                throw new IllegalArgumentException("Tipo de pago no reconocido: " + tipoPago);
        }
    }
}
