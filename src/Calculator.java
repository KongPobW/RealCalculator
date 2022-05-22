import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Color;

public class Calculator extends JFrame {

	private JPanel calPanel;
	private JLabel label;
	private JTextField input;
	private JButton btn0;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btnC;
	private JButton btnBack;
	private JButton btnEql;
	private JButton btnPlus;
	private JButton btnMinus;
	private JButton btnMulti;
	private JButton btnDivide;
	private JButton btnDot;
	private JRadioButton rdOn;
	private JRadioButton rdOff;
	
	private double num, ans;
	private char calculation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculator() {
		setTitle("Calculator");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\kongp\\IdeaProjects\\RealCalculator\\icon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 274, 367);
		calPanel = new JPanel();
		calPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(calPanel);
		calPanel.setLayout(null);
		
		input = new JTextField();
		input.setEditable(false);
		input.setHorizontalAlignment(SwingConstants.RIGHT);
		input.setFont(new Font("Tahoma", Font.BOLD, 23));
		input.setBounds(7, 21, 245, 43);
		calPanel.add(input);
		input.setColumns(10);
		
		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(Color.RED);
		label.setBounds(202, 3, 50, 13);
		calPanel.add(label);
		
		btnFunction();
		btnNumber();
		btnOperator();
	}
	
	private void calculate() {
		switch (calculation) {
			case '+':
				ans = num + Double.parseDouble(input.getText());
				input.setText(Double.toString(ans));
				break;
			case '-':
				ans = num - Double.parseDouble(input.getText());
				input.setText(Double.toString(ans));
				break;
			case '*':
				ans = num * Double.parseDouble(input.getText());
				input.setText(Double.toString(ans));
				break;
			case '/':
				ans = num / Double.parseDouble(input.getText());
				input.setText(Double.toString(ans));
				break;
		}
	}
	
	private void btnFunction() {
		rdOn = new JRadioButton("ON");
		rdOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean status = true;
				rdOff.setSelected(false);
				controlPower(status);
			}
		});
		rdOn.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdOn.setBounds(7, 70, 49, 21);
		rdOn.setSelected(true);
		calPanel.add(rdOn);
		
		rdOff = new JRadioButton("OFF");
		rdOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean status = false;
				rdOn.setSelected(false);
				controlPower(status);
			}
		});
		rdOff.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdOff.setBounds(7, 97, 49, 21);
		calPanel.add(rdOff);
		
		btnBack = new JButton("<-");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int length = input.getText().length();
				int number = input.getText().length() - 1;
				String txtRest = input.getText();
				StringBuilder back = new StringBuilder(input.getText());
				
				if (length > 0) {
					back.deleteCharAt(number);
					txtRest = back.toString();
					input.setText(txtRest);
				}
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.setBounds(75, 87, 49, 33);
		calPanel.add(btnBack);
		
		btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input.setText("");
			}
		});
		btnC.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnC.setBounds(139, 87, 49, 33);
		calPanel.add(btnC);
	}
	
	private void btnOperator() {
		btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num = Double.parseDouble(input.getText());
				calculation = '+';
				input.setText("");
				label.setText(num + "+");
			}
		});
		btnPlus.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPlus.setBounds(203, 87, 49, 33);
		calPanel.add(btnPlus);
		
		btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num = Double.parseDouble(input.getText());
				calculation = '-';
				input.setText("");
				label.setText(num + "-");
			}
		});
		btnMinus.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMinus.setBounds(203, 133, 49, 33);
		calPanel.add(btnMinus);
		
		btnMulti = new JButton("*");
		btnMulti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num = Double.parseDouble(input.getText());
				calculation = '*';
				input.setText("");
				label.setText(num + "*");
			}
		});
		btnMulti.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMulti.setBounds(203, 179, 49, 33);
		calPanel.add(btnMulti);
		
		btnDivide = new JButton("/");
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num = Double.parseDouble(input.getText());
				calculation = '/';
				input.setText("");
				label.setText(num + "/");
			}
		});
		btnDivide.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDivide.setBounds(203, 225, 49, 33);
		calPanel.add(btnDivide);
		
		btnDot = new JButton(".");
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input.setText(input.getText() + ".");
			}
		});
		btnDot.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDot.setBounds(73, 271, 49, 33);
		calPanel.add(btnDot);
		
		btnEql = new JButton("=");
		btnEql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate();
				label.setText("");
			}
		});
		btnEql.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEql.setBounds(139, 271, 111, 33);
		calPanel.add(btnEql);
	}
	
	private void btnNumber() {
		btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input.setText(input.getText() + "7");
			}
		});
		btn7.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn7.setBounds(10, 133, 49, 33);
		calPanel.add(btn7);
		
		btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input.setText(input.getText() + "8");
			}
		});
		btn8.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn8.setBounds(75, 133, 49, 33);
		calPanel.add(btn8);
		
		btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input.setText(input.getText() + "9");
			}
		});
		btn9.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn9.setBounds(139, 133, 49, 33);
		calPanel.add(btn9);
		
		btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input.setText(input.getText() + "4");
			}
		});
		btn4.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn4.setBounds(10, 179, 49, 33);
		calPanel.add(btn4);
		
		btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input.setText(input.getText() + "5");
			}
		});
		btn5.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn5.setBounds(73, 179, 49, 33);
		calPanel.add(btn5);
		
		btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input.setText(input.getText() + "6");
			}
		});
		btn6.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn6.setBounds(139, 179, 49, 33);
		calPanel.add(btn6);
		
		btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input.setText(input.getText() + "1");
			}
		});
		btn1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn1.setBounds(10, 225, 49, 33);
		calPanel.add(btn1);
		
		btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input.setText(input.getText() + "2");
			}
		});
		btn2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn2.setBounds(73, 225, 49, 33);
		calPanel.add(btn2);
		
		btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input.setText(input.getText() + "3");
			}
		});
		btn3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn3.setBounds(139, 225, 49, 33);
		calPanel.add(btn3);
		
		btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input.setText(input.getText() + "0");
			}
		});
		btn0.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn0.setBounds(10, 271, 49, 33);
		calPanel.add(btn0);
	}
	
	private void controlPower(boolean status) {
		input.setEnabled(status);
		btn0.setEnabled(status);
		btn1.setEnabled(status);
		btn2.setEnabled(status);
		btn3.setEnabled(status);
		btn4.setEnabled(status);
		btn5.setEnabled(status);
		btn6.setEnabled(status);
		btn7.setEnabled(status);
		btn8.setEnabled(status);
		btn9.setEnabled(status);
		btnC.setEnabled(status);
		btnBack.setEnabled(status);
		btnEql.setEnabled(status);
		btnPlus.setEnabled(status);
		btnMinus.setEnabled(status);
		btnMulti.setEnabled(status);
		btnDivide.setEnabled(status);
		btnDot.setEnabled(status);
	}
}