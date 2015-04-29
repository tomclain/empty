/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contenido;

import Util.Tools;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * @author Adalberto Rincon Nuñez - Ing. Mecatronico
 * @author Juan Camilo Trillos Velosa - Ing. Multimedia
 */
public class Anime {

    private String nombre, sinopsis, genero,
            estado, info, extras, fansub,
            version, opening, ending,
            estudio, descargados, capitulos;

    private AnimePanel panel;
    private ImageIcon image;

    //<editor-fold defaultstate="collapsed" desc="Constructor :: Anime()">
    public Anime() {

        nombre = "";
        sinopsis = "";
        genero = "";
        estado = "";
        info = "";
        extras = "";
        fansub = "";
        version = "";
        opening = "";
        ending = "";
        estudio = "";
        descargados = "";
        capitulos = "";

        panel = new AnimePanel();
        image = new ImageIcon();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodo :: agregarAnime()">
    public void agregarAnime() {

        nombre = panel.getNombreText().getText();
        genero = panel.getGeneroText().getText();
        descargados = panel.getDescargadosText().getText();
        capitulos = panel.getCapitulosText().getText();
        sinopsis = panel.getSinopsisText().getText();
        estado = panel.getEstadoText().getText();
        fansub = panel.getFansubText().getText();
        version = panel.getVersionText().getText();
        info = panel.getInfoText().getText();
        estudio = panel.getEstudioText().getText();
        extras = panel.getExtrasText().getText();
        opening = panel.getOpeningText().getText();
        ending = panel.getEndingText().getText();
        guardarAnime();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodo :: guardarAnime()">
    public void guardarAnime() {

        File file = new File("Animes\\" + nombre);
        file.mkdirs();
        try {
            File fImage = new File("Animes\\" + nombre + "\\Imagen.jpg");
            if (panel.getBufferedImage() != null) {
                ImageIO.write(panel.getBufferedImage(), "jpg", fImage);
            }

        } catch (IOException ex) {
        }

        saveInfo();
    }
//</editor-fold>

    public void eliminarAnime() {

    }

    //<editor-fold defaultstate="collapsed" desc="Metodo :: chargeAnime()">
    public void chargeAnime() {

        nombre = Tools.readFile(nombre, "Nombre");
        panel.getNombreText().setText(nombre);

        genero = Tools.readFile(nombre, "Genero");
        panel.getGeneroText().setText(genero);

        descargados = Tools.readFile(nombre, "Descargados");
        panel.getDescargadosText().setText(descargados);

        capitulos = Tools.readFile(nombre, "Capitulos");
        panel.getCapitulosText().setText(capitulos);

        sinopsis = Tools.readFile(nombre, "Sinopsis");
        panel.getSinopsisText().setText(sinopsis);

        estado = Tools.readFile(nombre, "Estado");
        panel.getEstadoText().setText(estado);

        fansub = Tools.readFile(nombre, "Fansub");
        panel.getFansubText().setText(fansub);

        version = Tools.readFile(nombre, "Version");
        panel.getVersionText().setText(version);

        info = Tools.readFile(nombre, "Información");
        panel.getInfoText().setText(info);

        estudio = Tools.readFile(nombre, "Estudio");
        panel.getEstudioText().setText(estudio);

        extras = Tools.readFile(nombre, "Extras");
        panel.getExtrasText().setText(extras);

        opening = Tools.readFile(nombre, "Openings");
        panel.getOpeningText().setText(opening);

        ending = Tools.readFile(nombre, "Endings");
        panel.getEndingText().setText(ending);

        image = new ImageIcon("Animes\\" + nombre + "\\Imagen.jpg");
        panel.getmImage().setIcon(Tools.chargeImage(image, panel.getmImage()));

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodo :: saveInfo()">
    public void saveInfo() {

        Tools.writeFile(nombre, nombre, "Nombre");
        Tools.writeFile(nombre, genero, "Genero");
        Tools.writeFile(nombre, descargados, "Descargados");
        Tools.writeFile(nombre, capitulos, "Capitulos");
        Tools.writeFile(nombre, sinopsis, "Sinopsis");
        Tools.writeFile(nombre, estado, "Estado");
        Tools.writeFile(nombre, fansub, "Fansub");
        Tools.writeFile(nombre, version, "Version");
        Tools.writeFile(nombre, info, "Información");
        Tools.writeFile(nombre, estudio, "Estudio");
        Tools.writeFile(nombre, extras, "Extras");
        Tools.writeFile(nombre, opening, "Openings");
        Tools.writeFile(nombre, ending, "Endings");
        Tools.writeFile(nombre, "Animes", "Animes");
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos :: Sets() and Gets()">
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public String getFansub() {
        return fansub;
    }

    public void setFansub(String fansub) {
        this.fansub = fansub;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getOpening() {
        return opening;
    }

    public void setOpening(String opening) {
        this.opening = opening;
    }

    public String getEnding() {
        return ending;
    }

    public void setEnding(String ending) {
        this.ending = ending;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getDescargados() {
        return descargados;
    }

    public void setDescargados(String descargados) {
        this.descargados = descargados;
    }

    public String getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(String capitulos) {
        this.capitulos = capitulos;
    }

    public AnimePanel getPanel() {
        return panel;
    }

    public void setPanel(AnimePanel panel) {
        this.panel = panel;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }
//</editor-fold>
}
