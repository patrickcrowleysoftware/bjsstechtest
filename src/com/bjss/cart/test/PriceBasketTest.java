package com.bjss.cart.test;
import com.bjss.cart.model.Apples;
import com.bjss.cart.model.Bread;
import com.bjss.cart.model.Milk;
import com.bjss.cart.model.Soup;
import com.bjss.cart.utils.ShopItemFactory;

import junit.framework.TestCase;


/**
 * Using JUnit 3
 */

/**
 * @author Patrick
 *
 */
public class PriceBasketTest extends TestCase {

	/**
	 * @param name
	 */
	public PriceBasketTest(String name) {
		super(name);
	}
	
	public void testApples() throws Exception {
		
		ShopItemFactory sif = new ShopItemFactory();
		
		try {
			
			Apples item = (Apples) sif.getShopItem("apples");
			
			assertEquals(item.getRetailPrice(), item.getPrice() - item.getDiscount());
					
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	public void testMilk() throws Exception {
		
		ShopItemFactory sif = new ShopItemFactory();
		
		try {
			
			Milk item = (Milk) sif.getShopItem("milk");
			
			assertEquals(item.getRetailPrice(), item.getPrice() - item.getDiscount());
					
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	public void testSoup() throws Exception {
		
		ShopItemFactory sif = new ShopItemFactory();
		
		try {
			
			Soup item = (Soup) sif.getShopItem("soup");
			
			assertEquals(item.getRetailPrice(), item.getPrice() - item.getDiscount());
					
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	public void testBread() throws Exception {
		
		ShopItemFactory sif = new ShopItemFactory();
		
		try {
			
			Bread item = (Bread) sif.getShopItem("bread");
			
			assertEquals(item.getRetailPrice(), item.getPrice() - item.getDiscount());
					
		} catch (Exception e) {
			throw e;
		}
		
	}	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
