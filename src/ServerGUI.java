
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ServerGUI extends javax.swing.JFrame {

    
    chat_room_server obj ;
    public ServerGUI() {
        initComponents();
        setVisible(true);
        setSize(500, 500);
        setLocation(700,250);
        getContentPane().setBackground(new Color(153,255,204));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        j_start = new javax.swing.JButton();
        j_stop = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        j_start.setText("Start Server");
        j_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j_startActionPerformed(evt);
            }
        });
        getContentPane().add(j_start);
        j_start.setBounds(80, 60, 170, 60);

        j_stop.setText("Stop Server");
        j_stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j_stopActionPerformed(evt);
            }
        });
        getContentPane().add(j_stop);
        j_stop.setBounds(80, 180, 180, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void j_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j_startActionPerformed
        try {
            
            obj = new chat_room_server(8888);
        } catch (IOException ex) {
            Logger.getLogger(ServerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_j_startActionPerformed

    private void j_stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j_stopActionPerformed
        // TODO add your handling code here:
        int ans=JOptionPane.showConfirmDialog(rootPane,"Are you Sure to Stop Server ?","Stop Server Dialog",JOptionPane.YES_NO_OPTION);
        if(ans==JOptionPane.YES_OPTION)     
        {
            dispose();
        }
        
        
    }//GEN-LAST:event_j_stopActionPerformed

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
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton j_start;
    private javax.swing.JButton j_stop;
    // End of variables declaration//GEN-END:variables
}
