package com.sln.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sln.model.Goal;

@Controller
@SessionAttributes("goal1")
public class GoalController {
	@RequestMapping(value ="/addGoal", method=RequestMethod.GET)
	public String addGoal(Model model) {
		Goal goal = new Goal();
		goal.setMinutes1(10);
		model.addAttribute("goal1", goal);
		return "addGoal";
	}
	
	@RequestMapping(value ="/addGoal", method=RequestMethod.POST)
	public String updateGoal(@Valid @ModelAttribute("goal1") Goal goal, BindingResult result) {
		System.out.println("result has errors: " + result.hasErrors());
		System.out.println("Minutes updated: " + goal.getMinutes1());
		if(result.hasErrors()) {
			return "addGoal";
		}
		return "redirect:addMinutes.html";
	}

}
