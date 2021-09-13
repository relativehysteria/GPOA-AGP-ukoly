import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.GroupLayout;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Src extends javax.swing.JFrame {

	private Font defaultFont;

	private String operation;
	private double num1;
	private double num2;
	private double ans;

    private JTextField inputField;
    private JButton bn0;
    private JButton bn1;
    private JButton bn2;
    private JButton bn3;
    private JButton bn4;
    private JButton bn5;
    private JButton bn6;
    private JButton bn7;
    private JButton bn8;
    private JButton bn9;
    private JButton bMinus;
    private JButton bPlus;
    private JButton bDiv;
    private JButton bMul;
	private JButton bEquals;
	private JButton bDecimal;
    private JButton bClear;
    private JButton bSwitch;
	private JButton bLog;
	private JButton bPow;
	private JButton bSqr;
	private JButton bInv;

	/* CONSTRUCTOR */
	public Src() {
		_init();
	}

    @SuppressWarnings("unchecked")
	private void _init() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Calculator 3000");

		defaultFont = new java.awt.Font("Tahoma", 1, 18);

		/* Calc display */
		inputField = new JTextField();
		inputField.setEditable(false);
		inputField.setFont(defaultFont);

		/* Number Button Listeners */
		bn0 = numButton("0");
		bn1 = numButton("1");
		bn2 = numButton("2");
		bn3 = numButton("3");
		bn4 = numButton("4");
		bn5 = numButton("5");
		bn6 = numButton("6");
		bn7 = numButton("7");
		bn8 = numButton("8");
		bn9 = numButton("9");
		bDecimal = numButton("."); /* bDecimal uses NumButton, not MiscButton */

		/* Operator Button Listeners */
		bMinus = opButton("-");
		bPlus  = opButton("+");
		bMul   = opButton("*");
		bDiv   = opButton("/");
		bLog   = opButton("log10(x)", true);
		bPow   = opButton("x^2", true);
		bSqr   = opButton("√x", true);
		bInv   = opButton("1/x", true);

		/* Misc Button listeners */
		bSwitch = miscButton("+/-", new ActionListener () {
			public void actionPerformed(ActionEvent evt) {
				bSwitchAct();
			}
		});
		bClear = miscButton("C", new ActionListener () {
			public void actionPerformed(ActionEvent evt) {
				bClearAct();
			}
		});
		bEquals = miscButton("=", new ActionListener () {
			public void actionPerformed(ActionEvent evt) {
				bEqualsAct();
			}
		});

		int width     = 100;
		int height    = 60;
		int padding   =  5;
		int ifpadding = padding + 15;
		initGUI(width, height, padding, ifpadding);
	}

/* #### MISC INITIATORS ##################################################### */

	private void initGUI(
		int oneWidth,         /* Width of one button */
		int oneHeight,        /* Height of one button */
		int padding,          /* Padding between buttons */
		int inputFieldPadding /* Vertical padding of the inputField */
	) {
		int PSIZ  = GroupLayout.PREFERRED_SIZE;
		GroupLayout.Alignment ALIGN_BASE = GroupLayout.Alignment.BASELINE;

		GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup()
                    .addComponent(inputField)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bn1, PSIZ, oneWidth, PSIZ)
                        .addGap(padding)
                        .addComponent(bn2, PSIZ, oneWidth, PSIZ)
                        .addGap(padding)
                        .addComponent(bn3, PSIZ, oneWidth, PSIZ)
                        .addGap(padding)
                        .addComponent(bn4, PSIZ, oneWidth, PSIZ)
                        .addGap(padding)
						.addComponent(bLog, PSIZ, oneWidth, PSIZ))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bn5, PSIZ, oneWidth, PSIZ)
                        .addGap(padding)
                        .addComponent(bn6, PSIZ, oneWidth, PSIZ)
                        .addGap(padding)
                        .addComponent(bn7, PSIZ, oneWidth, PSIZ)
                        .addGap(padding)
                        .addComponent(bn8, PSIZ, oneWidth, PSIZ)
						.addGap(padding)
						.addComponent(bPow, PSIZ, oneWidth, PSIZ))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bn9, PSIZ, oneWidth, PSIZ)
                        .addGap(padding)
                        .addComponent(bn0, PSIZ, oneWidth, PSIZ)
                        .addGap(padding)
                        .addComponent(bPlus, PSIZ, oneWidth, PSIZ)

                        .addGap(padding)
                        .addComponent(bMinus, PSIZ, oneWidth, PSIZ)
                        .addGap(padding)
                        .addComponent(bSqr, PSIZ, oneWidth, PSIZ))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bDiv, PSIZ, oneWidth, PSIZ)
                        .addGap(padding)
                        .addComponent(bMul, PSIZ, oneWidth, PSIZ)
                        .addGap(padding)
                        .addComponent(bSwitch, PSIZ, oneWidth, PSIZ)
                        .addGap(padding)
                        .addComponent(bDecimal, PSIZ, oneWidth, PSIZ)
                        .addGap(padding)
                        .addComponent(bInv, PSIZ, oneWidth, PSIZ))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bClear, PSIZ, oneWidth*2 + padding, PSIZ)
                        .addGap(padding)
                        .addComponent(bEquals, PSIZ, oneWidth*3 + padding*2, PSIZ)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.setVerticalGroup(
            layout.createParallelGroup()
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(inputFieldPadding, inputFieldPadding, inputFieldPadding)
                .addComponent(inputField, PSIZ, oneHeight, PSIZ)
                .addGap(inputFieldPadding, inputFieldPadding, inputFieldPadding)
                .addGroup(layout.createParallelGroup(ALIGN_BASE)
                    .addComponent(bn1, PSIZ, oneHeight, PSIZ)
                    .addComponent(bn2, PSIZ, oneHeight, PSIZ)
                    .addComponent(bn3, PSIZ, oneHeight, PSIZ)
                    .addComponent(bn4, PSIZ, oneHeight, PSIZ)
                    .addComponent(bLog, PSIZ, oneHeight, PSIZ))
                .addGap(padding)
                .addGroup(layout.createParallelGroup(ALIGN_BASE)
                    .addComponent(bn5, PSIZ, oneHeight, PSIZ)
                    .addComponent(bn6, PSIZ, oneHeight, PSIZ)
                    .addComponent(bn7, PSIZ, oneHeight, PSIZ)
                    .addComponent(bn8, PSIZ, oneHeight, PSIZ)
                    .addComponent(bPow, PSIZ, oneHeight, PSIZ))
                .addGap(padding)
                .addGroup(layout.createParallelGroup(ALIGN_BASE)
                    .addComponent(bn9, PSIZ, oneHeight, PSIZ)
                    .addComponent(bn0, PSIZ, oneHeight, PSIZ)
                    .addComponent(bPlus, PSIZ, oneHeight, PSIZ)
                    .addComponent(bMinus, PSIZ, oneHeight, PSIZ)
                    .addComponent(bSqr, PSIZ, oneHeight, PSIZ))
                .addGap(padding)
                .addGroup(layout.createParallelGroup(ALIGN_BASE)
                    .addComponent(bDiv, PSIZ, oneHeight, PSIZ)
                    .addComponent(bMul, PSIZ, oneHeight, PSIZ)
                    .addComponent(bSwitch, PSIZ, oneHeight, PSIZ)
                    .addComponent(bDecimal, PSIZ, oneHeight, PSIZ)
                    .addComponent(bInv, PSIZ, oneHeight, PSIZ))
                .addGap(padding)
                .addGroup(layout.createParallelGroup(ALIGN_BASE)
                    .addComponent(bClear, PSIZ, oneHeight+padding, PSIZ)
                    .addComponent(bEquals, PSIZ, oneHeight+padding, PSIZ)))
        );

		pack();
	}

	private JButton numButton(String bttnNum) {
		return miscButton(bttnNum, new ActionListener () {
			public void actionPerformed(ActionEvent evt) {
				bnAct(bttnNum);
			}
		});
	}

	private JButton opButton(String bttnOp) {
		return opButton(bttnOp, false);
	}
	private JButton opButton(String bttnOp, boolean immediateEqual) {
		return miscButton(bttnOp, new ActionListener () {
			public void actionPerformed(ActionEvent evt) {
				bOp(bttnOp, immediateEqual);
			}
		});
	}

	private JButton miscButton(
		String buttonText,
		ActionListener listener
	) {
		JButton button = new JButton();
		button.setFont(defaultFont);
		button.setText(buttonText);
		button.addActionListener(listener);
		return button;
	}

/* #### DEFAULT EVENT HANDLERS ############################################## */
	private void bnAct(String nToAdd) {
		String inputNum = inputField.getText() + nToAdd;
		inputField.setText(inputNum);
	}

	private void bOp(String op, boolean immediateEqual) {
		num1 = Double.parseDouble(inputField.getText());
		inputField.setText("");
		operation = op;
		if (immediateEqual) {
			inputField.setText("2");
			bEqualsAct();
		}
	}

/* #### MISC EVENT HANDLERS ################################################# */

	private void bClearAct() {
		num1 = 0;
		num2 = 0;
		ans  = 0;
		inputField.setText("");
	}

	private void bEqualsAct() {
		num2 = Double.parseDouble(inputField.getText());

		switch (operation) {
			case "+":        ans = num1 + num2;          break;
			case "-":        ans = num1 - num2;          break;
			case "*":        ans = num1 * num2;          break;
			case "/":        ans = num1 / num2;          break;
			case "log10(x)": ans = Math.log10(num1);     break;
			case "x^2":      ans = Math.pow(num1, num2); break;
			case "√x":       ans = Math.sqrt(num1);      break;
			case "1/x":      ans = 1.0/num1;             break;
			default:         break;
		}

		String res = Double.toString(ans);
		bClearAct();
		inputField.setText(res);
	}

	private void bSwitchAct() {
		num1 = Double.parseDouble(inputField.getText());
		num1 *= -1;
		inputField.setText(Double.toString(num1));
	}

/* #### MAIN FUNCTION ####################################################### */

	public static void main(String args[]) {
        try {
            for (
				UIManager.LookAndFeelInfo info :
				UIManager.getInstalledLookAndFeels()
			) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
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
