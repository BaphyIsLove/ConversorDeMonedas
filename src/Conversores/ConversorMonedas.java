package Conversores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import recursos.FrameStandar;
import recursos.Items;

public class ConversorMonedas extends FrameStandar{

    //lista de monedas
    Items[] monedas = {
        new Items("Selecciona una opción", "", "", 0), 
        new Items("Dolar", "USD", "$", 1),
        new Items("Euro", "EUR", "€", 0.91),
        new Items("Libra", "GBP", "£", 0.8),
        new Items("Yen", "JPY", "¥", 131.72),
        new Items("Won", "KRW", "₩", 1313.88),
        new Items("Peso Mexicano", "MXN", "$", 18.13)
    };
    
    public ConversorMonedas(){
        super();
        setTitle("Conversor de Monedas");
        for(Items item : monedas){
            seleccionOrigen.addItem(item);
            seleccionDestino.addItem(item);
        }
        
        btnConvertir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Items origen = (Items) seleccionOrigen.getSelectedItem();   
                Items destino = (Items) seleccionDestino.getSelectedItem();   
                if(origen.getNombre() != "Selecciona una opción"){
                    if(destino.getNombre() != "Selecciona una opción"){
                        double valor = Double.parseDouble(montoOrigen.getText());
                        double tipoCambio = destino.getValor() / origen.getValor();
                        double resultado = valor * tipoCambio;
                        montoDestino.setText(destino.getSimbolo() + " " + String.format("%1.2f", resultado));
                    } else{
                        JOptionPane.showMessageDialog(null, "Seleccione una opción");
                    }   
                } else{
                JOptionPane.showMessageDialog(null, "Seleccione una opción");
                }
                    
            }
 
        });
    }
}

