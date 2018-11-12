package User;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.net.PasswordAuthentication;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Login.LoginFrame;
import Login.MyConnection;
import Login.User;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import Admin.MyDate;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SettingsFrame extends JFrame {

	private JPanel Panel;
	private JTextField textFieldName;
	private JPasswordField passwordFieldOPass;
	private JPasswordField passwordFieldNPass;
	private JTextField textFieldemailID;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SettingsFrame frame = new SettingsFrame("raghu");
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
	@SuppressWarnings("restriction")
	public SettingsFrame(String username) {
		Color high = new Color(0xffa07a);
		Color norm = new Color(0xffdab9);
		
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
		
		
		JLabel IntroLabel = new JLabel("Hello "+User.findName(username)+",");
		IntroLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		IntroLabel.setBounds(33, 87, 233, 24);
		Panel.add(IntroLabel);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblName.setBounds(159, 167, 124, 29);
		Panel.add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBounds(377, 167, 204, 29);
		Panel.add(textFieldName);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth :");
		lblDateOfBirth.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblDateOfBirth.setBounds(159, 218, 139, 29);
		Panel.add(lblDateOfBirth);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblAddress.setBounds(159, 287, 124, 21);
		Panel.add(lblAddress);
		
		JTextArea textAreaAddress = new JTextArea();
		textAreaAddress.setForeground(Color.BLACK);
		textAreaAddress.setBounds(376, 274, 204, 53);
		Panel.add(textAreaAddress);
		
		JLabel lblPassword = new JLabel("Old Password :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(159, 464, 184, 26);
		Panel.add(lblPassword);
		
		passwordFieldOPass = new JPasswordField();
		passwordFieldOPass.setBounds(377, 466, 204, 29);
		Panel.add(passwordFieldOPass);
		
		JLabel lblReenterPassword = new JLabel("New Password :");
		lblReenterPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblReenterPassword.setBounds(159, 513, 185, 29);
		Panel.add(lblReenterPassword);
		
		passwordFieldNPass = new JPasswordField();
		passwordFieldNPass.setBounds(377, 513, 204, 29);
		Panel.add(passwordFieldNPass);
		
		JLabel lblEmailid = new JLabel("EmailID :");
		lblEmailid.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblEmailid.setBounds(159, 355, 124, 21);
		Panel.add(lblEmailid);
		
		textFieldemailID = new JTextField();
		textFieldemailID.setColumns(10);
		textFieldemailID.setBounds(377, 354, 204, 29);
		Panel.add(textFieldemailID);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblUsername.setBounds(159, 410, 124, 21);
		Panel.add(lblUsername);
		
		JLabel lblusername = new JLabel("null");
		lblusername.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblusername.setBounds(377, 410, 204, 24);
		Panel.add(lblusername);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSubmit.setBackground(new Color(0, 204, 204));
		btnSubmit.setBounds(321, 585, 89, 42);
		Panel.add(btnSubmit);
		
		ImageIcon settingIcon = new ImageIcon(getClass().getResource("/settings.png"));
		ImageIcon userIcon = new ImageIcon(getClass().getResource("/User.png"));
		ImageIcon logoutIcon = new ImageIcon(getClass().getResource("/Logout.png"));
		ImageIcon personicon = new ImageIcon(getClass().getResource("/person-icon.png"));
		
		lblusername.setText(username);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(377, 218, 204, 29);
		Panel.add(dateChooser);
		Date date = MyDate.getDate(1999, 1, 1);
		dateChooser.setDate(date);
		
		MyConnection.getConnection();
		String query = "select * from userinfo where username = '"+username+"'";
		ResultSet rSet = MyConnection.executeQuery(query);
		
		String name = "";
		java.sql.Date dob = MyDate.convToSqlDate(date);
		String address = "";
		String emailID = "";
		String UserName = "";
		String password = "";
		
		try {
			if(rSet.next()) {
				name = rSet.getString(1);
				dob = rSet.getDate(2);
				address = rSet.getString(3);
				emailID = rSet.getString(4);
				UserName = rSet.getString(5);
				password = rSet.getString(6);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		textFieldName.setText(name);
		textFieldemailID.setText(emailID);
		textAreaAddress.setText(address);
		lblusername.setText(UserName);
		dateChooser.setDate(dob);
		
		JLabel errLabel = new JLabel("");
		errLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		UIManager.put("Button.background", Color.white);
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int a = User.updateInfo(textFieldName.getText(), MyDate.convToSqlDate(dateChooser.getDate()), textAreaAddress.getText(), textFieldemailID.getText(), username, passwordFieldOPass.getText(), passwordFieldNPass.getText());
				if(a==0)
				{
					errLabel.setText("No Field should be left vacant");
					JOptionPane.showMessageDialog(null, errLabel);
				}
				if(a==1)
				{
					errLabel.setText("Old Password Not Matching");
					JOptionPane.showMessageDialog(null, errLabel);
				}
				if(a==2)
				{
					errLabel.setText("Successful Updation!");
					JOptionPane.showMessageDialog(null, errLabel);
					MyConnection.closeConnection();
					new UserFrame(username).setVisible(true);
					dispose();
				}
			}
		});
		
		DropDown dropDown = new DropDown(username,this);
		Panel.add(dropDown);
		
		
		Panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				dropDown.resize();
			}
		});
	}
}
