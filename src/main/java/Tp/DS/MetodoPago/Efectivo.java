package Tp.DS.MetodoPago;

public class Efectivo implements Pago {
    private int id;

    public Efectivo() {
    }
    
    public Efectivo(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public double calcularRecargo(double montoBase){
        return montoBase;
    }
}
