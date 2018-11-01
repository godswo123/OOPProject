package Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class User {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User window = new User();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public User() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(250, 235, 215));
		frame.setBounds(100, 100, 900,700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("BookMyHotel");
		label.setBounds(21, 11, 320, 65);
		label.setForeground(new Color(102, 0, 51));
		label.setFont(new Font("Consolas", Font.BOLD, 40));
		label.setBackground(Color.WHITE);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("-Your Stay our Responsibility");
		label_1.setBounds(277, 11, 386, 65);
		label_1.setForeground(new Color(102, 0, 51));
		label_1.setFont(new Font("Consolas", Font.PLAIN, 23));
		frame.getContentPane().add(label_1);
		
		JLabel Home_label = new JLabel("");
		Home_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		Home_label.setBounds(834, 11, 40, 54);
		frame.getContentPane().add(Home_label);
	}
}
