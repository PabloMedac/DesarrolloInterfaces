package Modul4;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane; // Importa JOptionPane para mostrar mensajes

public class RecargarAbono extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> comboBoxMeses;
    private JTextField textFieldCantidad; // Campo de texto para la cantidad

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RecargarAbono frame = new RecargarAbono();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public RecargarAbono() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(RecargarAbono.class.getResource("/Modul4/foto.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 400);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(152, 251, 152));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 128, 128));
        panel.setBounds(0, 0, 284, 51);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("RECARGA TU ABONO DE TRANSPORTE");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 13));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(0, 11, 284, 29);
        panel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Seleccione el mes para recargar su abono");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(0, 60, 284, 29);
        contentPane.add(lblNewLabel_1);
        
        // Crear el JComboBox con los meses del año
        String[] meses = {
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };
        comboBoxMeses = new JComboBox<>(meses);
        comboBoxMeses.setBounds(50, 100, 180, 30); // Cambiar las coordenadas según sea necesario
        contentPane.add(comboBoxMeses);
        
        // JLabel para seleccionar la cantidad
        JLabel lblCantidad = new JLabel("Seleccione la cantidad a recargar:");
        lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
        lblCantidad.setBounds(0, 150, 284, 29);
        contentPane.add(lblCantidad);
        
        // JTextField para introducir la cantidad
        textFieldCantidad = new JTextField();
        textFieldCantidad.setBounds(98, 180, 90, 30); // Cambiar las coordenadas según sea necesario
        contentPane.add(textFieldCantidad);
        
        // Botón para realizar la recarga
        JButton btnRecargar = new JButton("Recargar");
        btnRecargar.setBounds(98, 221, 90, 30); // Cambiar las coordenadas según sea necesario
        contentPane.add(btnRecargar);
        
        // Acción del botón
        btnRecargar.addActionListener(e -> {
            String mesSeleccionado = (String) comboBoxMeses.getSelectedItem();
            String cantidadTexto = textFieldCantidad.getText();
            // Validar la entrada de cantidad
            if (!cantidadTexto.isEmpty()) {
                try {
                    double cantidad = Double.parseDouble(cantidadTexto);
                    JOptionPane.showMessageDialog(this, "Has recargado " + cantidad + " euros para el mes de " + mesSeleccionado, "Recarga Exitosa", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Por favor, introduce una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, introduce una cantidad.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(RecargarAbono.class.getResource("/Modul4/foto.png")));
        lblNewLabel_2.setBounds(169, 246, 115, 115);
        contentPane.add(lblNewLabel_2);
    }
}
