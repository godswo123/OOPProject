package User;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class user {

	JFrame Welcome_frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user window = new user();
					window.Welcome_frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public user() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Welcome_frame = new JFrame();
		Welcome_frame.getContentPane().setBackground(new Color(250, 235, 215));
		Welcome_frame.getContentPane().setForeground(new Color(0, 255, 255));
		Welcome_frame.setBounds(180, 30, 900, 700);
		Welcome_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Welcome_frame.getContentPane().setLayout(null);
		Welcome_frame.setTitle("BookMyHotel");
		
		//JLayeredPane userpane=new JLayeredPane();
		//Welcome_frame.add(userpane);
		
		//userpane.add(label, new Integer(1));
		JLabel lblNewLabel = new JLabel("BookMyHotel");
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 45));
		lblNewLabel.setForeground(new Color(102, 0, 51));
		lblNewLabel.setBounds(88, 26, 310, 61);
		Welcome_frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("-Your Stay our Responsibility");
		lblNewLabel_1.setFont(new Font("Consolas", Font.ITALIC, 25));
		lblNewLabel_1.setForeground(new Color(102, 0, 51));
		lblNewLabel_1.setBounds(378, 23, 446, 64);
		Welcome_frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Explore hotels starting");
		lblNewLabel_2.setFont(new Font("Cooper Black", Font.ITALIC, 25));
		lblNewLabel_2.setForeground(new Color(102, 0, 51));
		lblNewLabel_2.setBounds(141, 138, 576, 95);
		Welcome_frame.getContentPane().add(lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("from INR 1000");
		lblNewLabel_3.setFont(new Font("Cooper Black", Font.ITALIC, 25));
		lblNewLabel_3.setForeground(new Color(102, 0, 51));
		lblNewLabel_3.setBounds(141, 203, 576, 111);
		Welcome_frame.getContentPane().add(lblNewLabel_3);
		JLabel lblNewLabel_4 = new JLabel("for the perfect holiday");
		lblNewLabel_4.setFont(new Font("Cooper Black", Font.ITALIC, 25));
		lblNewLabel_4.setForeground(new Color(102, 0, 51));
		lblNewLabel_4.setBounds(141, 277, 576, 111);
		Welcome_frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("MyBookings");
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setForeground(Color.WHITE);
	    btnNewButton.setFont(new Font("Cooper Black", Font.ITALIC, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(88, 471, 180, 85);
		Welcome_frame.getContentPane().add(btnNewButton);
		
		//userpane.add(btnNewButton, new Integer(2));
		//userpane.setVisible(true);
		
	    
	    JButton btnBookAHotel = new JButton("Book a Hotel");
	    btnBookAHotel.setBackground(Color.BLUE);
	    btnBookAHotel.setForeground(Color.WHITE);
	    btnBookAHotel.setFont(new Font("Cooper Black", Font.ITALIC, 20));
	    btnBookAHotel.setBounds(344, 471, 171, 85);
	    Welcome_frame.getContentPane().add(btnBookAHotel);
	    
	    JButton btnAccountSettings = new JButton("Account Settings");
	    btnAccountSettings.setBackground(Color.BLUE);
	    btnAccountSettings.setForeground(Color.WHITE);
	    btnAccountSettings.setFont(new Font("Cooper Black", Font.ITALIC, 20));
	    btnAccountSettings.setBounds(605, 471, 220, 85);
	    Welcome_frame.getContentPane().add(btnAccountSettings);
	    
	    JLabel label = new JLabel("");
		Image img2=new ImageIcon(this.getClass().getResource("/hoteluser.jpg")).getImage();
		label.setIcon(new ImageIcon(img2));
		label.setBounds(0, 382, 884, 250);
	    Welcome_frame.getContentPane().add(label);
		Welcome_frame.setVisible(true);
	}
}
