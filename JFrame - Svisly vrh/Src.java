import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Src extends javax.swing.JFrame {
    private Font       _font;
    private JLabel     lbIn;
    private JTextField tfIn;
    private JTextArea  tfOut;
    private JButton    btCalc;

    @SuppressWarnings("unchecked")
    public Src() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Srccab");

        _font = new java.awt.Font("Tahoma", 1, 18);

        lbIn   = default_label("Počáteční rychlost:");
        tfIn   = default_txtfield(true);
        tfOut  = default_txtarea(false);
        btCalc = default_button("Vypočti");
        btCalc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                calc();
            }
        });

        init_GUI();
    }

    private void init_GUI() {
        int PSIZ    = GroupLayout.PREFERRED_SIZE;
        int padding = 5;
        int height  = 32;
        int lbInW   = 240;
        int tfInW   = 400;
        int btCalcW = 150;
        int sumW    = lbInW + padding + tfInW + padding + btCalcW;

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        GroupLayout.ParallelGroup hGroup = layout.createParallelGroup();
        hGroup.addGroup(layout.createSequentialGroup()
            .addComponent(lbIn,   PSIZ, lbInW,   PSIZ)
            .addComponent(tfIn,   PSIZ, tfInW,   PSIZ)
            .addComponent(btCalc, PSIZ, btCalcW, PSIZ)
        );
        hGroup.addGroup(layout.createParallelGroup()
            .addComponent(tfOut, PSIZ, sumW, PSIZ)
        );

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup()
            .addComponent(lbIn,   PSIZ, height, PSIZ)
            .addComponent(tfIn,   PSIZ, height, PSIZ)
            .addComponent(btCalc, PSIZ, height, PSIZ)
        );
        vGroup.addGroup(layout.createParallelGroup()
            .addComponent(tfOut, PSIZ, height * 3, PSIZ)
        );

        layout.setHorizontalGroup(hGroup);
        layout.setVerticalGroup(vGroup);

        pack();
    }

    private JTextField default_txtfield(boolean editable) {
        JTextField field = new JTextField();
        field.setEditable(editable);
        field.setFont(_font);
        return field;
    }

    private JTextArea default_txtarea(boolean editable) {
        JTextArea area = new JTextArea();
        area.setEditable(editable);
        area.setFont(_font);
        return area;
    }

    private JLabel default_label(String text) {
        JLabel label = new JLabel();
        label.setFont(_font);
        label.setText(text);
        return label;
    }

    private JButton default_button(String text) {
        JButton button = new JButton();
        button.setFont(_font);
        button.setText(text);
        return button;
    };

    private void calc() {
        Double speed    = get_speed();
        if (speed == -1.0) { return; }

        Double constant = 9.81373;
        Double height   = speed * speed / (2 * constant);
        Double time     = (2 * speed) / constant;

        tfOut.setText(String.format(
            "Počáteční rychlost %.3f\n" +
            "Maximální výška %.3f\n" +
            "Doba vrhu %.3f",
            speed, height, time
        ));
    }

    /* Returns -1.0 on error */
    private Double get_speed() {
        String text  = tfIn.getText().trim();
        Double speed;

        if (text.length() == 0) {
            error("Nezadaná hodnota. Musíš zadat hodnotu");
            return -1.0;
        }

        try {
            speed = Double.parseDouble(text);
        } catch (java.lang.NumberFormatException e) {
            error("Nebyla zadaná správná hodnota, musíš zadat číslo");
            return -1.0;
        }

        if (speed < 0) {
            error("Hodnota rychlosti nesmí být záporná");
            return -1.0;
        }

        return speed;
    }

    private void error(String message) {
        JOptionPane.showMessageDialog(
            null,
            message,
            "Chyba",
            JOptionPane.ERROR_MESSAGE
        );
    }

    public static void main(String args[]) {
        try {
            for (
                javax.swing.UIManager.LookAndFeelInfo info :
                javax.swing.UIManager.getInstalledLookAndFeels()
            ) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Src().setVisible(true);
            }
        });
    }
}
