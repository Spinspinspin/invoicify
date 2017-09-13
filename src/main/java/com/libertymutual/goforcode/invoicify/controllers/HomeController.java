package com.libertymutual.goforcode.invoicify.controllers;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.libertymutual.goforcode.invoicify.models.User;
import com.libertymutual.goforcode.invoicify.repositories.UserRepository;

@Controller
@RequestMapping("/")
public class HomeController {
	
	private UserRepository userRepository;
	
	private PasswordEncoder encoder;
	
	public HomeController(UserRepository userRepository, PasswordEncoder encoder) {
		this.userRepository = userRepository;
		this.encoder = encoder;
	}

	@GetMapping("/")
	public String login() {
		return "/home/default";
	}
	@GetMapping("/signup") 
	public ModelAndView signup() {
		ModelAndView mv = new ModelAndView("home/signup");
		return mv;
	}
	
	@PostMapping("signup")
	public ModelAndView handleSignup(User user) {
			
		String password = user.getPassword(); //DUMB DUMB DUMB
		String encryptPassword = encoder.encode(password);
		user.setPassword(encryptPassword);
		
		ModelAndView mv = new ModelAndView();
	try	{
		userRepository.save(user);
		mv.setViewName("redirect:/login");
		
	} catch (DataIntegrityViolationException dive) {
		mv.setViewName("home/signup");
		mv.addObject("errorMessage", "Username already exists. Pick another.");
	}
		return mv;
		
	
		
	}
	
}
