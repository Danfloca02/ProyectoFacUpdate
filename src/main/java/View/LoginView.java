/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.ViewController;
import Controller.session.SesionController;

/**
 *
 * @author Josue Guedez
 */
public class LoginView extends javax.swing.JFrame {
    private static LoginView instance;
    private SesionController SC;
    
    /**
     * Creates new form LoginView
     */
    public LoginView() {
        initComponents();
        SC = SesionController.GetInstance();
        
    }
    public static LoginView GetInstance(){
        if(instance == null){
            instance = new LoginView();
        }
        return instance;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        DataUser = new javax.swing.JTextField();
        PasswordUsser = new javax.swing.JTextField();
        EnterButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("¿No tienes una cuenta?");

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Registrate");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 30)); // NOI18N
        jLabel1.setText("    FacUpdate");

        DataUser.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        DataUser.setForeground(new java.awt.Color(153, 153, 153));
        DataUser.setText("Cédula, Usuario o Correo electrónico");
        DataUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        DataUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                DataUserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                DataUserFocusLost(evt);
            }
        });
        DataUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataUserActionPerformed(evt);
            }
        });

        PasswordUsser.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        PasswordUsser.setForeground(new java.awt.Color(153, 153, 153));
        PasswordUsser.setText("contraseña");
        PasswordUsser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        PasswordUsser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PasswordUsserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PasswordUsserFocusLost(evt);
            }
        });
        PasswordUsser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordUsserActionPerformed(evt);
            }
        });

        EnterButton.setBackground(new java.awt.Color(0, 0, 0));
        EnterButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        EnterButton.setForeground(new java.awt.Color(255, 255, 255));
        EnterButton.setText("Entrar");
        EnterButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(153, 153, 153), null, null));
        EnterButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EnterButtonMouseClicked(evt);
            }
        });
        EnterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DataUser)
                    .addComponent(PasswordUsser, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addComponent(EnterButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DataUser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PasswordUsser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(EnterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(206, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(207, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
            
    private void DataUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataUserActionPerformed
        
    }//GEN-LAST:event_DataUserActionPerformed

    private void PasswordUsserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordUsserActionPerformed
        
    }//GEN-LAST:event_PasswordUsserActionPerformed

    private void EnterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnterButtonActionPerformed
        if(SC.login(DataUser.getText(), PasswordUsser.getText())){
            System.out.println("HAZ ACCEDIDO");
            ViewController.GetInstance().LoginToPrincipalFeed();
        }
        else{
            System.out.println("ERROR, LA CUENTA NO EXISTE O LOS DATOS SON INCORRECTOS");
        }
    }//GEN-LAST:event_EnterButtonActionPerformed

    private void EnterButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EnterButtonMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_EnterButtonMouseClicked
    
    private void ClearFields(){
        DataUser.setText("Cedula, Usuario o correo electronico");
        PasswordUsser.setText("contraseña");
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ClearFields();
        ViewController.GetInstance().LoginToRegister();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void PasswordUsserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PasswordUsserFocusLost
        if(PasswordUsser.getText().equals(""))PasswordUsser.setText("Contraseña");
    }//GEN-LAST:event_PasswordUsserFocusLost

    private void PasswordUsserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PasswordUsserFocusGained
        PasswordUsser.setText("");
    }//GEN-LAST:event_PasswordUsserFocusGained

    private void DataUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DataUserFocusLost
        if(DataUser.getText().equals(""))DataUser.setText("Cédula, Usuario o Correo electrónico");
    }//GEN-LAST:event_DataUserFocusLost

    private void DataUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DataUserFocusGained
        DataUser.setText("");
    }//GEN-LAST:event_DataUserFocusGained

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DataUser;
    private javax.swing.JButton EnterButton;
    private javax.swing.JTextField PasswordUsser;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
