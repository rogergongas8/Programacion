
import ficheros.ClassFichero;
import java.io.FileNotFoundException;
import java.text.ParseException;
import javax.swing.ImageIcon;
import model.exceptions.SpecificValidationException;
import model.exceptions.ValidationException;
import model.validations.UserDataValidations;


public class jFrameMain extends javax.swing.JFrame {

    public jFrameMain() {
        initComponents();
        initConfig();
    }

    private void initConfig() {
        ClassFichero.writeFile("nombre;nif;mail;fecha_nac;edad;cod_post\n");
        setLocationRelativeTo(null);
        setTitle("Validador de datos");
        ImageIcon icono = new ImageIcon("C:\\Users\\rogergongas\\Desktop\\M3Practica11RGG_COPY\\src\\media\\Form-1-removebg-preview.png");
        setIconImage(icono.getImage());
    }
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabelDNI = new javax.swing.JLabel();
        jTextFieldDNI = new javax.swing.JTextField();
        jButtonValidate = new javax.swing.JButton();
        jLabelErrorName = new javax.swing.JLabel();
        jLabelErrorDNI = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabelEmail = new javax.swing.JLabel();
        jTextFieldBirthdate = new javax.swing.JTextField();
        jLabelBirthdate = new javax.swing.JLabel();
        jLabelErrorEmail = new javax.swing.JLabel();
        jLabelErrorBirthdate = new javax.swing.JLabel();
        jTextFieldAge = new javax.swing.JTextField();
        jLabelBirthdate1 = new javax.swing.JLabel();
        jLabelErrorAge = new javax.swing.JLabel();
        jTextFieldCP = new javax.swing.JTextField();
        jLabelBirthdate2 = new javax.swing.JLabel();
        jLabelErrorCP = new javax.swing.JLabel();
        jButtonDelete = new javax.swing.JButton();
        jButtonCSV = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabelTitle.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTitle.setFont(new java.awt.Font("Gill Sans MT", 1, 36)); // NOI18N
        jLabelTitle.setText("Validador de datos");

        jLabelName.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabelName.setText("Name:");

        jTextFieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNameActionPerformed(evt);
            }
        });

        jLabelDNI.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabelDNI.setText("DNI:");

        jTextFieldDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDNIActionPerformed(evt);
            }
        });

        jButtonValidate.setText("Validate");
        jButtonValidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValidateActionPerformed(evt);
            }
        });

        jLabelErrorName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelErrorName.setForeground(new java.awt.Color(255, 0, 0));

        jLabelErrorDNI.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelErrorDNI.setForeground(new java.awt.Color(255, 0, 0));

        jTextFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEmailActionPerformed(evt);
            }
        });

        jLabelEmail.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabelEmail.setText("Email:");

        jTextFieldBirthdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBirthdateActionPerformed(evt);
            }
        });

        jLabelBirthdate.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabelBirthdate.setText("Birthdate:");

        jLabelErrorEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelErrorEmail.setForeground(new java.awt.Color(255, 51, 0));

        jLabelErrorBirthdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelErrorBirthdate.setForeground(new java.awt.Color(255, 51, 0));

        jTextFieldAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAgeActionPerformed(evt);
            }
        });

        jLabelBirthdate1.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabelBirthdate1.setText("Age:");

        jLabelErrorAge.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelErrorAge.setForeground(new java.awt.Color(255, 51, 0));

        jTextFieldCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCPActionPerformed(evt);
            }
        });

        jLabelBirthdate2.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabelBirthdate2.setText("CP:");

        jLabelErrorCP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelErrorCP.setForeground(new java.awt.Color(255, 0, 0));

        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonCSV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonCSV.setText("CSV");
        jButtonCSV.setEnabled(false);
        jButtonCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCSVActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/Form-1-removebg-preview.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelName)
                                    .addComponent(jLabelDNI)
                                    .addComponent(jLabelEmail)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelBirthdate, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabelBirthdate1))
                                    .addComponent(jLabelBirthdate2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldName)
                                    .addComponent(jTextFieldDNI)
                                    .addComponent(jTextFieldEmail)
                                    .addComponent(jTextFieldBirthdate)
                                    .addComponent(jTextFieldAge)
                                    .addComponent(jTextFieldCP, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonValidate)
                                .addGap(46, 46, 46)
                                .addComponent(jButtonDelete)
                                .addGap(35, 35, 35)
                                .addComponent(jButtonCSV)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelErrorBirthdate)
                            .addComponent(jLabelErrorAge)
                            .addComponent(jLabelErrorCP)
                            .addComponent(jLabelErrorDNI)
                            .addComponent(jLabelErrorEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(60, 60, 60)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelErrorName, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelErrorName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelName)
                                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelDNI)
                                    .addComponent(jTextFieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelEmail))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelBirthdate)
                                    .addComponent(jTextFieldBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelBirthdate1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelBirthdate2)
                                    .addComponent(jTextFieldCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelErrorDNI)
                                .addGap(12, 12, 12)
                                .addComponent(jLabelErrorEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelErrorBirthdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelErrorAge)
                                .addGap(37, 37, 37)
                                .addComponent(jLabelErrorCP)))
                        .addGap(95, 95, 95)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonDelete)
                            .addComponent(jButtonValidate)
                            .addComponent(jButtonCSV)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 943, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCPActionPerformed

    private void jTextFieldAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAgeActionPerformed

    private void jTextFieldBirthdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBirthdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBirthdateActionPerformed

    private void jTextFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEmailActionPerformed

    private void jButtonValidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValidateActionPerformed

        String name = jTextFieldName.getText();
        int validado = 0;
        try {
            UserDataValidations.checkName(name);
            jTextFieldName.setEnabled(false);
            jLabelErrorName.setText("");
            validado += 1;
        } catch (ValidationException e) {
            jLabelErrorName.setText(e.getMessage());
        }

        String DNI = jTextFieldDNI.getText();
        try {
            UserDataValidations.checkId(1, DNI);
            jTextFieldDNI.setEnabled(false);
            jLabelErrorDNI.setText("");
            validado += 1;
        } catch (SpecificValidationException e) {
            jLabelErrorDNI.setText("Error específico: " + e.getMessage());
        } catch (ValidationException e) {
            jLabelErrorDNI.setText("Error general: " + e.getMessage());
        }

        String Email = jTextFieldEmail.getText();
        try {
            UserDataValidations.checkEmail(Email);
            jTextFieldEmail.setEnabled(false);
            jLabelErrorEmail.setText("");
            validado += 1;
        } catch (ValidationException e) {
            jLabelErrorEmail.setText(e.getMessage());
        }

        String Birth = jTextFieldBirthdate.getText();
        try {
            UserDataValidations.checkFormatDate(Birth);
            jTextFieldBirthdate.setEnabled(false);
            jLabelErrorBirthdate.setText("");
            validado += 1;
        } catch (ValidationException e) {
            jLabelErrorBirthdate.setText(e.getMessage());
        }

        String Age = jTextFieldAge.getText();
        try {
            double calculatedAge = UserDataValidations.checkAge(Birth);
            int inputAge = Integer.parseInt(Age);
            if (Math.abs(calculatedAge - inputAge) > 1) {
                jLabelErrorAge.setText("La edad no coincide con la fecha de nacimiento");
            } else {
                jTextFieldAge.setEnabled(false);
                jLabelErrorAge.setText("");
                validado += 1;
            }
        } catch (ParseException | ValidationException | NumberFormatException e) {
            jLabelErrorAge.setText(e.getMessage());
        }

        String CP = jTextFieldCP.getText();
        try {
            UserDataValidations.checkPostalCode(CP);
            jTextFieldCP.setEnabled(false);
            jLabelErrorCP.setText("");
            validado += 1;
        } catch (ValidationException e) {
            jLabelErrorCP.setText(e.getMessage());
        }

        if (validado == 6) {
            jButtonValidate.setEnabled(false);
            jButtonCSV.setEnabled(true);
        }
    }
    }//GEN-LAST:event_jButtonValidateActionPerformed

    private void jTextFieldDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDNIActionPerformed

    private void jTextFieldNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNameActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        jTextFieldName.setText("");
        jTextFieldDNI.setText("");
        jTextFieldEmail.setText("");
        jTextFieldBirthdate.setText("");
        jTextFieldAge.setText("");
        jTextFieldCP.setText("");

        jTextFieldName.setEnabled(true);
        jTextFieldDNI.setEnabled(true);
        jTextFieldEmail.setEnabled(true);
        jTextFieldBirthdate.setEnabled(true);
        jTextFieldAge.setEnabled(true);
        jTextFieldCP.setEnabled(true);

        jButtonValidate.setEnabled(true);
        jButtonCSV.setEnabled(false);
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCSVActionPerformed
        ClassFichero.writeFile(jTextFieldName.getText() + ";" + jTextFieldDNI.getText() + ";" + jTextFieldEmail.getText() + ";" + jTextFieldBirthdate.getText() + ";" + jTextFieldAge.getText() + ";" + jTextFieldCP.getText());
        System.out.println("Se ha guardado correctamente");
        jButtonCSV.setEnabled(false);
    }//GEN-LAST:event_jButtonCSVActionPerformed

    public static void main(String args[]) throws FileNotFoundException {
    /* Set the Nimbus look and feel */
    ClassFichero.createFile("user_date_RGG.csv");
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
        java.util.logging.Logger.getLogger(jFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(jFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(jFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(jFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new JFrameMain().setVisible(true);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCSV;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonValidate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelBirthdate;
    private javax.swing.JLabel jLabelBirthdate1;
    private javax.swing.JLabel jLabelBirthdate2;
    private javax.swing.JLabel jLabelDNI;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelErrorAge;
    private javax.swing.JLabel jLabelErrorBirthdate;
    private javax.swing.JLabel jLabelErrorCP;
    private javax.swing.JLabel jLabelErrorDNI;
    private javax.swing.JLabel jLabelErrorEmail;
    private javax.swing.JLabel jLabelErrorName;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldAge;
    private javax.swing.JTextField jTextFieldBirthdate;
    private javax.swing.JTextField jTextFieldCP;
    private javax.swing.JTextField jTextFieldDNI;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldName;
    // End of variables declaration//GEN-END:variables

