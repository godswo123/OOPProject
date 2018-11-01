import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomeFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeFrame frame = new WelcomeFrame();	//test5
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
	public WelcomeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));//
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToOnline = new JLabel("Welcome");
		lblWelcomeToOnline.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 28));
		lblWelcomeToOnline.setBounds(341, 36, 150, 55);
		contentPane.add(lblWelcomeToOnline);
		
		JLabel lblHotelBookingSystem = new JLabel("Hotel Booking System");
		lblHotelBookingSystem.setForeground(Color.RED);
		lblHotelBookingSystem.setBackground(Color.WHITE);
		lblHotelBookingSystem.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 28));
		lblHotelBookingSystem.setBounds(247, 91, 366, 63);
		contentPane.add(lblHotelBookingSystem);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(Color.BLUE);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				LoginFrame loginFrame = new LoginFrame();
				loginFrame.setVisible(true);
				dispose();
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogin.setBounds(429, 223, 113, 26);
		contentPane.add(btnLogin);
		
		JLabel lblAlreadyRegistered = new JLabel("Already Registered?");
		lblAlreadyRegistered.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblAlreadyRegistered.setBounds(247, 223, 150, 26);
		contentPane.add(lblAlreadyRegistered);
		
		JLabel lblNewUser = new JLabel("New User?");
		lblNewUser.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewUser.setBounds(247, 275, 150, 26);
		contentPane.add(lblNewUser);
		
		JButton btnSignup = new JButton("SignUp");
		btnSignup.setForeground(Color.BLUE);
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				RegisterFrame registerFrame = new RegisterFrame();
				registerFrame.setVisible(true);
				dispose();
			}
		});
		btnSignup.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSignup.setBounds(429, 277, 113, 26);
		contentPane.add(btnSignup);
	}

}
