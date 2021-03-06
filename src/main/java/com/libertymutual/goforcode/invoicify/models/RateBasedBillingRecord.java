package com.libertymutual.goforcode.invoicify.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

public class RateBasedBillingRecord extends BillingRecord {

	
	
	private double rate;
	private double quantity;
	
	public double getTotal() {
	double total = rate * quantity;
	return total;
	}

	

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
}