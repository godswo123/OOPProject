import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.*;


public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField textFieldPassword;
	private JTextField textFieldUsername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setForeground(Color.BLUE);
		lblWelcome.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblWelcome.setBounds(321, 38, 116, 40);
		contentPane.add(lblWelcome);
		
		JLabel label_1 = new JLabel("Password :");
		label_1.setFont(new Font("Book Antiqua", Font.PLAIN, 22));
		label_1.setBounds(245, 185, 116, 40);
		contentPane.add(label_1);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke)
			{
				int a = ke.getKeyCode();
				if(a==KeyEvent.VK_ENTER)
				{
					if(User.login(textFieldUsername.getText(),textFieldPassword.getText()))
					{	
						JOptionPane.showMessageDialog(null, "Login Successful", "Login Successful",JOptionPane.INFORMATION_MESSAGE );
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Login Unsuccessful", "Login Unsuccessful",JOptionPane.INFORMATION_MESSAGE );
					}
				}
			}
		});
		textFieldPassword.setBounds(373, 192, 146, 26);
		contentPane.add(textFieldPassword);
		
		JLabel label_2 = new JLabel("Not a User ?");
		label_2.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		label_2.setBounds(321, 377, 116, 26);
		contentPane.add(label_2);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterFrame registerFrame = new RegisterFrame();
				registerFrame.setVisible(true);
				dispose();
			}
		});
		btnSignUp.setForeground(Color.BLUE);
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSignUp.setBounds(321, 416, 116, 28);
		contentPane.add(btnSignUp);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(Color.BLUE);
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0)
			{
				if(User.login(textFieldUsername.getText(),textFieldPassword.getText()))
				{	
					JOptionPane.showMessageDialog(null, "Login Successful", "Login Successful",JOptionPane.INFORMATION_MESSAGE );
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Login Unsuccessful", "Login Unsuccessful",JOptionPane.INFORMATION_MESSAGE );
				}
			}
		});
		
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogin.setBounds(321, 269, 116, 28);
		contentPane.add(btnLogin);
		
		JLabel label = new JLabel("Username :");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Book Antiqua", Font.PLAIN, 22));
		label.setBounds(245, 132, 116, 28);
		contentPane.add(label);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setColumns(10);
		textFieldUsername.setBounds(373, 132, 146, 28);
		contentPane.add(textFieldUsername);
		
		JButton btnBackToHome = new JButton("Back to Home");
		btnBackToHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomeFrame welcomeFrame = new WelcomeFrame();
				welcomeFrame.setVisible(true);
				dispose();
			}
		});
		btnBackToHome.setForeground(Color.BLUE);
		btnBackToHome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBackToHome.setBounds(12, 13, 131, 28);
		contentPane.add(btnBackToHome);
	}
}
