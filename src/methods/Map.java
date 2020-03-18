package methods;

import java.awt.*;
import javax.swing.*;
import java.util.Random;

/*
 * author @ CS_WBR
 * draw a random size map for LifeGame
 * */
public class Map extends JPanel implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2637193077862852042L;
	final static int Height = 40;
	final static int Width = 50;
	public Cell [][]cell = new Cell[Height][Width];
	{
		//TODO start the map by means of a random situation
		for(int i = 0;i<Height;i++) {
			for(int j = 0;j<Width;j++) {
				Random r = new Random();
				this.cell[i][j] = new Cell(r.nextInt(2));
			}
		}
	}
	
	public void updateStatus() {
		//TODO count the number of living cell in matrix each round
		int sourroundingAliveNum = 0;
		for(int x=0;x<Height;x++) {
			for(int y=0;y<Width;y++) {
				if(isvalideCell(x-1, y-1) && (cell[x-1][y-1].getCellStatus() == 1)) sourroundingAliveNum++;
				if(isvalideCell(x-1, y) && (cell[x-1][y].getCellStatus() == 1)) sourroundingAliveNum++;
				if(isvalideCell(x-1, y+1) && (cell[x-1][y+1].getCellStatus() == 1)) sourroundingAliveNum++;
				if(isvalideCell(x, y-1) && (cell[x][y-1].getCellStatus() == 1)) sourroundingAliveNum++;
				if(isvalideCell(x, y+1) && (cell[x][y+1].getCellStatus() == 1)) sourroundingAliveNum++;
				if(isvalideCell(x+1, y-1) && (cell[x+1][y-1].getCellStatus() == 1)) sourroundingAliveNum++;
				if(isvalideCell(x+1, y) && (cell[x+1][y].getCellStatus() == 1)) sourroundingAliveNum++;
				if(isvalideCell(x+1, y+1) && (cell[x+1][y+1].getCellStatus() == 1)) sourroundingAliveNum++;
				cell[x][y].setLivingNum(sourroundingAliveNum);
				sourroundingAliveNum = 0;
			}
		}
		for(int x=0;x<Height;x++) {
			for(int y=0;y<Width;y++) {
				cell[x][y].setNextStatus();
			}
		}
	}
	
	public boolean isvalideCell(int x,int y) {
		if((x>=0) && (x<Height) && (y>=0) && (y<Width))
			return true;
		else 
			return false;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for(int i=0;i<Height;i++)
		{
			for(int j=0;j<Width;j++)
			{
				if(cell[i][j].getCellStatus() == 1)
				{
					g.fillRect(j*20, i*20, 20, 20);
				}
				else
				{
					g.drawRect(j*20, i*20, 20, 20);
				}
			}
		}
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while(true)
		{
			synchronized(this)
			{
				repaint();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				this.updateStatus();
			}
		}
		
	}
	
	/*
	 public void updateStatus(Cell cell[][]) {
	}
	*/
}
