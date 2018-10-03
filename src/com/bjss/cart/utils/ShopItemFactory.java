package com.bjss.cart.utils;

import com.bjss.cart.error.ShopItemException;
import com.bjss.cart.model.Apples;
import com.bjss.cart.model.Bread;
import com.bjss.cart.model.Milk;
import com.bjss.cart.model.ShopItem;
import com.bjss.cart.model.Soup;

// Factory class to create shop items. Amend this class to add more shop items, or amend prices or discounts.

public class ShopItemFactory {

	
	public ShopItemFactory() {
		
	}

	// Factory method for shop items
	public ShopItem getShopItem(String itemName) throws ShopItemException {
		
		if(itemName.equalsIgnoreCase(ShopItemType.APPLES.getName())) {
            return new Apples(ShopItemType.APPLES.getPrice(), ShopItemType.APPLES.getDiscountPercentage());
        }
		else if(itemName.equalsIgnoreCase(ShopItemType.MILK.getName())) {
            return new Milk(ShopItemType.MILK.getPrice(), ShopItemType.MILK.getDiscountPercentage());
        }
		else if(itemName.equalsIgnoreCase(ShopItemType.SOUP.getName())) {
            return new Soup(ShopItemType.SOUP.getPrice(), ShopItemType.SOUP.getDiscountPercentage());
        }
		else if(itemName.equalsIgnoreCase(ShopItemType.BREAD.getName())) {
            return new Bread(ShopItemType.BREAD.getPrice(), ShopItemType.BREAD.getDiscountPercentage());
        }
		else {
			throw new ShopItemException("Shop Item name: "+itemName+" not recognised");
		}
	}

}
