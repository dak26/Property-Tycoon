package proportytycoon;
import static org.junit.Assert.assertArrayEquals;
/**

* @author Yang
*/
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class Testing {
	
	@Test
	public void testTile(){
		String[] data= {"Property","Crapper Street","true","BROWN","60","2","10","30","90","160","250"};
		Tile player=new Property(data);
		
		assertEquals(data[1],player.getName());
		assertEquals(Boolean.parseBoolean(data[2]),player.getBuyable());
	}
	
	@Test
	public void testProperty() {
		String[] data= {"Property","Crapper Street","true","BROWN","60","2","10","30","90","160","250"};
		Property ppty=new Property(data);
		Colour colour=Colour.BROWN;
		int[] rentPrices= {2,10,30,90,160,250};
		
		assertEquals(colour,Colour.BROWN);
		assertEquals(Integer.parseInt(data[4]),ppty.cost);
		assertArrayEquals(rentPrices,ppty.getRentPrices(data));
		
	}
	
	@Test
	public void testTax() {
		//assertEquals(data[],tax);
		return ;
	}
	
	@Test
	public void testLuck() {
		//assertEquals(data[],luck);
		return ;
	}
	
	@Test
	public void testOpp() {
		//assertEquals(data[],opp);
		return ;
	}
	
	@Test
	public void testJail() {
		//assertEquals(data[],jail);
		return ;
	}
	
	@Test
	public void testGo() {
		//assertEquals(data[],go);
		return ;
	}
	
	@Test
	public void testParking() {
		//assertEquals(data[],parking);
		return ;
	}
	


public static void main(String[] args) {
	
	Testing a=new Testing();
	
	a.testTile();
	a.testGo();
	a.testJail();
	a.testLuck();
	a.testOpp();
	a.testParking();
	a.testProperty();
	a.testTax();
}

}
