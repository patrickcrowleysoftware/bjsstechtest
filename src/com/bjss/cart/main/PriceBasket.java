package com.bjss.cart.main;

import java.util.ArrayList;
import java.util.List;

import com.bjss.cart.model.Bread;
import com.bjss.cart.model.ShopItem;
import com.bjss.cart.model.Soup;
import com.bjss.cart.utils.DisplayPriceList;
import com.bjss.cart.utils.ShopItemFactory;
import com.bjss.cart.utils.SpecialItemOffers;


public class PriceBasket {

	static int DEFAULT_NUM_SHOP_ITEMS = 100;
	
	public PriceBasket() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		// Read in the input argument parameters
		
		/*
		    Arguments can be entered as follows e.g.:
			
			>PriceBasket Apples Milk Bread Soup
			
			or:
			
			>PriceBasket Apples Milk Bread Apples Soup Bread Milk Apples
			
			etc.
			
			Separate discounts will appear on the output for each item that has a discount.
			
			To modify prices or discounts or to add discounts to items other than Apples, 
			modify the ShopItemFactory class in the "utils" sub-folder.	
		*/
		
		try {
			
			// Create a new basket list
			List<ShopItem> basketList = new ArrayList<ShopItem>(DEFAULT_NUM_SHOP_ITEMS);
			
			if (args.length > 0) {
			  
				// Create the shop item factory
				ShopItemFactory sif = new ShopItemFactory();
				
				int itemCount=0;
				while (itemCount < args.length) {
					
					String basketItem = args[itemCount];
					if (basketItem != null) {
				
						ShopItem shopItem = sif.getShopItem(basketItem.toLowerCase());
						if (shopItem != null) {
							
							// Add a shop item to the shopping basket list
							basketList.add(shopItem);
						}
					}
					
					itemCount++;
				}
			}	

			
			// Apply any cross-item special offers here
			SpecialItemOffers.applyCrossItemSpecialOffers(basketList);
			
			// Once item list is compiled and any special offers are applied, calculate the price totals
			double subTotalPrice = 0.0;
			double totalPrice = 0.0;
			
			for (ShopItem item : basketList) {
				
				subTotalPrice += item.getPrice();
				totalPrice += item.getRetailPrice();
			}
			
			// Compute and format any discount items text
			String discountOutputText = DisplayPriceList.formatDiscountOutput(basketList); 
			
			// Output summary to console
			DisplayPriceList.displayConsoleOutput(subTotalPrice, discountOutputText, totalPrice);
			
		} catch (Exception e) {
			
			System.err.println("Error: "+e.getMessage());
	        System.exit(1);
		}
		
	}	
	
}
