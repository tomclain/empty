/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Util.Tools;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author Adalberto Rincon Nuñez - Ing. Mecatronico
 * @author Juan Camilo Trillos Velosa - Ing. Multimedia
 */
public class Pantalla extends JPanel {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private JButton bBuscar;
    private JButton bCerrar;
    private JButton bAgregar;
    private JButton bImage;
    private ImageIcon image;
    private JLabel fondo;
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor :: Pantalla(int,int)">
    public Pantalla(int x, int y) {

        image = new ImageIcon("Images\\Inicio.jpg");

        fondo = Tools.createJLabel(null, 0, 0, x, y);
        Icon icon = Tools.chargeImage(image, fondo);
        fondo.setIcon(icon);
        add(fondo);

        setSize(x, y);
        setVisible(true);//se puede visualizar el JPanel
        setBackground(Color.LIGHT_GRAY);//color de fondo del JPanel
        setLayout(null);//permite organizar el contenido del panel libremente, sin restricciones

        createJButtons();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodo :: createJButtons()">
    private void createJButtons() {

        bAgregar = Tools.createJButton("Agregar Anime", 428, 275, 120, 30);
        fondo.add(bAgregar);//se agrega el JButton al JLabel para que este quede encima y se pueda visualizar

        bBuscar = Tools.createJButton("Buscar Anime", 428, 310, 120, 30);
        fondo.add(bBuscar);

        bCerrar = Tools.createJButton("Salir", 428, 345, 120, 30);
        fondo.add(bCerrar);

        bImage = Tools.createJButton("Image", 10, 480, 100, 30);
        fondo.add(bImage);

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodo :: saveImage()">
    public void saveImage() {
        BufferedImage bufferedImage = null;
        
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG y PNG", "jpg", "png");
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(filtro);
        
        int approve = fc.showOpenDialog(this);
        if (approve == JFileChooser.APPROVE_OPTION) {
            try {
                bufferedImage = ImageIO.read(fc.getSelectedFile().toURL());
                ImageIO.write(bufferedImage, "jpg", new File("Images\\Inicio.jpg"));
            } catch (IOException ex) {
            }
            image.setImage(bufferedImage);
            Icon icon = Tools.chargeImage(image, fondo);
            fondo.setIcon(icon);
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos :: Sets() and Gets()">
    /**
     * devuelve un atributo de la clase.
     *
     * @return Atributo JButton agregar anime.
     */
    public JButton getbAgregar() {
        return bAgregar;
    }

    /**
     * cambia un atributo de la clase.
     *
     * @param bAgregar
     */
    public void setbAgregar(JButton bAgregar) {
        this.bAgregar = bAgregar;
    }

    /**
     * devuelve un atributo de la clase.
     *
     * @return Atributo JButton Cerrar
     */
    public JButton getbCerrar() {
        return bCerrar;
    }

    /**
     * cambia un atributo de la clase.
     *
     * @param bCerrar
     */
    public void setbCerrar(JButton bCerrar) {
        this.bCerrar = bCerrar;
    }

    /**
     * devuelve un atributo de la clase.
     *
     * @return Atributo JButton Buscar
     */
    public JButton getbBuscar() {
        return bBuscar;
    }

    /**
     * cambia un atributo de la clase.
     *
     * @param bBuscar
     */
    public void setbBuscar(JButton bBuscar) {
        this.bBuscar = bBuscar;
    }

    /**
     * devuelve un atributo de la clase.
     *
     * @return Atributo JLabel Fondo
     */
    public JLabel getFondo() {
        return fondo;
    }

    /**
     * cambia un atributo de la clase.
     *
     * @param fondo
     */
    public void setFondo(JLabel fondo) {
        this.fondo = fondo;
    }

    public JButton getbImage() {
        return bImage;
    }

    public void setbImage(JButton bImage) {
        this.bImage = bImage;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }
    
    
//</editor-fold>
}
