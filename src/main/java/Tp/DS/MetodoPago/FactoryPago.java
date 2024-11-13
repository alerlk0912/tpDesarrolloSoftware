
package Tp.DS.MetodoPago;

public class FactoryPago {
    public static Pago crearPago(String tipoPago, String pago1, String pago2) {
        switch (tipoPago.toLowerCase()) {
            case "efectivo":
                return new Efectivo();

            case "mercado pago":
                if (pago1 == null) throw new IllegalArgumentException("Alias requerido para MercadoPago");
                return new MercadoPago(pago1);

            case "transferencia":
                if (pago1 == null && pago2 == null) throw new IllegalArgumentException("CBU y CUIT requeridos para Transferencia");
                return new Transferencia(pago1, pago2);

            default:
                throw new IllegalArgumentException("Tipo de pago no reconocido: " + tipoPago);
        }
    }
}
