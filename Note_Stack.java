package final_project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Note_Stack {

	private JFrame frame;

	public int counter = 0;

	/**
	 * Launch the application.
	 */
	public void Screen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Note_Stack window = new Note_Stack();
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
	public Note_Stack() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		Stack<String> undo = new Stack<>();
		Stack<String> redo = new Stack<>();
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 128, 128));
		frame.getContentPane().setForeground(new Color(102, 153, 153));
		frame.setBounds(100, 100, 943, 558);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		JTextArea tfa = new JTextArea();

		JLabel lblNewLabel_7 = new JLabel("Stack Version");
		lblNewLabel_7.setBounds(447, 10, 156, 48);
		frame.getContentPane().add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setForeground(new Color(230, 230, 250));
		lblNewLabel_5.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(779, 389, 138, 40);
		frame.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(new Color(230, 230, 250));
		lblNewLabel_2.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(779, 303, 138, 53);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel push = new JLabel("");
		push.setForeground(new Color(230, 230, 250));
		push.setFont(new Font("Segoe UI Variable", Font.PLAIN, 13));
		push.setBounds(713, 10, 204, 139);
		frame.getContentPane().add(push);

		tfa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {

					try {

						undo.push(tfa.getText());
						counter++;
						push.setText(undo.peek());

					} catch (Exception E) {

					}

				}

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					try {
						undo.push(tfa.getText());
						counter++;
					} catch (Exception E) {

					}

				}
				if ((e.getKeyCode() == KeyEvent.VK_Z) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					try {
						long start = System.nanoTime();
						String temp = undo.pop();

						redo.push(temp);
						tfa.setText(temp);
						counter++;
						push.setText(" ");
						long elapsedTime = System.nanoTime() - start;
						lblNewLabel_2.setText("<html>" + elapsedTime + "<html>" + " nano second");
					} catch (Exception E) {

					}

				}
				if ((e.getKeyCode() == KeyEvent.VK_Y) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					try {
						long start = System.nanoTime();
						String temp = redo.pop();
						undo.push(temp);
						tfa.setText(temp);
						counter++;
						long elapsedTime = System.nanoTime() - start;
						lblNewLabel_5.setText("<html>" + elapsedTime + "<html>" + " nano second");

					} catch (Exception E) {

					}

				}

			}
		});

		tfa.setBounds(144, 23, 674, 416);
		tfa.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 21));
		tfa.setCaretPosition(tfa.getText().length());
		tfa.moveCaretPosition(0);
		frame.getContentPane().add(tfa);
		tfa.setColumns(10);

		JLabel dis = new JLabel();
		dis.setBounds(144, 133, 138, 40);
		frame.getContentPane().add(dis);

		JButton rd = new JButton("redo");
		rd.setBackground(new Color(211, 211, 211));
		rd.setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
		rd.setBounds(139, 0, 70, 69);
		rd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					long start = System.nanoTime();
					String temp = redo.pop();
					undo.push(temp);
					tfa.setText(temp);
					counter++;
					long elapsedTime = System.nanoTime() - start;
					lblNewLabel_5.setText("<html>" + elapsedTime + "<html>" + " nano second");
				} catch (Exception E) {

				}
			}
		});
		frame.getContentPane().add(rd);

		JMenuItem item1, item2;
		frame.getContentPane().setLayout(null);

		JButton ud = new JButton("undo");
		ud.setBackground(new Color(211, 211, 211));
		ud.setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
		ud.setBounds(69, 0, 70, 69);
		ud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long start = System.nanoTime();
				try {
					String temp = undo.pop();

					redo.push(temp);
					tfa.setText(temp);
					counter++;
					long elapsedTime = System.nanoTime() - start;
					lblNewLabel_2.setText("<html>" + elapsedTime + "<html>" + " nano second");
				} catch (Exception E) {

				}
			}
		});

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 70, 69);
		frame.getContentPane().add(menuBar);
		JMenu demo1 = new JMenu("       File        ");
		demo1.setHorizontalAlignment(SwingConstants.LEFT);
		demo1.setFont(new Font("Segoe UI Variable", Font.BOLD, 16));
		item1 = new JMenuItem("    Open     ");
		item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Text File", "txt");
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileFilter(extensionFilter);
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					String fullPath = selectedFile.getAbsolutePath();
					System.out.println(fullPath);
					try {
						FileReader reader = new FileReader(fullPath);
						BufferedReader br = new BufferedReader(reader);
						tfa.read(br, null);
						br.close();
						tfa.requestFocus();
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}

			}

		});
		item2 = new JMenuItem("    Save     ");
		item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Text File", "txt");
				final JFileChooser saveAsFileChooser = new JFileChooser();
				saveAsFileChooser.setApproveButtonText("Save");
				saveAsFileChooser.setFileFilter(extensionFilter);
				int actionDialog = saveAsFileChooser.showSaveDialog(null);
				if (actionDialog != JFileChooser.APPROVE_OPTION) {
					return;
				}

				File file = saveAsFileChooser.getSelectedFile();
				if (!file.getName().endsWith(".txt")) {
					file = new File(file.getAbsolutePath() + ".txt");
				}

				BufferedWriter outFile = null;
				try {
					outFile = new BufferedWriter(new FileWriter(file));

					tfa.write(outFile);

				} catch (IOException ex) {
					ex.printStackTrace();
				} finally {
					if (outFile != null) {
						try {
							outFile.close();
						} catch (IOException e1) {
						}
					}
				}

			}

		});
		demo1.add(item1);
		demo1.add(item2);
		menuBar.add(demo1);
		frame.getContentPane().add(ud);

		JButton btnNewButton_1 = new JButton("„º");
		btnNewButton_1.setBounds(623, 0, 80, 69);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(211, 211, 211));

		JScrollPane scrollBar = new JScrollPane(tfa);
		scrollBar.setBounds(10, 68, 693, 418);
		frame.getContentPane().add(scrollBar);
		scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 703, 69);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(119, 136, 153));
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Push in the stack");
		lblNewLabel_1.setForeground(new Color(230, 230, 250));
		lblNewLabel_1.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(770, 144, 122, 34);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("Undo:");
		lblNewLabel_3.setForeground(new Color(230, 230, 250));
		lblNewLabel_3.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(723, 316, 56, 27);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Redo:");
		lblNewLabel_4.setForeground(new Color(230, 230, 250));
		lblNewLabel_4.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(723, 399, 46, 15);

		frame.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_6 = new JLabel("Time comparsion");
		lblNewLabel_6.setForeground(new Color(230, 230, 250));
		lblNewLabel_6.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		lblNewLabel_6.setBounds(733, 236, 194, 40);
		frame.getContentPane().add(lblNewLabel_6);

	}
}
