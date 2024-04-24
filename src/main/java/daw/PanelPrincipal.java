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
        String parametro = ((JButton) ae.getSource()).getText();
        System.out.println(parametro);
        double resultado = 0;
        boolean divCero = false;

        switch (parametro) {
            case "=" -> {
                String operacion = areaTexto.getText();
                String[] array = operacion.split("(?<=[-+*/])|(?=[-+*/])");
                String operador = "+";
                for (String array1 : array) {
                    if (array1.matches("[0-9]+")) {
                        double valor = Double.parseDouble(array1);
                        switch (operador) {
                            case "+" ->
                                resultado = resultado + valor;
                            case "-" ->
                                resultado = resultado - valor;
                            case "*" ->
                                resultado *= resultado * valor;
                            case "/" -> {
                                if (valor == 0) {
                                    divCero = true;
                                }
                                resultado = resultado / valor;
                            }
                        }
                    } else {
                        operador = array1;
                    }
                }
                if (divCero) {
                    areaTexto.setText("***ERROR***");
                } else {
                    areaTexto.setText(operacion + " = " + resultado);
                }
            }

            case "C" ->
                areaTexto.setText("");
            default ->
                areaTexto.append(parametro);
        }
    }

}
