package com.bjss.cart.utils;

import java.text.DecimalFormat;
import java.util.List;

import com.bjss.cart.model.ShopItem;

public class DisplayPriceList {

	public DisplayPriceList() {
		
	}

	// Helper method to format discount information before display to console
	public static String formatDiscountOutput(List<ShopItem> basketList) {
		String discountOutput="";
		
		boolean discountsApply=false;

		// Create display text for any discounts
		for (ShopItem item : basketList) {
			
			if (item.getdiscountPercent() > 0.0) {
				
				discountsApply=true;
				
				discountOutput = discountOutput + item.getClass().getSimpleName()+" "+
						item.getdiscountPercent()*100.0+"%"+
						" off: -£"+formatValueForDecimalDisplay(item.getDiscount())+"\n";
			}
		}
		
		if (discountsApply == false) {
			discountOutput = "(no offers available)\n";
		}
		
		return discountOutput;
	}

	// Helper method to display summary output to console
	public static void displayConsoleOutput(double subTotalPrice, String discountOutputText, double totalPrice) {
		
		// Display sub-total before any discounts are applied
		System.out.println("Subtotal: £" + formatValueForDecimalDisplay(subTotalPrice));

		// Display any discount information
		System.out.println(discountOutputText);
		
		// Display total after all discounts are applied
		System.out.println("Total: £" + formatValueForDecimalDisplay(totalPrice));
	
	}
	
	// Helper method to ensure that prices and discounts always display to 2 decimal places only
	private static String formatValueForDecimalDisplay(double value) {
		String strValue;
		
		DecimalFormat df = new DecimalFormat("#.00"); 
		
		strValue = df.format(value);

		return strValue;
	}
	
}
