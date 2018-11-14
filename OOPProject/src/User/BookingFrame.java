package User;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Login.LoginFrame;
import Login.MyConnection;
import Login.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import Admin.MyDate;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookingFrame extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel errLabel;
	DefaultComboBoxModel<String> model;
	Date checkInDate;
	Date checkOutDate;
	int noOfRooms;
	int noOfPeople;
	String location;
	String username;
	DropDown dropDown;
	JDateChooser chooserCheckOut;
	JDateChooser chooserCheckIn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingFrame frame = new BookingFrame("blake");
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
	public BookingFrame(String username) 
	
	{
		
		ImageIcon locationIcon = new ImageIcon(getClass().getResource("/location-icon.png"));
		ImageIcon hotelIcon = new ImageIcon(getClass().getResource("/hotel-icon.png"));
		ImageIcon roomIcon = new ImageIcon(getClass().getResource("/room-icon.png"));
		ImageIcon peopleIcon = new ImageIcon(getClass().getResource("/people-icon.png"));
		ImageIcon checkInIcon = new ImageIcon(getClass().getResource("/in.png"));
		ImageIcon checkOutIcon = new ImageIcon(getClass().getResource("/out.png"));
		
		dropDown = new DropDown(username,this);
		this.username = username;
		//setting the panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(180, 30, 900,700);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				dropDown.resize();
			}
		});
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		contentPane.add(dropDown);
		
		ImageIcon backIcon = new ImageIcon(getClass().getResource("/back.png"));
		JLabel lblBack = new JLabel("");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new UserFrame(username).setVisible(true);
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
		
		//Customising and adding the drop-down menu
		JComboBox locationMenu = new JComboBox();
		locationMenu.setFont(new Font("Roboto", Font.PLAIN, 20));
		locationMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				location = (String)locationMenu.getSelectedItem();		//updates location to the newly selected value
			}
		});
		
		//Adding a Model to the drop-down menu to display all unique locations
		model = new DefaultComboBoxModel();
		locationMenu.setModel(model);
		locationMenu.setToolTipText("");
		locationMenu.setBounds(466, 168, 204, 29);
		contentPane.add(locationMenu);
		populateModel();
		
		//location label
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		lblLocation.setBounds(118, 168, 103, 29);
		contentPane.add(lblLocation);
		
		//check-in date label
		JLabel lblCheckIn = new JLabel("Check-in Date");
		lblCheckIn.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		lblCheckIn.setBounds(118, 219, 158, 29);
		contentPane.add(lblCheckIn);
		
		//check-out date label
		JLabel lblCheckOut = new JLabel("Check-out Date");
		lblCheckOut.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		lblCheckOut.setBounds(118, 270, 178, 29);
		contentPane.add(lblCheckOut);
		
		//number of people label
		JLabel lblNoOfPeople = new JLabel("Number of People");
		lblNoOfPeople.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		lblNoOfPeople.setBounds(118, 372, 198, 29);
		contentPane.add(lblNoOfPeople);
		
		//text-field for number of people
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				fetchDetails();
			}
		});
		textField_2.setFont(new Font("Roboto", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(466, 372, 204, 29);
		contentPane.add(textField_2);
		
		//number of rooms label
		JLabel lblNoOfRooms = new JLabel("Number of Rooms");
		lblNoOfRooms.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		lblNoOfRooms.setBounds(118, 321, 189, 29);
		contentPane.add(lblNoOfRooms);
		
		//text-field for number of rooms
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					fetchDetails();
			}
		});
		textField_3.setFont(new Font("Roboto", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(466, 321, 204, 29);
		contentPane.add(textField_3);
		
		//calender for check-in date
		chooserCheckIn = new JDateChooser();
		chooserCheckIn.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) 
			{
				if(evt.getPropertyName().equals("date"))
				{
					checkInDate = chooserCheckIn.getDate();
					Date currentDate = MyDate.getCurrDate();
					if((MyDate.getIndex(convertToSQL(currentDate))>MyDate.getIndex(convertToSQL((checkInDate)))))
					{
						errLabel.setText("Enter valid check-in date.");
						JOptionPane.showMessageDialog(null, errLabel);
					}
				}
			}
		});
		chooserCheckIn.setBounds(466, 219, 204, 29);
		chooserCheckIn.setFont(new Font("Roboto", Font.PLAIN, 15));
		contentPane.add(chooserCheckIn);
		
		//calender for check-out date
		chooserCheckOut = new JDateChooser();
		chooserCheckOut.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) 
			{
				if(evt.getPropertyName().equals("date"))
				{
					checkOutDate = chooserCheckOut.getDate();
					if(MyDate.getIndex(convertToSQL(checkOutDate))<MyDate.getIndex(convertToSQL((checkInDate))))
					{
						errLabel.setText("Enter valid check-out date.");
						JOptionPane.showMessageDialog(null, errLabel);
					}
				}
			}
		});
		chooserCheckOut.setFont(new Font("Roboto", Font.PLAIN, 15));
		chooserCheckOut.setBounds(466, 270, 204, 29);
		contentPane.add(chooserCheckOut);
		
		
		//submit button
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				fetchDetails();
			}
		});
		btnNewButton.setBounds(356, 468, 169, 52);
		btnNewButton.addActionListener(new ActionListener() 
		{
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) 
			{
				fetchDetails();
			}
		});
		btnNewButton.setBackground(new Color(0, 204, 204));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		contentPane.add(btnNewButton);
		
		JLabel lblLocationIcon = new JLabel("");
		lblLocationIcon.setBounds(380, 165, 32, 34);
		contentPane.add(lblLocationIcon);
		lblLocationIcon.setIcon(locationIcon);
		
		JLabel lblHotelIcon = new JLabel("");
		lblHotelIcon.setBounds(380, 318, 32, 34);
		contentPane.add(lblHotelIcon);
		lblHotelIcon.setIcon(hotelIcon);
		
		JLabel lblPeopleIcon = new JLabel("");
		lblPeopleIcon.setBounds(380, 369, 32, 34);
		contentPane.add(lblPeopleIcon);
		lblPeopleIcon.setIcon(peopleIcon);
		
		JLabel lblcheckInIcon = new JLabel("");
		lblcheckInIcon.setBounds(380, 216, 32, 34);
		contentPane.add(lblcheckInIcon);
		lblcheckInIcon.setIcon(checkInIcon);
		
		JLabel lblcheckOutIcon = new JLabel("");
		lblcheckOutIcon.setBounds(380, 267, 32, 34);
		contentPane.add(lblcheckOutIcon);
		lblcheckOutIcon.setIcon(checkOutIcon);
	}
	
	//to populate the model to be used in the drop-down menu
	public void populateModel()
	{
		if(MyConnection.getConnection())
		{
			String query = "select location from hotelinfo";
			ResultSet rSet = MyConnection.executeQuery(query);
			try
			{
				while(rSet.next())
				{
					String nextLoc = rSet.getString(1);
					if(model.getIndexOf(nextLoc)==-1)			//to check if location already exists
						model.addElement(nextLoc);
				}
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//to get valid input from user and process the details
	public void fetchDetails()
	{
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
		{
			return;
		}
		dispose();
	}
	
	//to covert java.util date to java.sql date 
	public static java.sql.Date convertToSQL(Date date)
	{
		java.sql.Date dobj = new java.sql.Date(date.getTime());
		return dobj;
	}
	
	boolean checkDates()
	{
		checkOutDate = chooserCheckOut.getDate();
		if((MyDate.getIndex(convertToSQL(checkOutDate))<MyDate.getIndex(convertToSQL((checkInDate)))))
		{
			errLabel.setText("Enter valid check-out date.");
			JOptionPane.showMessageDialog(null, errLabel);
			return false;
		}
		checkInDate = chooserCheckIn.getDate();
		Date currentDate = MyDate.getCurrDate();
		if((MyDate.getIndex(convertToSQL(currentDate))>MyDate.getIndex(convertToSQL((checkInDate)))))
		{
			errLabel.setText("Enter valid check-in date.");
			JOptionPane.showMessageDialog(null, errLabel);
			return false;
		}
		return true;
	}
}
