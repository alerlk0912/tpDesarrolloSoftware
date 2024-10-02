package Tp.DS;

public class Transferencia implements Pago {
    private String cbu;
    private String cuit;
    
    @Override
    public double calcularRecargo(double montoBase){
        return (montoBase * 1.02);
    }
    
}
