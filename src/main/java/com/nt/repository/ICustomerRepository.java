package com.nt.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.entity.Customer;

public interface ICustomerRepository  extends PagingAndSortingRepository<Customer, Integer>{

}
