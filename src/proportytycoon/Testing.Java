package proportytycoon;
/**

* @author Yang
*/
import static org.junit.Assert.assertEquals;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class Testing {
	String[] data= {"Property","cookie","true","RED","9999"};
	
	@org.junit.Test
	public void testTile() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		Constructor<?> cnstr=Class.forName("Property").getConstructor(String[].class);
		Tile player=(Property) cnstr.newInstance(new Object[] {data});
		
		assertEquals(data[1],player.getName());
		assertEquals(Boolean.parseBoolean(data[2]),player.getBuyable());
	}
	
	@org.junit.Test
	public void testProperty() {
		assertEquals(data[3],Colour.RED);
		assertEquals(Integer.parseInt(data[4]),9999);
		//assertEquals(rentprice)
	}
	
	@org.junit.Test
	public void testTax() {
		//assertEquals(data[],tax);
	}
	
	@org.junit.Test
	public void testLuck() {
		//assertEquals(data[],luck);
	}
	
	@org.junit.Test
	public void testOpp() {
		//assertEquals(data[],opp);
	}
	
	@org.junit.Test
	public void testJail() {
		//assertEquals(data[],jail);
	}
	
	@org.junit.Test
	public void testGo() {
		//assertEquals(data[],go);
	}
	
	@org.junit.Test
	public void testParking() {
		//assertEquals(data[],parking);
	}
	
	
}
