package Tp.DS;

public class Efectivo implements Pago {
    
    @Override
    public double calcularRecargo(double montoBase){
        return montoBase;
    }
}
