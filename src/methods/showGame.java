package methods;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Button;
import java.awt.GridBagLayout;

public class showGame extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			showGame dialog = new showGame();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public showGame() {
		setBounds(100, 100, 564, 474);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0};
		gbl_contentPanel.rowHeights = new int[]{0};
		gbl_contentPanel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				Button button_start = new Button("\u5F00\u59CB");
				buttonPane.add(button_start);
			}
			{
				Button button_end = new Button("\u7ED3\u675F");
				buttonPane.add(button_end);
			}
		}
	}

}
