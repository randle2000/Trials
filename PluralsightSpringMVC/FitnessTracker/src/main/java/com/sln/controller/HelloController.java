/*
 * by sln:
 * Workspace folder for STS is set to PluralsightSpringMVC
 * Sometimes STS brakes so I delete everything in PluralsightSpringMVC folder (except for FitnessTracker folder),
 * restart STS and import FitnessTracker as "Existing Project into Workspace"
 * 
 * I used STS
 * I used version 3.2.2.RELEASE (instead of 3.2.1.RELEASE) for org.springframework in pom.xml
 * 	otherwise it didn't recognize <mvc:annotation-driven/> in servlet-config.xml
 * I deleted everything in C:\Documents and Settings\Administrator\.m2\repository
 * 
 * * IGNORE THE LINES BELOW, that's I was trying to run it via regular Eclipse
 * I installed m2e plugin in Eclipse
 * I used version 3.2.2.RELEASE (instead of 3.2.1.RELEASE) for org.springframework in pom.xml
 * 	otherwise it didn't recognize <mvc:annotation-driven/> in servlet-config.xml
 * I deleted everything in C:\Documents and Settings\Administrator\.m2\repository
 * Right-click project -> Maven -> Update project
 * Right-click project -> Properties -> Deployment Assembly -> click add -> "Java Build Path Entries" -> Maven Dependencies
 */

package com.sln.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@RequestMapping(value ="/greetingg")
	public String sayHello2(Model model) {
		model.addAttribute("greeting", "Hello Worldx");
		return "hello";
	}
}