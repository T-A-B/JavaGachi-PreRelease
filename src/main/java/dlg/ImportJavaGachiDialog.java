package dlg;

import javax.swing.*;
import java.awt.event.*;

public class ImportJavaGachiDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField codeEntryTextField;
    private JLabel CodeEntryLabel;
    private boolean isDisposed;
    String importText = "";
    magicContainer magic;

    public ImportJavaGachiDialog(magicContainer p_stringThatWillHoldReturnValue) {
        importText = p_stringThatWillHoldReturnValue.getString();
        magic = p_stringThatWillHoldReturnValue;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        isDisposed = true;
        importText = getEnteredText();
        magic.setString(importText);
        System.out.println(getEnteredText());
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        isDisposed = true;
        dispose();
    }

    public void showDialog() {
        ImportJavaGachiDialog dialog = new ImportJavaGachiDialog(magic);
        dialog.pack();
        dialog.setVisible(true);
      //  System.exit(0);
    }
    public boolean getDisposed(){
        return isDisposed;
    }

    public String getEnteredText() {
        return codeEntryTextField.getText();
    }
    public String getImportText() {
        return importText;
    }
}
