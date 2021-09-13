import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Src extends javax.swing.JFrame {
    private javax.swing.JButton buchtickaAdd;
    private javax.swing.JButton buchtickaCalc;
    private javax.swing.JButton buchtickaClear;
    private javax.swing.JButton buchtickaDel;
    private javax.swing.JButton buchtickaIns1;
    private javax.swing.JButton buchtickaIns2;
    private javax.swing.JButton buchtickaIns3;
    private javax.swing.JComboBox<String> jcomboboxCumBox;
    private javax.swing.JLabel jlabelMarekMidIziFeed;
    private javax.swing.JLabel jlabelPogChampIsRacist;
    private javax.swing.JList<String> jlistBottomOfTheWorld;
    private javax.swing.JList<String> jlistKdyZacneTundraVsNigma;
    private javax.swing.JScrollPane jscrollpaneCumChalice;
    private javax.swing.JScrollPane jscrollpaneFuckBiarynka;
    private javax.swing.JTextField jtextfieldJSwingRipsMySoulApart;
    private javax.swing.JTextField jtextfieldTeamFortressVolvoWhyNoUpdate;

    DefaultListModel model = new DefaultListModel();
    DefaultListModel empty = new DefaultListModel();

    @SuppressWarnings("unchecked")
    public Src() {
        jcomboboxCumBox                        = new javax.swing.JComboBox<>();
        jscrollpaneCumChalice                  = new javax.swing.JScrollPane();
        jscrollpaneFuckBiarynka                = new javax.swing.JScrollPane();
        jlistBottomOfTheWorld                  = new javax.swing.JList<String>();
        jlistKdyZacneTundraVsNigma             = new javax.swing.JList<String>();
        jlabelMarekMidIziFeed                  = new javax.swing.JLabel();
        jlabelPogChampIsRacist                 = new javax.swing.JLabel();
        jtextfieldJSwingRipsMySoulApart        = new javax.swing.JTextField();
        jtextfieldTeamFortressVolvoWhyNoUpdate = new javax.swing.JTextField();
        buchtickaClear                         = new javax.swing.JButton();
        buchtickaDel                           = new javax.swing.JButton();
        buchtickaIns1                          = new javax.swing.JButton();
        buchtickaIns2                          = new javax.swing.JButton();
        buchtickaIns3                          = new javax.swing.JButton();
        buchtickaAdd                           = new javax.swing.JButton();
        buchtickaCalc                          = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        buchtickaIns1.setText("Vložit Combobox");
        buchtickaIns2.setText("Vložit List");
        jlabelMarekMidIziFeed.setText("Přidej hodnotu do seznamu 1:");
        buchtickaAdd.setText("Přidat");
        buchtickaDel.setText("Vymazat položku z 1. seznamu");
        buchtickaCalc.setText("Vypočítej");
        jlabelPogChampIsRacist.setText("Výsledek je:");
        buchtickaClear.setText("Vymazat ALL");
        buchtickaIns3.setText("Vložit List 2");

        jscrollpaneCumChalice.setViewportView(jlistBottomOfTheWorld);
        jscrollpaneFuckBiarynka.setViewportView(jlistKdyZacneTundraVsNigma);

        buchtickaIns3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buchtickaIns3ActionPerformed(evt);
            }
        });

        jcomboboxCumBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
            "sčítání", "odečítání"
        }));

        jlistBottomOfTheWorld.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });

        jlistKdyZacneTundraVsNigma.setModel(new javax.swing.AbstractListModel<String>() {
            public String[] strings = { "0", "1", "2", "3", "4", "5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });

        buchtickaAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buchtickaAddActionPerformed(evt);
            }
        });

        buchtickaDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buchtickaDelActionPerformed(evt);
            }
        });

        buchtickaCalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buchtickaCalcActionPerformed(evt);
            }
        });

        buchtickaClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buchtickaClearActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buchtickaIns1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(jcomboboxCumBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jscrollpaneCumChalice)
                            .addComponent(buchtickaIns2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buchtickaIns3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jscrollpaneFuckBiarynka))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(buchtickaDel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(buchtickaAdd)
                                .addGap(18, 18, 18)
                                .addComponent(jtextfieldJSwingRipsMySoulApart))
                            .addComponent(jlabelMarekMidIziFeed, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buchtickaClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(buchtickaCalc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlabelPogChampIsRacist)
                                    .addComponent(jtextfieldTeamFortressVolvoWhyNoUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buchtickaIns1)
                    .addComponent(buchtickaIns2)
                    .addComponent(buchtickaIns3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jcomboboxCumBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jscrollpaneCumChalice, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addComponent(jscrollpaneFuckBiarynka, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabelMarekMidIziFeed)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buchtickaAdd)
                    .addComponent(jtextfieldJSwingRipsMySoulApart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabelPogChampIsRacist))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buchtickaDel)
                    .addComponent(buchtickaCalc)
                    .addComponent(jtextfieldTeamFortressVolvoWhyNoUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buchtickaClear)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void buchtickaAddActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Integer.parseInt(jtextfieldJSwingRipsMySoulApart.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Zadaná hodnota musí být číslo", "Chyba", JOptionPane.ERROR_MESSAGE);
            return;
        }

        model.add(0, jtextfieldJSwingRipsMySoulApart.getText());
        jlistBottomOfTheWorld.setModel(model);
    }

    private void buchtickaDelActionPerformed(java.awt.event.ActionEvent evt) {
        int index = jlistBottomOfTheWorld.getSelectedIndex();

        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Prvně musíš vybrat položku, pro smazání", "Chyba", JOptionPane.ERROR_MESSAGE);
        }

        model.remove(index);
        jlistBottomOfTheWorld.setModel(model);
    }

    private void buchtickaCalcActionPerformed(java.awt.event.ActionEvent evt) {
        String bottom = jlistBottomOfTheWorld.getSelectedValue();
        String nigma = jlistKdyZacneTundraVsNigma.getSelectedValue();

        if (bottom == null || nigma == null) {
            JOptionPane.showMessageDialog(this, "Musíš vybrat jedno číslo z každého listu", "Chyba", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int res = 0;
        int bottomInt = Integer.parseInt(bottom);
        int nigmaInt = Integer.parseInt(nigma);

        if (jcomboboxCumBox.getSelectedIndex() == 0) {
            res = bottomInt + nigmaInt;
        } else {
            res = bottomInt - nigmaInt;
        }

        jtextfieldTeamFortressVolvoWhyNoUpdate.setText(Integer.toString(res));
    }

    private void buchtickaClearActionPerformed(java.awt.event.ActionEvent evt) {
        jlistKdyZacneTundraVsNigma.setModel(empty);
        jtextfieldTeamFortressVolvoWhyNoUpdate.setText("");
        try {
            ((DefaultListModel)jlistBottomOfTheWorld.getModel()).clear();
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    private void buchtickaIns3ActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultListModel def = new DefaultListModel();
        String[] dflt = { "0", "1", "2", "3", "4", "5" };
        int counter = 0;

        for (String s : dflt){
            def.add(counter, s);
            counter++;
        }

        jlistKdyZacneTundraVsNigma.setModel(def);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Src().setVisible(true);
            }
        });
    }
}
