/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Contenido.Anime;
import Util.Buscador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JFrame;

/**
 * @author Adalberto Rincon Nuñez - Ing. Mecatronico
 * @author Juan Camilo Trillos Velosa - Ing. Multimedia
 */
public class AnimeApp extends JFrame implements ActionListener {

    public Pantalla pantalla;
    public Buscador buscar;
    public LinkedList<Anime> animes;

    //<editor-fold defaultstate="collapsed" desc="Constructor :: AnimeApp">
    public AnimeApp(String name) {

        super(name);//le coloca nombre al JFrame
        pantalla = new Pantalla(977, 550);//crea en JPanel que va conectado a la ventana
        animes = new LinkedList<>();//inicializa lista de animes
        buscar = null;
        add(pantalla);//el JPanel se agrega a la ventana

        setSize(977, 550);//Tamaño de la ventana
        setVisible(true);//se puede visualizar la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);//El JFrame se cierra al presionar salir [X]
        setResizable(false);//No se puede modificar el tamaño del JFrame manualmente
        setLocationRelativeTo(null);//JFrame aparece en el Centro

        setJButtons();
        cargarAnimes();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodo :: actionPerformed(ActionEvent)">
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == pantalla.getbCerrar()) {

            System.exit(0);
        }
        if (e.getSource() == pantalla.getbAgregar()) {

            setSize(1250, 700);
            pantalla.hide();
            Anime anime = new Anime();
            animes.add(anime);
            add(anime.getPanel());
            anime.getPanel().getbGuardar().addActionListener(this);
            anime.getPanel().getbImagen().addActionListener(this);
            anime.getPanel().getbInicio().addActionListener(this);
            anime.getPanel().getbModificar().addActionListener(this);
            setLocationRelativeTo(null);
        }
        if (e.getSource() == pantalla.getbBuscar()) {

            buscar = new Buscador();
            buscar.getbAnime().addActionListener(this);
        }
        if(e.getSource()==pantalla.getbImage()){
            pantalla.saveImage();
        }
        if (buscar != null) {
            if (e.getSource() == buscar.getbAnime()) {
                buscar.Start(animes);
                for (int i = 0; i < buscar.getButtons().length; i++) {
                    if (buscar.getButtons()[i] != null) {
                        buscar.getButtons()[i].addActionListener(this);
                    }
                }
            }
        }
        if (animes.size() > 0) {
            for (Anime anime : animes) {
                if (e.getSource() == anime.getPanel().getbImagen()) {
                    anime.setImage(anime.getPanel().saveImage());
                }
                if (e.getSource() == anime.getPanel().getbGuardar()) {
                    anime.agregarAnime();
                    anime.getPanel().Modificar(false);
                }
                if (e.getSource() == anime.getPanel().getbModificar()) {
                    anime.getPanel().Modificar(true);
                }
                if (e.getSource() == anime.getPanel().getbInicio()) {

                    setSize(977, 550);//Tamaño de la ventana
                    anime.getPanel().hide();
                    pantalla.show();
                    setLocationRelativeTo(null);
                    anime.getPanel().Modificar(false);
                    if (anime.getNombre().equals("")) {
                        animes.remove(anime);
                        break;
                    }
                }
            }
        }
        if (buscar != null) {
            if (buscar.getButtons() != null) {
                for (int i = 0; i < buscar.getButtons().length; i++) {
                    if (buscar.getButtons()[i] == e.getSource()) {
                        if (animes.size() > 0) {
                            for (Iterator<Anime> it = animes.iterator(); it.hasNext();) {
                                Anime anime = it.next();
                                anime.getPanel().hide();
                                if (buscar.getButtons()[i].getName().equals(anime.getNombre())) {
                                    setSize(1250, 700);
                                    pantalla.hide();
                                    anime.getPanel().show();
                                    setLocationRelativeTo(null);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodo :: setJButtons()">
    private void setJButtons() {
        //Estos metodos activan la escucha de los botones cuando son presionados
        pantalla.getbAgregar().addActionListener(this);
        pantalla.getbBuscar().addActionListener(this);
        pantalla.getbCerrar().addActionListener(this);
        pantalla.getbImage().addActionListener(this);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodo :: cargarAnime()">
    private void cargarAnimes() {
        File f = new File("Animes");
        f.mkdirs();
        File[] a = f.listFiles();
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i].getName());
            Anime anime = new Anime();
            anime.setNombre(a[i].getName());
            anime.chargeAnime();
            add(anime.getPanel());
            anime.getPanel().hide();
            animes.add(anime);
            anime.getPanel().getbGuardar().addActionListener(this);
            anime.getPanel().getbImagen().addActionListener(this);
            anime.getPanel().getbInicio().addActionListener(this);
            anime.getPanel().getbModificar().addActionListener(this);
            anime.getPanel().Modificar(false);
        }
    }
//</editor-fold>

    public static void main(String[] args) {

        // TODO code application logic here
        AnimeApp app = new AnimeApp("AnimeApp");
    }
}
