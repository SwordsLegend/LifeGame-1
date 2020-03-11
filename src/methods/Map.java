package methods;

import java.util.Random;

/*
 * author @ CS_WBR
 * draw a random size map for LifeGame
 * */
public class Map {
	final static int Width = 40;
	final static int Height = 30;
	public Cell[][] initialMap(){
		//TODO start the map by means of a random situation
		Cell [][]cell = new Cell[Width+2][Height+2];	//set two assistance of default border of dead cell 
		for(int i = 0;i<Width+2;i++) {					//initiate the cell matrix by set status to death
			for(int j = 0;j<Height+2;j++) {
				cell[i][j] = new Cell(0);
			}
		}
		for(int i = 2;i<Width;i++) {
			for(int j = 2;j<Height;j++) {
				Random r = new Random();
				cell[i][j] = new Cell(r.nextInt(2));
			}
		}
		return cell;
	}
	
	public void updateStatus(Cell cell[][]) {
		//TODO count the number of living cell in matrix each round
		int x,y;
		for(int X=2;X<Width;X++) {
			for(int Y=2;Y<Height;Y++) {
				int num = 0;
				x = X-1;
				y = Y-1;
				for(int i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						if(cell[x+i][y+j].getCellStatus() == 1 && i!=1 && j!=1)
							num++;
					}
				}
				//update this round cell's status 
				cell[x][y].setLivingNum(num);
				cell[x][y].setNextStatus();
			}
		}
	}
	
	/*
	 public void updateStatus(Cell cell[][]) {
	}
	*/
}
