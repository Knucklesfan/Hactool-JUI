package decryption;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.Font;

public class Howto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Howto dialog = new Howto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Howto() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblHowToUse = new JLabel("How to Use this tool");
			lblHowToUse.setHorizontalAlignment(SwingConstants.CENTER);
			lblHowToUse.setBounds(0, 11, 434, 14);
			contentPanel.add(lblHowToUse);
		}
		{
			JLabel lblFirstlyObtainAn = new JLabel("Firstly, obtain an NSP/NCA/XCI/Switch file that you want to decrypt.");
			lblFirstlyObtainAn.setHorizontalAlignment(SwingConstants.CENTER);
			lblFirstlyObtainAn.setBounds(10, 36, 414, 14);
			contentPanel.add(lblFirstlyObtainAn);
		}
		{
			JLabel lblNextlyPickThe = new JLabel("Nextly, Pick the NSP with the file picker, and keys from your switch.");
			lblNextlyPickThe.setHorizontalAlignment(SwingConstants.CENTER);
			lblNextlyPickThe.setBounds(20, 49, 404, 14);
			contentPanel.add(lblNextlyPickThe);
		}
		{
			JLabel lblFillInYour = new JLabel("Fill in your credentials for the file you wish to decrypt.");
			lblFillInYour.setHorizontalAlignment(SwingConstants.CENTER);
			lblFillInYour.setBounds(20, 61, 404, 14);
			contentPanel.add(lblFillInYour);
		}
		{
			JLabel lblDirectoriesWillBe = new JLabel("Directories will be made if they do not already exist.");
			lblDirectoriesWillBe.setHorizontalAlignment(SwingConstants.CENTER);
			lblDirectoriesWillBe.setBounds(0, 86, 434, 14);
			contentPanel.add(lblDirectoriesWillBe);
		}
		{
			JLabel lblNewLabel = new JLabel("Next, hit go. The tool will run the hactool commands and output your file.");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(10, 109, 414, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblThatsAboutIt = new JLabel("If you have any questions feel free to contact me on GBATemp");
			lblThatsAboutIt.setFont(new Font("Tahoma", Font.PLAIN, 9));
			lblThatsAboutIt.setHorizontalAlignment(SwingConstants.CENTER);
			lblThatsAboutIt.setBounds(10, 226, 414, 14);
			contentPanel.add(lblThatsAboutIt);
		}
		{
			JLabel lblThatsAboutIt_1 = new JLabel("That's about it!");
			lblThatsAboutIt_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblThatsAboutIt_1.setBounds(10, 129, 414, 14);
			contentPanel.add(lblThatsAboutIt_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
