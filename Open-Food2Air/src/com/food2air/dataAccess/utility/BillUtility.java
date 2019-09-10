package com.food2air.dataAccess.utility;

public class BillUtility {

	public static double getTax(double value) {
		double tax = value * 0.05;
		return tax;
	}

	public static double totalBill(double value) {
		double bill = value + getTax(value);
		return bill;
	}

}
