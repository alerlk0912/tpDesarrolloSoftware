package Tp.DS;

class Cliente implements PedidoObserver{
    private int id;
    private String cuit;
    private String nombre;
    private String email;
    private String direccion;
    private Coordenada coordenadas;

    public Cliente(int id, String cuit, String nombre, String email, String direccion, Coordenada coordenadas) {
        this.id = id;
        this.cuit = cuit;
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.coordenadas = coordenadas;
    }

    public int getId() {
        return id;
    }

    public String getCuit() {
        return cuit;
    }

    public String getEmail() {
        return email;
    }

    public String getDireccion() {
        return direccion;
    }

    public Coordenada getCoordenadas() {
        return coordenadas;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    @Override
    public String toString() {
        return "Cliente{" +
               "id=" + id +
               ", nombre='" + nombre + '\'' +
               ", cuit='" + cuit + '\'' +
               '}';
    }
    
    public static Cliente buscarClientePorId(Cliente[] clientes, int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    public static Cliente[] eliminarCliente(Cliente[] clientes, String cuit) {
        int index = -1;
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i].getCuit().equals(cuit)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            Cliente[] nuevoArray = new Cliente[clientes.length - 1];
            for (int i = 0, k = 0; i < clientes.length; i++) {
                if (i == index) {
                    continue;
                }
                nuevoArray[k++] = clientes[i];
            }
            return nuevoArray;
        } else {
            return clientes;
        }
    }
	
    @Override
    public void actualizarEstado(Pedido pedido) {
        System.out.println("Cliente " + nombre + ": El estado del pedido ha cambiado a " + pedido.getEstado());

        // si el estado es EN_ENVIO, generar el pago
        if (pedido.getEstado() == EstadoPedido.EN_ENVIO) {
            generarPago(pedido);
        }
    }

    // genera el pago asociado al pedido
    public void generarPago(Pedido pedido) {
        double montoFinal = pedido.getMetodoPago().calcularRecargo(pedido.getMontoTotal());
        System.out.println("Pago generado para " + nombre + " - Monto: " + montoFinal);
    }
    
    
}
