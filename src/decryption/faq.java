package decryption;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class faq extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			faq dialog = new faq();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public faq() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblFaq = new JLabel("FAQ");
			lblFaq.setHorizontalAlignment(SwingConstants.CENTER);
			lblFaq.setBounds(190, 11, 46, 14);
			contentPanel.add(lblFaq);
		}
		{
			JLabel lblQuestionWhereDo = new JLabel("Question: Where do I get keys?");
			lblQuestionWhereDo.setBounds(10, 36, 424, 14);
			contentPanel.add(lblQuestionWhereDo);
		}
		{
			JLabel lblAnswerKeysAre = new JLabel("Answer: Keys are extracted from the switch. It's illegal to share keys");
			lblAnswerKeysAre.setBounds(10, 61, 424, 14);
			contentPanel.add(lblAnswerKeysAre);
		}
		{
			JLabel lblQuestionTheTool = new JLabel("Question: The tool throws an error! What do I do?");
			lblQuestionTheTool.setBounds(10, 86, 414, 14);
			contentPanel.add(lblQuestionTheTool);
		}
		{
			JLabel lblAnswerMostLikely = new JLabel("Answer: Most likely you left a required file blank or HacTool isn't present.");
			lblAnswerMostLikely.setBounds(10, 111, 424, 14);
			contentPanel.add(lblAnswerMostLikely);
		}
		{
			JLabel lblIfYouGet = new JLabel("If you get a Java Error, please report it! I'll help in any way I can.");
			lblIfYouGet.setBounds(10, 124, 414, 14);
			contentPanel.add(lblIfYouGet);
		}
		{
			JLabel lblQuestionCanI = new JLabel("Question: Can I update safely if I use this tool?");
			lblQuestionCanI.setBounds(10, 149, 414, 14);
			contentPanel.add(lblQuestionCanI);
		}
		{
			JLabel lblAnswerThisTool = new JLabel("Answer: This tool has nothing to do with updating, so update at a risk.");
			lblAnswerThisTool.setBounds(10, 174, 414, 14);
			contentPanel.add(lblAnswerThisTool);
		}
		{
			JLabel lblQuestionIsHactool = new JLabel("Question: Is hactool embedded?");
			lblQuestionIsHactool.setBounds(10, 199, 414, 14);
			contentPanel.add(lblQuestionIsHactool);
		}
		{
			JLabel lblAnswerNoThis = new JLabel("Answer: No. This tool requires hactool in the same folder.");
			lblAnswerNoThis.setBounds(10, 224, 414, 14);
			contentPanel.add(lblAnswerNoThis);
		}
	}

}
