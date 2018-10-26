package decryption;

import java.awt.*;
//Made for Nintendo Switch, Good for decrypting files and whatnot.
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.util.*;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MainWindow {
	String File = "";
	String keys = "";
	private JFrame frame;
	private JTextField txtTitleKey;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lblHactoolJui = new JLabel("HacTool JUI");
		lblHactoolJui.setFont(new Font("Broadway", Font.PLAIN, 15));
		lblHactoolJui.setHorizontalAlignment(SwingConstants.CENTER);
		lblHactoolJui.setBounds(2, 29, 434, 23);
		frame.getContentPane().add(lblHactoolJui);
		JButton btnPickFile = new JButton("Pick File");
		btnPickFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final JFileChooser fc = new JFileChooser();
		        int returnVal = fc.showOpenDialog(fc);
		        if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File dir = fc.getSelectedFile();
		            //This is where a real application would open the file.
		            File = dir.getAbsolutePath();
		            System.out.println("Opened " + File + " successfully!");
		        } else {
		        	System.out.println("Couldn't open file! Was it canceled by user?");
		        }
			}
		});
		btnPickFile.setBounds(10, 29, 91, 23);
		frame.getContentPane().add(btnPickFile);
		JButton btnKeysdat = new JButton("Keys.dat");
		btnKeysdat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final JFileChooser fc = new JFileChooser();
		        int returnVal = fc.showOpenDialog(fc);
		        if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File keysdir = fc.getSelectedFile();
		            //This is where a real application would open the file.
		            keys = keysdir.getAbsolutePath();
		            System.out.println("Opened " + keys + " successfully!");
		        } else {
		        	System.out.println("Couldn't open file! Was it canceled by user?");
		        }
			}
		});
		btnKeysdat.setBounds(333, 29, 91, 23);
		frame.getContentPane().add(btnKeysdat);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Unencrypted NCA", "NSP/XCI", "Encrypted NCA"}));
		comboBox.setBounds(95, 64, 257, 26);
		frame.getContentPane().add(comboBox);
		
		txtTitleKey = new JTextField();
		txtTitleKey.setToolTipText("Title Key");
		txtTitleKey.setBounds(63, 101, 247, 28);
		frame.getContentPane().add(txtTitleKey);
		txtTitleKey.setColumns(10);
		
		JLabel lblTitleKey = new JLabel("Title Key");
		lblTitleKey.setBounds(10, 107, 55, 16);
		frame.getContentPane().add(lblTitleKey);
		
		textField = new JTextField();
		textField.setBounds(110, 140, 197, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblExefsoptional = new JLabel("Exefs Dir (Optional)");
		lblExefsoptional.setBounds(2, 146, 119, 16);
		frame.getContentPane().add(lblExefsoptional);
		
		textField_1 = new JTextField();
		textField_1.setBounds(113, 180, 197, 28);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblRomfsDiroptional = new JLabel("Romfs Dir (Optional)");
		lblRomfsDiroptional.setBounds(0, 186, 113, 16);
		frame.getContentPane().add(lblRomfsDiroptional);
		
		JLabel lblExtractionDir = new JLabel("Extraction Dir");
		lblExtractionDir.setBounds(10, 225, 91, 16);
		frame.getContentPane().add(lblExtractionDir);
		
		textField_2 = new JTextField();
		textField_2.setBounds(110, 219, 200, 28);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        String chosenName =  (String) comboBox.getSelectedItem();
	        	String titlekey = txtTitleKey.getText(); // get string from title key
	        	String exefsdir = textField.getText(); // get string from exefsdir
	        	String romfsdir = textField_1.getText(); // get string from romfsdir
	        	String dir = textField_2.getText(); // get string from directory
	        	String os = System.getProperty("os.name");
	        	StringBuilder woah = new StringBuilder(os);
	        	if(os.startsWith("Windows")) {
	        		if(chosenName.isEmpty()) {
		        		Error.main(null);
	        		}
	        		else
		        if(chosenName == "Unencrypted NCA") {
		        	if(dir.isEmpty() || chosenName.isEmpty() || keys.isEmpty() || File.isEmpty()) {
		        		Error.main(null);
		        	}
		        	else {
		        	String command = "hactool " + " -k " + keys + " --exefsdir " + exefsdir + " --romfsdir " + romfsdir + " --outdir " + dir + " " + File;
		        	Runtime rt = Runtime.getRuntime();
		        	try {
						Process pr = rt.exec(command);
					} catch (IOException e) {
			        	System.out.println("IF you are seeing this, then something went wrong hahaha");
						e.printStackTrace();
		        		Error2.main(null);
						
					}
		        }
		        }
		        else if(chosenName == "NSP/XCI") {
		        	if(dir.isEmpty() || chosenName.isEmpty() || keys.isEmpty() || File.isEmpty()) {
		        		Error.main(null);
		        	}
		        	String command = "hactool " + " -k " + keys + " --titlekey " + titlekey + " --exefsdir " + exefsdir + " --romfsdir " + romfsdir + " --outdir " + dir + " " + File;
		        	Runtime rt = Runtime.getRuntime();
		        	try {
						Process pr = rt.exec(command);
					} catch (IOException e) {
			        	System.out.println("IF you are seeing this, then something went wrong hahaha");
						e.printStackTrace();
		        		Error2.main(null);
					}
		        }
		        else if(chosenName == "Encrypted NCA") {
		        	if(dir.isEmpty() || chosenName.isEmpty() || keys.isEmpty() || File.isEmpty()) {
		        		Error.main(null);
		        	}
		        	String command = "hactool " + " -k " + keys + " --titlekey " + titlekey + " --exefsdir " + exefsdir + " --romfsdir " + romfsdir + " --outdir " + dir + " " + File;
		        	Runtime rt = Runtime.getRuntime();
		        	try {
						Process pr = rt.exec(command);
					} catch (IOException e) {
			        	System.out.println("IF you are seeing this, then something went wrong hahaha");
						e.printStackTrace();
		        		Error2.main(null);
					}
		        }
		        else {
		        	System.out.println("Exception thrown! (I didn't even know this was possible!");
		        }
	        	}
		        if(os.startsWith("Linux")) {
			        if(chosenName == "Unencrypted NCA") {
			        	if(dir.isEmpty() || chosenName.isEmpty() || keys.isEmpty() || File.isEmpty()) {
			        		Error.main(null);
			        	}
			        	else {
			        	String command = "./hactool " + " -k " + keys + " --exefsdir " + exefsdir + " --romfsdir " + romfsdir + " --outdir " + dir + " " + File;
			        	Runtime rt = Runtime.getRuntime();
			        	try {
							Process pr = rt.exec(command);
						} catch (IOException e) {
				        	System.out.println("IF you are seeing this, then something went wrong hahaha");
							e.printStackTrace();
			        		Error2.main(null);
							
						}
			        }
			        }
			        else if(chosenName == "NSP/XCI") {
			        	if(dir.isEmpty() || chosenName.isEmpty() || keys.isEmpty() || File.isEmpty()) {
			        		Error.main(null);
			        	}
			        	String command = "./hactool " + " -k " + keys + " --titlekey " + titlekey + " --exefsdir " + exefsdir + " --romfsdir " + romfsdir + " --outdir " + dir + " " + File;
			        	Runtime rt = Runtime.getRuntime();
			        	try {
							Process pr = rt.exec(command);
						} catch (IOException e) {
				        	System.out.println("IF you are seeing this, then something went wrong hahaha");
							e.printStackTrace();
			        		Error2.main(null);
						}
			        }
			        else if(chosenName == "Encrypted NCA") {
			        	if(dir.isEmpty() || chosenName.isEmpty() || keys.isEmpty() || File.isEmpty()) {
			        		Error.main(null);
			        	}
			        	String command = "./hactool " + " -k " + keys + " --titlekey " + titlekey + " --exefsdir " + exefsdir + " --romfsdir " + romfsdir + " --outdir " + dir + " " + File;
			        	Runtime rt = Runtime.getRuntime();
			        	try {
							Process pr = rt.exec(command);
						} catch (IOException e) {
				        	System.out.println("IF you are seeing this, then something went wrong hahaha");
							e.printStackTrace();
			        		Error2.main(null);
						}
			        }
			        else {
			        	System.out.println("Exception thrown! (I didn't even know this was possible!");
			        }
			}
			}
		});
		btnGo.setBounds(334, 219, 90, 28);
		frame.getContentPane().add(btnGo);
		
		JLabel lblWarningCurrentlyOnly = new JLabel("Warning: Currently only works on Linux and Windows");
		lblWarningCurrentlyOnly.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblWarningCurrentlyOnly.setBounds(10, 363, 414, 14);
		frame.getContentPane().add(lblWarningCurrentlyOnly);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmCredits = new JMenuItem("Credits");
		mntmCredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
        		Credits.main(null);
			}
		});
		mnHelp.add(mntmCredits);
		
		JMenuItem mntmHowto = new JMenuItem("How-To");
		mntmHowto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
        		Howto.main(null);
			}
		});
		mnHelp.add(mntmHowto);
		
		JMenuItem mntmFaq = new JMenuItem("FAQ");
		mntmFaq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
        		faq.main(null);
			}
		});
		mnHelp.add(mntmFaq);
	}
class ButtonListener implements ActionListener {
	  ButtonListener() {
	  }

	  public void actionPerformed(ActionEvent e) {
	    if (e.getActionCommand().equals("Button1")) {
	      System.out.println("Button1 has been clicked");
	    }
	  }
	}
}
