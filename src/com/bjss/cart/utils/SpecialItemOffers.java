package com.bjss.cart.utils;

import java.util.List;

import com.bjss.cart.model.Bread;
import com.bjss.cart.model.ShopItem;
import com.bjss.cart.model.Soup;

public class SpecialItemOffers {

	public SpecialItemOffers() {
		// TODO Auto-generated constructor stub
	}

	// Apply any cross-item special offers here
	public static void applyCrossItemSpecialOffers(List<ShopItem> basketList) {
		
		int soupCount = 0;
		boolean applySpecialOffer = false;
		
		// Iterate through the item list looking for any special offer rules
		for (ShopItem item : basketList) {
			
			if (item instanceof Soup) {

				soupCount++;
			}

			if (soupCount == 2) {
				// Special offer can be applied to bread
				
				applySpecialOffer = true;
				break;
			}
		}
	
		if (applySpecialOffer == true) {
			
			// Iterate through the item list looking for any bread to apply special offer to
			for (ShopItem item : basketList) {
				
				if (item instanceof Bread) {

					double price = item.getPrice();
					item.setPrice(price/2);
					break;
				}
			}
			
		}
		
	}

	
}
