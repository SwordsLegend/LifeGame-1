package methods;

import java.awt.*;
import javax.swing.*;
import java.util.Random;
/**
 * @authorCS_WBR
 * draw a random size map for LifeGame
 */
public class Map extends JPanel implements Runnable{
	private static final long serialVersionUID = -2637193077862852042L;
	final static int HEIGHT = 40;
	final static int WIDTH = 50;
	public Cell [][]cell = new Cell[HEIGHT][WIDTH];
	{
		//TODO start the map by means of a random situation
		for(int i = 0;i<HEIGHT;i++) {
			for(int j = 0;j<WIDTH;j++) {
				Random r = new Random();
				this.cell[i][j] = new Cell(r.nextInt(2));
			}
		}
	}
	
	public void updateStatus() {
		//TODO count the number of living cell in matrix each round
		int surroundingAliveNam = 0;
		for(int x=0;x<HEIGHT;x++) {
			for(int y=0;y<WIDTH;y++) {
				if(invalidCell(x-1, y-1) && (cell[x-1][y-1].getCellStatus() == 1)) {
					surroundingAliveNam++;
				}
				if(invalidCell(x-1, y) && (cell[x-1][y].getCellStatus() == 1)) {
					surroundingAliveNam++;
				}
				if(invalidCell(x-1, y+1) && (cell[x-1][y+1].getCellStatus() == 1)){
					surroundingAliveNam++;
				}
				if(invalidCell(x, y-1) && (cell[x][y-1].getCellStatus() == 1)) {
					surroundingAliveNam++;
				}
				if(invalidCell(x, y+1) && (cell[x][y+1].getCellStatus() == 1)){
					surroundingAliveNam++;
				}
				if(invalidCell(x+1, y-1) && (cell[x+1][y-1].getCellStatus() == 1)){
					surroundingAliveNam++;
				}
				if(invalidCell(x+1, y) && (cell[x+1][y].getCellStatus() == 1)) {
					surroundingAliveNam++;
				}
				if(invalidCell(x+1, y+1) && (cell[x+1][y+1].getCellStatus() == 1)) {
					surroundingAliveNam++;
				}
				cell[x][y].setLivingNum(surroundingAliveNam);
				surroundingAliveNam = 0;
			}
		}
		for(int x=0;x<HEIGHT;x++) {
			for(int y=0;y<WIDTH;y++) {
				cell[x][y].setNextStatus();
			}
		}
	}
	
	public boolean invalidCell(int x, int y) {
		return (x >= 0) && (x < HEIGHT) && (y >= 0) && (y < WIDTH);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for(int i=0;i<HEIGHT ;i++) {
			for(int j=0;j<WIDTH;j++) {
				if(cell[i][j].getCellStatus() == 1) {
					g.fillRect(j*20, i*20, 20, 20);
				}
				else {
					g.drawRect(j*20, i*20, 20, 20);
				}
			}
		}
	}

	@Override
	public void run() {
		/**
		 *run thread
		 */
		while (true) {
			synchronized (this) {
				repaint();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.updateStatus();
			}
		}

	}
}
