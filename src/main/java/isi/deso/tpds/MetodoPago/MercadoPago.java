package isi.deso.tpds.MetodoPago;

public class MercadoPago implements Pago {
    private String alias;
    private int id;

    public MercadoPago(String alias, int id) {
        this.alias = alias;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
