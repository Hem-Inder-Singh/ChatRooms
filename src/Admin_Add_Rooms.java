
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Admin_Add_Rooms extends javax.swing.JFrame {

    JFileChooser jfc=new JFileChooser();
    File obj_file;
    String username;
    public Admin_Add_Rooms(String username) {
        initComponents();
        setSize(500,500);
        setVisible(true);
        setLocation(700,250);
        this.username=username;
        getContentPane().setBackground(new Color(153,255,204));
        cb_category.removeAllItems();
        for(int i=0;i<GlobalClass.category.length;i++)
        {
            cb_category.addItem(GlobalClass.category[i]);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cb_category = new javax.swing.JComboBox<>();
        j_room = new javax.swing.JTextField();
        j_photo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        bt_browse = new javax.swing.JButton();
        back_to_adminhome = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Category");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 50, 70, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Room Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 120, 100, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Photo");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 180, 60, 16);

        cb_category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cb_category);
        cb_category.setBounds(140, 50, 240, 40);
        getContentPane().add(j_room);
        j_room.setBounds(140, 120, 240, 40);

        j_photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(j_photo);
        j_photo.setBounds(140, 200, 190, 140);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(150, 370, 130, 60);

        bt_browse.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        bt_browse.setText("Browse");
        bt_browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_browseActionPerformed(evt);
            }
        });
        getContentPane().add(bt_browse);
        bt_browse.setBounds(360, 240, 100, 50);

        back_to_adminhome.setText("<-Back");
        back_to_adminhome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_to_adminhomeActionPerformed(evt);
            }
        });
        getContentPane().add(back_to_adminhome);
        back_to_adminhome.setBounds(10, 10, 73, 25);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 153));
        jLabel4.setText("Add Rooms");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(160, 6, 260, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_browseActionPerformed
        
        int ans=jfc.showOpenDialog(this);
        if(ans==JFileChooser.APPROVE_OPTION)
        {
            obj_file=jfc.getSelectedFile();
            System.out.println(""+obj_file.getAbsolutePath());
            j_photo.setText(obj_file.getPath());
            
            //set Image into label
            ImageIcon icon=new ImageIcon(obj_file.getPath());
            Image img=icon.getImage();
            Image newImage=img.getScaledInstance(j_photo.getWidth(),j_photo.getHeight(),Image.SCALE_SMOOTH);
            j_photo.setIcon(new ImageIcon(newImage));
        }
        
    }//GEN-LAST:event_bt_browseActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String category = cb_category.getSelectedItem().toString();
        String roomname=j_room.getText().toString();
        if(roomname.isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane, "All Fields are mandatory");
        }
        else
        {
            try{
                HttpResponse<String> httpResponse=Unirest.post(GlobalClass.ip+"add_rooms")
                    .queryString("category",category)
                        .queryString("roomname",roomname)
                        .field("photo", obj_file)
                        .asString();
                if(httpResponse.getStatus()==200)
                {
                    String res=httpResponse.getBody();
                    JOptionPane.showMessageDialog(rootPane, res);
                    dispose();
                }
            }
            catch(UnirestException ex)
            {
                Logger.getLogger(Admin_Add_Rooms.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void back_to_adminhomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_to_adminhomeActionPerformed
        // TODO add your handling code here:
        Admin_Home obj=new Admin_Home(username);
        dispose();
    }//GEN-LAST:event_back_to_adminhomeActionPerformed

    
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
            java.util.logging.Logger.getLogger(Admin_Add_Rooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Add_Rooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Add_Rooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Add_Rooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Admin_Add_Rooms().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_to_adminhome;
    private javax.swing.JButton bt_browse;
    private javax.swing.JComboBox<String> cb_category;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel j_photo;
    private javax.swing.JTextField j_room;
    // End of variables declaration//GEN-END:variables
}
