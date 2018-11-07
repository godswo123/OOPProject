package Feedback;

import java.awt.*;
import javax.swing.*;

import Login.WelcomeFrame;

import java.awt.event.*;

public class feedback {
    int rating=0;
	public JFrame Welcome_frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					feedback window = new feedback();
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
	public feedback() {
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
		
		String str="Rate your stay at the hotel abc";
		JLabel lblNewLabel_2 = new JLabel(str);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		lblNewLabel_2.setForeground(new Color(102, 0, 51));
		lblNewLabel_2.setBounds(259, 292, 324, 64);
		Welcome_frame.getContentPane().add(lblNewLabel_2);
		
		
		JLabel label = new JLabel("");
		Image img2=new ImageIcon(this.getClass().getResource("/star2.png")).getImage();
		label.setIcon(new ImageIcon(img2));
		label.setBounds(178, 406, 85, 78);
		
		JLabel label2 = new JLabel("");
		label2.setIcon(new ImageIcon(img2));
		label2.setBounds(278, 406, 85, 78);
		
		JLabel label3 = new JLabel("");
		label3.setIcon(new ImageIcon(img2));
		label3.setBounds(378, 406, 85, 78);
		
		JLabel label4 = new JLabel("");
		label4.setIcon(new ImageIcon(img2));
		label4.setBounds(478, 401, 93, 93);
		
		JLabel label5 = new JLabel("");
		label5.setIcon(new ImageIcon(img2));
		label5.setBounds(578, 401, 93, 93);
		
		String str2="Thank you for your feedback";
		JLabel lblNewLabel_3 = new JLabel(str2);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		lblNewLabel_3.setForeground(new Color(102, 0, 51));
		lblNewLabel_3.setBounds(278, 545, 210, 64);
				
		JLabel label1 = new JLabel("");
		Image img21=new ImageIcon(this.getClass().getResource("/star1.png")).getImage();
		label1.setIcon(new ImageIcon(img21));
		label1.setBounds(178, 406, 85, 78);
		Welcome_frame.getContentPane().add(label1);
		label1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label1.setVisible(false);
				Welcome_frame.getContentPane().add(label);
				rating=1;

				Welcome_frame.getContentPane().add(lblNewLabel_3);
			}
		});
		JLabel label21 = new JLabel("");
		label21.setIcon(new ImageIcon(img21));
		label21.setBounds(278, 406, 85, 78);
		Welcome_frame.getContentPane().add(label21);
		label21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label21.setVisible(false);
				label1.setVisible(false);
				Welcome_frame.getContentPane().add(label);
				Welcome_frame.getContentPane().add(label2);
			rating=2;
			Welcome_frame.getContentPane().add(lblNewLabel_3);
			}
		});
		
		JLabel label31 = new JLabel("");
		label31.setIcon(new ImageIcon(img21));
		label31.setBounds(378, 406, 85, 78);
		Welcome_frame.getContentPane().add(label31);
		label31.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label31.setVisible(false);
                label21.setVisible(false);
				label1.setVisible(false);
				Welcome_frame.getContentPane().add(label);
				Welcome_frame.getContentPane().add(label2);
				Welcome_frame.getContentPane().add(label3);
			rating=3;
			Welcome_frame.getContentPane().add(lblNewLabel_3);
			}
		});
		JLabel label41 = new JLabel("");
		label41.setIcon(new ImageIcon(img21));
		label41.setBounds(478, 401, 93, 93);
		Welcome_frame.getContentPane().add(label41);
		label41.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label41.setVisible(false);
				label31.setVisible(false);
                label21.setVisible(false);
				label1.setVisible(false);
				Welcome_frame.getContentPane().add(label);
				Welcome_frame.getContentPane().add(label2);
				Welcome_frame.getContentPane().add(label3);
				Welcome_frame.getContentPane().add(label4);
			rating=4;
			Welcome_frame.getContentPane().add(lblNewLabel_3);
			}
		});

		
		
		JLabel label51 = new JLabel("");
		label51.setIcon(new ImageIcon(img21));
		label51.setBounds(578, 401, 93, 93);
		Welcome_frame.getContentPane().add(label51);
		label51.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label51.setVisible(false);
				label41.setVisible(false);
				label31.setVisible(false);
                label21.setVisible(false);
				label1.setVisible(false);
				Welcome_frame.getContentPane().add(label);
				Welcome_frame.getContentPane().add(label2);
				Welcome_frame.getContentPane().add(label3);
				Welcome_frame.getContentPane().add(label4);
				Welcome_frame.getContentPane().add(label5);
			rating =5;
			Welcome_frame.getContentPane().add(lblNewLabel_3);
			}
		});
		JLabel Home_label = new JLabel("");
		Home_label.setToolTipText("Back to Home");
		Image img4=new ImageIcon(this.getClass().getResource("/Home icon.png")).getImage();
		Home_label.setIcon(new ImageIcon(img4));
		Home_label.setBounds(834, 11, 40, 54);
		Home_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				WelcomeFrame obj=new WelcomeFrame();
				obj.Welcome_frame.setVisible(true);
			}
		});
		Welcome_frame.getContentPane().add(Home_label);
		
	}
	
}
