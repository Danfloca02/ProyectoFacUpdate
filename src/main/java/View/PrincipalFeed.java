/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import Controller.Publications.PublicationController;
import Controller.ViewController;
import Controller.session.SesionController;
import Data.DatabaseUsers;
import Model.Publication;
import Model.User;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.util.List;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
/**
 *
 * @author USER
 */
public class PrincipalFeed extends javax.swing.JFrame {
    private static PrincipalFeed instance;
    private Publication actualView;
    private List<Publication> actualFeed;
    private SesionController SC;
    private PublicationController PC;
    private comentView commentsScreen;
    private JButton deletePublicationButton;
    /**
     * Creates new form PrincipalFeed
     */
    private PrincipalFeed() {
        initComponents();
        PC = PublicationController.GetInstance();
        SC = SesionController.GetInstance();
        initializeDeleteButton();
    }
    
    public static PrincipalFeed GetInstance(){
        if(instance == null)instance = new PrincipalFeed();
        return instance;
    }
    public void OpenFeed(){
        LoadPublications();
        SetPublication(0);
        UpdateActualView();
    }
    private void LoadPublications(){
        actualFeed = PC.getPublications();
    }
    private void SetPublication(int index){
        actualView = actualFeed.get(index);
    }
    private void NextPublication(){
        int index = actualFeed.indexOf(actualView);
        index = (index + 1) % actualFeed.size();
        actualView = actualFeed.get(index);
    }
    private void PrevPublication(){
        int index = actualFeed.indexOf(actualView);
        index = (index - 1 + actualFeed.size()) % actualFeed.size();
        actualView = actualFeed.get(index);
    }
    private void UpdateActualView(){
        if(actualView == null){
            return;
        }
        String name = SC.SearchUserByID(actualView.getAUTOR_ID()).userName;
        PublicationUsername.setText(name);
        DescriptionBox.setText(actualView.getText());
        updateLikeButton(actualView.getUsersWhoReacted().contains(SC.ActualSession.ID));
        ChangeImage(actualView.getImage_path());
        if(commentsScreen != null)commentsScreen.setPublication(actualView);
        if (SC.ActualSession.userName.equals("Moderador")){
            System.out.println("MODERADOR");
            InicioButton.setVisible(false);
            jButton2.setVisible(false);
            UserViewButton.setVisible(false);
            LikeButton.setVisible(false);
            CommentsButton.setVisible(false);
            deleteButton.setVisible(true);
        }
    
    }
    
    void ChangeImage(String path){
        try {
            File imageFile = new File(path);
            ImageIcon imageIcon = new ImageIcon(imageFile.getAbsolutePath());Image image = imageIcon.getImage();
            Image resizedImage = image.getScaledInstance(428, 279, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(resizedImage);
            
            IMAGE_VIEWER.setIcon(imageIcon);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
        private void initializeDeleteButton() {
        deleteButton.setVisible(false);
        deleteButton.addActionListener(e -> {
            PC.deletePublication(actualView);
            LoadPublications();
            SetPublication(0);
            UpdateActualView();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jButton9 = new javax.swing.JButton();
        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        InicioButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        UserViewButton = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        canvas1 = new java.awt.Canvas();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        IMAGE_VIEWER = new javax.swing.JLabel();
        PublicationUsername = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DescriptionBox = new javax.swing.JTextArea();
        CommentsButton = new javax.swing.JButton();
        LikeButton = new javax.swing.JButton();
        nextPublicationButton = new javax.swing.JButton();
        PrevPublicationButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        jButton3.setText("Calendario");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Usuario");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(0, 0, 0));
        jButton9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Configuracion");
        jButton9.setInheritsPopupMenu(true);
        jButton9.setPreferredSize(new java.awt.Dimension(108, 23));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 20)); // NOI18N
        jLabel1.setText("FacUpdate");

        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));

        InicioButton.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        InicioButton.setForeground(new java.awt.Color(51, 0, 204));
        InicioButton.setText("Inicio");
        InicioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InicioButtonActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jButton2.setText("Calendario");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        UserViewButton.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        UserViewButton.setText("Usuario");
        UserViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserViewButtonActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(0, 0, 0));
        jButton10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Salir");
        jButton10.setInheritsPopupMenu(true);
        jButton10.setPreferredSize(new java.awt.Dimension(108, 23));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(229, 229, 229));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(229, 229, 229));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        IMAGE_VIEWER.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(IMAGE_VIEWER, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(IMAGE_VIEWER, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
        );

        PublicationUsername.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
        PublicationUsername.setText("Usuario");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel6.setToolTipText("");

        DescriptionBox.setEditable(false);
        DescriptionBox.setBackground(new java.awt.Color(255, 255, 255));
        DescriptionBox.setColumns(20);
        DescriptionBox.setLineWrap(true);
        DescriptionBox.setRows(5);
        jScrollPane1.setViewportView(DescriptionBox);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 261, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 146, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
        );

        CommentsButton.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        CommentsButton.setForeground(new java.awt.Color(204, 51, 0));
        CommentsButton.setText("COMMENTS");
        CommentsButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 0), 3, true));
        CommentsButton.setInheritsPopupMenu(true);
        CommentsButton.setPreferredSize(new java.awt.Dimension(108, 23));
        CommentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CommentsButtonActionPerformed(evt);
            }
        });

        LikeButton.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        LikeButton.setForeground(new java.awt.Color(204, 0, 0));
        LikeButton.setText("LIKE");
        LikeButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 0), 3, true));
        LikeButton.setInheritsPopupMenu(true);
        LikeButton.setPreferredSize(new java.awt.Dimension(108, 23));
        LikeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LikeButtonActionPerformed(evt);
            }
        });

        nextPublicationButton.setBackground(new java.awt.Color(204, 204, 204));
        nextPublicationButton.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        nextPublicationButton.setText(">");
        nextPublicationButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        nextPublicationButton.setInheritsPopupMenu(true);
        nextPublicationButton.setPreferredSize(new java.awt.Dimension(108, 23));
        nextPublicationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextPublicationButtonActionPerformed(evt);
            }
        });

        PrevPublicationButton.setBackground(new java.awt.Color(204, 204, 204));
        PrevPublicationButton.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        PrevPublicationButton.setText("<");
        PrevPublicationButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        PrevPublicationButton.setInheritsPopupMenu(true);
        PrevPublicationButton.setPreferredSize(new java.awt.Dimension(108, 23));
        PrevPublicationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrevPublicationButtonActionPerformed(evt);
            }
        });

        deleteButton.setForeground(new java.awt.Color(204, 0, 51));
        deleteButton.setText("Borrar Publicación");
        deleteButton.setToolTipText("deleteButton");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(InicioButton)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(UserViewButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(PublicationUsername))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addComponent(PrevPublicationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(19, 19, 19)))
                                                .addComponent(nextPublicationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                            .addComponent(deleteButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(LikeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(CommentsButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGap(0, 0, Short.MAX_VALUE))))))))
                            .addComponent(jSeparator1))
                        .addGap(22, 22, 22))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InicioButton)
                    .addComponent(jButton2)
                    .addComponent(UserViewButton))
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PublicationUsername))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CommentsButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LikeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addGap(42, 42, 42)
                        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nextPublicationButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PrevPublicationButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        LikeButton.getAccessibleContext().setAccessibleName("LIKE");
        deleteButton.getAccessibleContext().setAccessibleName("deleteButton");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        SC.CloseSession();
        if(commentsScreen != null)commentsScreen.dispose();
        commentsScreen = null;
        ViewController.GetInstance().PrincipalFeedToLogin();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void UserViewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserViewButtonActionPerformed
        if(commentsScreen != null)commentsScreen.dispose();
        commentsScreen = null;
        ViewController.GetInstance().FeedToUser();
    }//GEN-LAST:event_UserViewButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void InicioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicioButtonActionPerformed
        LoadPublications();
        
        if(commentsScreen != null)commentsScreen.dispose();
        commentsScreen = null;
        SetPublication(0);
    }//GEN-LAST:event_InicioButtonActionPerformed

    private void CommentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CommentsButtonActionPerformed
        if(commentsScreen == null){
            commentsScreen = ViewController.GetInstance().OpenCommentsView(actualView);
        }
        commentsScreen.setVisible(true);
    }//GEN-LAST:event_CommentsButtonActionPerformed

    private void LikeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LikeButtonActionPerformed
        boolean isLiked = actualView.getUsersWhoReacted().contains(SC.ActualSession.ID);
        if(isLiked){
            PC.DeleteLike(actualView.getPUBLICATION_ID(), SC.ActualSession.ID);
        }
        else{
            PC.AddLike(actualView.getPUBLICATION_ID(), SC.ActualSession.ID);       
        }
        updateLikeButton(!isLiked);
        int ind = actualFeed.indexOf(actualView);
        LoadPublications();
        SetPublication(ind);
        
        
        
    }//GEN-LAST:event_LikeButtonActionPerformed
    private void updateLikeButton(boolean isLiked){
        if(isLiked){
            LikeButton.setBorder(new LineBorder(Color.RED, 3));
            LikeButton.setBackground(Color.RED);
            LikeButton.setForeground(Color.WHITE);
            LikeButton.setText("DISLIKE");
        }
        else{
            LikeButton.setBorder(new LineBorder(Color.RED, 3));
            LikeButton.setBackground(Color.WHITE);
            LikeButton.setForeground(Color.RED);
            LikeButton.setText("LIKE");
        }
    }
    private void nextPublicationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextPublicationButtonActionPerformed
        NextPublication();
        UpdateActualView();
    }//GEN-LAST:event_nextPublicationButtonActionPerformed

    private void PrevPublicationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrevPublicationButtonActionPerformed
        PrevPublication();
        UpdateActualView();
    }//GEN-LAST:event_PrevPublicationButtonActionPerformed

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
            java.util.logging.Logger.getLogger(PrincipalFeed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalFeed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalFeed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalFeed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalFeed().setVisible(true);
            }
        });
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CommentsButton;
    private javax.swing.JTextArea DescriptionBox;
    private javax.swing.JLabel IMAGE_VIEWER;
    private javax.swing.JButton InicioButton;
    private javax.swing.JButton LikeButton;
    private javax.swing.JButton PrevPublicationButton;
    private javax.swing.JLabel PublicationUsername;
    private javax.swing.JButton UserViewButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private java.awt.Canvas canvas1;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton9;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.MenuBar menuBar1;
    private javax.swing.JButton nextPublicationButton;
    // End of variables declaration//GEN-END:variables
}
