package codigo;

import codigo.formas.Circulo;
import codigo.formas.Estrella;
import codigo.formas.Forma;
import codigo.formas.Pentagono;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rocio Soriano
 */
public class VentanaPaint extends javax.swing.JFrame {

    /**
     * un buffer acelera, guarda una memoria intermedia que acelera la lectura
     * del disco a la memoria. Servirá para que podamos dibujar en el jpanel,
     * que lo hace la tarjeta de memoria
     */
    BufferedImage buffer = null;
 

    Graphics2D bufferGraphics, jpanelGraphics = null;

    Circulo miCirculo = null;
    Forma miForma = null;

    public VentanaPaint() {
        initComponents();
        inicializaBuffers();
    }

    private void inicializaBuffers() {
        //queremos enlazar bufferGraphics (dibuja), jpanelGraphics.

        //se crea una imagen de igual ancho y alto q el JPanel1
        //Buffer almacena
        buffer = (BufferedImage) jPanel1.createImage(jPanel1.getWidth(), jPanel1.getHeight());
        //casteo= convertir de un tipo a otro
        //creo una imagen modificable
        bufferGraphics = buffer.createGraphics();
        // inicializo el buffer para que se pinte de blanco entero 
        bufferGraphics.setColor(Color.WHITE);
        //mismo ancho y alto que nuestro jpanel

        bufferGraphics.fillRect(0, 0, jPanel1.getWidth(), jPanel1.getHeight());

        //enlazamos el jPanel1 con el JPanelGraphics, de esa forma lo q 
        //dibujemos dentro del JpanelGraphics irá al Jpanel1
        jpanelGraphics = (Graphics2D) jPanel1.getGraphics();

    }

    /**
     * Enlazamos el jPanel con la zona que dibujamos sobreescribiendo un metodo:
     *
     * @Override
     */
    @Override
    public void paint(Graphics g) {
        //llamamos al jframe para el metodo paint que ya existia ignorando el codigo preexistente
        super.paint(g);

        // pinto el buffer sobre el jPanel, 
        jpanelGraphics.drawImage(buffer, 0, 0, null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        colores1 = new codigo.PanelColores();
        herramientas1 = new codigo.Herramientas();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 708, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 342, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(herramientas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(colores1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(68, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(herramientas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(colores1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        switch (herramientas1.formaElegida) {
            case 0:
                bufferGraphics.setColor(colores1.colorSeleccionado);
                bufferGraphics.fillOval(evt.getX(), evt.getY(), 5, 5);
                break;   

               case 1 : miCirculo.dibujate(bufferGraphics, evt.getX());break;
            case 5 : miForma.dibujate(bufferGraphics, evt.getX(), evt.getY());break;
            case 256 : miForma.dibujate(bufferGraphics, evt.getX(), evt.getY());break;

        }
  repaint(0, 0, 1, 1);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        switch (herramientas1.formaElegida) {
            case 0:
                break;

            case 1:
                miCirculo = new Circulo(evt.getX(), evt.getY(), 1, colores1.colorSeleccionado, true);
                miCirculo.dibujate(bufferGraphics, evt.getX());
                break;
            case 5 : miForma = new Pentagono(evt.getX(), evt.getY(), 5, colores1.colorSeleccionado , true);
                     miForma.dibujate(bufferGraphics, evt.getX(), evt.getY());
                break;    
            case 256 : miForma = new Estrella(evt.getX(), evt.getY(), 256, colores1.colorSeleccionado , true);
                     miForma.dibujate(bufferGraphics, evt.getX(), evt.getY());
                break; 
        }
    }//GEN-LAST:event_jPanel1MousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPaint().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private codigo.PanelColores colores1;
    private codigo.Herramientas herramientas1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
