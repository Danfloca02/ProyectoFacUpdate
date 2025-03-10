package View;

import Controller.ViewController;
import Controller.StringValidator;
import Controller.session.SesionController;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Josue Guedez
 */
public class RegisterView extends javax.swing.JFrame {
    private static RegisterView instance;
    private SesionController SC;
    
    
    /**
     * Creates new form RegisterView
     */
    private RegisterView() {
        initComponents();
        SC = SesionController.GetInstance();
    }
    
    public static RegisterView GetInstance(){
        if(instance == null)instance = new RegisterView();
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        EmailUser = new javax.swing.JTextField();
        RegisterButton = new javax.swing.JButton();
        PasswordUser = new javax.swing.JTextField();
        IDUser = new javax.swing.JTextField();
        UsernameUser = new javax.swing.JTextField();
        AccountTypeUser = new javax.swing.JSpinner();
        CarreeData = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 2));

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 35)); // NOI18N
        jLabel1.setText("FacUpdate");

        EmailUser.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        EmailUser.setForeground(new java.awt.Color(153, 153, 153));
        EmailUser.setText("  Correo electrónico");
        EmailUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        EmailUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                EmailUserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                EmailUserFocusLost(evt);
            }
        });
        EmailUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailUserActionPerformed(evt);
            }
        });

        RegisterButton.setBackground(new java.awt.Color(0, 0, 0));
        RegisterButton.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        RegisterButton.setForeground(new java.awt.Color(255, 255, 255));
        RegisterButton.setText("Registrarse");
        RegisterButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(153, 153, 153), null, null));
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
            }
        });

        PasswordUser.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        PasswordUser.setForeground(new java.awt.Color(153, 153, 153));
        PasswordUser.setText("  Contraseña");
        PasswordUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        PasswordUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PasswordUserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PasswordUserFocusLost(evt);
            }
        });
        PasswordUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordUserActionPerformed(evt);
            }
        });

        IDUser.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        IDUser.setForeground(new java.awt.Color(153, 153, 153));
        IDUser.setText("  Cédula");
        IDUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        IDUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                IDUserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                IDUserFocusLost(evt);
            }
        });
        IDUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDUserActionPerformed(evt);
            }
        });

        UsernameUser.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        UsernameUser.setForeground(new java.awt.Color(153, 153, 153));
        UsernameUser.setText("  Nombre de usuario");
        UsernameUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        UsernameUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UsernameUserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                UsernameUserFocusLost(evt);
            }
        });
        UsernameUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameUserActionPerformed(evt);
            }
        });

        AccountTypeUser.setModel(new javax.swing.SpinnerListModel(new String[] {"Estudiante", "Profesor"}));
        AccountTypeUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        AccountTypeUser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AccountTypeUser.setFocusable(false);
        AccountTypeUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                AccountTypeUserFocusGained(evt);
            }
        });

        CarreeData.setModel(new javax.swing.SpinnerListModel(new String[] {"Computacion", "Fisica", "Quimica", "Matematica", "Biologia", "Geoquimica"}));
        CarreeData.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EmailUser)
                    .addComponent(RegisterButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PasswordUser)
                    .addComponent(IDUser)
                    .addComponent(UsernameUser)
                    .addComponent(CarreeData)
                    .addComponent(AccountTypeUser))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AccountTypeUser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CarreeData, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(EmailUser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordUser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IDUser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UsernameUser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RegisterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 2));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("¿Ya tienes una cuenta?");

        jButton2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jButton2.setText("Entrar");
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
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(47, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(206, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(206, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EmailUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailUserActionPerformed
      
    }//GEN-LAST:event_EmailUserActionPerformed

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterButtonActionPerformed
        String AccountType;
        if(AccountTypeUser.getValue().equals("Estudiante")){
            AccountType = "STUDENT";
        }
        else{
            AccountType = "TEACHER";
        }
        System.out.println(AccountType);
        String Email = EmailUser.getText();
        String Password = PasswordUser.getText();
        String ID = IDUser.getText();
        String Username = UsernameUser.getText();
        String caree = ((String) CarreeData.getValue()).toUpperCase();
        
        if (!StringValidator.validateEmail(Email)){
        JOptionPane.showMessageDialog(this, "El correo no cumple el formato example1@gmail.com", 
        "Error de Registro", JOptionPane.ERROR_MESSAGE);
        }
        else if (!StringValidator.validateUsername(Username)){
        JOptionPane.showMessageDialog(this, "El nombre de usuario debe contener entre 3-20 caractéres", 
        "Error de Registro", JOptionPane.ERROR_MESSAGE);
        }
        else if (!StringValidator.validatePassword(Password)){
        JOptionPane.showMessageDialog(this, "La Contraseña debe contener entre 3-20 caracteres, contener al menos un número y una letra mayúscula", 
        "Error de Registro", JOptionPane.ERROR_MESSAGE);
        }
        else if (!StringValidator.validateIDcard(ID)){
        JOptionPane.showMessageDialog(this, "El ID debe contener entre 1-8 digitos y comenzar por un valor mayor a 0", 
        "Error de Registro", JOptionPane.ERROR_MESSAGE);
        }
        
        else if(SC.register(AccountType, Email, Password, ID, Username, caree)){
            System.out.println("TE REGISTRASTE CON USUARIO: " + Username + "Y CONTRASEÑA: " + Password);
            ClearFields();
            ViewController.GetInstance().RegisterToLogin();
        }
        else {
            JOptionPane.showMessageDialog(this, "El usuario ya existe", 
        "Error de Registro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_RegisterButtonActionPerformed

    private void PasswordUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordUserActionPerformed

    private void IDUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDUserActionPerformed

    private void UsernameUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameUserActionPerformed

    private void AccountTypeUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AccountTypeUserFocusGained
        
    }//GEN-LAST:event_AccountTypeUserFocusGained

    private void EmailUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmailUserFocusGained
        EmailUser.setText("");
    }//GEN-LAST:event_EmailUserFocusGained

    private void EmailUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmailUserFocusLost
        if(EmailUser.getText().equals(""))EmailUser.setText("Correo electrónico");
    }//GEN-LAST:event_EmailUserFocusLost

    private void PasswordUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PasswordUserFocusGained
        PasswordUser.setText("");
    }//GEN-LAST:event_PasswordUserFocusGained

    private void PasswordUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PasswordUserFocusLost
        if(PasswordUser.getText().equals(""))PasswordUser.setText("Contraseña");
    }//GEN-LAST:event_PasswordUserFocusLost

    private void IDUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IDUserFocusGained
        IDUser.setText("");
    }//GEN-LAST:event_IDUserFocusGained

    private void IDUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IDUserFocusLost
        if(IDUser.getText().equals(""))IDUser.setText("Cédula");
    }//GEN-LAST:event_IDUserFocusLost

    private void UsernameUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UsernameUserFocusGained
        UsernameUser.setText("");
    }//GEN-LAST:event_UsernameUserFocusGained

    private void UsernameUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UsernameUserFocusLost
        if(UsernameUser.getText().equals(""))UsernameUser.setText("Nombre de Usuario");
    }//GEN-LAST:event_UsernameUserFocusLost
    private void ClearFields(){
        UsernameUser.setText("Nombre de Usuario");
        IDUser.setText("Cédula");
        PasswordUser.setText("Contraseña");
        EmailUser.setText("Correo electrónico");
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ClearFields();
        ViewController.GetInstance().RegisterToLogin();
    }//GEN-LAST:event_jButton2ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner AccountTypeUser;
    private javax.swing.JSpinner CarreeData;
    private javax.swing.JTextField EmailUser;
    private javax.swing.JTextField IDUser;
    private javax.swing.JTextField PasswordUser;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JTextField UsernameUser;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
