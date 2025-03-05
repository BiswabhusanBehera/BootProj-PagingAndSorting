package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Customer;
import com.nt.service.ICustomerMgmtService;

@Component
public class PagingAndSortingTestRunner  implements CommandLineRunner{

	@Autowired
	private ICustomerMgmtService custService;
	
	@Override
	public void run(String... args) throws Exception {
		/*
		custService.showCustomerBySortingt(true, "cname").forEach(System.out::println);
		System.out.println("------------------------------");
		custService.showCustomerBySortingt(false, "billamt","cname").forEach(System.out::println);
		*/
		
		try {
			Page<Customer> page = custService.showCustomerInfoByPageNo(2, 3, false, "cname");
			System.out.println("Page Number :: "+page.getNumber());
			System.out.println("Page Count :: "+page.getTotalPages());
			System.out.println("Is it first Page :: "+page.isFirst());
			System.out.println("Is It Last Page :: "+page.isLast());
			System.out.println("Page Size :: "+page.getSize());
			System.out.println("Page Elements Count :: "+page.getNumberOfElements());
			if(!page.isEmpty()) {
				List<Customer> list = page.getContent();
				list.forEach(System.out::println);
			}
			else {
				System.out.println("no page found");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}