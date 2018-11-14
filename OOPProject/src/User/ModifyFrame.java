package User;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import Admin.MyDate;
import Hotel.Hotel;
import Hotel.MyContainer;
import Login.MyConnection;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ModifyFrame extends JFrame
{
	private static int refno;
	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnCheck;
	private JButton btnModify;
	private JDateChooser chooserCheckOut;
	private JDateChooser chooserCheckIn;
	Date checkInDate;
	Date checkOutDate;
	int noOfRooms;
	int noOfPeople;
	Date upCheckInDate;
	Date upCheckOutDate;
	int upNoOfRooms;
	int upNoOfPeople;
	String location;
	JLabel errLabel;
	String hotelName;
	String username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					ModifyFrame frame = new ModifyFrame(2,"black");
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ModifyFrame(int refno, String username)
	{
		ImageIcon locationIcon = new ImageIcon(getClass().getResource("/location-icon.png"));
		ImageIcon hotelIcon = new ImageIcon(getClass().getResource("/hotel-icon.png"));
		ImageIcon roomIcon = new ImageIcon(getClass().getResource("/room-icon.png"));
		ImageIcon peopleIcon = new ImageIcon(getClass().getResource("/people-icon.png"));
		ImageIcon checkInIcon = new ImageIcon(getClass().getResource("/in.png"));
		ImageIcon checkOutIcon = new ImageIcon(getClass().getResource("/out.png"));
		
		MyContainer myContainer = MyContainer.getContainer();
		this.refno = refno;
		fetch();			//to get details of booking against refno
		
		this.username = username;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(180, 30, 900,700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DropDown dropDown = new DropDown(username, this);
		contentPane.add(dropDown);
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				dropDown.resize();
			}
		});
		
		ImageIcon backIcon = new ImageIcon(getClass().getResource("/back.png"));
		JLabel lblBack = new JLabel("");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new MyBookingFrame(username).setVisible(true);
				dispose();
			}
		});
		lblBack.setBounds(655, 13, 40, 52);
		contentPane.add(lblBack);
		lblBack.setIcon(backIcon);
		lblBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//defining a single error label for use by all errors
		errLabel = new JLabel("");
		errLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		UIManager.put("Button.background", Color.white);
		
		//BookMyHotel label
		JLabel lblBookMyHotel = new JLabel("BookMyHotel");
		lblBookMyHotel.setBackground(new Color(255, 255, 255));
		lblBookMyHotel.setForeground(new Color(102, 0, 51));
		lblBookMyHotel.setFont(new Font("Consolas", Font.BOLD, 40));
		lblBookMyHotel.setBounds(23, 11, 320, 65);
		contentPane.add(lblBookMyHotel);
		
		//Setting original location
		JLabel lblLoc = new JLabel(location);
		lblLoc.setBounds(472, 214, 204, 29);
		lblLoc.setFont(new Font("Roboto", Font.PLAIN, 20));
		contentPane.add(lblLoc);
		
		//location label
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		lblLocation.setBounds(118, 214, 228, 29);
		contentPane.add(lblLocation);
		
		//check-in date label
		JLabel lblCheckIn = new JLabel("Check-in Date");
		lblCheckIn.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		lblCheckIn.setBounds(115, 265, 228, 29);
		contentPane.add(lblCheckIn);
		
		//check-out date label
		JLabel lblCheckOut = new JLabel("Check-out Date");
		lblCheckOut.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		lblCheckOut.setBounds(118, 317, 228, 29);
		contentPane.add(lblCheckOut);
		
		//number of people label
		JLabel lblNoOfPeople = new JLabel("Number of People");
		lblNoOfPeople.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		lblNoOfPeople.setBounds(118, 419, 228, 29);
		contentPane.add(lblNoOfPeople);
		
		//text-field for number of people
		textField_2 = new JTextField();
		
		textField_2.setFont(new Font("Roboto", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(472, 419, 204, 29);
		textField_2.setText(Integer.toString(noOfPeople));
		contentPane.add(textField_2);
		
		//number of rooms label
		JLabel lblNoOfRooms = new JLabel("Number of Rooms");
		lblNoOfRooms.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		lblNoOfRooms.setBounds(118, 368, 228, 29);
		contentPane.add(lblNoOfRooms);
		
		//text-field for number of rooms
		textField_3 = new JTextField();
	
		textField_3.setFont(new Font("Roboto", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(472, 368, 204, 29);
		textField_3.setText(Integer.toString(noOfRooms));
		contentPane.add(textField_3);
		
		//calender for check-in date
		chooserCheckIn = new JDateChooser();
		chooserCheckIn.setDate(checkInDate);
		chooserCheckIn.setFont(new Font("Roboto", Font.PLAIN, 15));
		upCheckInDate = chooserCheckIn.getDate();
		
		chooserCheckIn.setBounds(472, 265, 204, 29);
		contentPane.add(chooserCheckIn);
		
		//calender for check-out date
		chooserCheckOut = new JDateChooser();
		chooserCheckOut.setDate(checkOutDate);
		chooserCheckOut.setFont(new Font("Roboto", Font.PLAIN, 15));
		upCheckOutDate = chooserCheckOut.getDate();
		
		chooserCheckOut.setBounds(472, 317, 204, 29);
		contentPane.add(chooserCheckOut);
		
		//modify button
		
		JButton btnModify = new JButton("Modify");
		btnModify.setBounds(335, 521, 200, 42);
		btnModify.addActionListener(new ActionListener() 
		{
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) 
			{
				modify();
				MyContainer.storeContainer(myContainer);
			}
		});
		btnModify.setBackground(new Color(0, 204, 204));
		btnModify.setForeground(new Color(255, 255, 255));
		btnModify.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnModify.setVisible(false);
		contentPane.add(btnModify);
		
		JButton btnCheck = new JButton("Check Availability");
		btnCheck.setBounds(335, 521, 200, 42);
		btnCheck.addActionListener(new ActionListener() 
		{
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) 
			{
				if(!valid())
					return;
				Hotel hotelObj = myContainer.getHotel(hotelName, location);
				if(hotelObj.modifyCheck(refno, convertToSQL(upCheckInDate), convertToSQL(upCheckOutDate), upNoOfRooms, upNoOfPeople))
				{
					errLabel.setText("Available!");
					JOptionPane.showMessageDialog(null, errLabel);
					btnCheck.setVisible(false);
					btnModify.setVisible(true);
				}
				else
				{
					errLabel.setText("Given number of rooms not available for this period");
					JOptionPane.showMessageDialog(null, errLabel);
				}
			}
		});
		btnCheck.setBackground(new Color(0, 204, 204));
		btnCheck.setForeground(new Color(255, 255, 255));
		btnCheck.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnCheck);
		
		JLabel lblHotel = new JLabel("Hotel");
		lblHotel.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		lblHotel.setBounds(118, 168, 228, 29);
		contentPane.add(lblHotel);
		
		JLabel lblHot = new JLabel(hotelName);
		lblHot.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblHot.setBounds(472, 168, 204, 29);
		contentPane.add(lblHot);
		
		JLabel label = new JLabel("");
		label.setBounds(380, 210, 32, 34);
		contentPane.add(label);
		label.setIcon(locationIcon);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(380, 261, 32, 34);
		contentPane.add(label_1);
		label_1.setIcon(hotelIcon);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(380, 312, 32, 34);
		contentPane.add(label_2);
		label_2.setIcon(peopleIcon);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(380, 363, 32, 34);
		contentPane.add(label_3);
		label_3.setIcon(checkInIcon);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(380, 414, 32, 34);
		contentPane.add(label_4);
		label_4.setIcon(checkOutIcon);
		
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				btnCheck.setVisible(true);
				btnModify.setVisible(false);
			}
		});
		
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				btnCheck.setVisible(true);
				btnModify.setVisible(false);
			}
		});
		
		chooserCheckIn.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) 
			{		
				if(evt.getPropertyName().equals("date"))
				{
					btnModify.setVisible(false);
					btnCheck.setVisible(true);
					upCheckInDate = chooserCheckIn.getDate();
					Date currentDate = MyDate.getCurrDate();
					if(!upCheckInDate.after(currentDate))
					{
						errLabel.setText("Enter valid check-in date.");
						JOptionPane.showMessageDialog(null, errLabel);
					}
				}
			}
		});
		
		chooserCheckOut.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) 
			{
				if(evt.getPropertyName().equals("date"))
				{
					btnModify.setVisible(false);
					btnCheck.setVisible(true);
					upCheckInDate = chooserCheckIn.getDate();
					upCheckOutDate = chooserCheckOut.getDate();
					if(MyDate.getIndex(convertToSQL(upCheckInDate))>MyDate.getIndex(convertToSQL(upCheckOutDate)))
					{
						errLabel.setText("Enter valid check-out date.");
						JOptionPane.showMessageDialog(null, errLabel);
					}
				}
			}
		});
	}
	
	//updates class variables by comparing against details of refno
	void fetch()
	{
		MyConnection.getConnection();
		String query = "SELECT * FROM bookinginfo WHERE refno = "+refno;
		ResultSet rSet = MyConnection.executeQuery(query);
		try
		{
			if(rSet.next())
			{
				checkInDate = rSet.getDate(5);
				checkOutDate = rSet.getDate(6);
				noOfRooms = rSet.getInt(9);
				noOfPeople = rSet.getInt(10);
				location = rSet.getString(3);
				hotelName = rSet.getString(4);
			}
		}
		catch(SQLException e)
		{
		}
	}
	
	//
	boolean valid()
	{
		String str = textField_2.getText();
		try
		{
			upNoOfPeople = Integer.parseInt(str);
		}
		catch(NumberFormatException e1)
		{
			errLabel.setText("Enter valid number for Number of People.");
			JOptionPane.showMessageDialog(null, errLabel);
			return false;
		}
		str = textField_3.getText();
		try
		{
			upNoOfRooms = Integer.parseInt(str);
		}
		catch(NumberFormatException e2)
		{
			errLabel.setText("Enter valid number for Number of Rooms.");
			JOptionPane.showMessageDialog(null, errLabel);
			return false;
		}
		if(checkDates())
			return true;
		return false;
	}
	void modify()
	{
		//processing the details that have been input in this frame
		String str = textField_2.getText();
		try
		{
			noOfPeople = Integer.parseInt(str);
		}
		catch(NumberFormatException e1)
		{
			errLabel.setText("Enter valid number for Number of People.");
			JOptionPane.showMessageDialog(null, errLabel);
			return;
		}
		str = textField_3.getText();
		try
		{
			noOfRooms = Integer.parseInt(str);
		}
		catch(NumberFormatException e2)
		{
			errLabel.setText("Enter valid number for Number of Rooms.");
			JOptionPane.showMessageDialog(null, errLabel);
			return;
		}
		if(checkDates())
			//processing the details that have been input in this frame
			new Booking(username, location, convertToSQL(checkInDate), convertToSQL(checkOutDate), noOfPeople, noOfRooms);
		else
			return;
		dispose();
		errLabel.setText("Successfully modified.");
		JOptionPane.showMessageDialog(null, errLabel);
		new MyBookingFrame(username).setVisible(true);
		this.dispose();
	}
	
	public static java.sql.Date convertToSQL(Date date)
	{
		java.sql.Date dobj = new java.sql.Date(date.getTime());
		return dobj;
	}
	
	boolean checkDates()
	{
		upCheckOutDate = chooserCheckOut.getDate();
		upCheckInDate = chooserCheckIn.getDate();
		if(MyDate.getIndex(convertToSQL(upCheckInDate))>MyDate.getIndex(convertToSQL(upCheckOutDate)))
		{
			errLabel.setText("Enter valid check-out date.");
			JOptionPane.showMessageDialog(null, errLabel);
			return false;
		}
		upCheckInDate = chooserCheckIn.getDate();
		Date currentDate = MyDate.getCurrDate();
		if(!upCheckInDate.after(currentDate))
		{
			errLabel.setText("Enter valid check-in date.");
			JOptionPane.showMessageDialog(null, errLabel);
			return false;
		}
		return true;
	}
}
