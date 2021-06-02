
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class Group_Chat extends javax.swing.JFrame {

    /**
     * Creates new form Group_Chat
     */
    int width,height,rid;
    String username;
    String smiley[] = {"src/emojis/sm1.jpeg", "src/emojis/sm2.jpeg", "src/emojis/sm3.jpeg", "src/emojis/sm4.jpeg", "src/emojis/sm5.jpeg", "src/emojis/sm6.jpeg",
        "src/emojis/sm7.jpeg", "src/emojis/sm8.jpeg", "src/emojis/sm9.jpeg", "src/emojis/sm10.jpeg","src/emojis/sm11.png"};
    String symbols[] = {":D", "N(", "::@", ":'-)", "B-)", "**", ":(", ":)",":}",":/",":^)"};
    JFileChooser jfc = new JFileChooser();
    File obj_file;
    
    public Group_Chat(int rid,String username) {
        initComponents();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        width=d.width;
        height=d.height;
        setSize(width,height);
        setVisible(true);
        
        this.username=username;
        System.out.println(""+this.username+"...."+username);
        this.rid = rid;
        getContentPane().setBackground(new Color(153, 255, 204));

        make_visible_false();
        checkroomjoin();
        fetch_room_members();
        fetch_room_details();
        loadsmileys();
        
        new Thread(new MyClass()).start();
        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                new Thread(new MyClass()).start();
            }
        }, 5000, 5000);

        jEditorPane1.addHyperlinkListener(new HyperlinkListener() {
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    System.out.println("File url from hyperlink" + e.getURL());
                    
                    String u = e.getURL().toString();
                    String path = u.substring(u.indexOf("/") + 2);
                    String fname = path.substring(path.lastIndexOf("/") + 1);

                    System.out.println("" + fname);
                    try {

                        HttpResponse<InputStream> httpResponse = Unirest.get(GlobalClass.ip + "GetResource/" + path).asBinary();
                        if (httpResponse.getStatus() == 200) {
                            InputStream is = httpResponse.getBody();
                            long fiesize = Integer.parseInt(httpResponse.getHeaders().getFirst("Content-Length"));
                            FileOutputStream fos = new FileOutputStream("D:\\Docs\\" + fname);
                            long count = 0;
                            int r = 0;
                            byte b[] = new byte[100000];
                            while (true) {
                                r = is.read(b, 0, b.length);
                                fos.write(b, 0, r);
                                count = count + r;
                                if (count == fiesize) {
                                    System.out.println("File Downloaded.");
                                    break;
                                }
                            }

                            fos.close();
                            int ans = JOptionPane.showConfirmDialog(rootPane, "Do you want to open this file ?","Open File?",JOptionPane.YES_NO_OPTION);
                            if(ans == JOptionPane.YES_OPTION){
                                Desktop d = Desktop.getDesktop();
                                d.open(new File("D:\\Docs\\" + fname));
                            }

                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }

            }
        });

    }


    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        j_roomimg = new javax.swing.JLabel();
        j_roomname = new javax.swing.JLabel();
        j_join = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        j_send_text = new javax.swing.JTextField();
        j_send_msg = new javax.swing.JButton();
        j_send_img = new javax.swing.JButton();
        jfiles = new javax.swing.JButton();
        j_smiley_panel = new javax.swing.JPanel();
        back_to_home = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        j_group_members = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        j_roomimg.setText("jLabel1");
        j_roomimg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(j_roomimg);
        j_roomimg.setBounds(30, 41, 210, 170);

        j_roomname.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        getContentPane().add(j_roomname);
        j_roomname.setBounds(40, 250, 230, 70);

        j_join.setBackground(new java.awt.Color(51, 255, 0));
        j_join.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        j_join.setText("Join");
        j_join.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j_joinActionPerformed(evt);
            }
        });
        getContentPane().add(j_join);
        j_join.setBounds(280, 90, 120, 60);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(1080, 2400));
        jScrollPane1.setViewportView(jEditorPane1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(520, 30, 1020, 490);
        getContentPane().add(j_send_text);
        j_send_text.setBounds(520, 540, 700, 80);

        j_send_msg.setText("Send");
        j_send_msg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j_send_msgActionPerformed(evt);
            }
        });
        getContentPane().add(j_send_msg);
        j_send_msg.setBounds(1230, 540, 100, 80);

        j_send_img.setText("Images");
        j_send_img.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j_send_imgActionPerformed(evt);
            }
        });
        getContentPane().add(j_send_img);
        j_send_img.setBounds(1350, 540, 100, 80);

        jfiles.setText("Files");
        jfiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jfilesActionPerformed(evt);
            }
        });
        getContentPane().add(jfiles);
        jfiles.setBounds(1470, 540, 80, 80);

        j_smiley_panel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout j_smiley_panelLayout = new javax.swing.GroupLayout(j_smiley_panel);
        j_smiley_panel.setLayout(j_smiley_panelLayout);
        j_smiley_panelLayout.setHorizontalGroup(
            j_smiley_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1030, Short.MAX_VALUE)
        );
        j_smiley_panelLayout.setVerticalGroup(
            j_smiley_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        getContentPane().add(j_smiley_panel);
        j_smiley_panel.setBounds(520, 640, 1030, 60);

        back_to_home.setBackground(new java.awt.Color(51, 102, 255));
        back_to_home.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        back_to_home.setText("Back");
        back_to_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_to_homeActionPerformed(evt);
            }
        });
        getContentPane().add(back_to_home);
        back_to_home.setBounds(280, 170, 120, 60);

        j_group_members.setEditable(false);
        j_group_members.setColumns(20);
        j_group_members.setRows(5);
        jScrollPane2.setViewportView(j_group_members);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(30, 340, 300, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void j_joinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j_joinActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            HttpResponse<String> httpResponse = Unirest.get(GlobalClass.ip + "join_room")
                    .queryString("username", username)
                    .queryString("rid", rid)
                    .asString();
            if (httpResponse.getStatus() == 200) {
                String res = httpResponse.getBody();
                System.out.println("" + res);
                if (res.equals("success")) {
                    j_join.setText("Joined");
                    j_join.setEnabled(false);
                    make_visible();
                } else {
                    make_visible_false();
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(Group_Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_j_joinActionPerformed

    private void j_send_msgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j_send_msgActionPerformed
        // TODO add your handling code here:
        try {
            String message = j_send_text.getText().toString();
            if (message.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Write something first.");
            } else {
                HttpResponse<String> httpResponse = Unirest.get(GlobalClass.ip + "save_text_msg")
                        .queryString("message", message)
                        .queryString("posted_by", username)
                        .queryString("rid", rid)
                        .queryString("type", "text")
                        .asString();
                if (httpResponse.getStatus() == 200) {
                    JOptionPane.showMessageDialog(rootPane, httpResponse.getBody());
                    j_send_text.setText("");

                }
            }
            
        } catch (UnirestException ex) {
            Logger.getLogger(Group_Chat.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_j_send_msgActionPerformed

    private void j_send_imgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j_send_imgActionPerformed
        // TODO add your handling code here:
        int ans = jfc.showOpenDialog(this);
        if(ans == JFileChooser.APPROVE_OPTION){
             try {
                 obj_file = jfc.getSelectedFile();
                 HttpResponse<String> httpResponse = Unirest.post(GlobalClass.ip + "save_img_msg")
                         
                         .queryString("posted_by", username)
                         .queryString("rid", rid)
                         .queryString("type", "image")
                         .field("img", obj_file)
                         .asString();
                 if (httpResponse.getStatus() == 200) {
                     JOptionPane.showMessageDialog(rootPane, httpResponse.getBody());
                     
                 }
             } catch (UnirestException ex) {
                 Logger.getLogger(Group_Chat.class.getName()).log(Level.SEVERE, null, ex);
             }
            
        }
        
    }//GEN-LAST:event_j_send_imgActionPerformed

    private void jfilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jfilesActionPerformed
        // TODO add your handling code here:
          int ans = jfc.showOpenDialog(this);
        if(ans == JFileChooser.APPROVE_OPTION){
             try {
                 obj_file = jfc.getSelectedFile();
                 HttpResponse<String> httpResponse = Unirest.post(GlobalClass.ip + "save_img_msg")
                         
                         .queryString("posted_by", username)
                         .queryString("rid", rid)
                         .queryString("type", "file")
                         .field("img", obj_file)
                         .asString();
                 if (httpResponse.getStatus() == 200) {
                     JOptionPane.showMessageDialog(rootPane, httpResponse.getBody());
                     
                 }
             } catch (UnirestException ex) {
                 Logger.getLogger(Group_Chat.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
    
       
    }//GEN-LAST:event_jfilesActionPerformed

    private void back_to_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_to_homeActionPerformed
        
        User_Home obj=new User_Home(username);
        dispose();
    }//GEN-LAST:event_back_to_homeActionPerformed

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
            java.util.logging.Logger.getLogger(Group_Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Group_Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Group_Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Group_Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new Group_Chat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_to_home;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea j_group_members;
    private javax.swing.JButton j_join;
    private javax.swing.JLabel j_roomimg;
    private javax.swing.JLabel j_roomname;
    private javax.swing.JButton j_send_img;
    private javax.swing.JButton j_send_msg;
    private javax.swing.JTextField j_send_text;
    private javax.swing.JPanel j_smiley_panel;
    private javax.swing.JButton jfiles;
    // End of variables declaration//GEN-END:variables
public void checkroomjoin() {
        new Thread(new Runnable() {
            @Override
            public void run() {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

                HttpResponse<String> httpResponse;
                try {
                    httpResponse = Unirest.get(GlobalClass.ip + "check_room")
                            .queryString("username", username)
                            .queryString("rid", rid)
                            .asString();
                    if (httpResponse.getStatus() == 200) {
                        String res = httpResponse.getBody();
//                        System.out.println("" + res);
                        if (res.equals("exists")) {
                            j_join.setText("Joined");
                            j_join.setEnabled(false);
                            make_visible();
                        } else {
                            make_visible_false();
                        }
                    }
                } catch (UnirestException ex) {
                    Logger.getLogger(Group_Chat.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }).start();
    }

    public void fetch_room_members() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    
                    HttpResponse<String> httpResponse = Unirest.get(GlobalClass.ip + "fetch_room_members")
                            .queryString("rid", rid)
                            .asString();
                    if (httpResponse.getStatus() == 200) {
                        String res = httpResponse.getBody();
                        String name = "";
                        StringTokenizer st = new StringTokenizer(res, "~~");
                        while (st.hasMoreTokens()) {
                            String user_name = st.nextToken();
                            name += user_name + "\n";

                        }
                        j_group_members.setText(name);

                    }

                } catch (UnirestException ex) {
                    Logger.getLogger(Group_Chat.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }).start();
    }

    public void fetch_room_details() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

                    HttpResponse<String> httpResponse = Unirest.get(GlobalClass.ip + "fetch_room_details")
                            .queryString("rid", rid)
                            .asString();
                    if (httpResponse.getStatus() == 200) {
                        String res = httpResponse.getBody();
                        StringTokenizer st = new StringTokenizer(res, "~~");
                        while (st.hasMoreTokens()) {
                            String roomname = st.nextToken();
                            String pic = st.nextToken();
                            ImageIcon icon = new ImageIcon("");
                            BufferedImage bufferedImage = null, newimage;

                            try {
                                URL url = new URL(GlobalClass.ip + "GetResource/" + pic);
                                System.out.println("url3 : " + url);
                                bufferedImage = ImageIO.read(url);
                            } catch (Exception ex) {
                                Logger.getLogger(Group_Chat.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            newimage = resizephoto(bufferedImage, j_roomimg.getWidth(), j_roomimg.getHeight());
                            icon = new ImageIcon(newimage);
                            j_roomimg.setIcon(icon);
                            j_roomname.setText(roomname);

                        }
                    }

                } catch (UnirestException ex) {
                    Logger.getLogger(Group_Chat.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }).start();
    }

    public void make_visible() {
        jScrollPane1.setVisible(true);
        jEditorPane1.setVisible(true);
        j_send_text.setVisible(true);
        j_send_msg.setVisible(true);
        j_send_img.setVisible(true);
        jfiles.setVisible(true);
        j_smiley_panel.setVisible(true);
    }

    public void make_visible_false() {
        jScrollPane1.setVisible(false);
        jEditorPane1.setVisible(false);
        j_send_text.setVisible(false);
        j_send_msg.setVisible(false);
        j_send_img.setVisible(false);
        jfiles.setVisible(false);
        j_smiley_panel.setVisible(false);
    }

    void loadsmileys() {
        System.out.println("done");
        int x = 5, y = 5;
        JLabel lb[] = new JLabel[smiley.length];
        for (int i = 0; i < smiley.length; i++) {
            lb[i] = new JLabel();
            lb[i].setBounds(x, y, 40, 40);
            ImageIcon icon = new ImageIcon(smiley[i]);
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(lb[i].getWidth(), lb[i].getHeight(), Image.SCALE_SMOOTH);
            lb[i].setIcon(new ImageIcon(newimg));
            final int newi = i;
            lb[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    try {
                        String msg = symbols[newi];
                        HttpResponse<String> httpResponse=Unirest.post(GlobalClass.ip+"save_emojis_msg")
                                .queryString("posted_by",username)
                                .queryString("rid",rid)
                                .queryString("type","emojis")
                                .field("message",msg)
                                .asString();
                        if(httpResponse.getStatus()==200)
                        {
                            JOptionPane.showMessageDialog(rootPane, httpResponse.getBody());
                        }
                    } catch (UnirestException ex) {
                        Logger.getLogger(Group_Chat.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            });
            j_smiley_panel.add(lb[i]);
            x = x + 50;

            repaint();
            j_smiley_panel.repaint();
            lb[i].repaint();
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
    
    public class MyClass implements Runnable{

        @Override
        public void run() {
            try {
                
                HttpResponse<String> httpResponse = Unirest.get(GlobalClass.ip+"fetch_mess")
                        .queryString("rid",rid)
                        .asString();
                if(httpResponse.getStatus() == 200){
                    String res = httpResponse.getBody();
                    StringTokenizer st = new StringTokenizer(res,"~~");
                    jEditorPane1.setContentType("text/html");
                    String message1="";
                    while(st.hasMoreTokens()){
                        String res2 = st.nextToken();
                        StringTokenizer st2 = new StringTokenizer(res2,"$$");
                        String mesid = st2.nextToken();
                        String message = st2.nextToken();
                        String postedby = st2.nextToken();
                        String datetime = st2.nextToken();
                        String type = st2.nextToken();
                        jEditorPane1.setEditable(false);
                        if(postedby.equals(username))
                        {
                            if(type.equals("text"))
                            {
                                message1 +="<div style= 'text-align : right; background-color:#4FFCE4'><h3>"+message+"</h3>";
                                message1 +="<p>"+postedby+"&nbsp;&nbsp;"+datetime+"</p></div><hr>";
                                
                            }
                            else if (type.equals("image")) {
                                message1 += "<div style = 'text-align : right; background-color: #4FFCE4'><img src = 'file:" + message + "' width='150' height='150' />";
                                message1 += "<p>" + postedby + "&nbsp;&nbsp; " + datetime + " </p></div><hr>";

                            } else if (type.equals("file")) {
                                message1 += "<div style = 'text-align : right; background-color: #4FFCE4'><a href = 'http://" + message + "'><img src = 'file:src/emojis/sm12.png' width='80' height='80' /></a>";
                                message1 += "<p>" + postedby + "&nbsp;&nbsp; " + datetime + " </p></div><hr>";
                            }
                            else if(type.equals("emojis"))
                            {
                              
                                for(int i=0;i<smiley.length;i++)
                                {
                                    if(message.equals(symbols[i]))
                                    {
                                        message1 +="<div style= 'text-align : right; background-color:#4FFCE4'><img src='file:"+smiley[i]+"'width='80' height='80' />";
                                        message1 +="<p>"+postedby+"&nbsp;&nbsp;"+datetime+"</p></div><hr>";
                                
                                    }
                                }
                            }
                        }
                        else
                        {
                         if(type.equals("text"))
                            {
                                message1 +="<div style= 'text-align : left; background-color:yellow'><h3>"+message+"</h3>";
                                message1 +="<p>"+postedby+"&nbsp;&nbsp;"+datetime+"</p></div><hr>";
                                
                            }
                            else if (type.equals("image")) {
                                message1 += "<div style = 'text-align : left; background-color: yellow'><img src = 'file:" + message + "' width='150' height='150' />";
                                message1 += "<p>" + postedby + "&nbsp;&nbsp; " + datetime + " </p></div><hr>";

                            } else if (type.equals("file")) {
                                message1 += "<div style = 'text-align : left; background-color: yellow'><a href = 'http://" + message + "'><img src = 'file:src/emojis/sm12.png' width='80' height='80' /></a>";
                                message1 += "<p>" + postedby + "&nbsp;&nbsp; " + datetime + " </p></div><hr>";
                            }
                            else if(type.equals("emojis"))
                            {
                              
                                for(int i=0;i<smiley.length;i++)
                                {
                                    if(message.equals(symbols[i]))
                                    {
                                        message1 +="<div style= 'text-align : left; background-color:yellow'><img src='file:"+smiley[i]+"'width='80' height='80' />";
                                        message1 +="<p>"+postedby+"&nbsp;&nbsp;"+datetime+"</p></div><hr>";
                                
                                    }
                                }
                            }
                        }
                        
                        jEditorPane1.setText(message1);
                        scrollToBottom(jScrollPane1);
                        
                        
                        
                    }
                }
                
                
            } catch (UnirestException ex) {
                Logger.getLogger(Group_Chat.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
    }
     private void scrollToBottom(JScrollPane scrollPane) {
        JScrollBar verticalBar = scrollPane.getVerticalScrollBar();
        AdjustmentListener downScroller = new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                Adjustable adjustable = e.getAdjustable();
                adjustable.setValue(adjustable.getMaximum());
                verticalBar.removeAdjustmentListener(this);
            }

        };
        verticalBar.addAdjustmentListener(downScroller);
    }





}
