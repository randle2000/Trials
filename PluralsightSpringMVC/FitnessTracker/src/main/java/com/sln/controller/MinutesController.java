package com.sln.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sln.model.Activity;
import com.sln.model.Exercise;
import com.sln.service.ExerciseService;

@Controller
public class MinutesController {
	
	@Autowired
	private ExerciseService exerciseService;

	
	@RequestMapping(value ="/addMinutes")
	public String addMinutes(@ModelAttribute("exercise1") Exercise exercise) {
		System.out.println("exercise: " + exercise.getMinutes1());
		System.out.println("exercise activity: " + exercise.getActivity());
		//return "redirect:addMoreMinutes.html";
		return "addMinutes";
	}
	
	@RequestMapping(value = "/activities", method = RequestMethod.GET)
	public @ResponseBody List<Activity> findAllActivities() {
		return exerciseService.findAllActivities();
	}
	

//	@RequestMapping(value ="/addMoreMinutes")
//	public String addMoreMinutes(@ModelAttribute("exercise1") Exercise exercise) {
//		System.out.println("exercising: " + exercise.getMinutes());
//		return "addMinutes";
//	}
}
