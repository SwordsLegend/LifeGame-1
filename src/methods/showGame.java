package methods;

import javax.swing.*;


public class showGame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8632234651334745219L;
	private final Map m;
	public showGame() {
		m = new Map();
		new Thread(m).start();
		getContentPane().add(m);
	}
	public static void main (String[] args){
		showGame s =new showGame();
		s.setSize(1010,840);
		s.setVisible(true);
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//JPanel p = new JPanel();
		//p.setBounds(0,0,800,600);
		//j.add(p);
		s.setTitle("生命游戏");
		s.setResizable(false);
		s.setLocationRelativeTo(null);	//设置居中显示
	}
}