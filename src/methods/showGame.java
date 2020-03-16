package methods;

import java.awt.*;

import javax.swing.*;


public class showGame {
	public static void main (String[] args) {
		JFrame j = new JFrame();
		j.setSize(400,320);
		j.setVisible(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		//p.setBounds(0,0,800,600);
		j.add(p);
		j.setResizable(false);
		Graphics g=p.getGraphics();
		Map m = new Map();
		m.initialMap();
		for(int i=2;i<Map.Width+2;i++)
		{
			for(int t=2;t<Map.Height+2;t++)
			{
				if(m.cell[i][t].getCellStatus() == 1)
					g.fillRect((i-2)*20, (t-2)*20, 20, 20);
				else {
					g.drawRect((i-2)*20, (t-2)*20, 20, 20);
				}
			}
		}
		while(true) {
			m.updateStatus();
			try {
				Thread.sleep(600);
			} catch (Exception e) {
				// TODO: handle exception
				System.exit(0);
			}
			j.repaint();
			for(int i=2;i<Map.Width+2;i++)
			{
				for(int t=2;t<Map.Height+2;t++)
				{
					if(m.cell[i][t].getCellStatus() == 1)
						g.fillRect((i-2)*20, (t-2)*20, 20, 20);
					else {
						g.drawRect((i-2)*20, (t-2)*20, 20, 20);
					}
				}
			}
			
		}
		
	}
}