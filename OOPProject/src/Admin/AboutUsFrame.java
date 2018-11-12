package Admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import User.DropDown;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AboutUsFrame extends JFrame {

	private JPanel Panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutUsFrame frame = new AboutUsFrame("raghu");
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
	public AboutUsFrame(String username) {
		setTitle("BookMyHotel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(180, 30, 900, 700);
		Panel = new JPanel();

		
		Panel.setBackground(new Color(250, 235, 215));
		Panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Panel);
		Panel.setLayout(null);
		
		JLabel label = new JLabel("-Your Stay our Responsibility");
		label.setForeground(new Color(102, 0, 51));
		label.setFont(new Font("Consolas", Font.ITALIC, 23));
		label.setBounds(277, 11, 399, 65);
		Panel.add(label);
		
		JLabel label_1 = new JLabel("BookMyHotel");
		label_1.setForeground(new Color(102, 0, 51));
		label_1.setFont(new Font("Consolas", Font.BOLD, 40));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(23, 11, 320, 65);
		Panel.add(label_1);
		
		JLabel lblMeetTheTeam = new JLabel("Meet The Team");
		lblMeetTheTeam.setHorizontalAlignment(SwingConstants.CENTER);
		lblMeetTheTeam.setForeground(new Color(102, 0, 51));
		lblMeetTheTeam.setFont(new Font("Constantia", Font.PLAIN, 36));
		lblMeetTheTeam.setBackground(Color.WHITE);
		lblMeetTheTeam.setBounds(246, 116, 320, 65);
		Panel.add(lblMeetTheTeam);
		
		JLabel lblNihalJain = new JLabel("Nihal Jain");
		lblNihalJain.setHorizontalAlignment(SwingConstants.CENTER);
		lblNihalJain.setForeground(new Color(255, 99, 71));
		lblNihalJain.setFont(new Font("Footlight MT Light", Font.PLAIN, 28));
		lblNihalJain.setBackground(Color.WHITE);
		lblNihalJain.setBounds(74, 349, 213, 65);
		Panel.add(lblNihalJain);
		
		JLabel lblRaghuNathan = new JLabel("Raghu Nathan");
		lblRaghuNathan.setForeground(new Color(255, 99, 71));
		lblRaghuNathan.setFont(new Font("Footlight MT Light", Font.PLAIN, 28));
		lblRaghuNathan.setBackground(Color.WHITE);
		lblRaghuNathan.setBounds(323, 217, 213, 65);
		Panel.add(lblRaghuNathan);
		
		JLabel lblAnkitShibu = new JLabel("Ankit Shibu");
		lblAnkitShibu.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnkitShibu.setForeground(new Color(255, 99, 71));
		lblAnkitShibu.setFont(new Font("Footlight MT Light", Font.PLAIN, 28));
		lblAnkitShibu.setBackground(Color.WHITE);
		lblAnkitShibu.setBounds(533, 349, 213, 65);
		Panel.add(lblAnkitShibu);
		
		JLabel lblSimranSandhu = new JLabel("Simran Sandhu");
		lblSimranSandhu.setForeground(new Color(255, 99, 71));
		lblSimranSandhu.setFont(new Font("Footlight MT Light", Font.PLAIN, 28));
		lblSimranSandhu.setBackground(Color.WHITE);
		lblSimranSandhu.setBounds(323, 487, 213, 65);
		Panel.add(lblSimranSandhu);
		
		JLabel lblDevelopers = new JLabel("");
		lblDevelopers.setHorizontalAlignment(SwingConstants.CENTER);
		lblDevelopers.setBounds(299, 308, 222, 150);
		Panel.add(lblDevelopers);
		ImageIcon developersIcon = new ImageIcon(this.getClass().getResource("/developers.png"));
		lblDevelopers.setIcon(developersIcon);
		
		DropDown dropDown = new DropDown(username, this);
		Panel.add(dropDown);
		
		Panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				dropDown.resize();
				
			}
		});
	}

}
