/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Contenido.Anime;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * @author Adalberto Rincon Nuñez - Ing. Mecatronico
 * @author Juan Camilo Trillos Velosa - Ing. Multimedia
 */
public class Buscador extends JFrame implements ActionListener {

    private JPanel panel, pScroll;
    private JComboBox<String> combo;
    private JLabel buNombre, fondo;
    private JTextField tNombre;
    private JScrollPane scroll;
    private LinkedList<Anime> animes;
    private JButton bAnime, cerrar;
    private JButton[] buttons;

    //<editor-fold defaultstate="collapsed" desc="Constructor :: Buscador()">
    public Buscador() {

        setSize(500, 500);

        int r = (int) (Math.random() * 9);
        ImageIcon image = new ImageIcon("Images\\background" + r + ".jpg");
        fondo = new JLabel();//se crea un JLabel para crear un fondo al JPanel
        fondo.setBounds(0, 0, 500, 500);
        fondo.setIcon(Tools.chargeImage(image, fondo));

        animes = new LinkedList<>();
        panel = new JPanel(null);
        pScroll = new JPanel(null);
        scroll = Tools.createJScrollPane(pScroll, 50, 180, 400, 250);
        buNombre = Tools.createJLabel("Nombre", 50, 50, 100, 30);
        tNombre = Tools.createJtextField(155, 50, 150, 30);
        bAnime = Tools.createJButton("Buscar", 310, 50, 100, 30);
        cerrar = Tools.createJButton("Cerrar", 5, 435, 100, 30);
        combo = Tools.createComboBox(50, 15, 100, 30);
        buttons = null;

        tNombre.setText("Animes");
        combo.addItem("Animes");
        combo.addItem("Nombre");
        combo.addItem("Genero");
        combo.addItem("Fansub");
        combo.addItem("Estudio");
        combo.addItem("Version");

        add(panel);
        panel.add(buNombre);
        panel.add(tNombre);
        panel.add(bAnime);
        panel.add(combo);
        panel.add(cerrar);
        panel.add(fondo);
        fondo.add(scroll);

        DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
        dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        combo.setRenderer(dlcr);
        combo.addActionListener(this);
        cerrar.addActionListener(this);
        setVisible(true);//se puede visualizar la ventana
        setLocationRelativeTo(null);//JFrame aparece en el Centro
        setResizable(false);//No se puede modificar el tamaño del JFrame manualmente
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodo :: Search()">
    public void Search() {
        buttons = new JButton[animes.size()];
        pScroll.setPreferredSize(new Dimension(400, 100 * buttons.length / 4 + 75));
        int k = 0;
        
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < 4; j++) {
                
                if (k < buttons.length && !"".equals(tNombre.getText())) {
                    
                    if (animes.size() > 0) {
                        for (Anime anime : animes) {
                            
                            String hola = Tools.readFile(anime.getNombre(), (String) combo.getSelectedItem());
                            if (hola.toLowerCase().contains(tNombre.getText().toLowerCase())) {
                                
                                buttons[k] = new JButton();
                                buttons[k].setName(anime.getNombre());
                                buttons[k].setBounds(j * 100, i * 100, 100, 100);
                                ImageIcon image = anime.getImage();
                                Icon c = new ImageIcon(image.getImage().getScaledInstance(buttons[k].getWidth(),
                                        buttons[k].getHeight(), Image.SCALE_DEFAULT));
                                buttons[k].setIcon(c);
                                animes.remove(anime);
                                
                                pScroll.add(buttons[k]);
                                k++;
                                break;
                            }
                        }
                    }
                }
            }
        }
        
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodo :: Start(LinkedList<Anime>)">
    public void Start(LinkedList<Anime> animes) {
        
        this.animes.clear();
        for (Iterator<Anime> it = animes.iterator(); it.hasNext();) {
            Anime anime = it.next();
            this.animes.add(anime);
        }
        pScroll.removeAll();
        buttons = null;
        Search();
        tNombre.setText("");
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodo :: actionPerformed(ActionEvent)">
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == cerrar) {
            this.dispose();
        }
        
        if (e.getSource() == combo) {
            tNombre.setText("");
            if ("Animes".equals((String) combo.getSelectedItem())) {
                tNombre.setText("Animes");
            }
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos :: Sets() and Gets()">
    public JPanel getPanel() {
        return panel;
    }
    
    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
    
    public JPanel getpScroll() {
        return pScroll;
    }
    
    public void setpScroll(JPanel pScroll) {
        this.pScroll = pScroll;
    }
    
    public JComboBox<String> getCombo() {
        return combo;
    }
    
    public void setCombo(JComboBox<String> combo) {
        this.combo = combo;
    }
    
    public JLabel getBuNombre() {
        return buNombre;
    }
    
    public void setBuNombre(JLabel buNombre) {
        this.buNombre = buNombre;
    }
    
    public JLabel getFondo() {
        return fondo;
    }
    
    public void setFondo(JLabel fondo) {
        this.fondo = fondo;
    }
    
    public JTextField gettNombre() {
        return tNombre;
    }
    
    public void settNombre(JTextField tNombre) {
        this.tNombre = tNombre;
    }
    
    public JScrollPane getScroll() {
        return scroll;
    }
    
    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }
    
    public LinkedList<Anime> getAnimes() {
        return animes;
    }
    
    public void setAnimes(LinkedList<Anime> animes) {
        this.animes = animes;
    }
    
    public JButton getbAnime() {
        return bAnime;
    }
    
    public void setbAnime(JButton bAnime) {
        this.bAnime = bAnime;
    }
    
    public JButton getCerrar() {
        return cerrar;
    }
    
    public void setCerrar(JButton cerrar) {
        this.cerrar = cerrar;
    }
    
    public JButton[] getButtons() {
        return buttons;
    }
    
    public void setButtons(JButton[] buttons) {
        this.buttons = buttons;
    }
//</editor-fold>
}
