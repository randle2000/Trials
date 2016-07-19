package com.sln.model;

import org.hibernate.validator.constraints.Range;

public class Goal {
	@Range(min = 1, max = 120)
	private int minutess;

	public int getMinutes1() {
		return minutess;
	}

	public void setMinutes1(int minutes) {
		this.minutess = minutes;
	}
	

}
