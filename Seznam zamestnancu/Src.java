import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class Src extends javax.swing.JFrame {

	private void error(String arg) {
		JOptionPane.showMessageDialog(null, arg, "Chyba", JOptionPane.ERROR_MESSAGE);
	}

    public Src() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jobs = new ArrayList<Job>();

        jl1 = new javax.swing.JLabel();
        jl2 = new javax.swing.JLabel();
        jl3 = new javax.swing.JLabel();
        jl4 = new javax.swing.JLabel();
        jl5 = new javax.swing.JLabel();
        jl6 = new javax.swing.JLabel();
        jl7 = new javax.swing.JLabel();

        nameField     = new javax.swing.JTextField();
        lastnameField = new javax.swing.JTextField();
        ageField      = new javax.swing.JTextField();
        moneyField    = new javax.swing.JTextField();

        jScrollPane1  = new javax.swing.JScrollPane();
        jScrollPane2  = new javax.swing.JScrollPane();

        VlozenePrvky  = new javax.swing.JTextArea();
        VypisnePole   = new javax.swing.JTextArea();

        EndButton = new javax.swing.JButton();
		EndButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

        PushButton = new javax.swing.JButton();
		PushButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				try {
					String jmeno    = nameField.getText();
					String prijmeni = lastnameField.getText();

					if (jmeno.equals("") || prijmeni.equals("")) {
						error("Políčko nesmí být prázdné.");
						return;
					}

					long vek  = Long.parseLong(ageField.getText());
					long mzda = Long.parseLong(moneyField.getText());

					jobs.add(new Job(jmeno, prijmeni, vek, mzda));
				} catch (Exception e) {
					error("Vlož prosím číslo.");
				}

				String prvky = "";
				for (Job i : jobs) {
					prvky += String.format("Jméno a příjmení: %s %s\n", i.jmeno, i.prijmeni);
					prvky += String.format("Věk: %d\n", i.vek);
					prvky += String.format("Mzda: %d\n", i.mzda);
					prvky += String.format("-----------------\n", i.mzda);
				}
				VlozenePrvky.setText(prvky);
			}
		});

        ShowButton = new javax.swing.JButton();
		ShowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				String prvky = "";
				for (Job i : jobs) {
					prvky += String.format("Jméno a příjmení: %s %s    ", i.jmeno, i.prijmeni);
					prvky += String.format("Věk: %d    ", i.vek);
					prvky += String.format("Mzda: %d\n", i.mzda);
					prvky += String.format("------\n", i.mzda);
				}
				VypisnePole.setText(prvky);
			}
		});

        jl1.setText("Seznam pracovníků");
        jl2.setText("Jméno");
        jl3.setText("Příjmení");
        jl4.setText("Věk");
        jl5.setText("Mzda");
        jl6.setText("Vložené prvky");
        jl7.setText("Výpis pole");
        EndButton.setText("Konec");
        ShowButton.setText("Ukázat");
        PushButton.setText("Vlož");

        VypisnePole.setColumns(20);
        VypisnePole.setRows(5);
        jScrollPane1.setViewportView(VypisnePole);

        VlozenePrvky.setColumns(20);
        VlozenePrvky.setRows(5);
        jScrollPane2.setViewportView(VlozenePrvky);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addComponent(jl1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jl7))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jl2)
                                            .addComponent(jl3)
                                            .addComponent(jl4)
                                            .addComponent(jl5))
                                        .addGap(24, 24, 24)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ageField, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                            .addComponent(lastnameField)
                                            .addComponent(nameField)
                                            .addComponent(moneyField))
                                        .addGap(56, 56, 56)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ShowButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(PushButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addGap(0, 98, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EndButton)
                        .addGap(8, 8, 8)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jl6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl4)
                    .addComponent(ShowButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(moneyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl5)
                    .addComponent(PushButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jl6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                .addComponent(jl7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EndButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(208, 208, 208)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(205, Short.MAX_VALUE)))
        );

        pack();
    }
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception x) {
			System.err.println(x);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Src().setVisible(true);
            }
        });
    }

    private javax.swing.JButton EndButton;
    private javax.swing.JButton ShowButton;
    private javax.swing.JButton PushButton;
    private javax.swing.JTextArea VlozenePrvky;
    private javax.swing.JTextArea VypisnePole;
    private javax.swing.JTextField ageField;
    private javax.swing.JLabel jl1;
    private javax.swing.JLabel jl2;
    private javax.swing.JLabel jl3;
    private javax.swing.JLabel jl4;
    private javax.swing.JLabel jl5;
    private javax.swing.JLabel jl6;
    private javax.swing.JLabel jl7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField moneyField;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField lastnameField;
	private ArrayList<Job> jobs;
}
