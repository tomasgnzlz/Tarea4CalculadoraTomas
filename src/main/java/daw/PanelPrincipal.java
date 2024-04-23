/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author tomas
 */
public class PanelPrincipal extends JPanel implements ActionListener {

    // Atributos de la clase (privados)
    private PanelBotones botonera;
    private JTextArea areaTexto;
    private int tipoOperacion;

    // Constructor  
    public PanelPrincipal() {
        initComponents();
        tipoOperacion = -1; // No hay operaciones en la calculadora

    }

    // Se inicializan los componentes gráficos y se colocan en el panel
    private void initComponents() {
        // Creamos el panel de botones
        botonera = new PanelBotones();
        // Creamos el área de texto
        areaTexto = new JTextArea(10, 50);
        areaTexto.setEditable(false);
        areaTexto.setBackground(Color.white);
        //Establecemos layout del panel principal
        this.setLayout(new BorderLayout());
        // Colocamos la botonera y el área texto
        this.add(areaTexto, BorderLayout.NORTH);
        this.add(botonera, BorderLayout.SOUTH);

        for (JButton boton : this.botonera.getgrupoBotones()) {
            boton.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        // Atributos
        String parametro = "";
        String operacion = "";
        int valor1, valor2, resultado;

        // Se obtiene el objeto que desencadena el evento
        Object o = ae.getSource();
        // Si es un botón

        if (o instanceof JButton jbutton) {
            // Variable en la que guardo los valores de los botones
            parametro = ((JButton) o).getText();
            System.out.println(parametro);

            //if (Integer.parseInt(parametro) >= 0 || "+".contains(parametro)) {
                areaTexto.append(parametro);
//                valor1 = Integer.parseInt(areaTexto.getText());
//                System.out.println("Valor1: " + valor1);
            //} 
            
            operacion = areaTexto.getText();
            String [] array = operacion.split("+");
            
            
            // UNA VEZ TENGO EL AREA DE TEXTO CON LA OPERACION DESEADA, SEPARO EL sTRING EN PARTES Y DOY VALOR  A VALOR1 Y VALOR 2 Y SI EL AREA DE TEXTO CONTIENE UN = HAGO LA OPERACION
        }

        // RESTO DEL CÓDIGO DE LA LÓGICA DE LA CALCULADORA
    }

}
