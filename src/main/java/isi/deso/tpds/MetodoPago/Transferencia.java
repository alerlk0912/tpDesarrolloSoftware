package isi.deso.tpds.MetodoPago;

public class Transferencia implements Pago {
    private String cbu;
    private String cuit;
    private int id;

    public Transferencia(String cbu, String cuit, int id) {
        this.cbu = cbu;
        this.cuit = cuit;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
