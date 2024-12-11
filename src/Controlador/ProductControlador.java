package Controlador;

import Modelo.ProductoDAO;
import Vista.ProductoVista;

public class ProductControlador {
    private ProductoDAO dao;
    private ProductoVista vista;

    public ProductControlador(ProductoDAO dao, ProductoVista vista) {
        this.dao = dao;
        this.vista = vista;
        this.vista.setControlador(this);
    }

    public void añadirProducto(String nombre, double precio) {
        dao.addProduct(nombre, precio);
        vista.showMessage("Producto añadido exitosamente.");
    }

    public void VistaProductos() {
        vista.mostrarProductos(dao.getAllProducts());
    }

    public void close() {
        dao.close();
    }
}

