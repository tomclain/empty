/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author Adalberto Rincon Nuñez - Ing. Mecatronico
 * @author Juan Camilo Trillos Velosa - Ing. Multimedia
 */
public class Tools {

    //<editor-fold defaultstate="collapsed" desc="Metodo Static :: chargeImage(ImageIcon, JLabel)">
    public static Icon chargeImage(ImageIcon image, JLabel mostrarImage) {

        Icon c = new ImageIcon(image.getImage().getScaledInstance(mostrarImage.getWidth(),
                mostrarImage.getHeight(), Image.SCALE_DEFAULT));

        return c;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodo Static :: createJButton(String, int, int, int, int)">
    public static JButton createJButton(String nombre, int x, int y, int w, int h) {
        JButton boton = new JButton(nombre);
        boton.setBounds(x, y, w, h);
        boton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return boton;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodo Static :: createComboBox(int, int, int, int)">
    public static JComboBox<String> createComboBox(int x, int y, int w, int h) {
        JComboBox<String> combo = new JComboBox<>();
        combo.setBounds(x, y, w, h);
        combo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return combo;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodo Static :: createJLabel(String, int, int, int, int)">
    public static JLabel createJLabel(String titulo, int x, int y, int w, int h) {
        JLabel label = new JLabel(titulo);
        label.setBounds(x, y, w, h);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        label.setOpaque(true);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodo Static :: createJTextField(int, int, int, int)">
    public static JTextField createJtextField(int x, int y, int w, int h) {
        JTextField field = new JTextField();
        field.setBounds(x, y, w, h);
        field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        field.setHorizontalAlignment(SwingConstants.CENTER);
        return field;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodo Static :: createJScrollPane(Component area, int, int, int, int)">
    public static JScrollPane createJScrollPane(Component area, int x, int y, int w, int h) {
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(x, y, w, h);
        return scroll;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodo Static :: createJTextArea()">
    public static JTextArea createJTextArea() {
        JTextArea area = new JTextArea();
        area.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        return area;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodo Static :: writeFile(String, String, String)">
    public static void writeFile(String nombre, String variable, String file) {
        
        try {
            try (FileWriter fWriter = new FileWriter("Animes\\" + nombre + "\\" + file + ".txt")) {
                fWriter.write(variable);
            }
        } catch (IOException ex) {
            
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodo Static :: readFile(String, String)">
    public static String readFile(String nombre, String Dir) {
        String n = "";
        int m = -1;
        try {
            try (FileReader fileR = new FileReader("Animes\\" + nombre + "\\" + Dir + ".txt")) {
                while ((m = fileR.read()) != -1) {
                    n += "" + String.valueOf((char) m);
                }
            }
            return n;
            
        } catch (IOException ex) {
            System.out.println("error de lectura");
        }
        return null;
    }
//</editor-fold>
}
