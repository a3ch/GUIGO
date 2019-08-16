/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
import javax.swing.JFrame;
 
import com.towel.swing.img.JImagePanel;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author banshee
 */
public class TelaDescanso extends javax.swing.JFrame {
    
    private javax.swing.JMenu jMenuAcesso;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuLogin;

    
    public TelaDescanso() throws IOException {
        initComponents();
    }
    
    private void initComponents() throws IOException {
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuAcesso = new javax.swing.JMenu();
        jMenuLogin = new javax.swing.JMenuItem();
        
        JImagePanel panel = new JImagePanel(
                loadImage("/home/banshee/Documents/IFBA/3-Semestre/POO/GUIGO/src/img/guigo-logo.png"));
 
        setPreferredSize(new Dimension(100, 100));
        setExtendedState(MAXIMIZED_BOTH);
        add(panel);
        
        jMenuAcesso.setText("Acesso");
        jMenuLogin.setText("Log-in");
        jMenuAcesso.add(jMenuLogin);
        jMenuBar1.add(jMenuAcesso);
        setJMenuBar(jMenuBar1);
        
        
        
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) throws Throwable {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new TelaDescanso().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(TelaDescanso.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
 
    private static BufferedImage loadImage(String file) throws IOException {
        return ImageIO.read(new File(file));
    }

    
}
