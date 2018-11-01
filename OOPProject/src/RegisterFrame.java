import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldDOB;
	private JTextField textFieldEmailID;
	private static RegisterFrame frame;
	private JTextField textFieldUsername;
	private JPasswordField passwordFieldFirst;
	private JPasswordField passwordFieldSecond;
	private JTextField textFieldAddress;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new RegisterFrame();
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
	public RegisterFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setForeground(Color.MAGENTA);
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegister = new JLabel("Registeration");
		lblRegister.setForeground(Color.RED);
		lblRegister.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 22));
		lblRegister.setBounds(314, 74, 185, 43);
		contentPane.add(lblRegister);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblName.setBounds(144, 178, 83, 35);
		contentPane.add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(345, 186, 194, 22);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth  :");
		lblDateOfBirth.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblDateOfBirth.setBounds(144, 226, 142, 35);
		contentPane.add(lblDateOfBirth);
		
		textFieldDOB = new JTextField();
		textFieldDOB.setColumns(10);
		textFieldDOB.setBounds(345, 234, 194, 22);
		contentPane.add(textFieldDOB);
		
		JLabel lblEmailId = new JLabel("Email ID :");
		lblEmailId.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblEmailId.setBounds(144, 274, 102, 35);
		contentPane.add(lblEmailId);
		
		textFieldEmailID = new JTextField();
		textFieldEmailID.setColumns(10);
		textFieldEmailID.setBounds(345, 282, 194, 22);
		contentPane.add(textFieldEmailID);
		
		JButton btnBackToHome = new JButton("Back to Home");
		btnBackToHome.setForeground(Color.BLUE);
		btnBackToHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomeFrame frame = new WelcomeFrame();
				frame.setVisible(true);
				dispose();
			}
		});
		btnBackToHome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBackToHome.setBounds(12, 13, 131, 25);
		contentPane.add(btnBackToHome);
		
		JLabel label = new JLabel("Username :");
		label.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		label.setBounds(144, 401, 119, 35);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Password :");
		label_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		label_1.setBounds(144, 449, 119, 35);
		contentPane.add(label_1);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setColumns(10);
		textFieldUsername.setBounds(345, 409, 194, 22);
		contentPane.add(textFieldUsername);
		
		passwordFieldFirst = new JPasswordField();
		passwordFieldFirst.setBounds(345, 457, 194, 22);
		contentPane.add(passwordFieldFirst);
		
		passwordFieldSecond = new JPasswordField();
		passwordFieldSecond.setBounds(345, 505, 194, 22);
		contentPane.add(passwordFieldSecond);
		
		JLabel label_2 = new JLabel("Renter Password :");
		label_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		label_2.setBounds(144, 497, 174, 35);
		contentPane.add(label_2);
		
		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) 
			{
				if(!User.checkAvailability(textFieldUsername.getText()))
					JOptionPane.showMessageDialog(null, "Error", "Username Not Availabel", JOptionPane.ERROR_MESSAGE);
				else
				if(!passwordFieldFirst.getText().equals(passwordFieldSecond.getText()))
					JOptionPane.showMessageDialog(null, "Warning", "Passwords Don't Match", JOptionPane.WARNING_MESSAGE);
				else
				{
					User.register(textFieldName.getText(), textFieldDOB.getText(), textFieldEmailID.getText(), textFieldUsername.getText(), passwordFieldFirst.getText(), textFieldAddress.getText());
					JOptionPane.showMessageDialog(null, "Information", "Registration Successful", JOptionPane.INFORMATION_MESSAGE);
					LoginFrame lFrame = new LoginFrame();
					lFrame.setVisible(true);
					dispose();
				}
			}
		});
		button.setForeground(Color.BLUE);
		button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button.setBounds(314, 585, 119, 35);
		contentPane.add(button);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblAddress.setBounds(144, 332, 119, 35);
		contentPane.add(lblAddress);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(345, 330, 194, 43);
		contentPane.add(textFieldAddress);
	}
}
