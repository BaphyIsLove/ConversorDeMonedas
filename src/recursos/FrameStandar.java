package recursos;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;

public class FrameStandar extends JFrame{
    Toolkit pantalla = Toolkit.getDefaultToolkit();
    Dimension tamañoPantalla = pantalla.getScreenSize();
    int anchoPantalla = tamañoPantalla.width;
    int altoPantalla = tamañoPantalla.height;
    
    public JPanel panel;
    public GridBagConstraints c;
    public JComboBox<Items> seleccionOrigen, seleccionDestino;
    public JTextField montoOrigen, montoDestino;
    public JButton btnConvertir, btnRegresar;

    public FrameStandar(){
        
        // propiedades de la pantalla
        ImageIcon icon = new ImageIcon("src/img/icon.png");
        setIconImage(icon.getImage());
        setSize(anchoPantalla/3,altoPantalla/3);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);

        panel = new JPanel(new GridBagLayout());
        panel.setBackground(SystemColor.window);
        c = new GridBagConstraints();
        c.insets = new Insets(0, 10, 20, 10);

        // Etiquetas de texto
        c.gridx = 0;
        c.gridy = 0;
        panel.add(new JLabel("Convertir de:"),c);
        c.gridx = 1;
        panel.add(new JLabel("A:"),c);

        // menus desplegables
        seleccionOrigen = new JComboBox<>();
        seleccionOrigen.setPreferredSize(new Dimension(180,25));
        c.gridx = 0;
        c.gridy = 1;
        panel.add(seleccionOrigen,c);
        seleccionDestino = new JComboBox<>();
        seleccionDestino.setPreferredSize(new Dimension(180,25));
        c.gridx = 1;
        panel.add(seleccionDestino,c);

        //cuadros de entrada y salida de texto
        montoOrigen = new JTextField();
        montoOrigen.setHorizontalAlignment(JTextField.CENTER);
        montoOrigen.setPreferredSize(new Dimension(80,30));
        montoOrigen.addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                montoOrigen.setText("");
            }
            
        });
        ((AbstractDocument) montoOrigen.getDocument()).setDocumentFilter(new FiltroTextField());
        montoOrigen.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    btnConvertir.doClick();
                }
            }
        });
        c.gridx = 0;
        c.gridy = 2;
        c.fill = 1;
        panel.add(montoOrigen,c);
        montoDestino = new JTextField();
        montoDestino.setEditable(false);
        montoDestino.setHorizontalAlignment(JTextField.CENTER);
        montoDestino.setPreferredSize(new Dimension(80,30));
        c.gridx = 1;
        c.gridy = 2;
        c.fill = 1;
        panel.add(montoDestino,c);

        // botones
        btnConvertir = new JButton("Convertir");
        btnConvertir.setPreferredSize(new Dimension(100,25));
        
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        c.fill = 0;
        panel.add(btnConvertir,c);
        btnRegresar = new JButton("Regresar");
        btnRegresar.setPreferredSize(new Dimension(100,25));
        btnRegresar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                FrameInicio frame = new FrameInicio();
                frame.setVisible(true);
            }
            
        });
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        panel.add(btnRegresar,c);
        
        





        add(panel);

    }

    

}
