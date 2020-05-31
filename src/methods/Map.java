package methods;

import javax.swing.*;
import java.awt.Graphics;
import java.util.Random;
/**
 * @author CS_WBR
 * draw a random size map for LifeGame
 */
public class Map extends JPanel implements Runnable{
	//final static int HEIGHT = 40;
	//final static int WIDTH = 50;
	private int HEIGHT;
	private  int WIDTH;
	private int time;
	public Map(int height,int width){
		if(height < 3 || width < 3 || height > 1000 || width > 1000){
			System.out.println("illegal height or width");
			return;
		}
		else{
			System.out.println("legal");
		}
		this.HEIGHT = height;
		this.WIDTH = width;
	}
	public Cell [][]cell = new Cell[this.HEIGHT][this.WIDTH];
	{
		//TODO start the map by means of a random situation
		for(int i = 0;i<this.HEIGHT;i++) {
			for(int j = 0;j<this.WIDTH;j++) {
				Random r = new Random();
				this.cell[i][j] = new Cell(r.nextInt(2));
			}
		}
	}

	public void nextLivingNum(int x,int y){
		int surroundingAliveNum = 0;
		if(invalidCell(x-1, y-1) && (cell[x-1][y-1].getCellStatus() == 1)) {
			surroundingAliveNum++;
		}
		if(invalidCell(x-1, y) && (cell[x-1][y].getCellStatus() == 1)) {
			surroundingAliveNum++;
		}
		if(invalidCell(x-1, y+1) && (cell[x-1][y+1].getCellStatus() == 1)){
			surroundingAliveNum++;
		}
		if(invalidCell(x, y-1) && (cell[x][y-1].getCellStatus() == 1)) {
			surroundingAliveNum++;
		}
		if(invalidCell(x, y+1) && (cell[x][y+1].getCellStatus() == 1)){
			surroundingAliveNum++;
		}
		if(invalidCell(x+1, y-1) && (cell[x+1][y-1].getCellStatus() == 1)){
			surroundingAliveNum++;
		}
		if(invalidCell(x+1, y) && (cell[x+1][y].getCellStatus() == 1)) {
			surroundingAliveNum++;
		}
		if(invalidCell(x+1, y+1) && (cell[x+1][y+1].getCellStatus() == 1)) {
			surroundingAliveNum++;
		}
		cell[x][y].setLivingNum(surroundingAliveNum);
	}
	
	public void updateStatus() {
		//TODO count the number of living cell in matrix each round
		for(int x=0;x<this.HEIGHT;x++) {
			for(int y=0;y<this.WIDTH;y++) {
				nextLivingNum(x,y);
			}
		}
		for(int x=0;x<this.HEIGHT;x++) {
			for(int y=0;y<this.WIDTH;y++) {
				cell[x][y].setNextStatus();
			}
		}
	}
	
	public boolean invalidCell(int x, int y)
	{
		return (x >= 0) && (x <this.HEIGHT) && (y >= 0) && (y < this.WIDTH);
	}

	public void setTime(int t){
		if(t>5000){
			System.out.println("time is too long");
			return;
		}
		else if(time<500 && t>0){
			System.out.println("time is too short");
		}
		else if(t <=0 ){
			System.out.println("illegal time");
			return;
		}
		else{
			System.out.println("legal");
		}
		this.time = t;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for(int i=0;i<this.HEIGHT ;i++) {
			for(int j=0;j<this.WIDTH;j++) {
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
		/*
		 run thread
		 */
		while (true) {
			synchronized (this) {
				repaint();
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.updateStatus();
			}
		}

	}
}
