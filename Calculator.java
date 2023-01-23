import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Calculator {

	private JFrame frmCalculator;
	private JTextField txtDisplay;
	
	double firstnum ;
	double secondnum ;
	double result ;
	String operations ;
	String answer ;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
					Calculator window = new Calculator();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculator = new JFrame();
		frmCalculator.setTitle("Calculator");
		frmCalculator.setForeground(Color.DARK_GRAY);
		frmCalculator.setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\Programming\\Academic\\3rd semester\\Problems Solution\\Week11\\src\\_2\\2000px-Calculator_icon.svg.png"));
		frmCalculator.setResizable(false);
		//frmCalculator.setBounds(450, 150, 390, 498);
		frmCalculator.setSize(390, 505);
		frmCalculator.setLocationRelativeTo(null);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculator.getContentPane().setLayout(null);
		
		txtDisplay = new JTextField();
		txtDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDisplay.setForeground(Color.WHITE);
		txtDisplay.setBackground(Color.DARK_GRAY);
		txtDisplay.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtDisplay.setBounds(0, 0, 384, 93);
		frmCalculator.getContentPane().add(txtDisplay);
		txtDisplay.setColumns(10);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String EnterNumber = txtDisplay.getText() + btn7.getText() ;
			txtDisplay.setText(EnterNumber);
				
			}
		});
		btn7.setBackground(Color.LIGHT_GRAY);
		btn7.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btn7.setBounds(0, 92, 91, 76);
		frmCalculator.getContentPane().add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber = txtDisplay.getText() + btn8.getText() ;
				txtDisplay.setText(EnterNumber);
				
			}
		});
		btn8.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btn8.setBackground(Color.LIGHT_GRAY);
		btn8.setBounds(90, 92, 100, 76);
		frmCalculator.getContentPane().add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber = txtDisplay.getText() + btn9.getText() ;
				txtDisplay.setText(EnterNumber);
			}
		});
		btn9.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btn9.setBackground(Color.LIGHT_GRAY);
		btn9.setBounds(189, 92, 96, 76);
		frmCalculator.getContentPane().add(btn9);
		
		JButton btnAdd = new JButton("+");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				firstnum = Double.parseDouble(txtDisplay.getText()) ;
				txtDisplay.setText("");
				operations = "+" ;
				
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnAdd.setBackground(new Color(255, 153, 0));
		btnAdd.setBounds(284, 92, 100, 76);
		frmCalculator.getContentPane().add(btnAdd);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber = txtDisplay.getText() + btn4.getText() ;
				txtDisplay.setText(EnterNumber);
			}
		});
		btn4.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btn4.setBackground(Color.LIGHT_GRAY);
		btn4.setBounds(0, 168, 91, 76);
		frmCalculator.getContentPane().add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber = txtDisplay.getText() + btn5.getText() ;
				txtDisplay.setText(EnterNumber);
			}
		});
		btn5.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btn5.setBackground(Color.LIGHT_GRAY);
		btn5.setBounds(90, 168, 100, 76);
		frmCalculator.getContentPane().add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber = txtDisplay.getText() + btn6.getText() ;
				txtDisplay.setText(EnterNumber);
			}
		});
		btn6.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btn6.setBackground(Color.LIGHT_GRAY);
		btn6.setBounds(189, 168, 96, 76);
		frmCalculator.getContentPane().add(btn6);
		
		JButton btnSub = new JButton("-");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				firstnum = Double.parseDouble(txtDisplay.getText()) ;
				txtDisplay.setText("");
				operations = "-" ;
			}
		});
		btnSub.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnSub.setBackground(new Color(255, 153, 0));
		btnSub.setBounds(284, 168, 100, 76);
		frmCalculator.getContentPane().add(btnSub);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber = txtDisplay.getText() + btn1.getText() ;
				txtDisplay.setText(EnterNumber);
			}
		});
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btn1.setBackground(Color.LIGHT_GRAY);
		btn1.setBounds(0, 244, 91, 76);
		frmCalculator.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber = txtDisplay.getText() + btn2.getText() ;
				txtDisplay.setText(EnterNumber);
			}
		});
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btn2.setBackground(Color.LIGHT_GRAY);
		btn2.setBounds(90, 244, 100, 76);
		frmCalculator.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber = txtDisplay.getText() + btn3.getText() ;
				txtDisplay.setText(EnterNumber);
			}
		});
		btn3.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btn3.setBackground(Color.LIGHT_GRAY);
		btn3.setBounds(189, 244, 96, 76);
		frmCalculator.getContentPane().add(btn3);
		
		JButton btnMul = new JButton("*");
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				firstnum = Double.parseDouble(txtDisplay.getText()) ;
				txtDisplay.setText("");
				operations = "*" ;
			}
		});
		btnMul.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnMul.setBackground(new Color(255, 153, 0));
		btnMul.setBounds(284, 244, 100, 76);
		frmCalculator.getContentPane().add(btnMul);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber = txtDisplay.getText() + btn0.getText() ;
				txtDisplay.setText(EnterNumber);
			}
		});
		btn0.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btn0.setBackground(Color.LIGHT_GRAY);
		btn0.setBounds(0, 320, 91, 76);
		frmCalculator.getContentPane().add(btn0);
		
		JButton btnDot = new JButton(".");
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String dot = txtDisplay.getText() ;
				txtDisplay.setText(dot+".");
			}
		});
		btnDot.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnDot.setBackground(Color.LIGHT_GRAY);
		btnDot.setBounds(90, 320, 100, 76);
		frmCalculator.getContentPane().add(btnDot);
		
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDisplay.setText(null);
			}
		});
		btnC.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnC.setBackground(Color.LIGHT_GRAY);
		btnC.setBounds(189, 320, 96, 76);
		frmCalculator.getContentPane().add(btnC);
		
		JButton btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				firstnum = Double.parseDouble(txtDisplay.getText()) ;
				txtDisplay.setText("");
				operations = "/" ;
			}
		});
		btnDiv.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnDiv.setBackground(new Color(255, 153, 0));
		btnDiv.setBounds(284, 320, 100, 76);
		frmCalculator.getContentPane().add(btnDiv);
		
		JButton btnEqual = new JButton("=");
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String answer ;
				secondnum = Double.parseDouble(txtDisplay.getText()) ;
				if(operations == "+")
				{
					result = firstnum + secondnum ;
					answer = String.format("%.2f", result) ;
					txtDisplay.setText(answer);
				}
				
				else if(operations == "-")
				{
					result = firstnum - secondnum ;
					answer = String.format("%.2f", result) ;
					txtDisplay.setText(answer);
				}
				
				else if(operations == "*")
				{
					result = firstnum * secondnum ;
					answer = String.format("%.2f", result) ;
					txtDisplay.setText(answer);
				}
				
				else if(operations == "/")
				{
					result = firstnum / secondnum ;
					answer = String.format("%.2f", result) ;
					txtDisplay.setText(answer);
				}
				
			}
		});
		btnEqual.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnEqual.setBackground(new Color(0, 102, 51));
		btnEqual.setBounds(0, 393, 190, 76);
		frmCalculator.getContentPane().add(btnEqual);
		
		JButton btnDel = new JButton("Del");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String del = null ;
				if(txtDisplay.getText().length() > 0 ) {
					StringBuilder strB = new StringBuilder(txtDisplay.getText()) ;
					strB.deleteCharAt(txtDisplay.getText().length() - 1 ) ;
					del = strB.toString() ;
					txtDisplay.setText(del);
				}
					
			}
		});
		btnDel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnDel.setBackground(new Color(0, 102, 51));
		btnDel.setBounds(189, 393, 96, 76);
		frmCalculator.getContentPane().add(btnDel);
		
		JButton btnSqrt = new JButton("\u221A");
		btnSqrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstnum = Math.sqrt(Double.parseDouble(txtDisplay.getText())) ;
				String ans = String.format("%.2f", firstnum) ;
				txtDisplay.setText(ans);
				
			}
		});
		btnSqrt.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnSqrt.setBackground(new Color(255, 153, 0));
		btnSqrt.setBounds(284, 393, 100, 76);
		frmCalculator.getContentPane().add(btnSqrt);
	}
}
