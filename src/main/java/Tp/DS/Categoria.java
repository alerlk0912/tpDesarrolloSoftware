package Tp.DS;

class Categoria {
    private int id;
    private String descripcion;
    private String tipo_item;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo_item() {
        return tipo_item;
    }

    public void setTipo_item(String tipo_item) {
        if (tipo_item.equals("plato") || tipo_item.equals("bebida")) {
            this.tipo_item = tipo_item;
        } else {
            throw new IllegalArgumentException("tipo_item debe ser 'plato' o 'bebida'");
        }
    }
    public String toString() {
        return descripcion; // Devuelve la descripción de la categoría
    }
}
