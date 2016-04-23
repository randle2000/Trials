package com.sln.MyHiber;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;
 
@Entity
@Table(name = "onetomany")
public class OneToManyClass {
	int otmcA = 0;
	String otmcB = "otmcB";
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "otmc_id", unique = true, nullable = false)
	int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "root_id", nullable = false)
	public RootClass rc;

}
