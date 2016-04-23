package com.sln.MyHiber;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "ROOTCLASS")
public class RootClass {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	int id;
	
	int xField = 0;
	
	@Embedded
	ComponentClass componentClass = new ComponentClass();
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "rc", cascade = CascadeType.ALL)
	OneToOneClass oneToOneClass;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rc", cascade = CascadeType.ALL)
	List<OneToManyClass> oneToManyList = new ArrayList<OneToManyClass>();
}
