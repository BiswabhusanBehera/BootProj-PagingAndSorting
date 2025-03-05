package com.nt.service;

import org.springframework.data.domain.Page;

import com.nt.entity.Customer;

public interface ICustomerMgmtService {

	
	public Iterable<Customer>  showCustomerBySortingt(boolean asc, String...props);
	public  Page<Customer>  showCustomerInfoByPageNo(int pageNo, int pageSize,  boolean ascOrder, String props);
	
}
