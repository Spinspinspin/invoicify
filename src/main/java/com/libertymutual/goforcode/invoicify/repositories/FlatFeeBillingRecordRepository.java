package com.libertymutual.goforcode.invoicify.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libertymutual.goforcode.invoicify.models.BillingRecord;
import com.libertymutual.goforcode.invoicify.models.User;

@Repository
public interface FlatFeeBillingRecordRepository extends JpaRepository<BillingRecord, Long>{

	BillingRecord findById (Long id);
}
