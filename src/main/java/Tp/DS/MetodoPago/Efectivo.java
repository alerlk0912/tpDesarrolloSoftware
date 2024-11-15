package Tp.DS.MetodoPago;

public class Efectivo implements Pago {
    @Override
    public double calcularRecargo(double montoBase){
        return montoBase;
    }
}
