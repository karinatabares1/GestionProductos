package Vista;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import Controlador.ProductControlador;
import Modelo.Producto;

public class ProductoVista extends JFrame {
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTextArea textArea;
    private ProductControlador controlador;

    public ProductoVista() {
        setTitle("Gestión de Productos");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panel.add(txtNombre);

        panel.add(new JLabel("Precio:"));
        txtPrecio = new JTextField();
        panel.add(txtPrecio);

        JButton btnAdd = new JButton("Añadir Producto");
        panel.add(btnAdd);

        JButton btnView = new JButton("Ver Productos");
        panel.add(btnView);

        add(panel, BorderLayout.NORTH);

        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        btnAdd.addActionListener(e -> controlador.añadirProducto(txtNombre.getText(), Double.parseDouble(txtPrecio.getText())));
        btnView.addActionListener(e -> controlador.VistaProductos());
    }

    public void setControlador(ProductControlador controlador) {
        this.controlador = controlador;
    }

    public void mostrarProductos(List<Producto> productos) {
        textArea.setText("");
        for (Producto producto : productos) {
            textArea.append(producto.toString() + "\n");
        }
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
