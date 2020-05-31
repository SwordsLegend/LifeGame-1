package methods;

import org.junit.Test;

/**
 * @author CS_WBR
 */
public class MapTest {
    @Test
    public void Map(){
        System.out.println("******Create_Map******");
        System.out.print("case1:");
        Map m = new Map(-1,-1);
        System.out.print("case2:");
        Map c = new Map(1200,1200);
        System.out.print("case3:");
        Map d = new Map(30,30);
        System.out.println("*************end*******");
    }

    @Test
    public void invalidCell() {
        Map m = new Map(3,3);
        System.out.println("******invalidCell_test*******");
        System.out.println("case1:"+m.invalidCell(-1,-1));
        System.out.println("case2:"+m.invalidCell(0,0));
        System.out.println("case3:"+m.invalidCell(3,3));
        System.out.println("case4:"+m.invalidCell(2,2));
        System.out.println("*************end*************");
    }

    @Test
    public void setTime(){
        Map m = new Map(3,3);
        System.out.println("******setTime_test*******");
        System.out.print("case1:");
        m.setTime(400);
        System.out.print("case2:");
        m.setTime(1000);
        System.out.print("case3:");
        m.setTime(8000);
        System.out.print("case4:");
        m.setTime(-1);
        System.out.println("*************end**********");
    }
}