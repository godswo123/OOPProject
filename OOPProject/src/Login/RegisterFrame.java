package Login;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class RegisterFrame 
{

	JFrame frame;
	private JTextField Name_Field;
	private JTextField DOB_Field;
	private JTextField Add_Field;
	private JTextField Email_Field;
	private JTextField UName_Field;
	private JPasswordField FirstPass_Field;
	Connection conn;
	private JPasswordField RePass_Field;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrame window = new RegisterFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					//e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisterFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(250, 235, 215));
		frame.setBounds(100, 100, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("BookMyHotel");
		JLabel label = new JLabel("BookMyHotel");
		label.setBounds(21, 11, 320, 65);
		label.setForeground(new Color(102, 0, 51));
		label.setFont(new Font("Consolas", Font.BOLD, 40));
		label.setBackground(Color.WHITE);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("-Your Stay our Responsibility");
		label_1.setBounds(277, 11, 386, 65);
		label_1.setForeground(new Color(102, 0, 51));
		label_1.setFont(new Font("Consolas", Font.ITALIC, 23));
		frame.getContentPane().add(label_1);
		
		JLabel Name_Label = new JLabel("Name*");
		Name_Label.setBounds(88, 168, 124, 29);
		Name_Label.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		frame.getContentPane().add(Name_Label);
		
		JLabel DOB_Label = new JLabel("Date Of Birth*");
		DOB_Label.setBounds(88, 219, 139, 29);
		DOB_Label.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		frame.getContentPane().add(DOB_Label);
		
		JLabel Add_Label = new JLabel("Address*");
		Add_Label.setBounds(88, 288, 124, 21);
		Add_Label.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		frame.getContentPane().add(Add_Label);
		
		JLabel Email_Label = new JLabel("EmailID*");
		Email_Label.setBounds(88, 356, 124, 21);
		Email_Label.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		frame.getContentPane().add(Email_Label);
		
		JLabel UName_Label = new JLabel("UserName*");
		UName_Label.setBounds(88, 413, 124, 21);
		UName_Label.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		frame.getContentPane().add(UName_Label);
		
		JLabel First_Pass = new JLabel("Password*");
		First_Pass.setBounds(88, 465, 124, 26);
		First_Pass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(First_Pass);
		
		JLabel Re_Pass = new JLabel("Reenter Password*");
		Re_Pass.setBounds(88, 514, 185, 29);
		Re_Pass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(Re_Pass);
		
		Name_Field = new JTextField();
		Name_Field.setBounds(306, 168, 204, 29);
		frame.getContentPane().add(Name_Field);
		Name_Field.setColumns(10);
		
		DOB_Field = new JTextField();
		DOB_Field.setBounds(306, 219, 204, 29);
		frame.getContentPane().add(DOB_Field);
		DOB_Field.setColumns(10);
		
		Add_Field = new JTextField();
		Add_Field.setBounds(306, 275, 204, 53);
		frame.getContentPane().add(Add_Field);
		Add_Field.setColumns(10);
		
		Email_Field =  new JTextField();
		Email_Field.setBounds(306, 355, 204, 29);
		frame.getContentPane().add(Email_Field);
		Email_Field.setColumns(10);
		
		UName_Field = new JTextField();
		UName_Field.setBounds(306, 412, 204, 29);
		frame.getContentPane().add(UName_Field);
		UName_Field.setColumns(10);
		
		FirstPass_Field = new JPasswordField();
		FirstPass_Field.setBounds(306, 465, 204, 26);
		frame.getContentPane().add(FirstPass_Field);
		
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(363, 598, 89, 42);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkRegistration(frame);
			}
		});
		btnNewButton.setBackground(new Color(0, 204, 204));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("All fields marked * compulsary");
		lblNewLabel.setBounds(490, 565, 240, 14);
		frame.getContentPane().add(lblNewLabel);
		
		RePass_Field = new JPasswordField();
		RePass_Field.setBounds(306, 514, 204, 29);
		RePass_Field.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					checkRegistration(frame);
			}
		});
		frame.getContentPane().add(RePass_Field);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(795, 95, 40, 54);
		frame.getContentPane().add(label_2);
		
		JLabel Home_label = new JLabel("");
		Home_label.setToolTipText("Back to Home");
		Home_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				WelcomeFrame obj=new WelcomeFrame();
				obj.Welcome_frame.setVisible(true);
				frame.dispose();
			}
		});
		Home_label.setBounds(834, 11, 40, 54);
		Image img4=new ImageIcon(this.getClass().getResource("/Home icon.png")).getImage();
		Home_label.setIcon(new ImageIcon(img4));
		frame.getContentPane().add(Home_label);
		frame.setBounds(100, 100, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@SuppressWarnings("deprecation")
	private void checkRegistration(JFrame f)
	{
		String name=Name_Field.getText();
		String DOB=DOB_Field.getText();
		String Add=Add_Field.getText();
		String Email=Email_Field.getText();
		String UName=UName_Field.getText();
		String OrPass=FirstPass_Field.getText();
		String RePass=RePass_Field.getText();
		
		MyConnection.getConnection();
		
		try
		{
			
			JLabel errLabel = new JLabel("");
			errLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
			UIManager.put("Button.background", Color.white);
			
			String query = "SELECT password FROM userinfo WHERE username='"+UName+"'";
			ResultSet rs = MyConnection.executeQuery(query);
			
			if(rs.next())
			{
				errLabel.setText("UserName Exists");
				JOptionPane.showMessageDialog(null, errLabel);
			}
			else if(name.equals("")||DOB.equals("")||Add.equals("")||Email.equals("")||UName.equals("")||OrPass.equals("")||RePass.equals(""))
			{
				errLabel.setText("No Field should be left vacant");
				JOptionPane.showMessageDialog(null, errLabel);
				
			}
			else if(!(OrPass.equals(RePass)))
			{
				errLabel.setText("Password Mismatch");
				JOptionPane.showMessageDialog(null, errLabel);

			}
			else
			{
				String qry1="INSERT INTO db.userinfo VALUES('"+name+"','"+DOB+"','"+Add+"','"+Email+"','"+UName+"','"+OrPass+"')" ;
				MyConnection.updateQuery(qry1);
				errLabel.setText("Successful Registration! Login to continue with booking");
				JOptionPane.showMessageDialog(null, errLabel);
				MyConnection.closeConnection();
				LoginFrame obj =new LoginFrame();
				obj.setVisible(true);
				f.dispose();
			}
			
		}catch(Exception e)
		{
			
		}
	}
}
