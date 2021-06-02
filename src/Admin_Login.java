
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Admin_Login extends javax.swing.JFrame {

    public Admin_Login() {
        initComponents();
        setSize(500, 500);
        setVisible(true);
        setLocation(700,250);
        getContentPane().setBackground(new Color(153,255,204));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        j_admin_login = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        j_username = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Admin Login");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 30, 240, 60);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Enter Username");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 130, 130, 50);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Enter Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 220, 140, 50);

        j_admin_login.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        j_admin_login.setText("Login");
        j_admin_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j_admin_loginActionPerformed(evt);
            }
        });
        getContentPane().add(j_admin_login);
        j_admin_login.setBounds(120, 300, 140, 70);
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(160, 220, 260, 40);
        getContentPane().add(j_username);
        j_username.setBounds(160, 132, 260, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void j_admin_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j_admin_loginActionPerformed
        
        String username = j_username.getText().toString();
        String password = jPasswordField1.getText().toString();
        
        if(username.equals("") || password.equals("")){
            JOptionPane.showMessageDialog(rootPane, "All fields are required.");
        }
        else {
            try {
                
                //Create Request
                HttpResponse<String> httpResponse = Unirest.get(GlobalClass.ip+"admin_login")
                        .queryString("username",username)
                        .queryString("password",password)
                        .asString();
                
                if(httpResponse.getStatus() == 200)
                {
                    
                String res = httpResponse.getBody();
                
                
                if(res.equals("success")){
                    Admin_Home obj = new Admin_Home(username);
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(rootPane, res);
                }
                
                
            }
                
                
            } catch (UnirestException ex) {
                Logger.getLogger(Admin_Login.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
        }
        
    }//GEN-LAST:event_j_admin_loginActionPerformed

   
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
            java.util.logging.Logger.getLogger(Admin_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JButton j_admin_login;
    private javax.swing.JTextField j_username;
    // End of variables declaration//GEN-END:variables
}
