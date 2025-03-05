package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Customer;
import com.nt.repository.ICustomerRepository;

@Service("custService")
public class CustomerMgmtServiceImpl  implements ICustomerMgmtService{

	@Autowired
	private ICustomerRepository custRepo;

	@Override
	public Iterable<Customer> showCustomerBySortingt(boolean asc, String... props) {
		// prepare the sort object
		Sort sort = Sort.by(asc?Direction.ASC:Direction.DESC, props);
		//use repo
		Iterable<Customer> it = custRepo.findAll(sort);
		return it;
	}

	@Override
	public Page<Customer> showCustomerInfoByPageNo(int pageNo, int pageSize, boolean ascOrder, String props) {
		//Prepair the sort object
		Sort sort = Sort.by(ascOrder?Direction.ASC:Direction.DESC,props);
		//prepair pageable object
		Pageable pageable = PageRequest.of(pageNo, pageSize,sort);
		//use the repo
		Page<Customer>  page = custRepo.findAll(pageable);
		
		return page;
			
		}
	}
