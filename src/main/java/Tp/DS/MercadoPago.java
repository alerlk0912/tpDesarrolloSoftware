package Tp.DS;

public class MercadoPago implements Pago{
    private String alias;
    
    @Override
    public double calcularRecargo(double montoBase){
        return (montoBase * 1.04);
    }
    
}
