package com.sln.MyHiber;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
 
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "onetoone")
public class OneToOneClass {
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "rc"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "otoc_id", unique = true, nullable = false)
	int id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public RootClass rc;
	
	int otocA = 0;
	
	String otocB = "otocB";

}
