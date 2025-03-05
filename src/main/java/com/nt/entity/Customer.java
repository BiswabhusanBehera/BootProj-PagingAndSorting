package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Table(name = "JPA_CUST_TABL")
@Data
public class Customer {

	@Id
	@Column(name = "CID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer cno;
	@Column(name = "CNAME",length = 20)
	 private String cname;
	@Column(name = "CADD",length = 20)
	 private String addrs;
	@Transient
	@Column(name = "BILLAMT")
	 private  Float billAmt;
	 
	 
}
