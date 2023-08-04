package Conversores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import recursos.FrameStandar;
import recursos.Items;

public class ConversorTemperatura extends FrameStandar{

    Items[] temperatura = {
        new Items("Selecciona una opción", ""),
        new Items("Celsius", "°C"),
        new Items("Fahrenheit", "°F"),
        new Items("Kelvin", "K"),
    };

    public ConversorTemperatura(){
        super();
        setTitle("Conversor de Temperaturas");
        for(Items item : temperatura){
            seleccionOrigen.addItem(item);
            seleccionDestino.addItem(item);
        }
        btnConvertir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Items origen = (Items) seleccionOrigen.getSelectedItem();
                Items destino = (Items) seleccionDestino.getSelectedItem();
                double valor = Double.parseDouble(montoOrigen.getText());
                
        /*conversion con sentencia if */
                // if(origen.getNombre().equals("Celsius")){
                //     if(destino.getNombre().equals("Celsius")){
                //         montoDestino.setText(valor + " " + destino.getSimbolo());
                //     } else if(destino.getNombre().equals("Fahrenheit")){
                //         montoDestino.setText(((valor*1.8)+32) + " " + destino.getSimbolo());
                //     } else if(destino.getNombre().equals("Kelvin")){
                //         montoDestino.setText((valor + 273.15) + " " + destino.getSimbolo());
                //     } else{
                //         JOptionPane.showMessageDialog(null, "Seleccione una opción");
                //         }
                // }else if(origen.getNombre().equals("Fahrenheit")){
                //     if(destino.getNombre().equals("Celsius")){
                //         montoDestino.setText(((valor - 32) / 1.8) + " " + destino.getSimbolo());
                //     } else if(destino.getNombre().equals("Fahrenheit")){
                //         montoDestino.setText(valor + " " + destino.getSimbolo());
                //     } else if(destino.getNombre().equals("Kelvin")){
                //         montoDestino.setText((((valor - 32) / 1.8) + 273.15) + " " + destino.getSimbolo());
                //     } else{
                //         JOptionPane.showMessageDialog(null, "Seleccione una opción");
                //         }
                // }else if(origen.getNombre().equals("Kelvin")){
                //     if(destino.getNombre().equals("Celsius")){
                //         montoDestino.setText((valor - 273.15) + " " + destino.getSimbolo());
                //     } else if(destino.getNombre().equals("Fahrenheit")){
                //         montoDestino.setText(((valor * 1.8) - 459.67) + " " + destino.getSimbolo());
                //     } else if(destino.getNombre().equals("Kelvin")){
                //         montoDestino.setText(valor + " " + destino.getSimbolo());
                //     } else{
                //         JOptionPane.showMessageDialog(null, "Seleccione una opción");
                //         }
                // }else{
                //     JOptionPane.showMessageDialog(null, "Seleccione una opción");
                // } 
                
        /* conversion con sentencia switch */
                switch (origen.getNombre()){
                    case "Celsius":
                        switch (destino.getNombre()){
                            case "Celsius":
                                montoDestino.setText(valor + " " + destino.getSimbolo());
                                break;
                            case "Fahrenheit":
                                montoDestino.setText(((valor*1.8)+32) + " " + destino.getSimbolo());
                                break;
                            case "Kelvin":
                                montoDestino.setText((valor + 273.15) + " " + destino.getSimbolo());
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Seleccione una opción");
                        }
                        break;
                    
                    case "Fahrenheit":
                        switch (destino.getNombre()){
                            case "Celsius":
                                montoDestino.setText(((valor - 32) / 1.8) + " " + destino.getSimbolo());
                                break;
                            case "Fahrenheit":
                                montoDestino.setText(valor + " " + destino.getSimbolo());
                                break;
                            case "Kelvin":
                                montoDestino.setText((((valor - 32) / 1.8) + 273.15) + " " + destino.getSimbolo());
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Seleccione una opción");
                        }
                        break;

                    case "Kelvin":
                        switch (destino.getNombre()){
                            case "Celsius":
                                montoDestino.setText((valor - 273.15) + " " + destino.getSimbolo());
                                break;    
                            case "Fahrenheit":
                                montoDestino.setText(((valor * 1.8) - 459.67) + " " + destino.getSimbolo());
                                break;  
                            case "Kelvin":
                                montoDestino.setText(valor + " " + destino.getSimbolo());
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Seleccione una opción");
                                break;
                        }
                        break;
                    
                    default:
                        JOptionPane.showMessageDialog(null, "Seleccione una opción");
                        break;
                    }

            }
            
        });
    }
    
}
