package decryption;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
public class Credits extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Credits dialog = new Credits();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Credits() {
		double vers = 1.0;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCredits = new JLabel("Credits");
			lblCredits.setHorizontalAlignment(SwingConstants.CENTER);
			lblCredits.setBounds(0, 11, 424, 14);
			contentPanel.add(lblCredits);
		}
		{
			JLabel lblHactooljuiCreatedBy = new JLabel("HacToolJUI Created by Knucklesfan");
			lblHactooljuiCreatedBy.setHorizontalAlignment(SwingConstants.CENTER);
			lblHactooljuiCreatedBy.setBounds(0, 36, 434, 14);
			contentPanel.add(lblHactooljuiCreatedBy);
		}
		{
			JLabel lblVersion = new JLabel("Version: " + vers);
			lblVersion.setHorizontalAlignment(SwingConstants.CENTER);
			lblVersion.setBounds(0, 61, 434, 14);
			contentPanel.add(lblVersion);
		}
		{
			JLabel lblHactoolBy = new JLabel("Hactool by SciresM");
			lblHactoolBy.setHorizontalAlignment(SwingConstants.CENTER);
			lblHactoolBy.setBounds(0, 214, 434, 14);
			contentPanel.add(lblHactoolBy);
		}
		{
			JLabel lblWrittenInJava = new JLabel("Written in Java in 3 days lol");
			lblWrittenInJava.setHorizontalAlignment(SwingConstants.CENTER);
			lblWrittenInJava.setBounds(0, 75, 434, 14);
			contentPanel.add(lblWrittenInJava);
		}
	}

}
