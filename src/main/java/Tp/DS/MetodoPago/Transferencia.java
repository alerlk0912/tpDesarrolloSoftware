package Tp.DS.MetodoPago;

public class Transferencia implements Pago {
    private String cbu;
    private String cuit;

    public Transferencia(String cbu, String cuit) {
        this.cbu = cbu;
        this.cuit = cuit;
    }

    public String getCbu() {
        return cbu;
    }

    public String getCuit() {
        return cuit;
    }

    @Override
    public double calcularRecargo(double montoBase) {
        return montoBase * 1.02;
    }
}
