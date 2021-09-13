import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;

public class Src extends javax.swing.JFrame {
    private javax.swing.JComboBox<String> SelectionBox;
    private javax.swing.JPanel jPlatno;
    private Graphics2D gui;
    private int sirka;
    private int vyska;
    private int defaultStroke;
    private String[] https___tenor_com_view_ice_eating_ok_and_gif_19666657 = {
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "10",
        "11",
        "12",
    };

    public Src() {
        initComponents();
    }

    private void GUI() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(SelectionBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPlatno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPlatno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SelectionBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPlatno      = new javax.swing.JPanel();
        SelectionBox = new javax.swing.JComboBox<>();
        gui = (Graphics2D) jPlatno.getGraphics();
        sirka = jPlatno.getWidth();
        vyska = jPlatno.getHeight();
        defaultStroke = 2;

        jPlatno.setPreferredSize(new java.awt.Dimension(400, 400));
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout jPlatnoLayout = new javax.swing.GroupLayout(jPlatno);
        jPlatno.setLayout(jPlatnoLayout);
        jPlatnoLayout.setHorizontalGroup(
            jPlatnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPlatnoLayout.setVerticalGroup(
            jPlatnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        SelectionBox.setModel(new javax.swing.DefaultComboBoxModel<>(https___tenor_com_view_ice_eating_ok_and_gif_19666657));
        SelectionBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectionBoxActionPerformed(evt);
            }
        });

        GUI();
    }


    private void SelectionBoxActionPerformed(java.awt.event.ActionEvent evt) {
        switch (SelectionBox.getSelectedIndex()) {
            case 0: draw_cara();      break;
            case 1: draw_stverec();   break;
            case 2: draw_kulzebra();  break;
            case 3: draw_dutvysec();  break;
            case 4: draw_kruh();      break;
            case 5: draw_troj();      break;
            case 6: draw_trojusek();  break;
            case 7: fill_stverec();   break;
            case 8: fill_kulzebra();  break;
            case 9: fill_dutvysec();  break;
            case 10: fill_kruh();     break;
            case 11: fill_troj();     break;
            default: new_canvas();    break;
        }
    }

    /* ------------------ */
    /* GRAFICKE FUNKCE :) */
    /* ------------------ */

    private Graphics2D new_canvas() {
        gui = (Graphics2D) jPlatno.getGraphics();
        gui.setColor(Color.WHITE);
        gui.fillRect(0, 0, sirka+1, vyska+1);
        gui.setStroke(new BasicStroke(defaultStroke));

        sirka = jPlatno.getWidth() -1;
        vyska = jPlatno.getHeight()-1;

        gui.setColor(Color.BLACK);

        return gui;
    }

    private void draw_cara() {
        Graphics2D gui = new_canvas();
        gui.setColor(Color.GRAY);
        gui.drawLine(0, sirka, vyska, 0);
    }

    private void draw_stverec() {
        Graphics2D gui = new_canvas();
        gui.drawRect(10, 10, sirka-20, vyska-20);
    }

    private void draw_kulzebra() {
        Graphics2D gui = new_canvas();
        gui.setColor(Color.GRAY);
        float[] dash = {10.0f};
        gui.setStroke(new BasicStroke(defaultStroke,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND, 10.0f,dash,10.0f));
        gui.drawRoundRect(10, 10, sirka-20, vyska-20, 30, 30);
    }

    private void draw_dutvysec() {
        Graphics2D gui = new_canvas();
        gui.setStroke(new BasicStroke(20));
        gui.drawArc(10, 10, sirka-20, vyska-20, 90, 150);
    }

    private void draw_kruh() {
        Graphics2D gui = new_canvas();
        gui.drawOval(10, 10, sirka-20, vyska-20);
    }

    private void draw_troj() {
        Graphics2D gui = new_canvas();

        int x[] = {10, sirka-10, (int)((double)sirka/2.0),};
        int y[] = {10, 10      , (int)((double)vyska/2.0),};
        int x2[] = {10,       sirka-10, (int)((double)sirka/2.0),};
        int y2[] = {vyska-10, vyska-10, (int)((double)vyska/2.0),};

        gui.drawPolygon(x, y, 3);
        gui.drawPolygon(x2, y2, 3);
    }

    private void draw_trojusek() {
        Graphics2D gui = new_canvas();

        int x[] = {-defaultStroke, sirka,          (int)((double)sirka/2.0),};
        int y[] = {-defaultStroke, -defaultStroke, (int)((double)vyska/2.0),};
        gui.drawPolygon(x, y, 3);

        int x2[] = {10,       sirka-10, (int)((double)sirka/2.0),};
        int y2[] = {vyska-10, vyska-10, (int)((double)vyska/2.0),};
        gui.drawPolygon(x2, y2, 3);
    }

    private void fill_stverec() {
        Graphics2D gui = new_canvas();
        gui.setColor(Color.RED);
        gui.fillRect(10, 10, sirka-20, vyska-20);
    }

    private void fill_kulzebra() {
        Graphics2D gui = new_canvas();
        gui.setPaint(new GradientPaint(0, vyska-20, Color.RED, sirka-20, vyska-20, Color.YELLOW));
        gui.fillRoundRect(10, 10, sirka-20, vyska-20, 30, 30);
    }

    private void fill_dutvysec() {
        Graphics2D gui = new_canvas();
        gui.setColor(Color.RED);
        gui.fillArc(10, 10, sirka-20, vyska-20, 70, 180);
    }

    private void fill_kruh() {
        Graphics2D gui = new_canvas();
        gui.setPaint(new GradientPaint(0, vyska-20, Color.RED, sirka-20, vyska-20, Color.YELLOW));
        gui.fillOval(10, 10, sirka-20, vyska-20);
    }

    private void fill_troj() {
        Graphics2D gui = new_canvas();

        int x[] = {10, sirka-10, (int)((double)sirka/2.0),};
        int y[] = {10, 10      , (int)((double)vyska/2.0),};
        int x2[] = {10,       sirka-10, (int)((double)sirka/2.0),};
        int y2[] = {vyska-10, vyska-10, (int)((double)vyska/2.0),};

        gui.setColor(Color.RED);
        gui.fillPolygon(x, y, 3);
        gui.fillPolygon(x2, y2, 3);

        gui.setColor(Color.BLACK);
        gui.drawPolygon(x, y, 3);
        gui.drawPolygon(x2, y2, 3);
    }

    /* -------------------------- */
    /* KONEC GRAFICKYCH FUNKCI :) */
    /* -------------------------- */

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
