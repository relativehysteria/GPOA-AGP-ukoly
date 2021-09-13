import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.JTextPane;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Src extends javax.swing.JFrame {

	private JLabel     jmenoLabel;
	private JTextField jmenoTF;
	private JLabel     uliceLabel;
	private JTextField uliceTF;
	private JLabel     pscLabel;
	private JTextField pscTF;
	private JLabel     obecLabel;
	private JTextField obecTF;
	private JButton    okB;
	private JTextPane  vysledek;

	public Src() {
		setLocationRelativeTo(null);

		jmenoLabel = new JLabel();
		uliceLabel = new JLabel();
		pscLabel   = new JLabel();
		obecLabel  = new JLabel();
		jmenoTF = new JTextField();
		uliceTF = new JTextField();
		pscTF   = new JTextField();
		obecTF  = new JTextField();
		vysledek = new JTextPane();
		okB = new JButton();

		vysledek.setEditable(false);
		vysledek.setContentType("text/html");

		jmenoLabel.setText("Jméno");
		uliceLabel.setText("Ulice");
		pscLabel.setText("PSČ");
		obecLabel.setText("Obec");
		okB.setText("OK");

		okB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				printOut();
			}
		});

		GUI();
	}

	private void GUI() {
		int PSIZ = GroupLayout.PREFERRED_SIZE;

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateContainerGaps(true);
		layout.setAutoCreateGaps(true);

		GroupLayout.ParallelGroup   hGroup = layout.createParallelGroup();
		GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

		hGroup.addGroup(layout.createSequentialGroup()
			.addComponent(jmenoLabel, PSIZ, 100, PSIZ)
			.addComponent(jmenoTF, PSIZ, 300, PSIZ)
		);
		hGroup.addGroup(layout.createSequentialGroup()
			.addComponent(uliceLabel, PSIZ, 100, PSIZ)
			.addComponent(uliceTF, PSIZ, 300, PSIZ)
		);
		hGroup.addGroup(layout.createSequentialGroup()
			.addComponent(pscLabel, PSIZ, 100, PSIZ)
			.addComponent(pscTF, PSIZ, 300, PSIZ)
		);
		hGroup.addGroup(layout.createSequentialGroup()
			.addComponent(obecLabel, PSIZ, 100, PSIZ)
			.addComponent(obecTF, PSIZ, 300, PSIZ)
		);
		hGroup.addGroup(layout.createSequentialGroup()
			.addComponent(okB, PSIZ, 400, PSIZ)
		);
		hGroup.addGroup(layout.createSequentialGroup()
			.addComponent(vysledek, PSIZ, 400, PSIZ)
		);

		vGroup.addGroup(layout.createParallelGroup()
			.addComponent(jmenoLabel, PSIZ, 30, PSIZ)
			.addComponent(jmenoTF, PSIZ, 30, PSIZ)
		);
		vGroup.addGroup(layout.createParallelGroup()
			.addComponent(uliceLabel, PSIZ, 30, PSIZ)
			.addComponent(uliceTF, PSIZ, 30, PSIZ)
		);
		vGroup.addGroup(layout.createParallelGroup()
			.addComponent(pscLabel, PSIZ, 30, PSIZ)
			.addComponent(pscTF, PSIZ, 30, PSIZ)
		);
		vGroup.addGroup(layout.createParallelGroup()
			.addComponent(obecLabel, PSIZ, 30, PSIZ)
			.addComponent(obecTF, PSIZ, 30, PSIZ)
		);
		vGroup.addGroup(layout.createParallelGroup()
			.addComponent(okB, PSIZ, 30, PSIZ)
		);
		vGroup.addGroup(layout.createParallelGroup()
			.addComponent(vysledek, PSIZ, 90, PSIZ)
		);

		layout.setHorizontalGroup(hGroup);
		layout.setVerticalGroup(vGroup);

		pack();
	}

	private void error(String message) {
		JOptionPane.showMessageDialog(
			new JFrame(),
			message,
			"Chyba",
			JOptionPane.ERROR_MESSAGE
		);
	}

	private void printOut() {
		if (
			jmenoTF.getText().isEmpty()  || uliceTF.getText().isEmpty()
			|| pscTF.getText().isEmpty() || obecTF.getText().isEmpty()
		) {
			error("Prosím, vyplň všechna pole");
			return;
		}

		String jmenoText = jmenoTF.getText();
		String uliceText = uliceTF.getText();
		String pscText   = pscTF.getText();
		String obecText  = obecTF.getText();

		try {
			Integer.parseInt(pscText);
		} catch (Exception e) {
			error("PSČ musí být číslo");
			return;
		}

		vysledek.setText(
			"<span style=\"color: #AA0000\">Jméno:     </span>" + jmenoText +
			"<br><span style=\"color: #FF0AB3\">Ulice: </span>" + uliceText +
			"<br><span style=\"color: #043907\">PSČ:   </span>" + pscText   +
			"<br><span style=\"color: #AAAA00\">Obec:  </span>" + obecText
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
