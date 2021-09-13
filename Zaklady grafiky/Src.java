
import java.awt.Color;
import java.awt.Graphics2D;

public class Src extends javax.swing.JFrame {

    public Src() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPlatno = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPlatnoLayout = new javax.swing.GroupLayout(jPlatno);
        jPlatno.setLayout(jPlatnoLayout);
        jPlatnoLayout.setHorizontalGroup(
            jPlatnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPlatnoLayout.setVerticalGroup(
            jPlatnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 227, Short.MAX_VALUE)
        );

		jButton1.setText("Vykresli");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPlatno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPlatno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    	int vyska =jPlatno.getHeight()-1;
        int sirka = jPlatno.getWidth()-1;
        int pulkaVysky = vyska/2;
        int pulkaSirky = sirka/2;

        Graphics2D gr = (Graphics2D) jPlatno.getGraphics();
        gr.setColor(Color.white);
        gr.fillRect(0, 0, sirka, vyska);

		// osy
        gr.setColor(Color.BLACK);
        gr.drawLine(0, pulkaVysky, sirka, pulkaVysky);
        gr.drawLine(pulkaSirky, 0, pulkaSirky, vyska);

        // modly oval
        gr.setColor(Color.BLUE);
        int xo = 0, yo = 0;
        int sirkao = pulkaSirky, vyskao = pulkaVysky;
        gr.drawOval(xo, yo, sirkao, vyskao);

        // usecka
        gr.setColor(Color.RED);
        gr.drawLine(pulkaSirky, pulkaVysky/2, sirka, pulkaVysky/2);
		gr.drawLine((int)((double)sirka * 0.75), 0, (int)((double)sirka * 0.75), pulkaVysky);


        // zeleny oval
        gr.setColor(Color.green);
        gr.fillRoundRect(0, pulkaVysky, pulkaSirky, pulkaVysky, 20, 20);

		// cyan ctverec
        gr.setColor(Color.CYAN);
		gr.drawRect(pulkaSirky, pulkaVysky, pulkaSirky, pulkaVysky);

		// modry oval uvnitr cyan ctverce
		gr.setColor(Color.RED);
		gr.drawOval(pulkaSirky, pulkaVysky, pulkaSirky, pulkaVysky);
		gr.setColor(Color.BLUE);
		gr.fillOval(pulkaSirky, pulkaVysky, pulkaSirky, pulkaVysky);

		// uhlopricky
		gr.setColor(Color.YELLOW);
		gr.drawLine(pulkaSirky, pulkaVysky, sirka, vyska);
		gr.drawLine(sirka, pulkaVysky, pulkaSirky, vyska);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
			System.err.println(ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Src().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPlatno;
}
