package Tp.DS.MetodoPago;

public interface Pago {
    double calcularRecargo(double montoBase);
    
    static Pago valueOf(String tipoPago) {
        switch (tipoPago.toLowerCase()) {
            case "efectivo":
                return new Efectivo();
            case "mercado pago":
                return new MercadoPago("defaultAlias"); // Provide default or handle null
            case "transferencia":
                return new Transferencia("defaultCbu", "defaultCuit"); // Provide defaults
            default:
                throw new IllegalArgumentException("Unknown payment type: " + tipoPago);
        }
    }
}
