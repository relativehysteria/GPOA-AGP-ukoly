import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JPanel;

interface nemamRadJFrame {
	public int spocti(int x);
}

public class Src extends javax.swing.JFrame {
    private ButtonGroup grupa1;
	private ButtonGroup grupa2;
    private JButton vykresliButt;
    private JPanel platno;
    private JRadioButton rbBlue;
    private JRadioButton rbGreen;
    private JRadioButton rbRed;
	private JRadioButton rbSin;
	private JRadioButton rbCos;
	private JRadioButton rbInvSin;

    public Src() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        grupa1       = new ButtonGroup();
		grupa2       = new ButtonGroup();
        rbRed        = new JRadioButton();
        rbGreen      = new JRadioButton();
        rbBlue       = new JRadioButton();
		rbSin        = new JRadioButton();
		rbCos        = new JRadioButton();
		rbInvSin     = new JRadioButton();
        vykresliButt = new JButton();
        platno       = new JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        grupa1.add(rbRed);
        grupa1.add(rbGreen);
        grupa1.add(rbBlue);

        rbRed.setSelected(true);
        rbRed.setText("červená");
        rbBlue.setText("modrá ");
        rbGreen.setText("zelená");

        rbBlue.setForeground(Color.BLUE);
        rbRed.setForeground(Color.RED);
        rbGreen.setForeground(Color.GREEN);

		grupa2.add(rbSin);
		grupa2.add(rbCos);
		grupa2.add(rbInvSin);

		rbSin.setSelected(true);
		rbSin.setText("sin(x)");
		rbCos.setText("cos(2x)");
		rbInvSin.setText("sin(1/x)");

        vykresliButt.setText("Vykresli");
        vykresliButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vykresliButtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout platnoLayout = new javax.swing.GroupLayout(platno);
        platno.setLayout(platnoLayout);
        platnoLayout.setHorizontalGroup(
            platnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        platnoLayout.setVerticalGroup(
            platnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 227, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(platno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbRed)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbGreen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbBlue)
                        .addGap(18, 18, 18)
                        .addComponent(vykresliButt, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
						.addComponent(rbSin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(rbCos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbInvSin)
                .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(platno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbRed)
                    .addComponent(rbGreen)
                    .addComponent(rbBlue)
                    .addComponent(vykresliButt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbSin)
                    .addComponent(rbCos)
                    .addComponent(rbInvSin))
                .addGap(28, 28, 28))
        );

        pack();
    }

    private void vykresliButtActionPerformed(java.awt.event.ActionEvent evt) {
        int vyska = platno.getHeight()-1;
        int sirka = platno.getWidth()-1;
        int pulkaSirky = sirka / 2;
        int pulkaVysky = vyska / 2;
		nemamRadJFrame vypocti;

        int x = -pulkaSirky;
        int y = 0;

        Graphics2D gr = (Graphics2D)platno.getGraphics();
        gr.setColor(Color.WHITE);
        gr.fillRect(0, 0, sirka, vyska);

        gr.setColor(Color.BLACK);
        gr.drawLine(0, pulkaVysky, sirka, pulkaVysky);
        gr.drawLine(pulkaSirky, 0, pulkaSirky, vyska);

        if (rbRed.isSelected()) {
            gr.setColor(Color.red);
        } else if (rbGreen.isSelected()) {
            gr.setColor(Color.GREEN);
        } else {
            gr.setColor(Color.BLUE);
        }

		if (rbSin.isSelected()) {
			vypocti = (xy) -> { return (int)Math.round(Math.sin(Math.toRadians(xy)) * pulkaVysky); };
		} else if (rbCos.isSelected()) {
			vypocti = (xy) -> { return (int)Math.round(Math.cos(Math.toRadians(xy)*2) * pulkaVysky); };
		} else {
			vypocti = (xy) -> { return (int)Math.round(Math.sin(1.0 / Math.toRadians(xy)) * pulkaVysky); };
		}

		y = vypocti.spocti(x);

        for (int newX = -pulkaSirky; newX < pulkaSirky; newX++) {
            int newY = vypocti.spocti(newX);
            gr.drawLine(x + pulkaSirky, pulkaVysky - y, newX + pulkaSirky, pulkaVysky - newY);
            x = newX;
            y = newY;
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
