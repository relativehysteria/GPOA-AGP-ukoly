import java.awt.Color;
import java.awt.Graphics2D;

public class Src extends javax.swing.JFrame {
    private javax.swing.JComboBox<String> clr;
    private javax.swing.JButton           delete;
    private javax.swing.JButton           draw;
    private javax.swing.JPanel            plane;

    public Src() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        draw   = new javax.swing.JButton();
        plane  = new javax.swing.JPanel();
        delete = new javax.swing.JButton();
        clr    = new javax.swing.JComboBox<>();
        clr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
            "Červená", "Zelená"
        }));

        draw.setText("Vykresli");
        draw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawActionPerformed(evt);
            }
        });
        delete.setText("Smaž");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout planeLayout = new javax.swing.GroupLayout(plane);
        plane.setLayout(planeLayout);
        planeLayout.setHorizontalGroup(
            planeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        planeLayout.setVerticalGroup(
            planeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(plane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(draw, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clr, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(draw)
                    .addComponent(delete)
                    .addComponent(clr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }

    int cos(int x, int hVysky) {
        return (int)Math.round(Math.cos(Math.toRadians(x)*2) * hVysky);
    }

    void clear(Graphics2D grPlane) {
        grPlane.setColor(Color.WHITE);
        grPlane.fillRect(0, 0, plane.getWidth(), plane.getHeight());
    }

    private void drawActionPerformed(java.awt.event.ActionEvent evt) {
        int vyska = plane.getHeight() - 1;
        int sirka = plane.getWidth()  - 1;
        int hSirky = sirka / 2;
        int hVysky = vyska / 2;

        Graphics2D gr = (Graphics2D) plane.getGraphics();
        clear(gr);

        gr.setColor(Color.BLACK);
        gr.drawLine(0, hVysky, sirka, hVysky);

        int x = -hSirky;
        int y = cos(x, hVysky);

        for (int nX = -hSirky; nX < hSirky; nX++) {
            int nY = cos(nX, hVysky);

            if (clr.getSelectedIndex() == 0) {
                gr.setColor(Color.RED);
            } else {
                gr.setColor(Color.GREEN);
            }

            gr.drawLine(x + hSirky, hVysky - y, nX + hSirky, hVysky - nY);

            x = nX;
            y = nY;
        }
    }

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {
        clear((Graphics2D) plane.getGraphics());
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
}
