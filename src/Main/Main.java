package Main;

import java.sql.DriverManager;

import Controlador.ProductControlador;
import Modelo.ProductoDAO;
import Vista.ProductoVista;

public class Main {
    public static void main(String[] args) {
        ProductoDAO dao = new ProductoDAO();
        ProductoVista vista = new ProductoVista();
        ProductControlador controlador = new ProductControlador(dao, vista);

        vista.setVisible(true);
        
        System.out.println("Drivers cargados:");
        DriverManager.drivers().forEach(driver -> System.out.println(driver.getClass().getName()));


        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            controlador.close();
            System.out.println("Conexión cerrada correctamente.");
        }));
    }
}
