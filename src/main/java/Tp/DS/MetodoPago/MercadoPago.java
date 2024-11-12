package Tp.DS.MetodoPago;

public class MercadoPago implements Pago {
    private String alias;

    public MercadoPago(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }

    @Override
    public double calcularRecargo(double montoBase) {
        return montoBase * 1.04;
    }
}
