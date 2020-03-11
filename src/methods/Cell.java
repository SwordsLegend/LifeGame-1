package methods;
/*
 * author @ CS_WBR
 * define the Object cell 
 */
public class Cell {
	private int Status;		//dead '0' or living '1'
	private int LivingNum; //the number of living neighbor cells
	
	public Cell(int stau) {
		// TODO create a cell with a ramdom status
		this.Status = stau;
	}
	
	public int getCellStatus() {
		// TODO get this cell status
		return this.Status;
	}
	
	public void setCellStatus(int stau) {
		//TODO this stau are only two values '0' or '1'
		this.Status = stau;
	}
	
	public int getLivingNum() {
		//TODO 
		return this.LivingNum;
	}
	
	public void setLivingNum(int living) {
		this.LivingNum = living;
	}
	
	public void setNextStatus() {
		//TODO judge the next round status of cells
		if(this.getLivingNum() == 3) {
			this.setCellStatus(1);
		}
		else if(this.getLivingNum()<2 || this.getLivingNum()>3){
			//other numbers will lead to death
			this.setCellStatus(0);
		}
		else {
			//remain the status
			this.setCellStatus(this.Status);
		}
	}
}
