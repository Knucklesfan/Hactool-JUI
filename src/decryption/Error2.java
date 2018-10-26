package decryption;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalityType;

public class Error2 extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Error2 dialog = new Error2();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Error2() {
		setBounds(100, 100, 300, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblError = new JLabel("Error!");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(0, 11, 284, 14);
		contentPanel.add(lblError);
		
		JLabel lblAFileError = new JLabel("A command error has occured.");
		lblAFileError.setHorizontalAlignment(SwingConstants.CENTER);
		lblAFileError.setBounds(0, 36, 284, 14);
		contentPanel.add(lblAFileError);
		
		JLabel lblYouMayHave = new JLabel("Is hactool in the same folder?");
		lblYouMayHave.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouMayHave.setBounds(0, 61, 284, 14);
		contentPanel.add(lblYouMayHave);
		
		JLabel lblYouCanClose = new JLabel("You can close out this window and try again");
		lblYouCanClose.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouCanClose.setBounds(0, 86, 284, 14);
		contentPanel.add(lblYouCanClose);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
