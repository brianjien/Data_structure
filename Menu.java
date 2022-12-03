package final_project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 466, 543);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new Color(128, 128, 128));

		JLabel Title = new JLabel("Stack and linked list comparison");
		Title.setForeground(new Color(255, 255, 255));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 21));
		Title.setBounds(53, 128, 343, 62);
		frame.getContentPane().add(Title);

		JLabel lblNewLabel = new JLabel("in note pad");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel.setBounds(164, 173, 119, 45);
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("\nStack\r\n");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setForeground(new Color(230, 230, 250));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Note_Stack note = new Note_Stack();
				note.Screen();

			}
		});
		btnNewButton.setFont(new Font("Segoe UI Variable", Font.BOLD, 18));
		btnNewButton.setBounds(127, 241, 177, 61);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Linked list");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setForeground(new Color(230, 230, 250));
		btnNewButton_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Note_Linked_List list = new Note_Linked_List();
				list.Screen1();
			}
		});
		btnNewButton_1.setBounds(127, 350, 177, 62);
		frame.getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\USER\\Downloads\\EC534F6E-4262-402E-9843-82B6E95D5821.jpeg"));
		lblNewLabel_1.setBounds(116, 59, 270, 85);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
