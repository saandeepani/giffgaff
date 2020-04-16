package com.giffgaff.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.mockito.Mock;

import com.giffgaff.JsonReader;
import com.giffgaff.jackson.model.Products;

public class JsonReaderTest {

	@Mock
	private Products productMock;
	@Mock
	private JsonReader jsonReaderMock;
	
	@Test
	public void searchProductNullTest() {
		JsonReader jr = new JsonReader();
		String k = jr.searchProduct("ipad");
		assertNull(k);
	}
	
	@Test
	public void searchWidgetTest() {		
		String p = new String ("{\"name\":\"Widget\",\"price\":25,\"quantity\":5}");
		JsonReader jr = new JsonReader();
		String k = jr.searchProduct("Widget");
		assertEquals(p.toString(), k);
	}
	
	@Test
	public void searchThingTest() {		
		String p = new String ("{\"name\":\"Thing\",\"price\":15,\"quantity\":5}");
		JsonReader jr = new JsonReader();
		String k = jr.searchProduct("Thing");
		assertEquals(p.toString(), k);
	}
	
	@Test
	public void searchDoodadTest() {		
		String p = new String ("{\"name\":\"Doodad\",\"price\":5,\"quantity\":10}");
		JsonReader jr = new JsonReader();
		String k = jr.searchProduct("Doodad");
		assertEquals(p.toString(), k);
	}
	
	

}