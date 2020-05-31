package methods;
import javax.swing.*;
/**
 * @author cs_wbr
 * function: show map of the game
 */
public class ShowGame extends JFrame {
	private static final long serialVersionUID = -8632234651334745219L;
	public ShowGame() {
		Map m = new Map(40,50);
		Thread showMap = new Thread(m);
		showMap.start();
		getContentPane().add(m);
	}
	public static void main (String[] args){
		ShowGame s =new ShowGame();
		s.setSize(1010,840);
		s.setVisible(true);
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		s.setTitle("生命游戏");
		s.setResizable(false);
		//设置显示居中
		s.setLocationRelativeTo(null);
	}
}