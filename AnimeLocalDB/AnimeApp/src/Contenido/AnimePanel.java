/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contenido;

import Util.Tools;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author Adalberto Rincon Nuñez - Ing. Mecatronico
 * @author Juan Camilo Trillos Velosa - Ing. Multimedia
 */
public class AnimePanel extends JPanel {

    private JLabel mImage, fondo;

    private JLabel nombre, sinopsis, genero, estado,
            info, extras, fansub, version, opening,
            ending, estudio, descargados, capitulos;

    private JTextField nombreText, generoText, estadoText, fansubText, versionText,
            estudioText, descargadosText, capitulosText;

    private JTextArea sinopsisText, infoText, extrasText, openingText, endingText;

    private JButton bImagen, bGuardar, bInicio, bModificar;

    private JScrollPane scroll;
    private BufferedImage bufferedImage;

    //<editor-fold defaultstate="collapsed" desc="Constructor :: AnimePanel()">
    public AnimePanel() {

        bufferedImage = null;

        int r = (int) (Math.random() * 9);
        ImageIcon image = new ImageIcon("Images\\background" + r + ".jpg");

        fondo = new JLabel();
        fondo.setBounds(0, 0, 1250, 700);
        fondo.setIcon(Tools.chargeImage(image, fondo));
        add(fondo);

        setSize(1250, 700);
        setVisible(true);//panel visible
        setBackground(Color.LIGHT_GRAY);//color del panel
        setLayout(null);//permite organizar el contenido del panel libremente

        setScreen();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodo :: setScreen()">
    private void setScreen() {

        setJButtons();

        setJLabels();

        setJTextFields();

        setJTextAreas();

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodo :: saveImage()">
    public ImageIcon saveImage() {

        ImageIcon image = new ImageIcon();

        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG y PNG", "jpg", "png");
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(filtro);

        int approve = fc.showOpenDialog(this);
        if (approve == JFileChooser.APPROVE_OPTION) {
            try {
                bufferedImage = ImageIO.read(fc.getSelectedFile().toURL());
            } catch (IOException ex) {
            }
            image.setImage(bufferedImage);
            mImage.setIcon(Tools.chargeImage(image, mImage));
            fondo.add(mImage);
        }
        return image;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodo :: setJButtons()">
    private void setJButtons() {

        bImagen = Tools.createJButton("Examinar", 140, 255, 100, 30);
        fondo.add(bImagen);

        bGuardar = Tools.createJButton("Guardar", 1100, 600, 100, 30);
        fondo.add(bGuardar);

        bInicio = Tools.createJButton("Inicio", 50, 600, 100, 30);
        fondo.add(bInicio);

        bModificar = Tools.createJButton("Modificar", 575, 600, 100, 30);
        fondo.add(bModificar);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodo :: setJLabels()">
    private void setJLabels() {

        mImage = Tools.createJLabel(null, 50, 50, 280, 200);
        fondo.add(mImage);

        nombre = Tools.createJLabel("Nombre", 345, 100, 60, 30);
        fondo.add(nombre);

        genero = Tools.createJLabel("Genero", 345, 140, 60, 30);
        fondo.add(genero);

        descargados = Tools.createJLabel("Descargados", 345, 180, 90, 30);
        fondo.add(descargados);

        capitulos = Tools.createJLabel("Capitulos", 605, 180, 90, 30);
        fondo.add(capitulos);

        estado = Tools.createJLabel("Estado", 345, 220, 60, 30);
        fondo.add(estado);

        fansub = Tools.createJLabel("Fansub", 345, 260, 60, 30);
        fondo.add(fansub);

        version = Tools.createJLabel("Version", 345, 300, 60, 30);
        fondo.add(version);

        sinopsis = Tools.createJLabel("Sinopsis", 920, 50, 60, 30);
        fondo.add(sinopsis);

        info = Tools.createJLabel("Información", 905, 250, 90, 30);
        fondo.add(info);

        estudio = Tools.createJLabel("Estudio", 345, 340, 60, 30);
        fondo.add(estudio);

        extras = Tools.createJLabel("Extras", 920, 420, 60, 30);
        fondo.add(extras);

        opening = Tools.createJLabel("Openings", 270, 420, 60, 30);
        fondo.add(opening);

        ending = Tools.createJLabel("Endigns", 595, 420, 60, 30);
        fondo.add(ending);

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodo :: setJTextFields()">
    private void setJTextFields() {

        nombreText = Tools.createJtextField(410, 100, 320, 30);
        fondo.add(nombreText);

        generoText = Tools.createJtextField(410, 140, 320, 30);
        fondo.add(generoText);

        descargadosText = Tools.createJtextField(440, 180, 30, 30);
        fondo.add(descargadosText);

        capitulosText = Tools.createJtextField(700, 180, 30, 30);
        fondo.add(capitulosText);

        estadoText = Tools.createJtextField(410, 220, 320, 30);
        fondo.add(estadoText);

        fansubText = Tools.createJtextField(410, 260, 320, 30);
        fondo.add(fansubText);

        versionText = Tools.createJtextField(410, 300, 320, 30);
        fondo.add(versionText);

        estudioText = Tools.createJtextField(410, 340, 320, 30);
        fondo.add(estudioText);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodo :: setJTextArea()">
    private void setJTextAreas() {

        sinopsisText = Tools.createJTextArea();
        scroll = Tools.createJScrollPane(sinopsisText, 750, 90, 400, 150);
        fondo.add(scroll, BorderLayout.CENTER);

        infoText = Tools.createJTextArea();
        scroll = Tools.createJScrollPane(infoText, 750, 290, 400, 100);
        fondo.add(scroll, BorderLayout.CENTER);

        extrasText = Tools.createJTextArea();
        scroll = Tools.createJScrollPane(extrasText, 800, 460, 300, 130);
        fondo.add(scroll, BorderLayout.CENTER);

        openingText = Tools.createJTextArea();
        scroll = Tools.createJScrollPane(openingText, 150, 460, 300, 130);
        fondo.add(scroll, BorderLayout.CENTER);

        endingText = Tools.createJTextArea();
        scroll = Tools.createJScrollPane(endingText, 475, 460, 300, 130);
        fondo.add(scroll, BorderLayout.CENTER);

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodo :: Modificar()">
    public void Modificar(boolean change) {
        
        nombreText.setEditable(change);
        sinopsisText.setEditable(change);
        estadoText.setEditable(change);
        estudioText.setEditable(change);
        capitulosText.setEditable(change);
        descargadosText.setEditable(change);
        openingText.setEditable(change);
        endingText.setEditable(change);
        extrasText.setEditable(change);
        generoText.setEditable(change);
        fansubText.setEditable(change);
        generoText.setEditable(change);
        versionText.setEditable(change);
        infoText.setEditable(change);
        bGuardar.setEnabled(change);
        bImagen.setEnabled(change);
        bModificar.setEnabled(!change);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos :: Sets() and Gets()">
    public JLabel getmImage() {
        return mImage;
    }
    
    public void setmImage(JLabel mImage) {
        this.mImage = mImage;
    }
    
    public JLabel getFondo() {
        return fondo;
    }
    
    public void setFondo(JLabel fondo) {
        this.fondo = fondo;
    }
    
    public JLabel getNombre() {
        return nombre;
    }
    
    public void setNombre(JLabel nombre) {
        this.nombre = nombre;
    }
    
    public JLabel getSinopsis() {
        return sinopsis;
    }
    
    public void setSinopsis(JLabel sinopsis) {
        this.sinopsis = sinopsis;
    }
    
    public JLabel getGenero() {
        return genero;
    }
    
    public void setGenero(JLabel genero) {
        this.genero = genero;
    }
    
    public JLabel getEstado() {
        return estado;
    }
    
    public void setEstado(JLabel estado) {
        this.estado = estado;
    }
    
    public JLabel getInfo() {
        return info;
    }
    
    public void setInfo(JLabel info) {
        this.info = info;
    }
    
    public JLabel getExtras() {
        return extras;
    }
    
    public void setExtras(JLabel extras) {
        this.extras = extras;
    }
    
    public JLabel getFansub() {
        return fansub;
    }
    
    public void setFansub(JLabel fansub) {
        this.fansub = fansub;
    }
    
    public JLabel getVersion() {
        return version;
    }
    
    public void setVersion(JLabel version) {
        this.version = version;
    }
    
    public JLabel getOpening() {
        return opening;
    }
    
    public void setOpening(JLabel opening) {
        this.opening = opening;
    }
    
    public JLabel getEnding() {
        return ending;
    }
    
    public void setEnding(JLabel ending) {
        this.ending = ending;
    }
    
    public JLabel getEstudio() {
        return estudio;
    }
    
    public void setEstudio(JLabel estudio) {
        this.estudio = estudio;
    }
    
    public JLabel getDescargados() {
        return descargados;
    }
    
    public void setDescargados(JLabel descargados) {
        this.descargados = descargados;
    }
    
    public JLabel getCapitulos() {
        return capitulos;
    }
    
    public void setCapitulos(JLabel capitulos) {
        this.capitulos = capitulos;
    }
    
    public JTextField getNombreText() {
        return nombreText;
    }
    
    public void setNombreText(JTextField nombreText) {
        this.nombreText = nombreText;
    }
    
    public JTextField getGeneroText() {
        return generoText;
    }
    
    public void setGeneroText(JTextField generoText) {
        this.generoText = generoText;
    }
    
    public JTextField getEstadoText() {
        return estadoText;
    }
    
    public void setEstadoText(JTextField estadoText) {
        this.estadoText = estadoText;
    }
    
    public JTextField getFansubText() {
        return fansubText;
    }
    
    public void setFansubText(JTextField fansubText) {
        this.fansubText = fansubText;
    }
    
    public JTextField getVersionText() {
        return versionText;
    }
    
    public void setVersionText(JTextField versionText) {
        this.versionText = versionText;
    }
    
    public JTextField getEstudioText() {
        return estudioText;
    }
    
    public void setEstudioText(JTextField estudioText) {
        this.estudioText = estudioText;
    }
    
    public JTextField getDescargadosText() {
        return descargadosText;
    }
    
    public void setDescargadosText(JTextField descargadosText) {
        this.descargadosText = descargadosText;
    }
    
    public JTextField getCapitulosText() {
        return capitulosText;
    }
    
    public void setCapitulosText(JTextField capitulosText) {
        this.capitulosText = capitulosText;
    }
    
    public JTextArea getSinopsisText() {
        return sinopsisText;
    }
    
    public void setSinopsisText(JTextArea sinopsisText) {
        this.sinopsisText = sinopsisText;
    }
    
    public JTextArea getInfoText() {
        return infoText;
    }
    
    public void setInfoText(JTextArea infoText) {
        this.infoText = infoText;
    }
    
    public JTextArea getExtrasText() {
        return extrasText;
    }
    
    public void setExtrasText(JTextArea extrasText) {
        this.extrasText = extrasText;
    }
    
    public JTextArea getOpeningText() {
        return openingText;
    }
    
    public void setOpeningText(JTextArea openingText) {
        this.openingText = openingText;
    }
    
    public JTextArea getEndingText() {
        return endingText;
    }
    
    public void setEndingText(JTextArea endingText) {
        this.endingText = endingText;
    }
    
    public JButton getbImagen() {
        return bImagen;
    }
    
    public void setbImagen(JButton bImagen) {
        this.bImagen = bImagen;
    }
    
    public JButton getbGuardar() {
        return bGuardar;
    }
    
    public void setbGuardar(JButton bGuardar) {
        this.bGuardar = bGuardar;
    }
    
    public JButton getbInicio() {
        return bInicio;
    }
    
    public void setbInicio(JButton bInicio) {
        this.bInicio = bInicio;
    }
    
    public JButton getbModificar() {
        return bModificar;
    }
    
    public void setbModificar(JButton bModificar) {
        this.bModificar = bModificar;
    }
    
    public JScrollPane getScroll() {
        return scroll;
    }
    
    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }
    
    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }
    
    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }
//</editor-fold>
}
