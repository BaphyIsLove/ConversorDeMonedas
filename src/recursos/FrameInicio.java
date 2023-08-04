package recursos;

import Conversores.*;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameInicio extends JFrame{

    JPanel panel;
    JComboBox<String> selectorOpciones;
    JButton btnAcept, btnCancel;

    public FrameInicio(){
        // propiedades ventana Principal
        ImageIcon icon = new ImageIcon("src/img/icon.png");
        setIconImage(icon.getImage());
        setSize(400,200);
        setTitle("Bienvenido");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        
        panel = new JPanel(new GridBagLayout());
        panel.setBackground(SystemColor.window);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(0, 10, 20, 10);

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        panel.add(new JLabel("Selecciona una opcion para comenzar"),c);
        
        String[] opciones = {"Conversor de Monedas", "Conversor de Temperatura", "Conversor de Longitudes"};
        selectorOpciones = new JComboBox<>(opciones);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        panel.add(selectorOpciones,c);
        
        btnAcept = new JButton("Aceptar");
        btnAcept.setPreferredSize(new Dimension(100,25));
        btnAcept.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                String opcionSeleccionada = (String) selectorOpciones.getSelectedItem();
                switch (opcionSeleccionada){
                    case "Conversor de Monedas":
                        ConversorMonedas monedas = new ConversorMonedas();
                        monedas.setVisible(true);                
                        dispose();
                        break;
                    case "Conversor de Temperatura":
                        ConversorTemperatura temperatura = new ConversorTemperatura();
                        temperatura.setVisible(true);
                        dispose();
                        break;
                    case "Conversor de Longitudes":
                        ConversorLongitudes longitudes = new ConversorLongitudes();
                        longitudes.setVisible(true);
                        dispose();
                        break;
                    default:
                        break;
                }
            }
            
        });
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        panel.add(btnAcept,c);
        
        btnCancel = new JButton("Salir");
        btnCancel.setPreferredSize(new Dimension(100,25));
        btnCancel.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
            
        });
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        panel.add(btnCancel,c);

        add(panel);
    }
}
