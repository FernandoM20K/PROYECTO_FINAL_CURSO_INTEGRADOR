package Entidades;

public class Producto {
    private int idProducto;
    private String descripcion;
    private int stock;
    private String imagen;
    private int idCategoria;
    private String nombreCategoria;

    public Producto() {
    
    }

    public Producto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(String descripcion, int stock, String imagen, int idCategoria) {
        this.descripcion = descripcion;
        this.stock = stock;
        this.imagen = imagen;
        this.idCategoria = idCategoria;
    }

    public Producto(int idProducto, String descripcion, int stock, String imagen, int idCategoria) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.stock = stock;
        this.imagen = imagen;
        this.idCategoria = idCategoria;
    }

    public Producto(int idProducto, String descripcion, int stock, String imagen, int idCategoria,
            String nombreCategoria) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.stock = stock;
        this.imagen = imagen;
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    @Override
    public String toString() {
        return "Producto [idProducto=" + idProducto + ", descripcion=" + descripcion + ", stock=" + stock + ", imagen="
                + imagen + ", idCategoria=" + idCategoria + ", nombreCategoria=" + nombreCategoria + "]";
    }
}
