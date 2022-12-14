package lab5_kre17;

import java.awt.Cursor;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JTextField;
import org.apache.poi.hwpf.HWPFDocument;

public class JFrameLauncher extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private HWPFDocument doc = null;

    class ThreadExportToDoc extends Thread {

        @Override
        public void run() {
            String dir = new File(".").getAbsoluteFile().getParentFile().getAbsolutePath()
                    + System.getProperty("file.separator");

            // Чтение из файла-шаблона в переменную doc
            
            try ( FileInputStream fis = new FileInputStream(dir + "myTemplate.doc")) {
                doc = new HWPFDocument(fis);
                fis.close();
            } catch (Exception ex) {
                System.err.println("Error template!");
            }

            // Замена в переменной doc данных
            try {
                xxx("1", jTextFieldDateOfBirth);
                xxx("2", jTextFieldCitizen);
                xxx("3", jTextFieldLanguages);
                xxx("4", jTextFieldMaritalStatus);
                xxx("5", jTextFieldListedAs);
                xxx("6", jTextFieldCodename);
                xxx("7", jTextFieldFileNo);
                xxx("8", jTextFieldHairColour);
                xxx("9", jTextFieldEyeColour);
                xxx("z1", jTextFieldMarks);
                xxx("z2", jTextFieldHeight);

//                doc.getOverallRange().replaceText("$DATE_OF_BIRTH", jTextFieldDateOfBirth.getText());
//                doc.getOverallRange().replaceText("$CITIZEN", jTextFieldCitizen.getText());
//                doc.getOverallRange().replaceText("$LANGUAGES", jTextFieldLanguages.getText());
//                doc.getOverallRange().replaceText("$MARITAL_STATUS", jTextFieldMaritalStatus.getText());
//                doc.getOverallRange().replaceText("$LISTED_AS", jTextFieldListedAs.getText());
//                doc.getOverallRange().replaceText("$CODENAME", jTextFieldCodename.getText());
//                doc.getOverallRange().replaceText("$FILE_NO", jTextFieldFileNo.getText());
//                doc.getOverallRange().replaceText("$HAIR_COLOUR", jTextFieldHairColour.getText());
//                doc.getOverallRange().replaceText("$EYE_COLOUR", jTextFieldEyeColour.getText());
//                doc.getOverallRange().replaceText("$MARKS", jTextFieldMarks.getText());
//                doc.getOverallRange().replaceText("$HEIGHT", jTextFieldHeight.getText());
            } catch (Exception ex) {
                System.err.println("Error replaceText!");
            }

            // Сохранение переменной doc в новый файл
            try ( FileOutputStream fos = new FileOutputStream(dir + "receipt.doc")) {
                doc.write(fos);
                fos.close();
                // Открытие файла внешней программой
                if (System.getProperty("os.name").equals("Linux")
                        && System.getProperty("java.vendor").startsWith("Red Hat")) {
                    new ProcessBuilder("xdg-open", dir + "receipt.doc").start();
                } else {
                    Desktop.getDesktop().open(new File(dir + "receipt.doc"));
                }
            } catch (Exception ex) {
                System.err.println("Error getDesktop!");
            }
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }

    }

    private void xxx(String x, JTextField s) {
        final String ss1 = "citizencitizencitizencitizencitizen";
        String ss = ss1+x;
        System.out.println(s);
        doc.getOverallRange().replaceText(ss, String.format("%-" + ss.length() + "s", s.getText()));
    }

    public JFrameLauncher() {
        initComponents();
        this.getContentPane().setBackground(java.awt.Color.BLUE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldDateOfBirth = new javax.swing.JTextField();
        jTextFieldCitizen = new javax.swing.JTextField();
        jTextFieldLanguages = new javax.swing.JTextField();
        jTextFieldMaritalStatus = new javax.swing.JTextField();
        jTextFieldListedAs = new javax.swing.JTextField();
        jTextFieldCodename = new javax.swing.JTextField();
        jTextFieldFileNo = new javax.swing.JTextField();
        jTextFieldHairColour = new javax.swing.JTextField();
        jTextFieldEyeColour = new javax.swing.JTextField();
        jTextFieldMarks = new javax.swing.JTextField();
        jTextFieldHeight = new javax.swing.JTextField();
        jButtonExportToWord = new javax.swing.JButton();
        jLabelBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Лабораторная 5 ApachePOI экспорт в \".doc\"");
        setIconImage(java.awt.Toolkit.getDefaultToolkit().createImage(getClass().getResource("logo.png")));
        setResizable(false);
        getContentPane().setLayout(null);

        jTextFieldDateOfBirth.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextFieldDateOfBirth.setOpaque(false);
        getContentPane().add(jTextFieldDateOfBirth);
        jTextFieldDateOfBirth.setBounds(140, 144, 156, 23);

        jTextFieldCitizen.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextFieldCitizen.setOpaque(false);
        getContentPane().add(jTextFieldCitizen);
        jTextFieldCitizen.setBounds(140, 172, 156, 23);

        jTextFieldLanguages.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextFieldLanguages.setOpaque(false);
        getContentPane().add(jTextFieldLanguages);
        jTextFieldLanguages.setBounds(140, 200, 156, 23);

        jTextFieldMaritalStatus.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextFieldMaritalStatus.setOpaque(false);
        getContentPane().add(jTextFieldMaritalStatus);
        jTextFieldMaritalStatus.setBounds(140, 226, 156, 23);

        jTextFieldListedAs.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextFieldListedAs.setOpaque(false);
        getContentPane().add(jTextFieldListedAs);
        jTextFieldListedAs.setBounds(140, 254, 156, 23);

        jTextFieldCodename.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextFieldCodename.setOpaque(false);
        getContentPane().add(jTextFieldCodename);
        jTextFieldCodename.setBounds(140, 296, 156, 23);

        jTextFieldFileNo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextFieldFileNo.setOpaque(false);
        getContentPane().add(jTextFieldFileNo);
        jTextFieldFileNo.setBounds(140, 322, 156, 23);

        jTextFieldHairColour.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextFieldHairColour.setOpaque(false);
        getContentPane().add(jTextFieldHairColour);
        jTextFieldHairColour.setBounds(140, 396, 156, 23);

        jTextFieldEyeColour.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextFieldEyeColour.setOpaque(false);
        getContentPane().add(jTextFieldEyeColour);
        jTextFieldEyeColour.setBounds(140, 422, 156, 23);

        jTextFieldMarks.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextFieldMarks.setOpaque(false);
        getContentPane().add(jTextFieldMarks);
        jTextFieldMarks.setBounds(140, 450, 156, 23);

        jTextFieldHeight.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextFieldHeight.setOpaque(false);
        getContentPane().add(jTextFieldHeight);
        jTextFieldHeight.setBounds(390, 396, 146, 23);

        jButtonExportToWord.setText("в WORD");
        jButtonExportToWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportToWordActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExportToWord);
        jButtonExportToWord.setBounds(460, 750, 81, 26);

        jLabelBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lab5_kre17/квитанция.jpg"))); // NOI18N
        jLabelBackground.setAlignmentY(0.0F);
        getContentPane().add(jLabelBackground);
        jLabelBackground.setBounds(0, 0, 560, 800);

        setSize(new java.awt.Dimension(568, 826));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExportToWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportToWordActionPerformed
        new ThreadExportToDoc().start();
    }//GEN-LAST:event_jButtonExportToWordActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameLauncher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameLauncher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameLauncher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameLauncher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameLauncher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExportToWord;
    private javax.swing.JLabel jLabelBackground;
    private javax.swing.JTextField jTextFieldCitizen;
    private javax.swing.JTextField jTextFieldCodename;
    private javax.swing.JTextField jTextFieldDateOfBirth;
    private javax.swing.JTextField jTextFieldEyeColour;
    private javax.swing.JTextField jTextFieldFileNo;
    private javax.swing.JTextField jTextFieldHairColour;
    private javax.swing.JTextField jTextFieldHeight;
    private javax.swing.JTextField jTextFieldLanguages;
    private javax.swing.JTextField jTextFieldListedAs;
    private javax.swing.JTextField jTextFieldMaritalStatus;
    private javax.swing.JTextField jTextFieldMarks;
    // End of variables declaration//GEN-END:variables
}
