package com.libertymutual.goforcode.invoicify;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.Configuration;
import org.meanbean.test.ConfigurationBuilder;


import com.libertymutual.goforcode.invoicify.models.RateBasedBillingRecord;




public class InvoicifyRateBasedBillingRecordTests {

	@Test
    public void test_all_getters_and_setters() {
         BeanTester tester = new BeanTester();
         Configuration configuration = new ConfigurationBuilder()
                 .ignoreProperty("createdOn")
                 .build();
          tester.testBean(RateBasedBillingRecord.class, configuration);
    }
	
	@Test
	public void test_getTotal_returns_rate_times_quantity() {
		//Arrange
		RateBasedBillingRecord rbbr = new RateBasedBillingRecord();
		rbbr.setRate(7.0);	
		rbbr.setQuantity(2.0);
		//Act
		
		double actual = rbbr.getTotal();
		//Assert
		assertThat(actual).isEqualTo(14);
	}
	
}
