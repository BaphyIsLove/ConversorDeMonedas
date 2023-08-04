package Conversores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import recursos.FrameStandar;
import recursos.Items;

public class ConversorLongitudes extends FrameStandar{

    Items[] longitudes = {
        new Items("Metro", "m", 1),
        new Items("Kilometro", "km", 1000),
        new Items("Pie", "ft", 0.3048),
        new Items("Pulgada", "in", 0.0254),
        new Items("Yarda", "yd", 0.9144),
        new Items("Milla", "mi", 1609.344),
    };

    public ConversorLongitudes(){
        super();
        setTitle("Conversor de Monedas");
        for(Items item : longitudes){
            seleccionOrigen.addItem(item);
            seleccionDestino.addItem(item);
        }
        
        btnConvertir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Items origen = (Items) seleccionOrigen.getSelectedItem();   
                Items destino = (Items) seleccionDestino.getSelectedItem();   
                double valor = Double.parseDouble(montoOrigen.getText());
                double tipoCambio =origen.getValor() / destino.getValor();
                double resultado = valor * tipoCambio;
                montoDestino.setText(String.format("%1.4f", resultado)+destino.getSimbolo());
            }
        });
    }
}

