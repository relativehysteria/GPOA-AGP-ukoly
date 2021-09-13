import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class JFrame extends javax.swing.JFrame {
    private JTextField cTF;
    private JTextField kmTF;
    private JTextField oHTF;
    private JTextField zTF;
    private JButton calc;
    private JButton end;
    private JLabel jl1;
    private JLabel jl2;
    private JLabel jl3;
    private JLabel jl4;
    private JLabel jl5;

    public JFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jl1  = new javax.swing.JLabel();
        jl2  = new javax.swing.JLabel();
        jl3  = new javax.swing.JLabel();
        zTF  = new javax.swing.JTextField();
        oHTF = new javax.swing.JTextField();
        kmTF = new javax.swing.JTextField();
        jl4  = new javax.swing.JLabel();
        jl5  = new javax.swing.JLabel();
        cTF  = new javax.swing.JTextField();
        calc = new javax.swing.JButton();
        end  = new javax.swing.JButton();

        jl1.setText("Počet zaměstnanců:");
        jl2.setText("Počet odpracovaných hodin:");
        jl3.setText("Počet najetých Km:");
        jl4.setText("Sazba za 1km = 5Kč");
        jl5.setText("Sazba za 1h  = 120Kč");
		cTF.setEditable(false);

        calc.setText("Vypočítej");
        calc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcActionPerformed(evt);
            }
        });

        end.setText("Konec");
        end.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl5)
                            .addComponent(jl4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cTF)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(calc, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(end, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl2)
                            .addComponent(jl3)
                            .addComponent(jl1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(zTF)
                            .addComponent(oHTF)
                            .addComponent(kmTF))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl1)
                    .addComponent(zTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl2)
                    .addComponent(oHTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl3)
                    .addComponent(kmTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jl4)
                        .addGap(18, 18, 18)
                        .addComponent(jl5))
                    .addComponent(cTF, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calc)
                    .addComponent(end))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void endActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void calcActionPerformed(java.awt.event.ActionEvent evt) {
        String empty = "";

        if ("".equals(zTF.getText()) ||
				"".equals(oHTF.getText()) ||
				"".equals(kmTF.getText())) {
            JOptionPane.showMessageDialog(this,
					"Nebyly zadány potřebné parametry",
					"Chyba",
					JOptionPane.ERROR_MESSAGE);
        } else {
            try {
				Naklady n = new Naklady(
					Integer.parseInt(zTF.getText()),
					Integer.parseInt(oHTF.getText()),
					Integer.parseInt(kmTF.getText()),
					5, 120
				);

				cTF.setText("Náklady jsou: "+ n.FinVysledek() +"Kč");
            } catch(Exception e) {
                JOptionPane.showMessageDialog(this,
					"Hodnoty musí být celá čísla",
					"Chyba",
					JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame().setVisible(true);
            }
        });
    }
}
