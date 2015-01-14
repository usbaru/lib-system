

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;

import java.sql.*;

public class ISBN_Input {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ISBN_Input window = new ISBN_Input();
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
	public ISBN_Input() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblIsbn = new JLabel("ISBN: ");
		lblIsbn.setBounds(22, 61, 70, 15);
		frame.getContentPane().add(lblIsbn);
		
		textField = new JTextField();
		textField.setBounds(85, 59, 114, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(85, 88, 114, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblT = new JLabel("Title: ");
		lblT.setBounds(22, 90, 70, 15);
		frame.getContentPane().add(lblT);
		
		textField_2 = new JTextField();
		textField_2.setBounds(85, 119, 114, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Author: ");
		lblAuthor.setBounds(22, 121, 70, 15);
		frame.getContentPane().add(lblAuthor);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(211, 59, 200, 79);
		frame.getContentPane().add(textArea);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBConnect con = new DBConnect();
				Book nBook = new Book(	textField.getText(),
										textField_1.getText(),
										textField_2.getText());
				
				textArea.setText("Book(s) in Database: \n \n" + con.getData()); //fix to print out all books in db 

				con.setData(textField.getText(), textField_1.getText(), textField_2.getText());
			}
		});
		btnSubmit.setBounds(162, 229, 117, 25);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblNewBookEntry = new JLabel("New Book Entry");
		lblNewBookEntry.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewBookEntry.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewBookEntry.setBounds(12, 30, 180, 19);
		frame.getContentPane().add(lblNewBookEntry);

	}
}
