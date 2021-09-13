import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Src extends javax.swing.JFrame {
    class RadioButton extends javax.swing.JFrame {
        public JRadioButton button = new JRadioButton();
        public int cost;
        public RadioButton(String text, int price, ActionListener actL) {
            button.setText(String.format("%s %d Kč", text, price));
            cost = price;
            if (actL != null) { button.addActionListener(actL); }
        }
    }
    class CheckBox extends javax.swing.JFrame {
        public JCheckBox box = new JCheckBox();
        public int cost;
        public CheckBox(String text, int price, ActionListener actL) {
            box.setText(String.format("%s %d Kč", text, price));
            cost = price;
            if (actL != null) { box.addActionListener(actL); }
        }
    }
    class Field extends javax.swing.JFrame {
        public JTextField field = new JTextField();
        public Field(boolean editable) {
            field.setEditable(editable);
        }
    }
    class Label extends javax.swing.JFrame {
        public JLabel label = new JLabel();
        public Label(String text) {
            label.setText(text);
        }
    }
    class Button extends javax.swing.JFrame {
        public JButton button = new JButton();
        public Button(String text, ActionListener actL) {
            button.setText(text);
            if (actL != null) { button.addActionListener(actL); }
        }
    }

    private int pochutinacost;
    private int foodcost;
    private int drinkcost;
    private ArrayList<Label> Labels;
    private ArrayList<Button> Buttons;
    private ArrayList<CheckBox> CheckBoxes;
    private ArrayList<RadioButton> RadioButtonsF;
    private ArrayList<RadioButton> RadioButtonsD;
    private ArrayList<Field> Fields;

////////////////////////////////////////////////////////////////////////////////

    public Src() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setTitle("Výdej jídla");

        pochutinacost = 0;
        foodcost      = 0;
        drinkcost     = 0;

        CheckBoxes = new ArrayList<CheckBox>();
        CheckBoxes.add(new CheckBox("Zákusek", 45, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                pochutina(evt, 0);
            }
        }));
        CheckBoxes.add(new CheckBox("Tatarka", 15, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                pochutina(evt, 1);
            }
        }));
        CheckBoxes.add(new CheckBox("Salát", 30, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                pochutina(evt, 2);
            }
        }));
        CheckBoxes.add(new CheckBox("Kečup", 15, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                pochutina(evt, 3);
            }
        }));

        RadioButtonsF = new ArrayList<RadioButton>();
        RadioButtonsF.add(new RadioButton("Kuře na smetaně s těstovinami", 65, new ActionListener () {
            public void actionPerformed(ActionEvent evt) {
                food(evt, 0);
            }
        }));
        RadioButtonsF.add(new RadioButton("Řízek s bramborovým salátem", 78, new ActionListener () {
            public void actionPerformed(ActionEvent evt) {
                food(evt, 1);
            }
        }));
        RadioButtonsF.add(new RadioButton("Kančí guláš s knedlíkem", 100, new ActionListener () {
            public void actionPerformed(ActionEvent evt) {
                food(evt, 2);
            }
        }));

        RadioButtonsD = new ArrayList<RadioButton>();
        RadioButtonsD.add(new RadioButton("Točená Kofola", 25, new ActionListener () {
            public void actionPerformed(ActionEvent evt) {
                drink(evt, 0);
            }
        }));
        RadioButtonsD.add(new RadioButton("Minerální voda", 20, new ActionListener () {
            public void actionPerformed(ActionEvent evt) {
                drink(evt, 1);
            }
        }));

        Fields = new ArrayList<Field>();
        Fields.add(new Field(false));
        Fields.add(new Field(false));

        Labels = new ArrayList<Label>();
        Labels.add(new Label("Výdej jídla"));
        Labels.add(new Label("Vyber si jedno jídlo z hlavního chodu: "));
        Labels.add(new Label("Další pochutiny k jídlu:"));
        Labels.add(new Label("Jaké si dáte pití k jídlu:"));
        Labels.add(new Label("celková cena je"));
        Labels.add(new Label("chcete zabalit do krabice příplatek 10 Kč, cena nyní je:"));

        Buttons = new ArrayList<Button>();
        Buttons.add(new Button("Spočítej cenu", new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bCalc(evt);
            }
        }));
        Buttons.add(new Button("Konec objednávky", new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bEnd(evt);
            }
        }));

        init_GUI();
    }

    @SuppressWarnings("unchecked")
    private void init_GUI() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(158, 158, 158)
                                .addComponent(Labels.get(0).label))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Labels.get(2).label)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CheckBoxes.get(0).box)
                                            .addComponent(CheckBoxes.get(2).box))
                                        .addGap(53, 53, 53)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CheckBoxes.get(1).box)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(CheckBoxes.get(3).box)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(Buttons.get(0).button, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Labels.get(1).label)
                                    .addComponent(RadioButtonsF.get(0).button)
                                    .addComponent(RadioButtonsF.get(1).button)
                                    .addComponent(RadioButtonsF.get(2).button))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(RadioButtonsD.get(0).button)
                                    .addComponent(RadioButtonsD.get(1).button)
                                    .addComponent(Labels.get(3).label)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Labels.get(5).label)
                                    .addComponent(Labels.get(4).label))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Fields.get(1).field)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(Fields.get(0).field, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Buttons.get(1).button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Labels.get(0).label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Labels.get(1).label)
                    .addComponent(Labels.get(3).label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RadioButtonsF.get(0).button)
                    .addComponent(RadioButtonsD.get(0).button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RadioButtonsF.get(1).button)
                    .addComponent(RadioButtonsD.get(1).button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RadioButtonsF.get(2).button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Labels.get(2).label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckBoxes.get(0).box)
                    .addComponent(CheckBoxes.get(1).box))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckBoxes.get(2).box)
                    .addComponent(CheckBoxes.get(3).box)
                    .addComponent(Buttons.get(0).button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Labels.get(4).label)
                    .addComponent(Fields.get(0).field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Labels.get(5).label)
                    .addComponent(Fields.get(1).field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Buttons.get(1).button)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        pack();
    }

    private void bEnd(ActionEvent evt) {
        System.exit(0);
    }

    private void bCalc(ActionEvent evt) {
        int currentcost = pochutinacost + foodcost + drinkcost;
        Fields.get(0).field.setText(String.format("%d", currentcost));
        Fields.get(1).field.setText(String.format("%d", currentcost+10));
    }

    private void pochutina(ActionEvent evt, int pos) {
        boolean action = CheckBoxes.get(pos).box.isSelected();
        if (action) {
            for ( CheckBox i : CheckBoxes ) {
                i.box.setSelected(false);
            }
        }
        CheckBoxes.get(pos).box.setSelected(action);
        pochutinacost = action ? CheckBoxes.get(pos).cost : 0;
    }

    private void food(ActionEvent evt, int pos) {
        boolean action = RadioButtonsF.get(pos).button.isSelected();
        if (action) {
            for ( RadioButton i : RadioButtonsF ) {
                i.button.setSelected(false);
            }
        }
        RadioButtonsF.get(pos).button.setSelected(action);
        foodcost = action ? RadioButtonsF.get(pos).cost : 0;
    }

    private void drink(ActionEvent evt, int pos) {
        boolean action = RadioButtonsD.get(pos).button.isSelected();
        if (action) {
            for ( RadioButton i : RadioButtonsD ) {
                i.button.setSelected(false);
            }
        }
        RadioButtonsD.get(pos).button.setSelected(action);
        drinkcost = action ? RadioButtonsD.get(pos).cost : 0;
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
