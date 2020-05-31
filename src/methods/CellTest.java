package methods;

import static org.junit.Assert.*;

/**
 * @author CS_WBR
 */
public class CellTest {
    
    @org.junit.Test
    public void setLivingNum() {
        System.out.println("******setLivingNum_test*******");
        Cell c = new Cell(1);
        System.out.print("case1:");
        c.setLivingNum(-1);
        System.out.print("case2:");
        c.setLivingNum(9);
        System.out.print("case3:");
        c.setLivingNum(1);
        System.out.println("*************end**************");

    }

    @org.junit.Test
    public void setNextStatus(){
        System.out.println("******setLivingNum_test*******");
        Cell c = new Cell(0);
        System.out.println("0:dead 1:living");
        c.setLivingNum(3);
        System.out.print("case1:");
        System.out.print(c.getCellStatus()+"->");
        c.setNextStatus();
        System.out.println(c.getCellStatus());
        c.setLivingNum(5);
        System.out.print("case2:");
        System.out.print(c.getCellStatus()+"->");
        c.setNextStatus();
        System.out.println(c.getCellStatus());
        c.setLivingNum(1);
        System.out.print("case3:");
        System.out.print(c.getCellStatus()+"->");
        c.setNextStatus();
        System.out.println(c.getCellStatus());
        System.out.println("*************end**************");
    }

    @org.junit.Test
    public void setCellStatus() {
        System.out.println("******setCellStatus_test*******");
        Cell c =  new Cell(1);
        System.out.print("case1:");
        c.setCellStatus(-1);
        System.out.print("case2:");
        c.setCellStatus(2);
        System.out.print("case3:");
        c.setCellStatus(0);
        System.out.print("case4:");
        c.setCellStatus(1);
        System.out.println("*************end**************");

    }
}