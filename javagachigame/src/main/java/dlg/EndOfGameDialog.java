package dlg;

import model.interfaces.IJavaGachi;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndOfGameDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel nameLabel;
    private JLabel birthdayLabel;
    private JLabel ageLabel;
    private JLabel spriteDisplayLabel;
    private JLabel deathSpriteDisplayLabel;
    private JLabel timesPetLabel;
    private JLabel timesFedLabel;
    private JLabel nameDisplayLabel;
    private JLabel birthdayDisplayLabel;
    private JLabel ageDisplayLabel;
    private JLabel timesFedDisplayLabel;
    private JLabel timesPetDisplayLabel;
    private JPanel mainDialogPanel;


    IJavaGachi perishedJavaGachi;
    public EndOfGameDialog(IJavaGachi p_perishedJavaGachi) {
        perishedJavaGachi = p_perishedJavaGachi;
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

    public void showPanel() {

        EndOfGameDialog dialog = new EndOfGameDialog(perishedJavaGachi);

        dialog.configureDialog();
        dialog.repaint();
        dialog.contentPane.repaint();
        dialog.pack();
        dialog.setVisible(true);

    }

    public void configureDialog(){
        nameDisplayLabel.setText(perishedJavaGachi.getJavaGachiName());
        birthdayDisplayLabel.setText(perishedJavaGachi.getBirthdayDate().toString());
        ageDisplayLabel.setText(Integer.toString(perishedJavaGachi.getJavaGachiAge().getSecondsOld() / 60));
        timesFedDisplayLabel.setText(perishedJavaGachi.getStatistics().getTimesFedString());
        timesPetDisplayLabel.setText(perishedJavaGachi.getStatistics().getTimesPetString());
    }
}
