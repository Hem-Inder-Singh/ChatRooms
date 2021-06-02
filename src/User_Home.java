
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class User_Home extends javax.swing.JFrame {

    int x=10,y=20;
    int width;
    int height;
    String username;
    public User_Home(String username) {
        initComponents();
        setVisible(true);
        getContentPane().setBackground(new Color(153,255,204));
        
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        width=d.width;
        height=d.height;
        setSize(width,height);
        this.username=username;
        j_welcome_user.setText("Welcome "+username);
        
        jPanel1.setBounds(5,5,width,200);
        jScrollPanecategory.setBounds(10, 210, width-200, height-200);
        main_panel.setPreferredSize(new Dimension(width,height));
        
        get_allcategory();
        
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        j_change_pass = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        j_welcome_user = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPanecategory = new javax.swing.JScrollPane();
        main_panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));
        jPanel1.setLayout(null);

        j_change_pass.setText("Change Password");
        j_change_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j_change_passActionPerformed(evt);
            }
        });
        jPanel1.add(j_change_pass);
        j_change_pass.setBounds(700, 60, 150, 40);

        jButton2.setText("Logout");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(980, 60, 120, 40);

        j_welcome_user.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jPanel1.add(j_welcome_user);
        j_welcome_user.setBounds(50, 40, 430, 70);

        jButton1.setText("MyRooms");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(860, 60, 110, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1220, 110);

        jScrollPanecategory.setPreferredSize(new java.awt.Dimension(10000, 10020));

        main_panel.setBackground(new java.awt.Color(255, 204, 255));
        main_panel.setPreferredSize(new java.awt.Dimension(1000, 1000));
        main_panel.setLayout(null);
        jScrollPanecategory.setViewportView(main_panel);

        getContentPane().add(jScrollPanecategory);
        jScrollPanecategory.setBounds(10, 170, 620, 340);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void j_change_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j_change_passActionPerformed
    
        User_Change_Password obj=new User_Change_Password(username);
        dispose();
        
    }//GEN-LAST:event_j_change_passActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        User_Login obj=new User_Login();
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        User_Follow_Rooms obj=new User_Follow_Rooms(username);
        dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(User_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              //  new User_Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPanecategory;
    private javax.swing.JButton j_change_pass;
    private javax.swing.JLabel j_welcome_user;
    private javax.swing.JPanel main_panel;
    // End of variables declaration//GEN-END:variables

    public void get_allcategory() {
        category_panel cp[] = new category_panel[GlobalClass.category.length];

        for (int i = 0; i < GlobalClass.category.length; i++) {

            cp[i] = new category_panel();

            cp[i].setBounds(x, y, width, 330);
            y = y + 340;

            cp[i].j_text.setText(GlobalClass.category[i]);

            cp[i].j_cat_panel.setPreferredSize(new Dimension(width * 2, 300));
            cp[i].jScrollPanecategory.setBounds(50, 80, width, 250);

            try {
                // UNirest Req
                HttpResponse<String> httpResponse = Unirest.get(GlobalClass.ip + "fetch_rooms_cat")
                        .queryString("category", GlobalClass.category[i])
                        .asString();
                if (httpResponse.getStatus() == 200) {
                    String res = httpResponse.getBody();
                    StringTokenizer st = new StringTokenizer(res, "~~");
                    int j = 0, m = 10, n = 10;
                    Rooms_Panel rp[] = new Rooms_Panel[st.countTokens()];

                    while (st.hasMoreTokens()) {
                        String res2 = st.nextToken();
                        StringTokenizer st2 = new StringTokenizer(res2, "$$");
//                         while(st2.hasMoreTokens()){
                        rp[j] = new Rooms_Panel();
                        int rid = Integer.parseInt(st2.nextToken());
                        String roomname = st2.nextToken();
                        String photo = st2.nextToken();
                        String cat = st2.nextToken();
                        ImageIcon icon = new ImageIcon("");
                        BufferedImage bufferedImage = null, newimage;

                        try {
                            URL url = new URL(GlobalClass.ip + "GetResource/" + photo);
                            System.out.println("url : " + url);
                            bufferedImage = ImageIO.read(url);
                        } catch (Exception ex) {
                            Logger.getLogger(User_Home.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        newimage = resizephoto(bufferedImage, rp[j].jroom_img.getWidth(), rp[j].jroom_img.getHeight());
                        icon = new ImageIcon(newimage);
                        
                       System.out.println("" + roomname);
                        
                        rp[j].setBounds(m, n, 250,250);
//                        rp[j].jroom_img.setText(photo);
                        rp[j].jroom_text.setText(roomname);
                        rp[j].jroom_img.setIcon(icon);

                        m = m + 260;

                        rp[j].addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
//                                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                                if (e.getClickCount() == 1) {
                                    
                                    //JOptionPane.showMessageDialog(rootPane, "Hello " + roomname);
                                    Group_Chat obj=new Group_Chat(rid,username);
                                    dispose();
                                }

                            }

                        });
                        cp[i].j_cat_panel.add(rp[j]);
                        repaint();

//                         }
                        j++;
                    }
                }

            } catch (UnirestException ex) {
                Logger.getLogger(User_Home.class.getName()).log(Level.SEVERE, null, ex);
            }

            main_panel.add(cp[i]);
            repaint();
            main_panel.repaint();
        }
    }

    BufferedImage resizephoto(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }

}


