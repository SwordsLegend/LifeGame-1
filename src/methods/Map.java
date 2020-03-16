package methods;

import java.awt.*;
import javax.swing.*;
import java.util.Random;

/*
 * author @ CS_WBR
 * draw a random size map for LifeGame
 * */
public class Map extends JPanel{
	final static int Width = 16;
	final static int Height = 16;
	public Cell [][]cell = new Cell[Width+4][Height+4];	//set two assistance of default border of dead cell 
	public void initialMap(){
		//TODO start the map by means of a random situation
		for(int i = 0;i<Width+4;i++) {					//initiate the cell matrix by set status to death
			for(int j = 0;j<Height+4;j++) {
				this.cell[i][j] = new Cell(0);
			}
		}
		for(int i = 2;i<Width+2;i++) {
			for(int j = 2;j<Height+2;j++) {
				Random r = new Random();
				this.cell[i][j] = new Cell(r.nextInt(2));
			}
		}
	}
	
	public void updateStatus() {
		//TODO count the number of living cell in matrix each round
		int x,y;
		for(int X=2;X<Width+2;X++) {
			for(int Y=2;Y<Height+2;Y++) {
				int num = 0;
				x = X-1;
				y = Y-1;
				for(int i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						if(this.cell[x+i][y+j].getCellStatus() == 1 && i!=1 && j!=1)
							num++;
					}
				//update this round cell's status 
				this.cell[X][Y].setLivingNum(num);
				}
			}
		}
		for(int i=2;i<Width+2;i++) {
			for(int j=2;j<Height+2;j++) {
				this.cell[i][j].setNextStatus();
			}
		}
	}
	
	/*
	 public void updateStatus(Cell cell[][]) {
	}
	*/
}
