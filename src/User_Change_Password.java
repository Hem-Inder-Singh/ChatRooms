
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class User_Change_Password extends javax.swing.JFrame {

    
    String username;
    public User_Change_Password(String username) {
        initComponents();
        setSize(500,500);
        setVisible(true);
        getContentPane().setBackground(new Color(153,255,204));
        this.username=username;
        j_user.setText(username);
        j_user.setEnabled(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        j_user = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        j_newpass = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jconfirmpass = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        joldpass = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Username");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 90, 90, 30);
        getContentPane().add(j_user);
        j_user.setBounds(140, 90, 320, 30);

        jLabel2.setText("Old Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 140, 90, 30);

        jLabel3.setText("New Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 200, 90, 30);
        getContentPane().add(j_newpass);
        j_newpass.setBounds(140, 200, 320, 30);

        jLabel4.setText("Confirm Password");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 250, 110, 30);
        getContentPane().add(jconfirmpass);
        jconfirmpass.setBounds(140, 250, 320, 30);

        jButton1.setBackground(new java.awt.Color(51, 204, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 255));
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(180, 300, 110, 50);
        getContentPane().add(joldpass);
        joldpass.setBounds(140, 140, 320, 30);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 51, 255));
        jButton2.setText("<- Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(10, 10, 90, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String oldpass=joldpass.getText().toString();
        String newpass=j_newpass.getText().toString();
        String confirmpass=jconfirmpass.getText().toString();
        if(oldpass.isEmpty()|| newpass.isEmpty()||confirmpass.isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane,"All field are mandatory");
        }
        else if(newpass.equals(confirmpass))
        {
            try {
                HttpResponse<String> httpresponse=Unirest.get(GlobalClass.ip+"user_change_password")
                        .queryString("username",username)
                        .queryString("oldpassword",oldpass)
                        .queryString("newpassword",newpass)
                        .asString();
                if(httpresponse.getStatus()== 200)
                {
                    String res=httpresponse.getBody();
                    JOptionPane.showMessageDialog(rootPane, res);
                }
            } catch (UnirestException ex) {
                Logger.getLogger(User_Change_Password.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane,"New Password and Confirm Password must Match");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        User_Home obj=new User_Home(username);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(User_Change_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_Change_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_Change_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_Change_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new User_Change_Password().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField j_newpass;
    private javax.swing.JTextField j_user;
    private javax.swing.JPasswordField jconfirmpass;
    private javax.swing.JPasswordField joldpass;
    // End of variables declaration//GEN-END:variables
}
