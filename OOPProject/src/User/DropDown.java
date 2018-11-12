package User;

import javax.swing.JPanel;

import Login.LoginFrame;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EtchedBorder;

public class DropDown extends JPanel {

	/**
	 * Create the panel.
	 */
	
	Color high = new Color(0xffa07a);
	Color norm = new Color(0xffdab9);
	
	
	public DropDown(String username,JFrame jFrame) {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		setBounds(712,13,158,52);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(new Color(0xffebcd));
				setSize(getWidth(), 151);
			}
		});
		
		
		
		ImageIcon settingIcon = new ImageIcon(getClass().getResource("/settings.png"));
		ImageIcon userIcon = new ImageIcon(getClass().getResource("/User.png"));
		ImageIcon logoutIcon = new ImageIcon(getClass().getResource("/Logout.png"));
		ImageIcon personicon = new ImageIcon(getClass().getResource("/person-icon.png"));
		
		setBackground(norm);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel.setBackground(high);
			}
			public void mouseExited(MouseEvent me)
			{
				panel.setBackground(norm);
			}
			public void mouseClicked(MouseEvent me)
			{
				new UserFrame(username).setVisible(true);
				jFrame.dispose();
			}
		});
		panel.setBounds(0, 50, 158, 52);
		add(panel);
		panel.setBackground(norm);
		panel.setLayout(null);
		
		JLabel lblProfileIcon = new JLabel("");
		lblProfileIcon.setBounds(12, 9, 42, 36);
		panel.add(lblProfileIcon);
		lblProfileIcon.setIcon(personicon);
		
		JLabel lblUserProfile = new JLabel("<dynamic>");
		lblUserProfile.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblUserProfile.setBounds(51, 9, 95, 36);
		panel.add(lblUserProfile);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1.setBackground(high);
			}
			public void mouseExited(MouseEvent me)
			{
				panel_1.setBackground(norm);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				new LoginFrame().setVisible(true);
				jFrame.dispose();
			}
		});
		panel_1.setBounds(0, 99, 158, 52);
		add(panel_1);
		panel_1.setBackground(norm);
		panel_1.setLayout(null);
		
		JLabel lblLogoutIcon = new JLabel("");
		lblLogoutIcon.setBounds(12, 9, 42, 36);
		panel_1.add(lblLogoutIcon);
		lblLogoutIcon.setIcon(logoutIcon);
		
		JLabel lblLogout = new JLabel("Log Out");
		lblLogout.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblLogout.setBounds(51, 9, 95, 36);
		panel_1.add(lblLogout);
		
		JLabel lblUserIcon = new JLabel("");
		lblUserIcon.setBounds(12, 2, 42, 49);
		add(lblUserIcon);
		lblUserIcon.setIcon(userIcon);
		
		JLabel lblUserName = new JLabel("<dynamic>");
		lblUserName.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblUserName.setBounds(51, 2, 95, 49);
		add(lblUserName);
		lblUserName.setText(username);
		
		lblUserProfile.setText(username);
	}
	
	public void resize()
	{
		setBackground(norm);
		setSize(getWidth(), 52);
	}
}
