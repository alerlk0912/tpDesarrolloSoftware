package Tp.DS.Categoria;

public class Categoria {
    private int id;
    private String descripcion;
    private String tipo_item;

    public Categoria(int id, String descripcion, String tipo_item) {
        this.id = id;
        this.descripcion = descripcion;
        this.tipo_item = tipo_item;
    }
    
    public Categoria( String descripcion, String tipo) {
        this.descripcion = descripcion;
        this.tipo_item = tipo;
    }
    
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

    public void setTipoItem(String tipo_item) {
        if (tipo_item.equals("plato") || tipo_item.equals("bebida")) {
            this.tipo_item = tipo_item;
        } else {
            throw new IllegalArgumentException("tipo_item debe ser 'plato' o 'bebida'");
        }
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
