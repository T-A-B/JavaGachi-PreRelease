package dlg;

import encryption.impl.EncryptionTool;
import model.impl.PlayerJavaGachiImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExportJavaGachiDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField codeTextArea;
    PlayerJavaGachiImpl javaGachi;
    public ExportJavaGachiDialog(PlayerJavaGachiImpl p_javaGachi) {
        javaGachi = p_javaGachi;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    public void showDialog() {
        EncryptionTool et = new EncryptionTool();
        ExportJavaGachiDialog dialog = new ExportJavaGachiDialog(javaGachi);
        dialog.codeTextArea.setText(et.antiCheatEncrypt(javaGachi.getExportString()));
        dialog.pack();
        dialog.setVisible(true);

    }
}
