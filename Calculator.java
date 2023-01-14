import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.util.ArrayList;

public class Calculator extends JFrame {
	private static ArrayList<JButton> theButtons = new ArrayList<JButton>();
	private JPanel contentPane;
	private static int firstNum = 0;
	private static int secondNum = 0;
	private static int sum;
	private JLabel sumLabel;
	private static JButton addButton;
	private JButton subtractButton;
	private static String action = "Add"; // by default
	private static boolean firstDeclared = false;
	private static boolean secondDeclared = false;

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
	
	public static void setButtonsPlain() {
		for (JButton i: theButtons) {
			System.out.println("Changed for "+ i.getText());
			i.setFont(new Font(i.getFont().getFontName(), Font.PLAIN, 24));
		}
	}
	
	public ActionListener actionThing(JButton theButton) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(theButton.getText());
				if (theButton.getText().equals("=")) {
					if (firstNum == 0 && secondNum == 0) {
						System.out.println("returned - values were not inputted correctly");
						return;
					}
					if (action.equals("Add")) {
						sum = firstNum + secondNum;
					}
					if (action.equals("Subtract")) {
						sum = firstNum - secondNum;
					}
					sumLabel.setText(String.valueOf(sum));
				}
				
				if (theButton.getText().equals("+") || theButton.getText().equals("-") || theButton.getText().equals("CLR")) {
					System.out.println("is add/sub button");
					if (theButton.getText().equals("+")) {
						System.out.println("Addition");
						action = "Add";
					}
					if (theButton.getText().equals("-")) {
						System.out.println("Subtraction");
						action = "Subtract";
					}
					if (theButton.getText().equals("CLR")) {
						firstNum = 0;
						secondNum = 0;
						sumLabel.setText("0");
						firstDeclared = false;
						secondDeclared = false;
					}
//					theButton.setFont(new Font(theButton.getFont().getFontName(), Font.PLAIN, theButton.getFont().getSize()));
//					setButtonsPlain();
				}
				
				// -- the number buttons
				if (!theButton.getText().equals("=") && !theButton.getText().equals("+") && !theButton.getText().equals("-") && !theButton.getText().equals("CLR")) {
					System.out.println("is a number");
					if (!firstDeclared) {
						firstDeclared = true;
						secondDeclared = false;
						firstNum = Integer.valueOf(theButton.getText());
						sumLabel.setText(String.valueOf(firstNum));
						System.out.println("The first num is "+ String.valueOf(firstNum));
						return;
					}
					if (!secondDeclared) {
						secondDeclared = true;
						firstDeclared = false;
						secondNum = Integer.valueOf(theButton.getText());
						sumLabel.setText(String.valueOf(secondNum));
						System.out.println("The second num is "+ String.valueOf(secondNum));
						return;
					}
				}
			}
		};
	}
	public Calculator() {
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 373, 409);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("=");
//		theButtons.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.addActionListener(actionThing(btnNewButton));
		btnNewButton.setBounds(286, 326, 63, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("1");
		btnNewButton_1.addActionListener(actionThing(btnNewButton_1));
//		theButtons.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton_1.setBounds(31, 291, 63, 36);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("2");
		btnNewButton_1_1.addActionListener(actionThing(btnNewButton_1_1));
//		theButtons.add(btnNewButton_1_1);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton_1_1.setBounds(102, 291, 63, 36);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("3");
		btnNewButton_1_1_1.addActionListener(actionThing(btnNewButton_1_1_1));
//		theButtons.add(btnNewButton_1_1_1);
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton_1_1_1.setBounds(178, 291, 63, 36);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("4");
		btnNewButton_1_1_1_1.addActionListener(actionThing(btnNewButton_1_1_1_1));
//		theButtons.add(btnNewButton_1_1_1_1);
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton_1_1_1_1.setBounds(31, 245, 63, 36);
		contentPane.add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("5");
		btnNewButton_1_1_1_1_1.addActionListener(actionThing(btnNewButton_1_1_1_1_1));
//		theButtons.add(btnNewButton_1_1_1_1_1);
		btnNewButton_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton_1_1_1_1_1.setBounds(102, 245, 63, 36);
		contentPane.add(btnNewButton_1_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_2 = new JButton("6");
		btnNewButton_1_1_1_1_2.addActionListener(actionThing(btnNewButton_1_1_1_1_2));
//		theButtons.add(btnNewButton_1_1_1_1_2);
		btnNewButton_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton_1_1_1_1_2.setBounds(178, 245, 63, 36);
		contentPane.add(btnNewButton_1_1_1_1_2);
		
		JButton btnNewButton_1_1_1_1_2_1 = new JButton("7");
		btnNewButton_1_1_1_1_2_1.addActionListener(actionThing(btnNewButton_1_1_1_1_2_1));
//		theButtons.add(btnNewButton_1_1_1_1_2_1);
		btnNewButton_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton_1_1_1_1_2_1.setBounds(31, 199, 63, 36);
		contentPane.add(btnNewButton_1_1_1_1_2_1);
		
		JButton btnNewButton_1_1_1_1_2_2 = new JButton("8");
		btnNewButton_1_1_1_1_2_2.addActionListener(actionThing(btnNewButton_1_1_1_1_2_2));
//		theButtons.add(btnNewButton_1_1_1_1_2_2);
		btnNewButton_1_1_1_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton_1_1_1_1_2_2.setBounds(102, 199, 63, 36);
		contentPane.add(btnNewButton_1_1_1_1_2_2);
		
		JButton btnNewButton_1_1_1_1_2_3 = new JButton("9");
		btnNewButton_1_1_1_1_2_3.addActionListener(actionThing(btnNewButton_1_1_1_1_2_3));
//		theButtons.add(btnNewButton_1_1_1_1_2_3);
		btnNewButton_1_1_1_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton_1_1_1_1_2_3.setBounds(178, 199, 63, 36);
		contentPane.add(btnNewButton_1_1_1_1_2_3);
		
		sumLabel = new JLabel("0");
		sumLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sumLabel.setBounds(10, 73, 339, 60);
		contentPane.add(sumLabel);
		
		addButton = new JButton("+");
		theButtons.add(addButton);
		addButton.addActionListener(actionThing(addButton));
		addButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		addButton.setBounds(286, 280, 63, 36);
		contentPane.add(addButton);
		
		subtractButton = new JButton("-");
		theButtons.add(subtractButton);
		subtractButton.addActionListener(actionThing(subtractButton));
		subtractButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		subtractButton.setBounds(286, 234, 63, 36);
		contentPane.add(subtractButton);
		
		JButton btnNewButton_2_1_1 = new JButton("CLR");
		btnNewButton_2_1_1.addActionListener(actionThing(btnNewButton_2_1_1));
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2_1_1.setBounds(286, 184, 63, 36);
		contentPane.add(btnNewButton_2_1_1);
	}
}
