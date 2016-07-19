package com.sln.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

public class Exercise {
	@Range(min = 1, max = 120)
	private int minutes1;

	@NotNull
	private String activity;

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public int getMinutes1() {
		return minutes1;
	}

	public void setMinutes1(int minutes1) {
		this.minutes1 = minutes1;
	}
}
