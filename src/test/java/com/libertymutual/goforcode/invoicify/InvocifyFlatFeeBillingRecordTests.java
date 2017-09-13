package com.libertymutual.goforcode.invoicify;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.Configuration;
import org.meanbean.test.ConfigurationBuilder;

import com.libertymutual.goforcode.invoicify.models.FlatFeeBillingRecord;

public class InvocifyFlatFeeBillingRecordTests {

	@Test
    public void test_all_getters_and_setters() {
         BeanTester tester = new BeanTester();
         Configuration configuration = new ConfigurationBuilder()
                 .ignoreProperty("createdOn")
                 .build();
          tester.testBean(FlatFeeBillingRecord.class, configuration);
    }
	
	@Test
	public void test_get_total_returns_amount() {
		//Arrange
		FlatFeeBillingRecord ffbr = new FlatFeeBillingRecord();
		ffbr.setAmount(7.0);
		//Act
		double actual = ffbr.getTotal();
		
		//Assert
		assertThat(actual).isEqualTo(7.0);
	}
}
