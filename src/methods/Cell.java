package methods;
/**
 * @author CS_WBR
 *define the Object cell
 */
public class Cell {
	/**
	 * dead '0' or living '1'
	 */
	private int status;
	/**
	 * the number of living neighbor cells
	 */
	private int livingNum;
	
	public Cell(int sta) {

		this.status = sta;
	}
	
	public int getCellStatus() {

		return this.status;
	}
	
	public void setCellStatus(int sta) {
		if(sta!=0 && sta!=1){
			System.out.println("illegal status");
			return;
		}
		else{
			System.out.println("legal");
		}
		this.status = sta;
	}
	
	public int getLivingNum() {

		return this.livingNum;
	}
	
	public void setLivingNum(int living) {
		if(living > 8 || living < 0){
			System.out.println("illegal living number");
			return;
		}
		else{
			System.out.println("legal");
		}
		this.livingNum = living;
	}
	
	public void setNextStatus() {
		if(this.getLivingNum() == 3) {
			this.setCellStatus(1);
		}
		else if(this.getLivingNum()<2 || this.getLivingNum()>3){
			this.setCellStatus(0);
		}
		else {
			this.setCellStatus(this.status);
		}
	}
}
