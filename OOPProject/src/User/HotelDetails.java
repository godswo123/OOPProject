package User;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Hotel.Hotel;
import Hotel.MyContainer;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class HotelDetails extends JFrame
{
	static String hotelName;
	static JFrame prevFrame;
	String location;
	static boolean isAvailable;
	private JPanel contentPane;
	JFrame Fobj = this;
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
					HotelDetails frame = new HotelDetails(null,hotelName,prevFrame,isAvailable);
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
	public HotelDetails(MyContainer myContainer, String hotelName, JFrame prevFrame, boolean isAvailable)
	{
		this.hotelName = hotelName;
		this.prevFrame = prevFrame;
		this.isAvailable = isAvailable;
		location = Booking.getLocation();
		
		ImageIcon okIcon = new ImageIcon(getClass().getResource("/check.png"));
		ImageIcon noIcon = new ImageIcon(getClass().getResource("/cross.png"));
		
		Hotel hotelObj = myContainer.getHotel(hotelName, location);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(180, 30, 644,683);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon backIcon = new ImageIcon(getClass().getResource("/back.png"));
		JLabel lblBack = new JLabel("");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		lblBack.setBounds(551, 17, 40, 52);
		contentPane.add(lblBack);
		lblBack.setIcon(backIcon);
		lblBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//hotelName label
		JLabel lblHotel = new JLabel(hotelName);
		lblHotel.setBounds(23, 11, 320, 65);
		lblHotel.setBackground(new Color(255, 255, 255));
		lblHotel.setForeground(new Color(102, 0, 51));
		lblHotel.setFont(new Font("Consolas", Font.BOLD, 40));
		contentPane.add(lblHotel);
		
		//amenities label and panel
		JLabel label = new JLabel("");
		label.setBounds(263, 112, 40, 52);
		contentPane.add(label);
		label.setIcon(okIcon);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(263, 149, 40, 52);
		contentPane.add(label_1);
		label_1.setIcon(okIcon);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(263, 186, 40, 52);
		contentPane.add(label_2);
		label_2.setIcon(okIcon);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(263, 227, 40, 52);
		contentPane.add(label_3);
		label_3.setIcon(okIcon);
		
		JLabel lblAmenities_1 = new JLabel("Free WiFi");
		lblAmenities_1.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblAmenities_1.setBounds(23, 126, 179, 24);
		if(hotelObj.amenities[0]==true)
			label.setIcon(okIcon);
		else
			label.setIcon(noIcon);
		contentPane.add(lblAmenities_1);
		
		JLabel lblAmenities_2 = new JLabel("Complementary Breakfast");
		lblAmenities_2.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblAmenities_2.setBounds(23, 163, 280, 24);
		if(hotelObj.amenities[1]==true)
			label_1.setIcon(okIcon);
		else
			label_1.setIcon(noIcon);
		contentPane.add(lblAmenities_2);
		
		JLabel lblAmenities_3 = new JLabel("Swimming Pool");
		lblAmenities_3.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblAmenities_3.setBounds(23, 200, 190, 24);
		if(hotelObj.amenities[2]==true)
			label_2.setIcon(okIcon);
		else
			label_2.setIcon(noIcon);
		contentPane.add(lblAmenities_3);
		
		JLabel lblAmenities_4 = new JLabel("Free Parking");
		lblAmenities_4.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblAmenities_4.setBounds(23, 241, 112, 24);
		if(hotelObj.amenities[3]==true)
			label_3.setIcon(okIcon);
		else
			label_3.setIcon(noIcon);
		contentPane.add(lblAmenities_4);
		
		JLabel lblAmenities = new JLabel("Amenities");
		lblAmenities.setBounds(23, 89, 167, 24);
		lblAmenities.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
		contentPane.add(lblAmenities);
		
		JLabel lblReviews = new JLabel("Reviews");
		lblReviews.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
		lblReviews.setBounds(23, 298, 167, 24);
		contentPane.add(lblReviews);
		
		TextArea reviews = new TextArea();
		reviews.setBounds(23, 328, 568, 209);
		reviews.setFont(new Font("Roboto", Font.PLAIN, 16));
		reviews.setEditable(false);
		contentPane.add(reviews);
		
		ArrayList<String> feedback = hotelObj.getFeedback();
		for(int i=0;i<feedback.size();i+=4)
		{
			String username = feedback.get(i);
			String feed = feedback.get(i+1);
			String rating = feedback.get(i+2);
			String checkout = feedback.get(i+3);
			reviews.append(username+":\nRating: ");
			for(int j=0;j<Integer.parseInt(rating);j++)
				reviews.append("*");
			reviews.append("\n"+feed+"\n"+"(on "+checkout+")\n");
			reviews.append("-----------------------------------------------------------------------------\n\n");
		}
		
		JButton btn = new JButton();
		btn.setBounds(254, 565, 89, 42);
		btn.setBackground(new Color(0, 204, 204));
		btn.setForeground(new Color(255, 255, 255));
		btn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btn);
		
		JLabel lblRating = new JLabel("");
		lblRating.setForeground(new Color(102, 0, 51));
		lblRating.setFont(new Font("Consolas", Font.BOLD, 30));
		lblRating.setBackground(Color.WHITE);
		lblRating.setBounds(285, 11, 167, 65);
		Double rate = hotelObj.getRating();
		DecimalFormat dec = new DecimalFormat("#0.0");
		lblRating.setText("("+dec.format(rate)+"/5.0)");
		contentPane.add(lblRating);
		
		if(isAvailable==true)
		{
			btn.setText("Book");
			btn.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0)
				{
					(new ConfirmBooking(myContainer,hotelObj,true,prevFrame)).setVisible(true);
					prevFrame.setVisible(false);
					Fobj.dispose();
				}
			});
		}
		
		else
		{
			btn.setText("Enroll");
			btn.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0)
				{
					(new ConfirmBooking(myContainer,hotelObj,false,prevFrame)).setVisible(true);
					prevFrame.setVisible(false);
					Fobj.dispose();
				}
			});
		}
	}
}
